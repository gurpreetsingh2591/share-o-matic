package com.macrew.medirydes.uiControler.login.model.loginNew

import android.os.Parcel
import android.os.Parcelable

data class Original(
    val path: String?,
    val url: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(path)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Original> {
        override fun createFromParcel(parcel: Parcel): Original {
            return Original(parcel)
        }

        override fun newArray(size: Int): Array<Original?> {
            return arrayOfNulls(size)
        }
    }
}