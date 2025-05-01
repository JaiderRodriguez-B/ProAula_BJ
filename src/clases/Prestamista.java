/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;

/**
 *
 * @author PC PERSONAL
 */
public class Prestamista extends Usuario{
    private double Saldo_disponible;
    private List<Prestamo> Prestamos_R;
    private String Palabra_seguridad;

    public double getSaldo_disponible() {
        return Saldo_disponible;
    }

    public void setSaldo_disponible(double Saldo_disponible) {
        this.Saldo_disponible = Saldo_disponible;
    }

    public List<Prestamo> getPrestamos_R() {
        return Prestamos_R;
    }

    public void setPrestamos_R(List<Prestamo> Prestamos_R) {
        this.Prestamos_R = Prestamos_R;
    }

    public String getPalabra_seguridad() {
        return Palabra_seguridad;
    }

    public void setPalabra_seguridad(String Palabra_seguridad) {
        this.Palabra_seguridad = Palabra_seguridad;
    }
}
