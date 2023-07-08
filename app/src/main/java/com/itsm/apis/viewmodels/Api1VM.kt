package com.itsm.apis.viewmodels

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itsm.apis.models.Api1Model
import com.itsm.apis.models.Translation
import kotlinx.coroutines.launch

class Api1VM : ViewModel() {

    private var _translation = MutableLiveData<String>()
    val translation: LiveData<String> = _translation

    private val model = Api1Model()

    fun translate(text: String, source:String, target:String, lifecycleScope: LifecycleCoroutineScope){
        lifecycleScope.launch {
            _translation.value = model.translate(text,source,target)
        }
    }

}