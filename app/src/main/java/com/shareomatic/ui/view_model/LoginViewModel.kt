package com.shareomatic.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.macrew.medirydes.uiControler.login.model.loginNew.LoginModelNew
import com.shareomatic.annotation.Status
import com.shareomatic.exception.ErrorHandler
import com.shareomatic.retrofit.ApiClient
import com.shareomatic.retrofit.WebResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    var responseLoginData: MutableLiveData<WebResponse<LoginModelNew>> = MutableLiveData()


    var isLoading = MutableLiveData<Boolean>()
    var isViewEnable = MutableLiveData<Boolean>()

    var errorHandler: ErrorHandler? = ErrorHandler()


    /*
     * method to call login api
     * */
    fun callGetLoginApi(email: String, password: String,company_id: String) {
        isLoading.postValue(true)
        isViewEnable.postValue(true)


        val call = ApiClient().getClient().getLogin(email,password,company_id)
            call.enqueue(object : Callback<LoginModelNew?> {
                override fun onResponse(
                    call: Call<LoginModelNew?>,
                    response: Response<LoginModelNew?>
                ) {
                    isLoading.postValue(false)
                    isViewEnable.postValue(false)
                    if (response.isSuccessful && response.body() != null) {
                        val result: LoginModelNew? = response.body()
                        if (result?.StatusCode == "200") {
                            responseLoginData.setValue(
                                WebResponse(Status.SUCCESS, result, response.body()!!.message)
                            )
                        }else {
                                responseLoginData.setValue(
                                    WebResponse(Status.FAILURE, null, response.body()!!.message)
                                )
                            }
                        } else {
                            val errorMsg = errorHandler!!.reportError(response.code())
                            responseLoginData.setValue(
                                WebResponse(
                                    Status.FAILURE,
                                    null,
                                    response.body()!!.message
                                )
                            )
                        }

                }

                override fun onFailure(
                    call: Call<LoginModelNew?>,
                    t: Throwable
                ) {
                    isLoading.postValue(false)
                    isViewEnable.postValue(false)
                     val errorMsg = errorHandler!!.reportError(t)
                    responseLoginData.setValue(WebResponse(Status.FAILURE, null, errorMsg))
                }
            })
    }


}