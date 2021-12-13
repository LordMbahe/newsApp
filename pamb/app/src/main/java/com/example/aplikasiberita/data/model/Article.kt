package com.example.aplikasiberita.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(

    @Expose
    @SerializedName("created_at")
    val createdAt: String?,
    @Expose
    @SerializedName("creator")
    val creator: String?,
    @Expose
    @SerializedName("title")
    val title: String?,
    @Expose
    @SerializedName("content")
    val content: String?,
    @Expose
    @SerializedName("image")
    val image: String?

): Parcelable
