package com.itsm.apis.viewmodels

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itsm.apis.models.Api2Model
import com.itsm.apis.models.Team
import kotlinx.coroutines.launch

class Api2VM : ViewModel() {

    private var _list = MutableLiveData<ArrayList<Team>>()
    val list: LiveData<ArrayList<Team>> = _list

    val model = Api2Model()

    fun getAll(lifecycleScope: LifecycleCoroutineScope){
        lifecycleScope.launch {
            _list.value = model.getAll()
        }
    }

}