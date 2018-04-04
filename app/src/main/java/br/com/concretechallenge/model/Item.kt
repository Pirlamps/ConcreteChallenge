package br.com.concretechallenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("full_name") val fullName: String,
        @SerializedName("owner") val owner: Owner,
        @SerializedName("description") val description: String,
        @SerializedName("url") val url: String,
        @SerializedName("stargazers_count") val stargazersCount: Int,
        @SerializedName("forks") val forks: Int,
        @SerializedName("watchers") val watchers: Int
) : Parcelable
