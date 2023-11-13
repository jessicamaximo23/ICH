package com.example.institutodocorpohumano.view
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.institutodocorpohumano.R
import com.example.institutodocorpohumano.adapter.ServicosAdapter
import com.example.institutodocorpohumano.databinding.ActivityHomeBinding
import com.example.institutodocorpohumano.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Fazer o binding da pagina do home (pag de servicos)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("Nome")

        binding.tvNomeusuario.text = "Bem vindo(a), $nome"
        //passar o id do recycler view no xml-home
        val recyclerViewServicos = binding.rvServicos

        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)

        servicosAdapter = ServicosAdapter(this, listaServicos)

        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicosAdapter
        getServicos()

        binding.btnAgendarHome.setOnClickListener {
            val intent = Intent(this, Agendamento::class.java)
            intent.putExtra("Nome", nome)
            startActivity(intent)
        }
    }

    private fun getServicos() {
        //Passar o nome da imagem que eu ta na servicos.xml
        //Listar servicos
        val servico1 = Servicos(R.drawable.recovery, "Recuperação Muscular (Recovery)")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.phisio, "Fisioterapia Ortopédica")
        listaServicos.add(servico2)

        //val servico3 = Servicos(R.drawable.icone_phone, "Whats App")
       // listaServicos.add(servico3)

       // val servico4 = Servicos(R.drawable.icone_instagram, "Visite nosso Instagram")
        //listaServicos.add(servico4)

    }
}