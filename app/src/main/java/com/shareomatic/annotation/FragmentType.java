package com.shareomatic.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({FragmentType.HOME_FRAGMENT, FragmentType.CURRENT_SHIFT_FRAGMENT,
        FragmentType.FUTURE_SHIFT_FRAGMENT,FragmentType.ORDER_FRAGMENT,
        FragmentType.REPORTS_FRAGMENT,  FragmentType.FUEL_RECEIPT_FRAGMENT,
        FragmentType.INCIDENT_FRAGMENT,FragmentType.NOTIFICATION_FRAGMENT,
        FragmentType.TRIP_DETAIL_FRAGMENT, FragmentType.REQUEST_TIME_FRAGMENT,
        FragmentType.PROFILE_FRAGMENT,FragmentType.FUEL_FRAGMENT,
        FragmentType.INSPECTION_FRAGMENT, FragmentType.TRIPS_LOG_FRAGMENT,
        FragmentType.DRIVER_REPORT_FRAGMENT, FragmentType.TRIPS_MANAGEMENT,
        FragmentType.CREATE_TRIPS, FragmentType.COMPANY_TRIPS, FragmentType.DRIVER_LIST,
        FragmentType.EN_ROUTE,FragmentType.NO_SHOW,FragmentType.ON_SCENE
        ,FragmentType.ON_BOARD ,FragmentType.CANCELLED ,FragmentType.COMPLETED,


})

public @interface FragmentType {
    String HOME_FRAGMENT = "HomeFragment";
    String CURRENT_SHIFT_FRAGMENT = "CurrentScheduleFragment";
    String FUTURE_SHIFT_FRAGMENT = "FutureShiftFragment";
    String REPORTS_FRAGMENT = "ReportsFragment";
    String REQUEST_TIME_FRAGMENT = "RequestTimeFragment";
    String PROFILE_FRAGMENT = "ProfileFragment";
    String FUEL_FRAGMENT = "FuelFragment";
    String ORDER_FRAGMENT = "OrderFragment";
    String INSPECTION_FRAGMENT = "InspectionFragment";
    String FUEL_RECEIPT_FRAGMENT = "FuelReceiptFragment";
    String TRIP_DETAIL_FRAGMENT = "TripDetailFragment";
    String INCIDENT_FRAGMENT = "IncidentFragment";
    String NOTIFICATION_FRAGMENT = "NotificationFragment";
    String TRIPS_LOG_FRAGMENT = "TripsLogFragment";
    String DRIVER_REPORT_FRAGMENT = "DriverReportFragment";
    String TRIPS_MANAGEMENT= "TripsManagementFragment";
    String COMPANY_TRIPS= "CompanyTripsFragment";
    String CREATE_TRIPS= "CreateTripsFragment";
    String DRIVER_LIST= "DriverListFragment";
    String EN_ROUTE= "En_RouteFragment";
    String NO_SHOW= "No_ShowFragment";
    String ON_SCENE= "On_SceneFragment";
    String ON_BOARD= "On_BoardFragment";
    String CANCELLED= "CancelledFragment";
    String COMPLETED= "CompletedFragment";
}
// Declare the constants
