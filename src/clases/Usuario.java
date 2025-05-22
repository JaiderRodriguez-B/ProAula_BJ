/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Date;

/**
 *
 * @author PC PERSONAL
 */
public class Usuario {

    private String Nombre;
    private String Apellido;
    private String Documento;
    private String Email;
    private String Direccion;
    private String Contraseña;
    private Date fechaNacimiento;

    public Usuario(String Nombre, String Apellido, String Documento, String Email, String Direccion, String Contraseña, Date fechaNacimiento) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Email = Email;
        this.Documento = Documento;
        this.Direccion = Direccion;
        this.Contraseña = Contraseña;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario() {
        Nombre = "sin nombre";
        Apellido = "sin apellido";
        Documento = "12345678";
        Direccion = "sin direccion";
        Contraseña = "pass123";
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }
        Date ahora = new Date();
        long diffInMillies = Math.abs(ahora.getTime() - fechaNacimiento.getTime());
        return (int) (diffInMillies / (1000L * 60 * 60 * 24 * 365));
    }
}
