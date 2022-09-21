package br.edu.ifsp.souza.charles.pdm.introkotlin

//fun multiplo(a: Int = 10, b: Int) = a % b == 0
fun multiplo(a: Int = 10, b: Int) = if (a % b == 0) true else false

fun Int.multiploo(b: Int): Boolean{
    return multiplo(this, b)
}

infix fun Int.multiplooo(b: Int): Boolean{
    return multiplo(this, b)
}

fun main(){
    println(multiplo(10, 2))
    println(12.multiploo(3))
    println(10.multiplooo(3))
    println(12 multiplooo 3)
}
