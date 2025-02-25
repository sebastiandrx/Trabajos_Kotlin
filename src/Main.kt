fun main() {

    var m50 = 0
    var m20 = 0
    var m100 = 0
    var m200 = 0
    var m500 = 0
    var continuar = true

    while (continuar) {
        println(
            """
            ¿QUÉ DESEAS HACER HOY?
            1. Agregar monedas
            2. Contar Monedas
            3. Calcular dinero ahorrado
            4. Vaciar contenido de la alcancía
            5. Salir
            """.trimIndent()
        )

        print("Ingresa tu opción: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                var seguirAgregando = true

                while (seguirAgregando) {
                    println(
                        """
                        INGRESA EL VALOR DE LA MONEDA
                        1. Moneda de 20
                        2. Moneda de 50
                        3. Moneda de 100
                        4. Moneda de 200
                        5. Moneda de 500
                        6. Volver al menú principal
                        """.trimIndent()
                    )

                    print("Ingresa tu opción: ")
                    when (readLine()?.toInt()) {
                        1 -> {
                            m20++
                            println("Agregada 1 moneda de 20.")
                        }

                        2 -> {
                            m50++
                            println("Agregada 1 moneda de 50.")
                        }

                        3 -> {
                            m100++
                            println("Agregada 1 moneda de 100.")
                        }

                        4 -> {
                            m200++
                            println("Agregada 1 moneda de 200.")
                        }

                        5 -> {
                            m500++
                            println("Agregada 1 moneda de 500.")
                        }

                        6 -> {
                            seguirAgregando = false
                            println("Volviendo al menú principal...")
                        }

                        else -> println("Opción no válida. Por favor, intenta de nuevo.")
                    }
                }
            }

            2 -> {
                println("\n CONTEO DE TUS MONEDAS")
                println("Monedas de 20: $m20")
                println("Monedas de 50: $m50")
                println("Monedas de 100: $m100")
                println("Monedas de 200: $m200")
                println("Monedas de 500: $m500")
                println("Total de monedas: ${m20 + m50 + m100 + m200 + m500}")
            }

            3 -> {
                val total = (m20 * 20) + (m50 * 50) + (m100 * 100) + (m200 * 200) + (m500 * 500)

                println("\n TU DINERO AHORRADO ")
                println("Valor monedas de 20: ${m20 * 20}")
                println("Valor monedas de 50: ${m50 * 50}")
                println("Valor monedas de 100: ${m100 * 100}")
                println("Valor monedas de 200: ${m200 * 200}")
                println("Valor monedas de 500: ${m500 * 500}")
                println("Total ahorrado: $total")
            }

            4 -> {
                println("VACIANDO TU ALCANCIA...")
                m20 = 0
                m50 = 0
                m100 = 0
                m200 = 0
                m500 = 0
            }
            5 -> {
                println("Vuelve Pronto")
                continuar = false
            }
        }
    }
}