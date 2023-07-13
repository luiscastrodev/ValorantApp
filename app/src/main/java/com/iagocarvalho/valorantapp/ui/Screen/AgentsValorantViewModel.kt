package com.iagocarvalho.valorantapp.ui.Screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagocarvalho.valorantapp.model.Responses.Data
import com.iagocarvalho.valorantapp.model.Responses.ModelValorant
import com.iagocarvalho.valorantapp.model.ValorantRespository
import kotlinx.coroutines.launch

class AgentsValorantViewModel(): ViewModel() {

    private val respository = ValorantRespository()

    private val _valorantAgents = MutableLiveData<ModelValorant>()
    val valorantAgents: LiveData<ModelValorant> = _valorantAgents

    fun fetValorantAgents(){
        viewModelScope.launch {
            try {
                val agents = respository.getValorantCards()
                _valorantAgents.value = agents
            }catch (e: Exception){
                Log.d("EXC", "fetValorantAgents: ${e.message.toString()}")
            }
        }
    }


}