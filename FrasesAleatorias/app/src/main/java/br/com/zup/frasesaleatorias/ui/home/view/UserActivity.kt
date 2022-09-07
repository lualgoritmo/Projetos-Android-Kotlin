package br.com.zup.frasesaleatorias.ui.home.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.frasesaleatorias.R
import br.com.zup.frasesaleatorias.constants.USER_NAME
import br.com.zup.frasesaleatorias.databinding.ActivityUserBinding
import br.com.zup.frasesaleatorias.domain.model.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnSaveUser.setOnClickListener(this)
    }

    override fun onClick(view: View) {
////        val shared: SharedPreferences = this.getSharedPreferences(NAME, 1)
//        val shared: SharedPreferences = applicationContext.getSharedPreferences(NAME, )
        if (view.id == R.id.btnSaveUser) {
            handleSave()
        }
    }
//    VERIFICAR SE O SHAREDPREFERENCE TEM UM DADO OU NÃO
//    private fun verifyUserName() {
//        val name = "${SecurityPreferences(this).getString(USER_NAME)}"
//
//        if (name != "") {
//            startActivity(Intent(this, HomeActivity::class.java))
//            finish()
//        }
//    }

    private fun handleSave() {
        val name = binding.edName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(USER_NAME, name)
            startActivity(Intent(this, HomeActivity::class.java))
            clearName()
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_LONG).show()
        }
    }

    private fun clearName() {
        binding.edName.text.clear()
    }
}