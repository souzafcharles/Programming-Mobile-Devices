package br.edu.ifsp.souza.charles.pdm.introkotlin

fun main(){

    var frase: String = "Hello, world!"

    println(frase)

    //Declaração de value
    //val frase: String = "Hello, IFSP!"

    //String templates
    println("$frase")
    println("${frase}")
    println("Quantidade de caracteres:  ${frase.count()}")
    println("Quantidade de caracteres:  ${frase.length}")
}
