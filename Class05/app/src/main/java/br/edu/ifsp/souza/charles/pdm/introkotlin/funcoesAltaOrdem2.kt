

inline fun <T, R> List<T>.paraCada(funcao: (T) -> R): List<R> {
    var lista: MutableList<R> = mutableListOf()

    for (item in this) {
        lista.add(funcao(item))
    }
    return lista.toList()
}



fun List<String>.paraCadastraString(funcao: (String) -> String): List<String>{
    val listaStrings: MutableList<String> = mutableListOf()

    for (str in this) {
        listaStrings.add(funcao(str))
    }
    return listaStrings.toList()
}

fun primeiraString(s: String): String {
    return s.first().toString()
}

fun main(){
    val listaNomes: List<String> = listOf("Balthazar", "Ophelia", "Charles")
    //val listaPrimeiras: List<String> = listaNomes.paraCadastraString(::primeiraString)
    val listaPrimeiras: List<String> = listaNomes.paraCada(::primeiraString)
    val listaMaiusculas = listaNomes.paraCadastraString() { it.uppercase() }

    listaPrimeiras.forEach(::println)
    listaMaiusculas.forEach{println(it)}
    listaMaiusculas.forEach() { println(it)}
    listaMaiusculas.forEach({ println(it)})

    val listaInteiros = listOf(1,2,3,4,5)
    val listaNegativos = listaInteiros.paraCada { it * -1 }
    listaNegativos.forEach { println(it)}
    val listaFloats: List<Float> = listaInteiros.paraCada { it.toFloat() }
    listaFloats.forEach { println(it)}
}