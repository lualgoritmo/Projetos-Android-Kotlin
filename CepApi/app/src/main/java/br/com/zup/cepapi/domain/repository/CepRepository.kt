package br.com.zup.cepapi.domain.repository

import br.com.zup.cepapi.data.datasource.remote.RetrofitCep
import br.com.zup.cepapi.data.model.CepResult

class CepRepository {
    suspend fun getCep(cep: String): CepResult {
        return RetrofitCep.api.getAddress(cep)
    }
}