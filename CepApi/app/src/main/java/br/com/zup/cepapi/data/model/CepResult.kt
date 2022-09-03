package br.com.zup.cepapi.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CepResult(
    @SerializedName("bairro")
    var bairro: String,
    @SerializedName("cep")
    var cep: String,
    @SerializedName("cidade")
    var cidade: String,
    @SerializedName("estado")
    var estado: String,
    @SerializedName("logradouro")
    var logradouro: String
) : Parcelable