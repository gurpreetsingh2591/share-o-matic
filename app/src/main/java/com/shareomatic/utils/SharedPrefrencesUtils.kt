package com.shareomatic.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.shareomatic.annotation.Constants

object SharedPrefrencesUtils {

    private const val SHARED_PREFERENCES = Constants.PREFERENCE_NAME
    private const val SHARED_PREFERENCES_COMPANY = Constants.PREFERENCE_NAME_COMPANY
    private const val SHARED_PREFERENCES_BIO_AUTH = Constants.PREFERENCE_NAME_COMPANY_AUTH

    private var sPreferencesCompany: SharedPreferences? = null
    private var sPreferences: SharedPreferences? = null
    private var sPreferencesBioAuth: SharedPreferences? = null
    private var editorCompany: SharedPreferences.Editor? = null
    private var editor: SharedPreferences.Editor? = null
    private var editorBioAuth: SharedPreferences.Editor? = null

    private const val IS_USER_LOGIN = Constants.IS_USER_LOGIN
    private const val IS_USER_DRIVER = Constants.IS_USER_DRIVER
    private const val IS_USER_ADMIN = Constants.IS_USER_ADMIN
    private const val IS_USER_LOGIN_BIO = Constants.IS_USER_BIO_LOGIN
    private const val IS_USER_LOGIN_BIO_SKIP = Constants.IS_USER_BIO_LOGIN_SKIP
    private const val USER_ID = Constants.USER_ID
    private const val TOKEN = Constants.TOKEN
    private const val ROLE = Constants.ROLE
    private const val STATUS = Constants.STATUS
    private const val SCHEDULE_STATUS = Constants.SCHEDULE_STATUS
    private const val PICK_UP_COMPLETE = "PickUpComplete"

    private const val COMPANY_ID = Constants.COMPANY_ID
    private const val IS_COMPANY_ID = Constants.IS_COMPANY_ID
    private const val COMPANY_CODE = Constants.COMPANY_CODE
    private const val COMPANY_NAME = Constants.COMPANY_NAME
    private const val COMPANY_PHONE = Constants.COMPANY_PHONE
    private const val COMPANY_ADDRESS = Constants.COMPANY_ADDRESS
    private const val COMPANY_WEBSITE = Constants.COMPANY_WEBSITE
    private const val COMPANY_IMAGE = Constants.COMPANY_IMAGE
    private const val COMPANY_EMAIL = Constants.COMPANY_EMAIL
    private const val COMPANY_LATITUDE = Constants.COMPANY_LATITUDE
    private const val COMPANY_LONGITUDE = Constants.COMPANY_LONGITUDE
    private const val VEHICLE_ID = Constants.VEHICLE_ID
    private const val DRIVER_ID = Constants.DRIVER_ID
    private const val COMPANY_ADMIN_ID = Constants.COMPANY_ADMIN_ID


    private const val TIME_ZONE = Constants.TIME_ZONE
    private const val TIME_FORMAT = Constants.TIME_FORMAT_TYPE
    private const val DATE_FORMAT = Constants.DATE_FORMAT_TYPE
    private const val DISTANCE_FORMAT = Constants.DISTANCE_FORMAT

    private const val USER_NAME = Constants.USER_NAME
    private const val USER_EMAIL = Constants.USER_EMAIL
    private const val USER_PHONE = Constants.USER_PHONE
    private const val USER_SIGN = Constants.USER_SIGN
    private const val Address = Constants.Address
    private const val DOB = Constants.DOB
    private const val Country = Constants.Country
    private const val State = Constants.State
    private const val City = Constants.City
    private const val Pin = Constants.Pin
    private const val Gender = Constants.Gender
    private const val AGE = Constants.AGE
    private const val LICENCE_NO = Constants.LICENCE_NO
    private const val IMAGE = Constants.IMAGE
    private const val FcmToken = Constants.FcmToken
    private const val DeviceId = Constants.DeviceId
    private const val transport_id = Constants.TRANSPORT_ID
    private const val Current_lat = Constants.LAT
    private const val Current_long = Constants.LONG
    private const val MOBILITY_TYPE = Constants.MOBILITY

