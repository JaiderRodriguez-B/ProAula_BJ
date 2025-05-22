package Handlers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DAO.CobradorDAO;
import clases.Cobrador;
import clases.Deudor;
import clases.Prestamo;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author PC PERSONAL
 */
public class CobradorHandler {

    private final CobradorDAO cobradorDAO;

    public CobradorHandler() {
        this.cobradorDAO = new CobradorDAO();
    }

    // Métodos para manejar cobradores
    public boolean registrarCobrador(String documento, String nombre, String apellido,
            String direccion, String contraseña, Date fechaNacimiento) {
        // Crear un nuevo cobrador con todos los datos requeridos
        Cobrador nuevoCobrador = new Cobrador(documento, nombre);
        nuevoCobrador.setApellido(apellido);
        nuevoCobrador.setDireccion(direccion);
        nuevoCobrador.setContraseña(contraseña);
        nuevoCobrador.setFechaNacimiento(fechaNacimiento);

        return cobradorDAO.registrarCobrador(nuevoCobrador);
    }

    /*public Cobrador obtenerCobrador(String id) {
        return cobradorDAO.obtenerPorId(id);
    } */
 /*public boolean actualizarCobrador(String id, String nuevoNombre) {
        Cobrador cobrador = cobradorDAO.obtenerPorId(id);
        if (cobrador != null) {
            cobrador.setNombre(nuevoNombre);
            return cobradorDAO.actualizarCobrador(cobrador);
        }
        return false;
    }*/
    // Métodos para manejar deudores
    /*public List<Deudor> obtenerDeudoresDeCobrador(String idCobrador) {
        return cobradorDAO.obtenerDeudoresDeCobrador(idCobrador);
    }*/
 /*public boolean agregarDeudorACobrador(String idCobrador, Deudor deudor) {
        return cobradorDAO.agregarDeudorACobrador(idCobrador, deudor);
    }*/
 /*public boolean eliminarDeudorDeCobrador(String idCobrador, String idDeudor) {
        List<Deudor> deudores = cobradorDAO.obtenerDeudoresDeCobrador(idCobrador);
        for (Deudor deudor : deudores) {
            if (deudor.getDocumento().equals(idDeudor)) {
                deudores.remove(deudor);
                Cobrador cobrador = cobradorDAO.obtenerPorId(idCobrador);
                cobrador.setDeudores(deudores);
                return cobradorDAO.actualizarCobrador(cobrador);
            }
        }
        return false;
    }*/
    // Métodos para actualizar la interfaz gráfica
    /* public void mostrarInformacionCobrador(String idCobrador, JLabel etiNombreCobrador) {
        Cobrador cobrador = cobradorDAO.obtenerPorId(idCobrador);
        if (cobrador != null) {
            etiNombreCobrador.setText(cobrador.getNombre());
        }
    } */
 /*public void mostrarInformacionDeudor(String idCobrador, String idDeudor,JLabel etiNombreDeudor, JLabel etiNombrePrestamista,
                                        JLabel etiNumeroCuotas, JLabel etiCuotaActual,
                                        JLabel etiValorCuota, JLabel etiDireccion) {
        List<Deudor> deudores = cobradorDAO.obtenerDeudoresDeCobrador(idCobrador);
        for (Deudor deudor : deudores) {
            if (deudor.getDocumento().equals(idDeudor)) {
                etiNombreDeudor.setText(deudor.getNombre());
                // Aquí puedes agregar más lógica para mostrar los préstamos del deudor
                if (!deudor.getPrestamos().isEmpty()) {
                    Prestamo prestamo = deudor.getPrestamos().get(0); // Tomamos el primer préstamo como ejemplo
                    double valorCuota = prestamo.getMonto_prestado() / prestamo.getValor_cuotas();
                    etiNombrePrestamista.setText("Nombre del prestamista: " + prestamo.getID()); 
                    etiNumeroCuotas.setText("Número de cuotas: " + prestamo.getCantidad_cuotas()); 
                    etiCuotaActual.setText("Cuota actual: " + prestamo.getCuota_actual());
                    etiValorCuota.setText("Valor cuota: $" + valorCuota);
                    etiDireccion.setText("Dirección: " + deudor.getDireccion()); // Asegúrate de tener este campo en Deudor
                }
                break;
            }
        }
    } */
}
