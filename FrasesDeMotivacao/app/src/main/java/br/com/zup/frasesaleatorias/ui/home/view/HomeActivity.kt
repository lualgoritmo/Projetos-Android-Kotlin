package br.com.zup.frasesaleatorias.ui.home.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.zup.frasesaleatorias.R
import br.com.zup.frasesaleatorias.constants.*
import br.com.zup.frasesaleatorias.data.Mock
import br.com.zup.frasesaleatorias.databinding.ActivityHomeBinding
import br.com.zup.frasesaleatorias.domain.model.SecurityPreferences

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    private var categoryId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        handleUserName()
        handleFilter(R.id.imageAll)
        binding.btnNewFrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnNewFrase -> {
                supportActionBar?.show()
                handleNextPhrase()
            }
            in listOf(R.id.imageAll, R.id.imageHappy, R.id.imageSunny) -> {
                handleFilter(view.id)
            }
        }
    }

    private fun handleUserName() {
        val name = "${SecurityPreferences(this).getString(USER_NAME)}"
        binding.txtOla.text = "$OLA, $name"
    }

    private fun handleNextPhrase() {
        if (categoryId == ALL || categoryId == HAPPY) {
            binding.textPhrase.text = Mock().getPhrase(categoryId)
        } else {
            handleMaria()
        }
    }

    private fun handleMaria() {
        binding.textPhrase.text = Mock().getPhraseMaria(SUNNY)
    }

    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))

        when (id) {
            R.id.imageAll -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.teal_200))
                categoryId = ALL
            }
            R.id.imageHappy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.teal_200))
                categoryId = HAPPY
            }
            else -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.teal_200))
                categoryId = SUNNY
            }
        }
    }
}