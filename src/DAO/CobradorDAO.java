/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import clases.Cobrador;
import clases.Deudor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC PERSONAL
 */
public class CobradorDAO {

    private final String archivoCobradores = "Data/Cobradores.json";
    private final Gson gson = new Gson();
    private List<Cobrador> cobradores;

    public CobradorDAO() {
        cargarCobradores();
    }

    private void cargarCobradores() {
        try (FileReader reader = new FileReader(archivoCobradores)) {
            cobradores = gson.fromJson(reader, new TypeToken<List<Cobrador>>() {
            }.getType());
            if (cobradores == null) {
                cobradores = new ArrayList<>();
            }
        } catch (IOException e) {
            cobradores = new ArrayList<>();
        }
    }

    private void guardarCobradores() {
        try (FileWriter writer = new FileWriter(archivoCobradores)) {
            gson.toJson(cobradores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cobrador obtenerPorId(String idCobrador) {
        for (Cobrador cobrador : cobradores) {
            if (cobrador.getDocumento().equals(idCobrador)) {
                return cobrador;
            }
        }
        return null;
    }

    public List<Cobrador> listarTodos() {
        return new ArrayList<>(cobradores);
    }

    public boolean agregarCobrador(Cobrador cobrador) {
        if (obtenerPorId(cobrador.getDocumento()) != null) {
            return false; // Ya existe un cobrador con ese ID
        }
        cobradores.add(cobrador);
        guardarCobradores();
        return true;
    }

    public boolean actualizarCobrador(Cobrador cobradorActualizado) {
        for (int i = 0; i < cobradores.size(); i++) {
            if (cobradores.get(i).getDocumento().equals(cobradorActualizado.getDocumento())) {
                cobradores.set(i, cobradorActualizado);
                guardarCobradores();
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCobrador(String idCobrador) {
        Cobrador cobrador = obtenerPorId(idCobrador);
        if (cobrador != null) {
            cobradores.remove(cobrador);
            guardarCobradores();
            return true;
        }
        return false;
    }

    // Métodos específicos para manejar deudores de un cobrador
    public List<Deudor> obtenerDeudoresDeCobrador(String idCobrador) {
        Cobrador cobrador = obtenerPorId(idCobrador);
        if (cobrador != null) {
            return cobrador.getDeudores();
        }
        return new ArrayList<>();
    }

    public boolean agregarDeudorACobrador(String idCobrador, Deudor deudor) {
        Cobrador cobrador = obtenerPorId(idCobrador);
        if (cobrador != null) {
            cobrador.getDeudores().add(deudor);
            guardarCobradores();
            return true;
        }
        return false;
    }
}
