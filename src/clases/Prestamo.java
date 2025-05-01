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
public class Prestamo {
    private String ID;
    private double Monto_prestado;
    private Prestamista Prestador;
    private List<Pagos> Abonos;
    private double Valor_cuotas;
    private int Cantidad_cuotas;
    private double Tasa_interes;
    private Date Fecha_prestamo;

    public Prestamo(String ID, double Monto_prestado, Prestamista Prestador, List<Pagos> Abonos, double Valor_cuotas, int Cantidad_cuotas, double Tasa_interes, Date Fecha_prestamo) {
        this.ID = ID;
        this.Monto_prestado = Monto_prestado;
        this.Prestador = Prestador;
        this.Abonos = Abonos;
        this.Valor_cuotas = Valor_cuotas;
        this.Cantidad_cuotas = Cantidad_cuotas;
        this.Tasa_interes = Tasa_interes;
        this.Fecha_prestamo = Fecha_prestamo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getMonto_prestado() {
        return Monto_prestado;
    }

    public void setMonto_prestado(double Monto_prestado) {
        this.Monto_prestado = Monto_prestado;
    }

    public Prestamista getPrestador() {
        return Prestador;
    }

    public void setPrestador(Prestamista Prestador) {
        this.Prestador = Prestador;
    }

    public List<Pagos> getAbonos() {
        return Abonos;
    }

    public void setAbonos(List<Pagos> Abonos) {
        this.Abonos = Abonos;
    }

    public double getValor_cuotas() {
        return Valor_cuotas;
    }

    public void setValor_cuotas(double Valor_cuotas) {
        this.Valor_cuotas = Valor_cuotas;
    }

    public int getCantidad_cuotas() {
        return Cantidad_cuotas;
    }

    public void setCantidad_cuotas(int Cantidad_cuotas) {
        this.Cantidad_cuotas = Cantidad_cuotas;
    }

    public double getTasa_interes() {
        return Tasa_interes;
    }

    public void setTasa_interes(double Tasa_interes) {
        this.Tasa_interes = Tasa_interes;
    }

    public Date getFecha_prestamo() {
        return Fecha_prestamo;
    }

    public void setFecha_prestamo(Date Fecha_prestamo) {
        this.Fecha_prestamo = Fecha_prestamo;
    }
}
