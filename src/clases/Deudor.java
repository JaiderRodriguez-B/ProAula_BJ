/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Date;
import java.util.List;

/**
 *
 * @author PC PERSONAL
 */
public class Deudor extends Usuario{
    private List<Prestamo> Prestamos;
    private String Palabra_seguridad;

    public Deudor(List<Prestamo> Prestamos, String Palabra_seguridad, String Nombre, String Apellido, String Email, String Documento, String Direccion, String Contraseña, Date fechaNacimiento) {
        super(Nombre, Apellido, Email, Documento, Direccion, Contraseña, fechaNacimiento);
        this.Prestamos = Prestamos;
        this.Palabra_seguridad = Palabra_seguridad;
    }

    public List<Prestamo> getPrestamos() {
        return Prestamos;
    }

    public void setPrestamos(List<Prestamo> Prestamos) {
        this.Prestamos = Prestamos;
    }

    public String getPalabra_seguridad() {
        return Palabra_seguridad;
    }

    public void setPalabra_seguridad(String Palabra_seguridad) {
        this.Palabra_seguridad = Palabra_seguridad;
    }
    
}
