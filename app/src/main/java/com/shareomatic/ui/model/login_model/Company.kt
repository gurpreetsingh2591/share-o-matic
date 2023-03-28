package com.macrew.medirydes.uiControler.login.model.loginNew

import android.os.Parcel
import android.os.Parcelable

data class Company(
    val device_token: String?,
    val email: String?,
    val email_verified_at: String?,
    val id: Int?,
    val is_phone_verified: String?,
    val isd_code: String?,
    val last_login: String?,
    val name: String?,
    val phone: String?,
    val status: String?,
    val total_login: String?,
    val updated_at: String?,
    val user_detail: UserDetail?,
    val username: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(UserDetail::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(device_token)
        parcel.writeString(email)
        parcel.writeString(email_verified_at)
        parcel.writeValue(id)
        parcel.writeString(is_phone_verified)
        parcel.writeString(isd_code)
        parcel.writeString(last_login)
        parcel.writeString(name)
        parcel.writeString(phone)
        parcel.writeString(status)
        parcel.writeString(total_login)
        parcel.writeString(updated_at)
        parcel.writeParcelable(user_detail, flags)
        parcel.writeString(username)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Company> {
        override fun createFromParcel(parcel: Parcel): Company {
            return Company(parcel)
        }

        override fun newArray(size: Int): Array<Company?> {
            return arrayOfNulls(size)
        }
    }
}