package com.macrew.medirydes.uiControler.login.model.loginNew

import android.os.Parcel
import android.os.Parcelable

data class Image(
    val original: Original?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readParcelable(Original::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(original, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: Parcel): Image {
            return Image(parcel)
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }
}