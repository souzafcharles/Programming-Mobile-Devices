fun processaTexto(
    str1: String,
    str2: String,
    processa: (String, String) -> String
): String = processa(str1, str2)

fun concatena(a: String, b: String): String = "$a$b"

fun inverte(x: String, y: String) = "${y.reversed()}${x.reversed()}"

fun main() {
    println(processaTexto("Olá, ", "Mundo", ::concatena))
    println(processaTexto("Olá, ", "Mundo", ::inverte))
}