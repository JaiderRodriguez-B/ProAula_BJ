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
public class Pagos {
    private double Pagos_realizados;
    private boolean Tipo_pago;
    private Date Limite_para_pagar ;
    private double Monto_pagado;

    public double getPagos_realizados() {
        return Pagos_realizados;
    }

    public void setPagos_realizados(double Pagos_realizados) {
        this.Pagos_realizados = Pagos_realizados;
    }

    public boolean isTipo_pago() {
        return Tipo_pago;
    }

    public void setTipo_pago(boolean Tipo_pago) {
        this.Tipo_pago = Tipo_pago;
    }

    public Date getLimite_para_pagar() {
        return Limite_para_pagar;
    }

    public void setLimite_para_pagar(Date Limite_para_pagar) {
        this.Limite_para_pagar = Limite_para_pagar;
    }

    public double getMonto_pagado() {
        return Monto_pagado;
    }

    public void setMonto_pagado(double Monto_pagado) {
        this.Monto_pagado = Monto_pagado;
    }
    
    
}
