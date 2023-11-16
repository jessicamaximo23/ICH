package com.example.institutodocorpohumano.view

import android.graphics.Color
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.institutodocorpohumano.databinding.ActivityAgendamentoBinding
import com.google.android.material.snackbar.Snackbar

class Agendamento : AppCompatActivity() {

    private lateinit var binding:ActivityAgendamentoBinding
    private val calendar: Calendar = Calendar.getInstance()
    private var data: String = ""
    private var hora: String = " "

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    supportActionBar?.hide()

        val nome = intent.extras?.getString("Nome").toString()

        val datePicker= binding.datePicker
        datePicker.setOnDateChangedListener { _ , year, monthOfYear, dayOfMonth ->

        calendar.set(Calendar.YEAR,year)
        calendar.set(Calendar.MONTH,monthOfYear)
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)

        var dia = dayOfMonth.toString()
        val mes:String

        if (dayOfMonth < 10) {
            dia = "0$dayOfMonth"
        }
        if (monthOfYear <10){
           mes = "" + (monthOfYear + 1)
        } else {
            mes = (monthOfYear + 1).toString()
        }

        data = "$dia / $mes/ $year"

        }
        binding.timerPicker.setOnTimeChangedListener { _, hourOfday, minute ->

        val minuto : String

        if (minute < 10){
            minuto = "$minute"
        } else {
            minuto = minute.toString()
        }
            hora = "$hourOfday : $minuto"

        }
        
        binding.timerPicker.setIs24HourView(true)
        binding.btnAgendarAgendamento.setOnClickListener {

            //In the future I will add more PT
            val fisioterapeuta1 = binding.fisioterapeuta1

            when{
                hora.isEmpty()-> {
                    mensagem(it, "Preencha o horário", "#FFFFFF")

                }
                //mudar aqui de acordo com a disponibilidade da Dani
                hora < "10:00" && hora > "12:00"  || hora < "15:00" && hora > "18:00" -> {
                    mensagem(it, "Este horário não esta disponível", "#FFFFFF")
                }

                data.isEmpty() -> {
                    mensagem(it, "Escolha uma data!", "#FFFFFF")
                }
                fisioterapeuta1.isChecked && data.isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it, "AGENDAMENTO REALIZADO COM SUCESSO!", "#FFFFFF")
                }
                else -> {
                    mensagem(it, "Selecione a Fisioterapeuta", "#FFFFFF")

                }

            }
        }
    }

    private fun mensagem (view: View, mensagem: String, cor: String){

        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.setTextColor(Color.parseColor("#FFF84949"))
        snackbar.show()




    }
}