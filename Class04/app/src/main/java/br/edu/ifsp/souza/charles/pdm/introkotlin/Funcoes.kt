package br.edu.ifsp.souza.charles.pdm.introkotlin


fun multiplo (a: Int, b: Int): Boolean {
    val c: Int = a % b
    if (c==0) {
        return true
    }
    return false
}

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