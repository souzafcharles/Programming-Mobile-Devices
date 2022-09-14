fun processaTexto(
    str1: String,
    str2: String,
    processa: (String, String) -> String
): String = processa(str1, str2)

fun concatena(a: String, b: String): String{
    return "$a$b"
}

fun main() {
    println(processaTexto("Olá, ", "Mundo", ::concatena))
}