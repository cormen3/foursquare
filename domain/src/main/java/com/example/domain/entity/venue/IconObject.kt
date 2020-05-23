package com.example.domain.entity.venue

data class IconObject(
    val prefix: String?,
    val suffix: String?
) {
    override fun toString(): String {
        return "${prefix}88$suffix"
    }
}