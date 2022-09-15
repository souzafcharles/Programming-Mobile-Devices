 enum class  TipoOperacao {
     ADD, MUL, DIV, SUB
 }

 fun div (a: Int, b: Int) = a / b
 /*
fun operacao(op: TipoOperacao): (Int, Int) -> Int{
val sub: (Int, Int) -> Int = {a: Int, b: Int -> a - b}

return when (op){
    TipoOperacao.ADD -> {x , y -> x + y}
    TipoOperacao.MUL -> fun (a, b): Int = a * b
    TipoOperacao.DIV -> ::div
    TipoOperacao.SUB -> sub
}
}*/
 fun operacao(op: TipoOperacao) = when (op){
         TipoOperacao.ADD -> {x , y -> x + y}
         TipoOperacao.MUL -> fun (a, b): Int = a * b
         TipoOperacao.DIV -> ::div
         TipoOperacao.SUB -> {a: Int, b: Int -> a + b}
 }

 fun Int.aplica(i: Int, f: (Int, Int) -> Int): Int {
     return f(this, i)
 }
 
 fun main (){
     println(10.aplica(2, operacao(TipoOperacao.ADD)))
     println(10.aplica(2, operacao(TipoOperacao.MUL)))
     println(10.aplica(2, operacao(TipoOperacao.DIV)))
     println(10.aplica(2, operacao(TipoOperacao.SUB)))
 }