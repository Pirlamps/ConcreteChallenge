package br.com.concretechallenge.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(val name: String, val address: String, val photoUrl: String) : Parcelable