package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("pluralName") val pluralName: String?,
    @SerializedName("shortName") val shortName: String?,
    @SerializedName("icon") val iconDto: IconDto?,
    @SerializedName("primary") val primary: Boolean?
)