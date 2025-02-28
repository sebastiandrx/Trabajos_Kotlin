fun main() {
        var intentosFallidos = 0
        val maximoIntentos = 3

        println("CONTROL DE ACCESO")

        while (intentosFallidos < maximoIntentos) {
            print("Ingresa tu código de acceso: ")
            val codigoIngresado = readLine()?.toIntOrNull()

            if (codigoIngresado == null) {
                println("Por favor, ingresa un código numérico válido.")
                continue
            }

            if (codigoIngresado in 1000..1999) {
                println("¡Bienvenido, Empleado #$codigoIngresado!")
                println("Acceso concedido.")
                break
            }

            else if (codigoIngresado in 2000..2999) {
                println("Bienvenido, Visitante #$codigoIngresado")

                print("Por favor, ingrese su nombre: ")
                val nombre = readLine() ?: ""

                print("Motivo de la visita: ")
                val motivo = readLine() ?: ""

                println("Gracias $nombre. Motivo de visita: $motivo")
                println("Acceso concedido como visitante.")
                break
            }
            else {
                intentosFallidos++
                val intentosRestantes = maximoIntentos - intentosFallidos

                if (intentosRestantes > 0) {
                    println("Código incorrecto. Te quedan $intentosRestantes intentos.")
                } else {
                    println("Acceso bloqueado. Haz excedido el número máximo de intentos.")
                }
            }
        }
    }


