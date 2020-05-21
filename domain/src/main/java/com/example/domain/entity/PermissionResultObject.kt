package com.example.domain.entity

data class PermissionResultObject(
    val requestCode: Int,
    val permissions: Array<out String>,
    val grantResults: IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PermissionResultObject

        if (requestCode != other.requestCode) return false
        if (!permissions.contentEquals(other.permissions)) return false
        if (!grantResults.contentEquals(other.grantResults)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = requestCode
        result = 31 * result + permissions.contentHashCode()
        result = 31 * result + grantResults.contentHashCode()
        return result
    }
}