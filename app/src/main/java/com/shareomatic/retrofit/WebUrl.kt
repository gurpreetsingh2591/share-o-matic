package com.shareomatic.retrofit

interface WebUrl {
    companion object {

        //Admin API's
       // const val API_LOGIN = "admin/admin_login"
        const val API_LOGIN = "login"
        const val API_BIO_LOGIN = "biometriclogin"
        const val API_VERIFY_COMPANY= "checkcompany"
        const val API_FORGOT_PASSWORD = "forgotpassword"
        const val API_GET_DASHBOARD = "users/schedules"
        const val API_START_SCHEDULE = "schedules"
        const val API_GET_FUTURE="users/futureschedules"
        const val API_GET_CHANGE_STATUS="users/changeschedule"
        const val API_GET_REPORTS="users/historyschedules"
        const val JSON_GET_INSPECTION_LIST="inspectionList.json"
        const val API_GET_INSPECTION_DETAIL="inspections"
        const val API_POST_REARRANGE_LIST="tripsorting"
        const val API_GET_EDIT_PROFILE="editprofile"
        const val API_GET_PROFILE_DATA="userdetails"
        const val API_GET_START_TRIP="trips"
        const val API_GET_AVAILABILITY="availability"
        const val API_POST_AVAILABILITY="availability"
        const val API_POST_INCIDENT="incidents"
        const val API_POST_TOKEN="users/device_token"
        const val API_GET_NOTIFICATIONS="notifications"
        const val API_GET_PDF_LOG="pdflogs"
        const val API_TRIP_SIGNATURE="tripsignature"
        const val API_DRIVER_ADD_SIGNATURE="users/add_signature"
        const val API_DRIVER_VEHICLE="users/vehicle_driver"
        const val API_EXCHANGE_TRIP="exchangetrip"
        const val API_REMOVE_AVAILABILITY="remove_availability"
        const val API_update_device_id="users/update_device_id"

        /*admin end points*/
        const val API_PASSENGER_LIST="getpassenger?"
        const val API_BROKER_LIST="getbroker?"
        const val API_COMPANY_TRIP_LIST="companytrip?"
        const val API_COMPANY_TRIP_LEGS_LIST="companytriplegs?"
        const val API_TRIP_NUMBER="tripsnumber"
        const val API_CREATE_TRIP="createtrip"
        const val API_VEHICLE_LIST="getvehicle?"
        const val API_DRIVER_LIST="getdriver?"
        const val API_CANCEL_TRIP="canceltrip"
        const val API_ASSIGN_TRIP="assigntrip"
        const val API_COMPLETE_TRIP="completetrip"
        const val API_UN_ASSIGN_TRIP="unassigntrip"
        const val API_DELETE_TRIP="triplegdelete?"
        const val API_DRIVER_REPORT="singledriverreport?"
        const val API_DASHBOARD_API="dashboardAPI?"
        const val API_LEG_DETAIL_API="editcompanylegs?"
        const val API_LEG_UPDATE_API="updatecompanylegs"
        const val API_SEND_NOTIFICATION_API="sendnotification?"
        const val API_PAYMENT_STATUS_API="legpayment?"
        const val API_TOTAL_TRIP_API="totaltrip"
        const val API_ASSIGN_API="assigntotaltrip"

        //com.macrew.medirydes.uiControler.login.model.login.com.macrew.medirydes.uiControler.dashboard.model.currentSchedule.com.macrew.medirydes.uiControler.dashboard.model.abc.com.macrew.medirydes.uiControler.dashboard.model.profile.User API's
        const val API_USER_LOGIN = "login"

    }

}