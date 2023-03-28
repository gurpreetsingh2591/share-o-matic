package com.macrew.medirydes.uiControler.login.model.loginNew

import android.os.Parcel
import android.os.Parcelable

data class UserDetail(
    val address: String?,
    val age: String?,
    val birthday: String?,
    val broker_id: String?,
    val company_code: String?,
    val company_id: Int?,
    val created_at: String?,
    val gender: String?,
    val height: String?,
    val id: Int?,
   // val image: Image?,
    val image_content_type: String?,
    val image_file_name: String?,
    val image_file_size: Int?,
    val image_updated_at: String?,
    val image_url: String?,
    val inches: String?,
    val license_expire: String?,
    val license_number: String?,
    val member_id: String?,
    val updated_at: String?,
    val user_id: Int?,
    val website: String?,
    val weight: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
       // parcel.readParcelable(Image::class.java.classLoader),
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
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(address)
        parcel.writeString(age)
        parcel.writeString(birthday)
        parcel.writeString(broker_id)
        parcel.writeString(company_code)
        parcel.writeValue(company_id)
        parcel.writeString(created_at)
        parcel.writeString(gender)
        parcel.writeString(height)
        parcel.writeValue(id)
      //  parcel.writeParcelable(image, flags)
        parcel.writeString(image_content_type)
        parcel.writeString(image_file_name)
        parcel.writeValue(image_file_size)
        parcel.writeString(image_updated_at)
        parcel.writeString(image_url)
        parcel.writeString(inches)
        parcel.writeString(license_expire)
        parcel.writeString(license_number)
        parcel.writeString(member_id)
        parcel.writeString(updated_at)
        parcel.writeValue(user_id)
        parcel.writeString(website)
        parcel.writeString(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDetail> {
        override fun createFromParcel(parcel: Parcel): UserDetail {
            return UserDetail(parcel)
        }

        override fun newArray(size: Int): Array<UserDetail?> {
            return arrayOfNulls(size)
        }
    }
}