    @SuppressLint("CommitPrefEdits")
    fun init(context: Context?) {
        sPreferences = context?.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        editor = sPreferences!!.edit()
    }

    @SuppressLint("CommitPrefEdits")
    fun initCompany(context: Context?) {
        sPreferencesCompany =
            context?.getSharedPreferences(SHARED_PREFERENCES_COMPANY, Context.MODE_PRIVATE)
        editorCompany = sPreferencesCompany!!.edit()
    }

    @SuppressLint("CommitPrefEdits")
    fun initBioAuth(context: Context?) {
        sPreferencesBioAuth =
            context?.getSharedPreferences(SHARED_PREFERENCES_BIO_AUTH, Context.MODE_PRIVATE)
        editorBioAuth = sPreferencesBioAuth!!.edit()
    }

    //get is user login?
    fun isUserLogin(): Boolean? {
        return sPreferences?.getBoolean(IS_USER_LOGIN, false)
    }

    //get is user login?
    fun isUserDriver(): Boolean? {
        return sPreferences?.getBoolean(IS_USER_DRIVER, false)
    }

    //get is user login?
    fun isUserAdmin(): Boolean? {
        return sPreferences?.getBoolean(IS_USER_ADMIN, false)
    }

    //get is user bio login?
    fun isUserBioLogin(): Boolean? {
        return sPreferencesBioAuth?.getBoolean(IS_USER_LOGIN_BIO, false)
    }

    //get is user bio login skip?
    fun isUserBioLoginSkip(): Boolean? {
        return sPreferencesBioAuth?.getBoolean(IS_USER_LOGIN_BIO_SKIP, false)
    }

    //get is user bio login skip?
    fun isCompanyDetail(): Boolean? {
        return sPreferencesCompany?.getBoolean(IS_COMPANY_ID, false)
    }

    //get user detail
    fun getUserId(): String? {
        return sPreferences?.getString(USER_ID, "")
    }

    fun getUserName(): String? {
        return sPreferences?.getString(USER_NAME, "")
    }


    fun getUserEmail(): String? {
        return sPreferences?.getString(USER_EMAIL, "")
    }

    fun getUserNumber(): String? {
        return sPreferences?.getString(USER_PHONE, "")
    }

    fun getUserSignature(): String? {
        return sPreferences?.getString(USER_SIGN, "")
    }

    fun getUserImage(): String? {
        return sPreferences?.getString(IMAGE, "")
    }

    fun getUserToken(): String? {
        return sPreferences?.getString(TOKEN, "")
    }

    fun getAddress(): String? {
        return sPreferences?.getString(Address, "")
    }

    fun getCountry(): String? {
        return sPreferences?.getString(Country, "")
    }

    fun getState(): String? {
        return sPreferences?.getString(State, "")
    }

    fun getCity(): String? {
        return sPreferences?.getString(City, "")
    }

    fun getDob(): String? {
        return sPreferences?.getString(DOB, "")
    }

    fun getAge(): String? {
        return sPreferences?.getString(AGE, "")
    }

    fun getGender(): String? {
        return sPreferences?.getString(Gender, "")
    }

    fun getPin(): String? {
        return sPreferences?.getString(Pin, "")
    }

    fun getDeviceId(): String? {
        return sPreferences?.getString(DeviceId, "")
    }

    fun getFcmToken(): String? {
        return sPreferences?.getString(FcmToken, "")
    }


    //get Company detail
    fun getCompanyCode(): String? {
        return sPreferences?.getString(COMPANY_CODE, "")
    }

    fun getCompanyName(): String? {
        return sPreferencesCompany?.getString(COMPANY_NAME, "")
    }

    fun getCompanyEmail(): String? {
        return sPreferencesCompany?.getString(COMPANY_EMAIL, "")
    }

    fun getCompanyWebSite(): String? {
        return sPreferencesCompany?.getString(COMPANY_WEBSITE, "")
    }
    fun getLicenceNo(): String? {
        return sPreferences?.getString(LICENCE_NO, "")
    }

    fun getCompanyPhone(): String? {
        return sPreferencesCompany?.getString(COMPANY_PHONE, "")
    }

