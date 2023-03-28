package com.shareomatic.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.content.SharedPreferences
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallState
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.shareomatic.R
import com.shareomatic.annotation.Constants
import com.shareomatic.utils.SharedPrefrencesUtils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import kotlin.collections.ArrayList


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val mWaitHandler = Handler()
    var mcontext: Context? = null
    var isDeepLink = false
    var isExecuting = true
    lateinit var appUpdateManager: AppUpdateManager
    private var appUpdateInfoTask: Task<AppUpdateInfo>? = null
    private var installStateUpdatedListener: InstallStateUpdatedListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupViews()
        checkForAppUpdate()
        generateKeyHash()
    }

    private fun navigateToHome() {
        onInsertedSuccessFull()
    }

    override fun onResume() {
        super.onResume()
        checkNewAppVersionState()
    }

    private fun setupViews() {
        mcontext = this@SplashActivity
    }

    private fun checkForAppUpdate() {
        appUpdateManager = AppUpdateManagerFactory.create(this)
        appUpdateInfoTask = appUpdateManager.appUpdateInfo
        appUpdateInfoTask?.addOnSuccessListener { appUpdateInfo: AppUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                    appUpdateManager.registerListener(installStateUpdatedListener!!)
                    // Start Flexible update.
                    startAppUpdateFlexible(appUpdateInfo)
                } else if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                    // Start Immediate update.
                    startAppUpdateImmediate(appUpdateInfo)
                }
            } else if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_NOT_AVAILABLE || appUpdateInfo.updateAvailability() == UpdateAvailability.UNKNOWN) {
                navigateToHome()
            }
        }
        installStateUpdatedListener =
            InstallStateUpdatedListener { installState: InstallState -> if (installState.installStatus() == InstallStatus.DOWNLOADED) popupSnackbarForCompleteUpdateAndUnregister() }
    }

    private fun startAppUpdateImmediate(appUpdateInfo: AppUpdateInfo) {
        try {
            appUpdateManager.startUpdateFlowForResult(
                appUpdateInfo,
                AppUpdateType.IMMEDIATE,  // The current activity making the update request.
                this,  // Include a request code to later monitor this update request.
                REQ_CODE_VERSION_UPDATE
            )
        } catch (e: IntentSender.SendIntentException) {
            e.printStackTrace()
            navigateToHome()
        }
    }

    private fun startAppUpdateFlexible(appUpdateInfo: AppUpdateInfo) {
        try {
            appUpdateManager.startUpdateFlowForResult(
                appUpdateInfo,
                AppUpdateType.FLEXIBLE,  // The current activity making the update request.
                this,  // Include a request code to later monitor this update request.
                REQ_CODE_VERSION_UPDATE
            )
        } catch (e: IntentSender.SendIntentException) {
            e.printStackTrace()
            unregisterInstallStateUpdListener()
            navigateToHome()
        }
    }

    /**
     * Displays the snackbar notification and call to action.
     * Needed only for Flexible app update
     */
    private fun popupSnackbarForCompleteUpdateAndUnregister() {
        val snackbar = Snackbar.make(
            findViewById(R.id.activityMain), "Update Download",
            Snackbar.LENGTH_INDEFINITE
        )
        snackbar.setAction("Restart") { appUpdateManager.completeUpdate() }
        snackbar.setActionTextColor(resources.getColor(R.color.colorAccent))
        snackbar.show()
        unregisterInstallStateUpdListener()
    }

    /**
     * Checks that the update is not stalled during 'onResume()'.
     * However, you should execute this check at all app entry points.
     */
    private fun checkNewAppVersionState() {
        appUpdateManager
            .appUpdateInfo
            .addOnSuccessListener { appUpdateInfo: AppUpdateInfo ->
                if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                    popupSnackbarForCompleteUpdateAndUnregister()
                }
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                    startAppUpdateImmediate(appUpdateInfo)
                }
            }
    }

    /**
     * Needed only for FLEXIBLE update
     */
    private fun unregisterInstallStateUpdListener() {
        if (installStateUpdatedListener != null) appUpdateManager.unregisterListener(
            installStateUpdatedListener!!
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            navigateToHome()
            unregisterInstallStateUpdListener()
        }
    }

    override fun onContactGet(arrayList: ArrayList<String>) {

    }

    override fun onInsertedSuccessFull() {
        mWaitHandler.postDelayed({
            if (!isDeepLink) {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }, TIME_OUT.toLong())
    }

    companion object {
        private const val REQ_CODE_VERSION_UPDATE = 530
        var TIME_OUT = 1000
    }

    override fun onStart() {
        super.onStart()
        Branch.sessionBuilder(this).withCallback(branchReferralInitListener)
            .withData(if (intent != null) intent.data else null).init()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        // if activity is in foreground (or in backstack but partially visible) launching the same
        // activity will skip onStart, handle this case with reInitSession
        if (intent != null &&
            intent.hasExtra("branch_force_new_session") &&
            intent.getBooleanExtra("branch_force_new_session", false)
        ) {
            Branch.sessionBuilder(this).withCallback(branchReferralInitListener).reInit()
        }
    }

    private val branchReferralInitListener =
        BranchReferralInitListener { linkProperties, error ->
            val status = pref.getBoolean("loginStatus", false)
            if (error == null && linkProperties?.getBoolean("+clicked_branch_link") == true) {
                try {
                    isDeepLink = true
                    if (linkProperties.has(getString(R.string.event_code))) {
                        val eCode = linkProperties.getString(getString(R.string.event_code))
                        val eventType = linkProperties.getString(getString(R.string.event_type))
                        val isRequestEnable =
                            linkProperties.getString(getString(R.string.is_request_enable))
                        val description =
                            linkProperties.getString(getString(R.string.title_sharing))

                        println("loginStatus = ${status}")
                        if (status) {
                            startActivity(
                                Intent(
                                    this,
                                    WishJoinActivity::class.java
                                ).apply {
                                    putExtra(Constants.EVENT_CODE, eCode)
                                    putExtra(Constants.IS_REQUEST_ENABLE, isRequestEnable)
                                    putExtra(getString(R.string.event_type), eventType)
                                    putExtra(Constants.WISH_DESCRIPTION, description)
                                })
                        } else {
                            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                            startActivity(intent)
                        }
                    } else {
                        println("loginStatus = Exception ")
                        if (status) {
                            navigateToHome()
                        } else {

                            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                            startActivity(intent)
                        }
                    }
                } catch (e: Exception) {
                    println("loginStatus = Exception ${e.message}")
                    if (status) {
                        navigateToHome()
                    } else {

                        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                        startActivity(intent)
                    }
                    e.printStackTrace()
                }
            } else {
                val currentVersion = Build.VERSION.SDK_INT
                if (currentVersion <=28) {
                    if (status) {
                        navigateToHome()
                    } else {

                        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                        startActivity(intent)
                    }
                }else{

                }
            }
        }

    fun generateKeyHash(){
        try {
            val info: PackageInfo = packageManager.getPackageInfo(
                packageName,
                PackageManager.GET_SIGNATURES
            )
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }
    }

}