package com.example.institutodocorpohumano.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.institutodocorpohumano.R
import com.example.institutodocorpohumano.adapter.ServicosAdapter
import com.example.institutodocorpohumano.databinding.ActivityHomeBinding
import com.example.institutodocorpohumano.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

    private lateinit var imageView: ImageView

    //instagram, whatsapp
    val instagramURL =
        "https://www.instagram.com/institutodocorpohumano/?utm_source=ig_web_button_share_sheet&igshid=OGQ5ZDc2ODk2ZA=="
    val whatsappURL = "https://api.whatsapp.com/message/6ITB3NV4J6LCC1?autoload=1&app_absent=0"


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

        //icone do instagram e whatsapp
        val instagram = findViewById<ImageView>(R.id.iv_instagram)
        instagram.setOnClickListener {
            openInstagram()
        }
        val whatsapp = findViewById<ImageView>(R.id.iv_whatsapp)
        whatsapp.setOnClickListener {
            openWhatsapp()
        }
    }

    //Lista de Servicos
    private fun getServicos() {
        //Passar o nome da imagem que eu ta na servicos.xml
        //Listar servicos
        val servico1 = Servicos(R.drawable.recovery, "Recuperação Muscular (Recovery)")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.phisio, "Fisioterapia Ortopédica")
        listaServicos.add(servico2)

    }

    //Redes Sociais
    private fun openInstagram() {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramURL))
        startActivity(intent)
    }

    private fun openWhatsapp() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(whatsappURL))
        startActivity(intent)

    }
}