package com.macrew.medirydes.uiControler.login.model.loginNew

import android.os.Parcel
import android.os.Parcelable


data class User(
    val device_token: String?,
    val email: String?,
    val email_verified_at: String?,
    val id: Int?,
    val is_phone_verified: String?,
    val last_login: String?,
    val name: String?,
    val phone: String?,
    val status: String?,
    val token: String?,
    val total_login: Int?,
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
        parcel.readValue(Int::class.java.classLoader) as? Int,
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
        parcel.writeString(last_login)
        parcel.writeString(name)
        parcel.writeString(phone)
        parcel.writeString(status)
        parcel.writeString(token)
        parcel.writeValue(total_login)
        parcel.writeString(updated_at)
        parcel.writeParcelable(user_detail, flags)
        parcel.writeString(username)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}