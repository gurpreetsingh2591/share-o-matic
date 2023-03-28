package com.macrew.medirydes.uiControler.login.model.loginNew

import android.os.Parcel
import android.os.Parcelable

data class LoginModelNew(
    val StatusCode: String?,
    val message: String?,
    val result: LoginResult?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(LoginResult::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(StatusCode)
        parcel.writeString(message)
        parcel.writeParcelable(result, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginModelNew> {
        override fun createFromParcel(parcel: Parcel): LoginModelNew {
            return LoginModelNew(parcel)
        }

        override fun newArray(size: Int): Array<LoginModelNew?> {
            return arrayOfNulls(size)
        }
    }
}