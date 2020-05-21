package com.example.presentation.ui.venue

import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.ActivityResultObject
import com.example.domain.entity.PermissionResultObject
import com.example.presentation.base.BaseViewModel
import javax.inject.Inject

class VenueSharedViewModel @Inject constructor() : BaseViewModel() {

    private val _activityResultData = MutableLiveData<ActivityResultObject>()
    val activityResultData: MutableLiveData<ActivityResultObject> = _activityResultData

    private val _permissionResultData = MutableLiveData<PermissionResultObject>()
    val permissionResultData: MutableLiveData<PermissionResultObject> = _permissionResultData


    fun setActivityResultData(item: ActivityResultObject) {
        _activityResultData.value = item
    }

    fun setPermissionResultData(item: PermissionResultObject) {
        _permissionResultData.value = item
    }
}