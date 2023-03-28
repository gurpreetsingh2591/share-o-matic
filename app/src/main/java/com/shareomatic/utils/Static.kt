package com.shareomatic.utils

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Paint
import android.location.Location
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.util.Patterns
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.shareomatic.R
import com.shareomatic.annotation.Constants
import com.shareomatic.interfaces.DialogClickListener
import java.lang.Math.*
import java.sql.DriverManager.println
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@Suppress("DEPRECATION")
class Static {
    var alertDialog: AlertDialog? = null
    lateinit var dialogClickListener: DialogInterface

    fun statusBarColor(activity: Activity, color: Int) {
        val window: Window = activity.window
        val decor = window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        window.statusBarColor = color;
    }

    fun toggleFullscreen(fullscreen: Boolean, activity: Activity) {
        val attrs = activity.window.attributes
        if (fullscreen) {
            attrs.flags = attrs.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
        } else {
            attrs.flags = attrs.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
        }
        activity.window.attributes = attrs
    }


    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    fun showDialog(activity: Activity, title: String) {
        AlertDialog.Builder(activity)
            .setTitle(title)
            .setCancelable(false)
            .setPositiveButton(
                Constants.OK
            ) { dialog, _ ->
                // do something...
                dialog.dismiss()
            }
            .show()
    }

    fun rotate_Clockwise(view: View?) {
        val rotate = ObjectAnimator.ofFloat(view, "rotation", 180f, 0f)
        //        rotate.setRepeatCount(10);
        rotate.duration = 500
        rotate.start()
    }

