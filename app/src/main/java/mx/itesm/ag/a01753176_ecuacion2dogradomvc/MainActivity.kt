package mx.itesm.ag.a01753176_ecuacion2dogradomvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import mx.itesm.ag.a01753176_ecuacion2dogradomvc.databinding.ActivityMainBinding

/**
 *@author: Gilberto André García Gaytán
 * El código @MainFunciomiento funciona para calcular las raíces de segundo grado
 * y poder calcular el valor de el funcionamiento
 */

class MainActivity : AppCompatActivity() {
    // El Esta @binding nos acceder a las vistas de una forma muy sencilla, enlazando variables de nuestro código Kotlin o Java
    // con los componentes del XML.
    // Esto se consigue gracias a que habilita la posibilidad de añade código dentro de los XMLs y agregarlos de una manera mas sencilla.
    private lateinit var binding: ActivityMainBinding //lateinit permite inicializar una propiedad no anulable por fuera del constructor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ConfigurarInterfaz()}
    private fun registrarObservadoresx1(valor : String,con: Boolean) {
        MainFuncionamiento()
        if (con){
            binding.x1.setText(valor)
        }else{
            binding.x1.setText(valor + " i")
        }
    }
    private fun comprobarValores(a : Float,b  : Float,c  : Float, comp : Double){
        val modelo = MainFuncionamiento()
        val x1_true : String = modelo.x1(a,b,c, true)
        val x2_true : String = modelo.x2(a,b,c, true)
        val x1_false : String = modelo.x1(a,b,c, false)
        val x2_false : String = modelo.x2(a,b,c, false)


        if (comp== 1.0){
            val builder = AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage("No es una ecuación de segundo grado")
                .setCancelable(false)
                .setPositiveButton("Aceptar"){_, _->
                }
            builder.show()
        } else if (comp == 2.0) {
            val builder = AlertDialog.Builder(this)//Se genera la alerta
                .setTitle("Aviso")
                .setMessage("Esta ecuación es de dos raíces")
                .setCancelable(false)
                .setPositiveButton("Aceptar") { _, _ ->
                    registrarObservadoresx1(x1_true,true)
                    registrarObservadoresx2(x2_true,true)
                }
            builder.show()
        }
        else if (comp == 3.0)
        {
            //Sirve para mandar el cuadro con una alerta al usuario
            val builder = AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage("Esta ecuación tiene dos raíces complejas")
                .setCancelable(false)
                .setPositiveButton("Aceptar") { _, _ ->
                    registrarObservadoresx1(x1_false,false)
                    registrarObservadoresx2(x2_false,false)
                }
            builder.show()
        }
        else if (comp == 4.0)
        {
            //Sirve para mandar el cuadro con una alerta al usuario
            val builder = AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage("No es una ecuación de segundo grado")
                .setCancelable(false)
                .setPositiveButton("Aceptar") { _, _ -> }
            builder.show()
        }
    }

    //Esta función nos ayuda para que el usuario digite lo números correspondientes
    private fun ConfigurarInterfaz() {
        binding.btnResolver.setOnClickListener {
            val a = binding.a.text.toString().toFloat()
            val b = binding.b.text.toString().toFloat()
            val c = binding.c.text.toString().toFloat()
            val modelo = MainFuncionamiento()
            val comp:Double = modelo.comprobarlosDatos(a,b,c) //Se llama a la función de comprobar datos para que el programa
            // calcule los valores de las raíces puestas por el usuario
            comprobarValores(a,b,c, comp) }
    }
    private fun registrarObservadoresx2(valor : String,con: Boolean){
        if (con){
            binding.x2.setText(valor)
        }else {
            binding.x2.setText(valor+ " i")
        }
    }
}