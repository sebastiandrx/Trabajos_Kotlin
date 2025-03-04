import kotlin.collections.mutableMapOf

fun main() {

    val Costo_Internet = 700000
    val Costo_Radio = 200000
    val Costo_Television = 600000


    val votos = mutableMapOf(
        "Candidato 1" to mutableMapOf("internet" to 0, "radio" to 0, "tv" to 0),
        "Candidato 2" to mutableMapOf("internet" to 0, "radio" to 0, "tv" to 0),
        "Candidato 3" to mutableMapOf("internet" to 0, "radio" to 0, "tv" to 0)
    )

    var continuar = true

    while (continuar) {
        println(" SISTEMA DE VOTACIÓN MUNICIPIO PREMIER ")
        println("1. Votar por un candidato")
        println("2. Calcular costo de campaña por candidato")
        println("3. Vaciar urnas")
        println("4. Ver número total de votos")
        println("5. Ver porcentaje de votos por candidato")
        println("6. Ver costo promedio de campaña")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (readLine()) {
            "1" -> {
                println("VOTACIÓN")

                println("Seleccione un candidato:")
                println("1. Candidato 1")
                println("2. Candidato 2")
                println("3. Candidato 3")
                print("Su elección: ")

                val candidatoInput = readLine()
                val candidato = when (candidatoInput) {
                    "1" -> "Candidato 1"
                    "2" -> "Candidato 2"
                    "3" -> "Candidato 3"
                    else -> {
                        println("Opción inválida. Voto cancelado.")
                        continue
                    }
                }

                println("\n¿Qué medio influyó en su voto?")
                println("1. Internet")
                println("2. Radio")
                println("3. Televisión")
                print("Su respuesta: ")

                val medioInput = readLine()
                val medio = when (medioInput) {
                    "1" -> "internet"
                    "2" -> "radio"
                    "3" -> "tv"
                    else -> {
                        println("Opción inválida. Voto cancelado.")
                        continue
                    }
                }

                val mediosCandidato = votos[candidato]
                if (mediosCandidato != null) {
                    val votosActuales = mediosCandidato[medio] ?: 0
                    mediosCandidato[medio] = votosActuales + 1
                    println("Voto registrado con éxito para $candidato influenciado por $medio.")
                }
            }

            "2" -> {
                
                println("COSTO DE CAMPAÑA POR CANDIDATO")

                for (candidato in votos.keys) {
                    val mediosCandidato = votos[candidato]
                    if (mediosCandidato != null) {
                        val votosInternet = mediosCandidato["internet"] ?: 0
                        val votosRadio = mediosCandidato["radio"] ?: 0
                        val votosTv = mediosCandidato["tv"] ?: 0

                        val costoInternet = votosInternet * Costo_Internet
                        val costoRadio = votosRadio * Costo_Radio
                        val costoTv = votosTv * Costo_Television
                        val costoTotal = costoInternet + costoRadio + costoTv

                        println("$candidato: $costoTotal pesos")
                        println("  - Internet: $votosInternet votos x $Costo_Internet = $costoInternet pesos")
                        println("  - Radio: $votosRadio votos x $Costo_Radio = $costoRadio pesos")
                        println("  - Televisión: $votosTv votos x $Costo_Television = $costoTv pesos")
                    }
                }
            }

            "3" -> {
                for (candidato in votos.keys) {
                    val mediosCandidato = votos[candidato]
                    if (mediosCandidato != null) {
                        mediosCandidato["internet"] = 0
                        mediosCandidato["radio"] = 0
                        mediosCandidato["tv"] = 0
                    }
                }
                println("Urnas vaciadas con éxito.")
            }

            "4" -> {
                var totalVotos = 0

                for (mediosCandidato in votos.values) {
                    for (votosEnMedio in mediosCandidato.values) {
                        totalVotos += votosEnMedio
                    }
                }

                println("\nNúmero total de votos: $totalVotos")
            }

            "5" -> {
                println("PORCENTAJE DE VOTOS POR CANDIDATO")
                var totalVotos = 0
                for (mediosCandidato in votos.values) {
                    for (votosEnMedio in mediosCandidato.values) {
                        totalVotos += votosEnMedio
                    }
                }

                if (totalVotos == 0) {
                    println("No hay votos registrados.")
                    continue
                }

                for (candidato in votos.keys) {
                    var votosCandidato = 0
                    val mediosCandidato = votos[candidato]

                    if (mediosCandidato != null) {
                        for (votosEnMedio in mediosCandidato.values) {
                            votosCandidato += votosEnMedio
                        }
                    }

                    val porcentaje = (votosCandidato.toDouble() / totalVotos) * 100
                    println("$candidato: ${String.format("%.2f", porcentaje)}% ($votosCandidato votos)")
                }
            }

            "6" -> {
                println("\n----- COSTO PROMEDIO DE CAMPAÑA -----")

                // Calcular total de votos
                var totalVotos = 0
                for (mediosCandidato in votos.values) {
                    for (votosEnMedio in mediosCandidato.values) {
                        totalVotos += votosEnMedio
                    }
                }

                if (totalVotos == 0) {
                    println("No hay votos registrados.")
                    continue
                }

                var costoTotal = 0

                for (candidato in votos.keys) {
                    val mediosCandidato = votos[candidato]
                    if (mediosCandidato != null) {
                        val votosInternet = mediosCandidato["internet"] ?: 0
                        val votosRadio = mediosCandidato["radio"] ?: 0
                        val votosTv = mediosCandidato["tv"] ?: 0

                        costoTotal += votosInternet * Costo_Internet
                        costoTotal += votosRadio * Costo_Radio
                        costoTotal += votosTv * Costo_Television
                    }
                }

                val costoPromedio = costoTotal.toDouble() / totalVotos
                println("Costo promedio por voto: ${String.format("%.2f", costoPromedio)} pesos")
                println("Costo total de campaña: $costoTotal pesos")
            }

            "7" -> continuar = false

            else -> println("Opción inválida. Intente nuevamente.")
        }
    }

    println("¡Gracias por utilizar el sistema de votación!")
}