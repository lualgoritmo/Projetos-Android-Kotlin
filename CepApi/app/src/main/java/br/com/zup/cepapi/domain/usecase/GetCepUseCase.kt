package br.com.zup.cepapi.domain.usecase

import br.com.zup.cepapi.data.model.CepResult
import br.com.zup.cepapi.domain.repository.CepRepository

class GetCepUseCase(private val repository: CepRepository) {
    suspend fun execute(cep: String): CepResult {
        return repository.getCep(cep)
    }
}