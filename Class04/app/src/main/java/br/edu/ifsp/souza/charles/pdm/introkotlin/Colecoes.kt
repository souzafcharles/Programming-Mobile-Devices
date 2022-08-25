package br.edu.ifsp.souza.charles.pdm.introkotlin

fun main() {
    //List e MutableList
    //var familia = listOf("Charles", "Balthazar", "Ophélia")
    var familia: List<String> = listOf("Charles", "Balthazar", "Ophélia")

    //familia = listOf("Jeferson", "Ibrain")
    for (integrante in familia) {
        println(integrante)
    }

    //val listaInteiros: List<Int> = listOf(1,2,3,4,5,6,7,8,9,10)
    //for (i in 0..9){
    //    println(listaInteiros[i])
    val listaInteiros: List<Int> = (1..10 step 2).toList()
    // for (i in 0..listaInteiros.size -  1){
    //    println(listaInteiros[i])
    //}
    listaInteiros.forEach { print(it) }
    listaInteiros.forEachIndexed {indice, valor -> println("$indice - $valor")}
}