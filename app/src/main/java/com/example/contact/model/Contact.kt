package com.example.contact.model


import android.os.Parcel
import android.os.Parcelable

/**
 * Data class representing a Contact.
 * @property id Unique identifier for the contact.
 * @property name Name of the contact.
 * @property phoneNumber Phone number of the contact.
 * @property email Email address of the contact.
 */
data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val email: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(phoneNumber)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}