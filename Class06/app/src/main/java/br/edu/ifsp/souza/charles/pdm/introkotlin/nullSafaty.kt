package br.edu.ifsp.souza.charles.pdm.introkotlin

import java.lang.Exception

fun main(){
    var nome: String
    //nome = null

    //Operador Elvis ?:

    var sobrenome: String?
    //sobrenome = null
    sobrenome = "Bartholomeu"

    var sn =  sobrenome?:"de Bigode"
    println(sn)
    try {
        println(sobrenome?.length)
        //println(sobrenome.length)
        //println(sobrenome!!.length)
    }
    catch (npe: Exception){
        println(npe.stackTrace)
    }

    if(sobrenome != null) {
        println(sobrenome?.count())
    }

    val numString: String = 10.toString()
    val numDouble: Double = numString.toDouble()
    val numFloat: Float = numDouble.toFloat()
    val numInt: Int = numFloat.toInt()
    println(numInt)

    val any: Any = "Any equivale a Object em Java"
    //val str: String? = any as? String

    if (any is String){
        println(any.count())
    }

}
