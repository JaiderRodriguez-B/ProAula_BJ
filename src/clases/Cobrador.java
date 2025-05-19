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
public class Cobrador extends Usuario{
     private List<Deudor> Deudores;

    public Cobrador(List<Deudor> Deudores) {
        this.Deudores = Deudores;
    }
    
    public Cobrador(String id,String nombre){
        super();
        this.Deudores = Deudores;
    }

    public List<Deudor> getDeudores() {
        return Deudores;
    }

    public void setDeudores(List<Deudor> Deudores) {
        this.Deudores = Deudores;
    }
     
     

}
