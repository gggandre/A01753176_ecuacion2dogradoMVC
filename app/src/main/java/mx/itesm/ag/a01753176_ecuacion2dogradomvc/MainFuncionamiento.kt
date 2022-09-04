package mx.itesm.ag.a01753176_ecuacion2dogradomvc

/**
 *@author: Gilberto André García Gaytán
 * El código @MainFunciomiento funciona para calcular las raíces de segundo grado
 * y poder calcular el valor de el funcionamiento
 */
class MainFuncionamiento {
    var x1:String = ""
        private set //set se usa para establecer el valor de cualquier variable
    var x2:String = ""
        private set
    var x1i:String = ""
        private set
    var x2i:String = ""
        private set
    var x1ii:String = ""
        private set
    var x2ii:String = ""
        private set

    //Se hace uso de sqrt para las funciones matemáticas https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/sqrt.html
    fun x1(a:Float,b:Float,c:Float, con:Boolean): String{
        if (con){
            x1 = (((-b+(Math.sqrt(((b*b)-(4*a*c)).toDouble())))/(2*a)).toFloat()).toString()
        }else{
            x1i = (((-b)/(2*a))).toString()
            x1ii =(((+(Math.sqrt(-(((b*b)-(4*a*c)).toDouble()))))/(2*a)).toFloat()).toString()
            x1=x1i+"+"+x1ii
        }
        return x1
    }
    fun x2(a:Float,b:Float,c:Float, con:Boolean):String{
        if (con == true){
            x2 = (((-b-(Math.sqrt(((b*b)-(4*a*c)).toDouble())))/(2*a)).toFloat()).toString()
        }else{
            x2i = (((-b)/(2*a))).toString()
            x2ii = (((-(Math.sqrt(-(((b*b)-(4*a*c)).toDouble()))))/(2*a)).toFloat()).toString()
            x2=x2i+x2ii
        }
        return x2
    }
    fun comprobarlosDatos(a:Float,b:Float,c:Float) : Double{
        // El discriminante es la parte de la fórmula cuadrática dentro del símbolo de raíz cuadrada:
        // b²-4ac. El discriminante nos indica si hay dos soluciones.
        var discriminante:Float = (b*b)-(4*a*c)
        if (discriminante == 0.0f)
        {
            return  1.0 // Nos va a devolver esto si la ecuación solo tiene una raíz
        }else if (discriminante > 0.0f) {
            return 2.0 // Nos va a devolver esto si la ecuación solo tiene dos raíces
        }else if (discriminante < 0.0f) {
            return 3.0 // Nos va a devolver esto si la ecuación tenga raíces complejas
        }else {
            return 4.0 // Nos va a devolver esto si la ecuación solo tiene una raíz +(-c/b)
        }
    }
}