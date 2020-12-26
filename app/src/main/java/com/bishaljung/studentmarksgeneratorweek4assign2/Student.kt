package com.bishaljung.studentmarksgeneratorweek4assign2;

import android.os.Parcel
import android.os.Parcelable
data class Student(val ID: String?, val name: String?, val androidMarks:Float, val apiMarks:Float, val iotMarks:Float) : Parcelable {
        constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat()) {
        }
        override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ID)
        parcel.writeString(name)
        parcel.writeFloat(androidMarks)
        parcel.writeFloat(apiMarks)
        parcel.writeFloat(iotMarks)
        }
        override fun describeContents(): Int {
        return 0
        }
        companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
        return Student(parcel)
        }
        override fun newArray(size: Int): Array<Student?> {
        return arrayOfNulls(size)
        }
        }
        }