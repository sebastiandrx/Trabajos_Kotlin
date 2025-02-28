fun main() {

    print("Introduce la cantidad de dinero inicial: ")
    var dinero = readLine()?.toDoubleOrNull() ?: run {
        println("Entrada inválida, usando 100 como valor predeterminado")
        100.0
    }

    var jugando = true

    while (jugando && dinero > 0) {
        println("Tu dinero actual: $dinero")

        val numero = (1..3).random()
        println("Ha salido el número $numero")


        when (numero) {
            1 -> {
                dinero *= 2
                println("¡Has duplicado tu dinero! Ahora tienes $dinero")

                print("¿Quieres seguir jugando? (s/n): ")
                val respuesta = readLine() ?: ""
                if (respuesta.lowercase() != "s") {
                    jugando = false
                }
            }
            2 -> {
                dinero /= 2
                println("Has perdido la mitad de tu dinero. Ahora tienes $dinero")

                print("¿Quieres seguir jugando? (s/n): ")
                val respuesta = readLine() ?: ""
                if (respuesta.lowercase() != "s") {
                    jugando = false
                }
            }
            else -> { // numero == 3
                dinero = 0.0
                println("Has perdido todo tu dinero.")
                jugando = false
            }
        }
    }

    println("Juego terminado. Te vas con $dinero")
}

