package br.edu.ifsp.souza.charles.pdm.introkotlin

fun main(){

    // tipo explicito
    var nome: String = "Balthazar"

    //tipo implícito
    var sobrenome = "de Bigode"

    // atribuição a posteriori
    val nomeMeio: String
    nomeMeio = "Bartholomeu"

    //float
    val altura = 1.7f

    //int
    var idade: Int = 2

    var peso: Double = 6.toDouble()

    println("Nome: $nome $nomeMeio $sobrenome, altura: $altura, peso: $peso, idade: $idade anos")

}