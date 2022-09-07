package br.com.zup.gastodeviagem.ui.home.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.gastodeviagem.Constants.TEXT_ERROR
import br.com.zup.gastodeviagem.R
import br.com.zup.gastodeviagem.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
//        binding.doisbtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.id == R.id.button_calculate) {
                executeEdtCamps()
                //            else if(view.id == R.id.doisbtn) {
                //                responseTest()
                //            }
            }
        }
    }

    private val isValidateEdt = {
        (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }
    private val executeEdtCamps = {
        if (isValidateEdt()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val totalValue = (distance * price) / autonomy
            binding.txtValueGast.text = "R$: ${"%.2f".format(totalValue)}"
            clearCampsEdt()
        } else {
            Toast.makeText(this, "$TEXT_ERROR", Toast.LENGTH_LONG).show()
        }
    }
    private val clearCampsEdt = {
        binding.editDistance.text.clear()
        binding.editPrice.text.clear()
        binding.editAutonomy.text.clear()
    }
//    val a = {azul:String, B:String ->}
//    fun click(): Unit {}
    //    private fun isValidate(): Boolean {
//        return (binding.editDistance.text.toString() != ""
//                && binding.editPrice.text.toString() != ""
//                && binding.editAutonomy.text.toString() != ""
//                && binding.editAutonomy.text.toString().toFloat() != 0f)
//    }
//    @SuppressLint("SetTextI18n")
//    private fun calculete() {
//        if (isValidate()) {
//            val distance = binding.editDistance.text.toString().toFloat()
//            val price = binding.editPrice.text.toString().toFloat()
//            val autonomy = binding.editAutonomy.text.toString().toFloat()
//            val totalValue = (distance * price) / autonomy
//            binding.textTotalValue.text = "R$: ${"%.2f".format(totalValue)}"
//        } else {
//            Toast.makeText(this, "$TEXT_ERROR", Toast.LENGTH_LONG).show()
//        }
//    }
}