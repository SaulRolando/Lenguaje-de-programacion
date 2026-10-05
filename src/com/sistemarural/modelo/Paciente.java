package com.sistemarural.modelo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

// Subclase Paciente que aplica Encapsulamiento y Protección de Datos (Ley N.º 29733)
public class Paciente extends Persona {
    private String dniHash; // DNI encriptado/anonimizado

    public Paciente(String dni, String nombre, int edad) {
        super(nombre, edad);
        this.dniHash = encriptarDni(dni);
    }

    // Método para anonimizar el DNI mediante SHA-256
    private String encriptarDni(String dni) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(dni.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return "HASH-ERROR";
        }
    }

    public String getDniHash() {
        return dniHash;
    }
}