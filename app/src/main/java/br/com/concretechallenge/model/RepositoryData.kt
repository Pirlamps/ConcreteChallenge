package br.com.concretechallenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RepositoryData(
        @SerializedName("total_count") val totalCount: Int,
        @SerializedName("incomplete_results") val incompleteResults: Boolean,
        @SerializedName("items") val items: List<Item>
) : Parcelable

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

@Parcelize
data class Owner(
        @SerializedName("login") val login: String,
        @SerializedName("id") val id: Int,
        @SerializedName("avatar_url") val avatarUrl: String,
        @SerializedName("url") val url: String
) : Parcelable