package com.example.institutodocorpohumano.view
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.institutodocorpohumano.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    //Recuperar os itens da Ui usando a funcao binding (HERDAR)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //login screen
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Escondendo a barra da login screen
        supportActionBar?.hide()

        //Passando o click do btn
        binding.btnConfirmar.setOnClickListener {

            //capturar o que o usuario ta digitando
            //Converte esse metodo em string
            val nome = binding.edtNome.text.toString()
            binding.txt.setText(nome)
            val telefone = binding.edtTelefone.text.toString()

            //Mostrar mensagem quando o nome estiver vazio
            when {
                nome.isEmpty() -> {
                    mensagem(it, "Preencha seu nome!")
                }
                telefone.isEmpty() -> {
                    mensagem(it, "Preencha seu telefone!")
                }
                telefone.length <= 10 -> {
                    mensagem(it, "O telefone precisa ter pelo menos 11 caracteres!")
                }
                else -> {
                    navegarpraHome(nome)

                }
            }
        }
        }

        //funcao pra tela de login
        private fun mensagem(view: View, mensagem: String) {
            val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
            snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
            snackbar.setTextColor(Color.parseColor("#FFFFFF"))
            snackbar.show()

        }        private fun navegarpraHome(nome: String) {
            val intent = Intent(this, Home::class.java)
            intent.putExtra("Nome", nome)
            startActivity(intent)
        }


}