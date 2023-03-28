package com.macrew.medirydes.uiControler.login.model.loginNew

import android.os.Parcel
import android.os.Parcelable

data class LoginResult(
    val company: Company?,
    val user: User?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Company::class.java.classLoader),
        parcel.readParcelable(User::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(company, flags)
        parcel.writeParcelable(user, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginResult> {
        override fun createFromParcel(parcel: Parcel): LoginResult {
            return LoginResult(parcel)
        }

        override fun newArray(size: Int): Array<LoginResult?> {
            return arrayOfNulls(size)
        }
    }
}