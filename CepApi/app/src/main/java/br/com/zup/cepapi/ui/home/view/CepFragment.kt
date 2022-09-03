package br.com.zup.cepapi.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.zup.cepapi.databinding.FragmentCepBinding
import br.com.zup.cepapi.ui.home.viewmodel.RegisterCepViewModel

class CepFragment : Fragment() {

    private lateinit var binding: FragmentCepBinding

    private val viewModel: RegisterCepViewModel by lazy {
        ViewModelProvider(this)[RegisterCepViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCepBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSendCep.setOnClickListener {
            val cep = binding.etCep.text.toString()
            viewModel.getCep(cep)
            limpCep()
            receptCep()
        }
    }

    private fun limpCep() {
        binding.etCep.text.clear()
    }
    private fun receptCep() {
        viewModel.cepResponse.observe(viewLifecycleOwner, Observer {
            it.let {
                binding.tvCep.text = it.cep
                binding.tvCity.text = it.cidade
                binding.tvDistrict.text = it.bairro
                binding.tvRoad.text = it.logradouro
                binding.tvUF.text = it.estado
            }
        })
    }
}