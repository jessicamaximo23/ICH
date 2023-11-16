package com.example.institutodocorpohumano

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.institutodocorpohumano.view.MainActivity

class ActivitySplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Splash Screen
        setContentView(R.layout.activity_splash)
        //Escondendo a barra da splash_screen
        supportActionBar?.hide()
        //Mudando a cor da status bar
        window.statusBarColor = Color.parseColor("#D5AAA0")

        //Configurando a splash screen
        //classe handler
        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

            //tempo da tela
        }, 2000)

    }
}