    fun getCompanyAddress(): String? {
        return sPreferencesCompany?.getString(COMPANY_ADDRESS, "")
    }
    fun getCompanyImage(): String? {
        return sPreferencesCompany?.getString(COMPANY_IMAGE, "")
    }
    fun getCompanyId(): String? {
        return sPreferencesCompany?.getString(COMPANY_ID, "")
    }
    fun getCompanyLat(): String? {
        return sPreferencesCompany?.getString(COMPANY_LATITUDE, "")
    }
    fun getCompanyLong(): String? {
        return sPreferencesCompany?.getString(COMPANY_LONGITUDE, "")
    }


    fun getCompanyAdminId(): String? {
        return sPreferences?.getString(COMPANY_ADMIN_ID, "")
    }
    fun getDriverId(): String? {
        return sPreferences?.getString(DRIVER_ID, "")
    }

    //get current lat long
    fun getCurrentLat(): String? {
        return sPreferences?.getString(Current_lat, "")
    }

    fun getCurrentLong(): String? {
        return sPreferences?.getString(Current_long, "")
    }


    fun getTransId(): String? {
        return sPreferences?.getString(transport_id, "")
    }

    fun getRole(): String? {
        return sPreferences?.getString(ROLE, "")
    }

    fun getTripStatus(): String? {
        return sPreferences?.getString(STATUS, "")
    }


    fun setTripStatus(status: String) {
        sPreferences?.edit()
            ?.putString(STATUS, status)
            ?.apply()
    }

    fun getScheduleStatus(): String? {
        return sPreferences?.getString(SCHEDULE_STATUS, "")
    }

    fun setScheduleStatus(status: String) {
        sPreferences?.edit()
            ?.putString(SCHEDULE_STATUS, status)
            ?.apply()
    }

    fun getDropOffReturn(): String? {
        return sPreferences?.getString("Drop", "")
    }

    fun setDropOffReturn(status: String) {
        sPreferences?.edit()
            ?.putString("Drop", status)
            ?.apply()
    }


    fun getPickUpComplete(): Boolean? {
        return sPreferences?.getBoolean(PICK_UP_COMPLETE, false)
    }

    fun setPickUPComplete(pickup: Boolean) {
        sPreferences?.edit()
            ?.putBoolean(PICK_UP_COMPLETE, pickup)
            ?.apply()
    }


    fun getMobilityType(): String? {
        return sPreferences?.getString(MOBILITY_TYPE, "")

    }

    // set user and company detail
    fun setFcmToken(token: String) {
        sPreferences?.edit()
            ?.putString(FcmToken, token)
            ?.apply()
    }

    fun setMobilityType(type: String) {
        sPreferences?.edit()
            ?.putString(MOBILITY_TYPE, type)
            ?.apply()
    }

    fun setDeviceId(device: String) {
        sPreferences?.edit()
            ?.putString(DeviceId, device)
            ?.apply()
    }

    fun setCurrentLat(lat: String) {
        sPreferences?.edit()
            ?.putString(Current_lat, lat)
            ?.apply()
    }

    fun setCurrentLong(long: String) {
        sPreferences?.edit()
            ?.putString(Current_long, long)
            ?.apply()
    }


    fun getTimeFormat(): String? {
        return sPreferences?.getString(TIME_FORMAT, "")
    }

    fun getTimeZone(): String? {
        return sPreferences?.getString(TIME_ZONE, "")
    }

    fun geDateFormat(): String? {
        return sPreferences?.getString(DATE_FORMAT, "")
    }

    fun getDistanceType(): String? {
        return sPreferences?.getString(DISTANCE_FORMAT, "")

    }