    fun rotate_AntiClockwise(view: View?) {
        val rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 180f)
        //        rotate.setRepeatCount(10);
        rotate.duration = 500
        rotate.start()
    }

    fun TextView.showStrikeThrough(show: Boolean) {
        paintFlags =
            if (show) paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            else paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }

    fun getDeviceId(activity: Activity): String {
        return Settings.Secure.getString(
            activity.contentResolver, Settings.Secure.ANDROID_ID
        )
    }

    fun status(status: String): String {
        var tripStatus = ""
        if (status == Constants.not_started) {
            tripStatus = "Not Started"
            return tripStatus
        } else if (status == Constants.ended_with_sign) {
            tripStatus = "Completed"
            return tripStatus
        } else if (status == Constants.no_show) {
            tripStatus = "No-show"
            return tripStatus
        } else if (status == Constants.cancelled_with_sign) {
            tripStatus = "Canceled"
            return tripStatus
        } else if (status == Constants.manually_cancelled) {
            tripStatus = "Manually Canceled"
            return tripStatus
        } else if (status == Constants.manually_completed) {
            tripStatus = "Manually Completed"
            return tripStatus
        } else {
            tripStatus = "Started"
            return tripStatus
        }

        return tripStatus
    }

    private var progressDialog: Dialog? = null


    fun cancelLoading() {
        if (progressDialog != null && progressDialog!!.isShowing) progressDialog!!.cancel()
    }

    fun convertKmsToMiles(kms: Float): Float {
        return (kms / 1.609).toFloat()
    }

    fun convertIntoMiles(km: Double): Double {

        val ans = Math.round(km / 1.609);
        return ans.toDouble()
    }

    @Throws(ParseException::class)
    fun timeCoversion24to12(twelveHoursTime: String?): String? {

        //Date/time pattern of input date (12 Hours format - hh used for 12 hours)
        val df: DateFormat = SimpleDateFormat("HH:mm")

        //Date/time pattern of desired output date (24 Hours format HH - Used for 24 hours)
        val outputformat: DateFormat = SimpleDateFormat("hh:mm aa")
        var date: Date? = null
        var output: String? = null

        //Returns Date object
        date = df.parse(twelveHoursTime)

        //old date format to new date format
        output = outputformat.format(date)
        println(output)
        return output
    }


    @Throws(ParseException::class)
    fun timeCoversion12to24(twelveHoursTime: String?): String? {

        //Date/time pattern of input date (12 Hours format - hh used for 12 hours)
        val df: DateFormat = SimpleDateFormat("hh:mm")

        //Date/time pattern of desired output date (24 Hours format HH - Used for 24 hours)
        val outputformat: DateFormat = SimpleDateFormat("HH:mm")
        var date: Date? = null
        var output: String? = null

        //Returns Date object
        date = df.parse(twelveHoursTime)

        //old date format to new date format
        output = outputformat.format(date)
        println(output)
        return output
    }


    fun convertIntoKms(miles: Double): Double {
        val ans = Math.round(1.609 * miles);
        return ans.toDouble()
    }


    fun fadeIn(view: View, activity: Activity) {
        val animMoveToTop =
            AnimationUtils.loadAnimation(activity, R.anim.fadein);
        view.startAnimation(animMoveToTop)

        animMoveToTop.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                view.visibility = View.VISIBLE

            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
    }


    fun slideToTop(activity: Activity, view: View, animation: Int) {
        val animMoveToTop = AnimationUtils.loadAnimation(activity, animation);
        view.startAnimation(animMoveToTop)

        animMoveToTop.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                view.visibility = View.VISIBLE

            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
    }

    fun getCurrentDate(): String {
        val locale: Locale = Locale.getDefault()
        val sdf = SimpleDateFormat(Constants.DATE_FORMAT, locale)
        return sdf.format(Date())
    }

    @SuppressLint("SimpleDateFormat")
    fun getDateFormat(date: String, format: String): String {

        val formatIn = SimpleDateFormat(Constants.DATE_FORMAT_IN)
        val formatOut = SimpleDateFormat(format)
        val calendar = Calendar.getInstance()
        calendar.time = formatIn.parse(date)

        return formatOut.format(calendar.time)

    }

    fun getCDate(date: String): String {
        val locale: Locale = Locale.getDefault()
        val sdf = SimpleDateFormat(Constants.DATE_FORMAT_IN, locale)
        val formatOut = SimpleDateFormat(Constants.DATE_FORMAT, locale)
        val calendar = Calendar.getInstance()
        calendar.time = sdf.parse(date)
        return formatOut.format(calendar.time)
    }

    fun getDynamicFormatDate(date: String, format: String): String {
        var formatType = ""
        if (format == "m-d-Y") {
            formatType = "MM-dd-yyyy"
        }
        if (format == "d-m-Y") {
            formatType = "dd-MM-yyyy"
        }
        if (format == "Y-m-d") {
            formatType = "yyyy-MM-dd"
        }
        if (format == "yyyy-MM-dd") {
            formatType = "MM-dd-yyyy"
        }
        val locale: Locale = Locale.getDefault()
        val sdf = SimpleDateFormat(Constants.DATE_FORMAT_IN, locale)
        val formatOut = SimpleDateFormat(formatType, locale)
        val calendar = Calendar.getInstance()
        calendar.time = sdf.parse(date)
        return formatOut.format(calendar.time)
    }

    fun getText(data: Any): String {
        var str = ""
        if (data is EditText) {
            str = data.text.toString()
        } else if (data is String) {
            str = data
        }
        return str
    }


    fun dialog(
        activity: Activity,
        msg: String,
        toastMsg: String,
        dialogClickListener: DialogClickListener
    ) {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(msg)
        builder.setPositiveButton(Constants.YES) { dialog, _ ->

            dialogClickListener.onClickYes(Constants.YES)
            dialog.dismiss()
            //  Toast.makeText(activity, toastMsg, Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton(Constants.NO) { dialog, _ ->
            dialog.dismiss()
            dialogClickListener.onClickNo(Constants.NO)

        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun checkList(selected: ArrayList<String?>) {
        val selectedlist: ArrayList<String?> = selected
    }

    fun getSpeed(currentLocation: Location, oldLocation: Location): Double {
        val newLat: Double = currentLocation.latitude
        val newLon: Double = currentLocation.longitude
        val oldLat: Double = oldLocation.latitude
        val oldLon: Double = oldLocation.longitude
        if (currentLocation.hasSpeed()) {
            return currentLocation.speed.toDouble()
        } else {
            val radius = 6371000.0
            val dLat = Math.toRadians(newLat - oldLat)
            val dLon = Math.toRadians(newLon - oldLon)
            val a = sin(dLat / 2) * sin(dLat / 2) +
                    cos(Math.toRadians(newLat)) * cos(Math.toRadians(oldLat)) *
                    sin(dLon / 2) * sin(dLon / 2)
            val c = 2 * asin(sqrt(a))
            val distance = Math.round(radius * c).toDouble()
            val timeDifferent: Long = currentLocation.time - oldLocation.time
            return distance / timeDifferent
        }
    }



    fun distance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val theta = lon1 - lon2
        var dist = (sin(deg2rad(lat1))
                * sin(deg2rad(lat2))
                + (cos(deg2rad(lat1))
                * cos(deg2rad(lat2))
                * cos(deg2rad(theta))))
        dist = acos(dist)
        dist = rad2deg(dist)
        dist *= 60 * 1.1515
        return dist
    }

    private fun deg2rad(deg: Double): Double {
        return deg * Math.PI / 180.0
    }

    private fun rad2deg(rad: Double): Double {
        return rad * 180.0 / Math.PI
    }



    @SuppressLint("SimpleDateFormat")
    fun dateFormatString(date: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("MM/dd")

//        val format = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//        val localDate: LocalDate = LocalDate.parse(str, format)
//        val formatter = DateTimeFormatter.ofPattern("dd/MM", Locale.getDefault())

        return formatter.format(parser.parse(date)!!)
    }

    @SuppressLint("SimpleDateFormat")
    fun dateFormat2String(date: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("MMM dd yyyy")

        return formatter.format(parser.parse(date)!!)
    }

    @SuppressLint("SimpleDateFormat")
    fun dateFormat2mmddyy(date: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("MM/dd/yyyy")

        return formatter.format(parser.parse(date)!!)
    }


    @SuppressLint("SimpleDateFormat")
    fun dateFormatChange(date: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        val formatter = SimpleDateFormat("MMM dd yyyy  hh:mm")
        return formatter.format(parser.parse(date)!!)
    }






    fun createDialog(msg: String, activity: Activity) {
        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setTitle(activity.getString(R.string.app_name))
        alertDialogBuilder.setMessage(msg)
        alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
            alertDialog!!.dismiss()
        }
        alertDialogBuilder.setCancelable(false)
        alertDialog = alertDialogBuilder.create()
        alertDialog!!.show()
    }

    protected fun fullScreen(isDarkColor: Boolean ,activity: Activity) {
        val w = activity.window
        val v = w.decorView
        w.navigationBarColor = activity.resources.getColor(android.R.color.transparent)
        v.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        w.statusBarColor = Color.TRANSPARENT
        if (isDarkColor) {
            w.navigationBarColor =
                ContextCompat.getColor(activity, android.R.color.black)
        } else {
            w.navigationBarColor = ContextCompat.getColor(activity, android.R.color.white)
        }
    }

}

