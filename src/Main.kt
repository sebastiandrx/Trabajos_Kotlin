fun main() {

        var puntajeDado1 = 0
        var puntajeDado2 = 0
        val totalTiradas = 10

        println("JUEGO DE DADOS - 10 TIRADAS ")
        println("El dado con mayor puntuación total será el ganador.")
        println()


        for (tirada in 1..totalTiradas) {

            val resultadoDado1 = (1..6).random()
            val resultadoDado2 = (1..6).random()

            puntajeDado1 += resultadoDado1
            puntajeDado2 += resultadoDado2

            println("Tirada #$tirada:")
            println("Dado 1: $resultadoDado1")
            println("Dado 2: $resultadoDado2")

            val ganadorTirada = when {
                resultadoDado1 > resultadoDado2 -> "Dado 1"
                resultadoDado2 > resultadoDado1 -> "Dado 2"
                else -> "Empate"
            }
            println("Resultado de la tirada: $ganadorTirada")
            println()
        }


        println("=== RESULTADO FINAL ===")
        println("Puntuación total Dado 1: $puntajeDado1")
        println("Puntuación total Dado 2: $puntajeDado2")

        val ganadorFinal = when {
            puntajeDado1 > puntajeDado2 -> "Dado 1"
            puntajeDado2 > puntajeDado1 -> "Dado 2"
            else -> "Empate"
        }

        println("\n¡EL GANADOR ES: $ganadorFinal!")
    }
