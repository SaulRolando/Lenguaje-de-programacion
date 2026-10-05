package com.sistemarural.servicio;

import com.sistemarural.modelo.Paciente;
import java.util.List;
import java.util.stream.Collectors;

// Procesamiento analítico aplicando Programación Funcional (Streams y Lambdas)
public class ServicioReportes {

    // Filtrado de pacientes prioritarios utilizando la función de orden superior filter
    public List<Paciente> obtenerPacientesMayores(List<Paciente> lista, int edadCorte) {
        return lista.stream()
                .filter(p -> p.getEdad() >= edadCorte)
                .collect(Collectors.toList());
    }

    // Cálculo estadístico utilizando mapToInt y el operador de reducción average
    public double calcularPromedioEdad(List<Paciente> lista) {
        if (lista == null || lista.isEmpty()) {
            return 0.0;
        }
        return lista.stream()
                .mapToInt(p -> p.getEdad())
                .average()
                .orElse(0.0);
    }
}