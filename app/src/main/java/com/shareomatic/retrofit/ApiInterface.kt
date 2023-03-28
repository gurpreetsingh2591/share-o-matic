package com.shareomatic.retrofit


import com.macrew.medirydes.uiControler.login.model.loginNew.LoginModelNew
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*


interface ApiInterface {

    /*Driver API's*/

    // login api
    @FormUrlEncoded
    @POST(WebUrl.API_LOGIN)
    fun getLogin(
        @Field(Constant.EMAIL) email: String,
        @Field(Constant.PASSWORD) password: String,
        @Field(Constant.COMPANY_ID) company_id: String
    ): Call<LoginModelNew>




    // get future data
    @GET(WebUrl.API_GET_REPORTS)
    fun getReportData(
        @Query(Constant.FROM_DATE) fromDate: String,
        @Query(Constant.TO_DATE) toDate: String,
    ): Call<String>


    //get start Schedule
    @FormUrlEncoded
    @POST(WebUrl.API_START_SCHEDULE +"/{id}")
    fun getStartSchedule(
        @Path("id") id: String?,
        @Field(Constant.METHOD) method: String,
        @Field(Constant.STATUS) status: String
    ): Call<String>

    //post Edit Profile
    @Multipart
    @POST(WebUrl.API_GET_EDIT_PROFILE)
    fun getEditProfile(
        @PartMap partMap: HashMap<String, RequestBody>,
        @Part file: MultipartBody.Part
    ): Call<String>





}