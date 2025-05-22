/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC PERSONAL
 */
public class Cobrador extends Usuario {

    private List<Deudor> Deudores;

    public Cobrador(List<Deudor> Deudores) {
        super(); // Llama al constructor por defecto de Usuario
        this.Deudores = Deudores;
    }
    
    public Cobrador(String id, String nombre) {
        super(); // Llama al constructor por defecto de Usuario
        this.setDocumento(id); // Usa el método setter heredado
        this.setNombre(nombre); // Usa el método setter heredado
        this.Deudores = new ArrayList<>(); // Inicializa la lista vacía
    }

    public List<Deudor> getDeudores() {
        return Deudores;
    }

    public void setDeudores(List<Deudor> Deudores) {
        this.Deudores = Deudores;
    }

}
