import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val alumnos = mutableListOf<String>()
    val calificaciones = mutableMapOf<String, MutableList<Double>>()

    // pedimos a los nombres de los alumnos
    for (i in 1..4) {
        var nombre: String
        do {
            println("Ingrese el nombre del alumno $i: ")
            nombre = scanner.nextLine().trim()
        } while (nombre.isBlank()) // si esta vacio no lo tomes en cuenta y vuelvo a preguntar
        alumnos.add(nombre)
    }

    // Pedir calificaciones para cada alumno
    for (alumno in alumnos) {
        val calificacionesAlumno = mutableListOf<Double>()
        println("Ingrese las calificaciones para $alumno:")

        for (i in 1..3) {
            var calificacion: Double
            while (true) {
                print("Calificación del parcial $i: ")
                try {
                    calificacion = scanner.nextDouble()
                    break
                } catch (e: java.util.InputMismatchException) {
                    println("Por favor ingrese un número válido.")
                    scanner.nextLine() // Limpiar el buffer de entrada
                }
            }
            calificacionesAlumno.add(calificacion)
        }

        calificaciones[alumno] = calificacionesAlumno
    }

    // Calcular promedio de calificaciones y mostrar resultados
    println("\nResultados:")
    for ((alumno, calificacionesAlumno) in calificaciones) {
        val promedio = calificacionesAlumno.average()
        println("El promedio de $alumno es: $promedio")
    }
}