    @SuppressLint("CommitPrefEdits")
    fun setCompanyDetail(
        id: String?,
        company_name: String?,
        company_code: String?,
        company_phone: String?,
        company_address: String?,
        company_email: String?,
        company_website: String?,
        company_image: String?,
        vehicle_id: String?,
        latitude: String?,
        longitude: String?,


        ) {
        sPreferencesCompany?.edit()
            ?.putString(COMPANY_ID, id)
            ?.putString(COMPANY_NAME, company_name)
            ?.putString(COMPANY_CODE, company_code)
            ?.putString(COMPANY_PHONE, company_phone)
            ?.putString(COMPANY_ADDRESS, company_address)
            ?.putString(COMPANY_EMAIL, company_email)
            ?.putString(COMPANY_WEBSITE, company_website)
            ?.putString(COMPANY_IMAGE, company_image)
            ?.putString(VEHICLE_ID, vehicle_id)
            ?.putString(COMPANY_LATITUDE, latitude)
            ?.putString(COMPANY_LONGITUDE, longitude)
            ?.apply()
    }

    @SuppressLint("CommitPrefEdits")
    fun setIsCompanyDetail(
        id: String?,
        isDetail: Boolean,
        ) {
        sPreferencesCompany?.edit()
            ?.putString(COMPANY_ID, id)
            ?.putBoolean(IS_COMPANY_ID, isDetail)
            ?.apply()
    }
    @SuppressLint("CommitPrefEdits")
    fun setFormatDetail(
        dateFormat: String?,
        distanceFormat: String?,
        timeZone: String?,
        timeFormat: String?,
    ) {
        sPreferences?.edit()
            ?.putString(DATE_FORMAT, dateFormat)
            ?.putString(DISTANCE_FORMAT, distanceFormat)
            ?.putString(TIME_ZONE, timeZone)
            ?.putString(TIME_FORMAT, timeFormat)
            ?.apply()
    }

    fun setUserBioLogin(
        bioAuth: Boolean,
    ) {
        sPreferencesBioAuth?.edit()
            ?.putBoolean(IS_USER_LOGIN_BIO, bioAuth)
            ?.apply()
    }
    fun setUserBioLoginSkip(
        bioAuth: Boolean,
    ) {
        sPreferencesBioAuth?.edit()
            ?.putBoolean(IS_USER_LOGIN_BIO_SKIP, bioAuth)
            ?.apply()
    }
    fun setUserLogin(
        status: Boolean,
        statusDriver: Boolean,
        statusAdmin: Boolean,
        id: String?,
        driverId: String?,
        companyAdminId: String?,
        name: String?,
        email: String?,
        phone: String?,
        token: String?,
        gender: String?,
        age: String?,
        licenceNo: String?,
        image_file_name: String?,
        image_sign: String?

    ) {
        sPreferences?.edit()
            ?.putBoolean(IS_USER_LOGIN, status)
            ?.putBoolean(IS_USER_DRIVER, statusDriver)
            ?.putBoolean(IS_USER_ADMIN, statusAdmin)
            ?.putString(USER_ID, id)
            ?.putString(DRIVER_ID, driverId)
            ?.putString(COMPANY_ADMIN_ID, companyAdminId)
            ?.putString(USER_NAME, name)
            ?.putString(USER_EMAIL, email)
            ?.putString(USER_PHONE, phone)
            ?.putString(TOKEN, token)
            ?.putString(Gender, gender)
            ?.putString(AGE, age)
            ?.putString(LICENCE_NO, licenceNo)
            ?.putString(IMAGE, image_file_name)
            ?.putString(USER_SIGN, image_sign)
            ?.apply()
    }

    fun setUserLogin(
        name: String?,
        email: String?,
        phone: String?,
        token: String?,
        gender: String?,
        age: String?,
        image_file_name: String?,
        image_sign: String?

    ) {
        sPreferences?.edit()
            ?.putString(USER_NAME, name)
            ?.putString(USER_EMAIL, email)
            ?.putString(USER_PHONE, phone)
            ?.putString(TOKEN, token)
            ?.putString(Gender, gender)
            ?.putString(AGE, age)
            ?.putString(IMAGE, image_file_name)
            ?.putString(USER_SIGN, image_sign)
            ?.apply()
    }


    fun clearUser() {
        sPreferences?.edit()
            ?.clear()
            ?.apply()
    }

    fun clearCompanyDetail() {
        sPreferencesCompany?.edit()
            ?.clear()
            ?.apply()
    }

    fun clearBioAuth() {
        sPreferencesBioAuth?.edit()
            ?.clear()
            ?.apply()
    }
}