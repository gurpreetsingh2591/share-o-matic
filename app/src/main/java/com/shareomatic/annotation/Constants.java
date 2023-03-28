package com.shareomatic.annotation;

public @interface Constants {
    String YES = "Yes";
    String NO = "No";
    String OK = "OK";
    String CANCEL = "Cancel";
    String TAG = "MediRydes";
    String DELETE = "Delete!";
    String DATE_FORMAT="MM-dd-yyyy";
    String DATE_FORMAT_IN="yyyy-MM-dd";
    String FORMAT_EEE_dd_MM="EEE'\n'dd/MM";
    String FORMAT_hh_mm="hh:mm";
    String LOCALE_DANISH="da";
    String ENTER_EMAIL="Please enter registered E-mail";
    String ENTER_CODE="Please enter Company Code";
    String ENTER_VALID_EMAIL="Please enter valid E-mail";
    String ENTER_PASSWORD="Please enter the password";
    String AUTH="Authorization";
    String BEARER="Bearer ";
    String RETROFIT_MANAGER="RetrofitManager";
    String UN_AUTH_USER="Unauthorised User";
    String  FORBIDDEN="Forbidden";
    String  INTERNAL_ERROR="Internal Server Error";
    String  BAD_REQUEST= "Bad Request";
    String  API_NOT_RESPONDING="Something Went Wrong API is not responding properly!";
    String  CANNOT_CONNECT_TO_SERVER="Sorry cannot connect to the server!";
    String  DEPRECATION="DEPRECATION";

    String  NO_INTERNET="No Internet Connection";
    String  HTTP_CODE="http_code";
    String  MESSAGE="message";
    String  HTTP_CACHE="http_cache";
    String  COULD_NOT_CACHE="Could not create Cache!";
    
   String ARG_PARAM_TRIP_LIST = "tripList";
   String ARG_PARAM_TRIP_Object = "tripObject";
   String ARG_PARAM_START_TIME = "startTime";
   String ARG_PARAM_END_TIME = "endTime";
   String ARG_PARAM_DATE = "date";
   String ARG_PARAM_DAY = "day";
   String NOTE= "Note: ";
   String WILLCALL= "willcall";

    // PREFERENCE=============================================================
    String IS_USER_LOGIN = "IS_USER_LOGIN";
    String IS_USER_DRIVER = "IS_USER_DRIVER";
    String IS_USER_ADMIN = "IS_USER_ADMIN";
    String IS_USER_BIO_LOGIN = "IS_USER_BIO_LOGIN";
    String IS_USER_BIO_LOGIN_SKIP = "IS_USER_BIO_LOGIN_SKIP";
    String USER_ID = "USER_ID";
    String TOKEN = "Token";
    String ROLE = "Role";
    String STATUS = "Status";
    String SCHEDULE_STATUS = "ScheduleStatus";
    String COMPANY_NAME = "company_name";
    String COMPANY_CODE = "company_code";
    String COMPANY_ID = "company_id";
    String IS_COMPANY_ID = "is_company_id";
    String COMPANY_PHONE = "company_phone";
    String COMPANY_ADDRESS = "company_address";
    String COMPANY_EMAIL = "company_EMAIL";
    String COMPANY_WEBSITE= "company_WEBSITE";
    String COMPANY_IMAGE= "company_image";
    String COMPANY_LATITUDE = "company_latitude";
    String COMPANY_LONGITUDE = "company_longitude";
    String VEHICLE_ID = "Vehicle_Id";
    String DRIVER_ID = "driver_Id";
    String COMPANY_ADMIN_ID = "company_admin_Id";
    String TIME_ZONE = "time_zone";
    String TIME_FORMAT_TYPE = "time_format";
    String DATE_FORMAT_TYPE = "date_format";
    String DISTANCE_FORMAT = "distance_format";
    String USER_NAME = "USER_NAME";
    String USER_EMAIL = "USER_EMAIL";
    String USER_PHONE = "USER_PHONE";
    String USER_SIGN = "user_sign";
    String Address = "Address";
    String DOB = "DOB";
    String AGE = "Age";
    String LICENCE_NO = "LicenceNo";
    String IMAGE = "Image";
    String Country = "Country";
    String State = "State";
    String City = "City";
    String Pin = "Pin";
    String Gender = "Gender";
    String FcmToken = "FcmToken";
    String DeviceId = "DeviceId";
    String PREFERENCE_NAME = "MediRydes";
    String PREFERENCE_NAME_COMPANY = "MediRydesCompany";
    String PREFERENCE_NAME_COMPANY_AUTH = "MediRydesBioAuth";
    String TRANSPORT_ID = "TRANSPORT_ID";
    String LAT = "Lat";
    String LONG = "Long";
    String MOBILITY = "mobility_type";
    String PASSANGER = "Passenger: ";



    /*Status*/
   String not_started = "not_started";
   String assigned = "assigned";
   String not_started_ = "Not Started";
   String started = "started";
   String completed = "completed";
   String arrived_at_pickup = "arrived_at_pickup";
   String member_on_board = "member_on_board";
   String next_of_navigate = "next_of_navigate";
   String arrived_at_drop = "arrived_at_drop";
   String confirmed_arrived_at_drop = "confirmed_arrived_at_drop";
   String confirm_arrived_at_pickup = "confirm_arrived_at_pickup";
   String next_of_navigate_pickup_location = "next_of_navigate_pickuplocation";
   String ended = "ended";
   String cancelled = "cancelled";
    String canceled = "canceled";
   String no_show = "no_show";
   String cancelled_with_sign = "cancelled_with_sign";
   String ended_with_sign = "ended_with_sign" ;
   String manually_completed = "manually_completed" ;
   String manually_cancelled = "manually_cancelled" ;
   String end_shift = "End Shift" ;
   String start_shift = "Start Shift" ;
   String re_start_shift = "Restart Shift" ;
   String shift_completed = "Shift Completed" ;
   String no_schedule = "There is no schedule Available!" ;
   String pick_up_completed_with_sign = "pick_up_completed_with_sign" ;
   String private_coordinates_channel = "private-coordinates-channel" ;
   String client_coordinates = "client-coordinates" ;
   String PusherProductionKey = "ac908c6b410dd8e739b2" ;
   String PusherDevelopmentKey = "cf31e4604b9cd823f91d" ;
   String PusherApp_id = "1312942" ;
   String PusherSecret = "6b3a6a05b8817cdd30f5" ;
   String PusherCluster = "us2" ;
   String PaymentNo = "Payment No" ;
   String PaymentYes = "Payment Yes" ;



   String AlreadyNoShow = "You already No-show this trip." ;
   String TripCompleted = "Trip completed." ;
   String AlreadyCancel = "You already cancelled this trip." ;
   String AlreadyCompleted = "You already completed this trip." ;
   String AlreadyManuallyCompleted = "You already manually completed this trip." ;
   String AlreadyManuallyCanceled = "You already manually cancelled this trip." ;
   String Cancel = "Cancel" ;
   Integer DistanceInMeter = 50 ;




}

