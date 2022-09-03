package br.com.zup.cepapi.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.cepapi.data.model.CepResult
import br.com.zup.cepapi.domain.repository.CepRepository
import br.com.zup.cepapi.domain.usecase.GetCepUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterCepViewModel(application: Application) : AndroidViewModel(application) {

    private val _cepResponse = MutableLiveData<CepResult>()
    val cepResponse: LiveData<CepResult> = _cepResponse
    private val getCepUseCase = GetCepUseCase(CepRepository())

    fun getCep(cep: String) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    getCepUseCase.execute(cep)
                }
                _cepResponse.value = response
            } catch (ex: Exception) {
                Log.i("Error", "${ex.message}")
            }
        }
    }
}