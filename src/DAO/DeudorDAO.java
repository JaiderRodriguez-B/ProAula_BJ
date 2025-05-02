/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import clases.Deudor;
import clases.Prestamista;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boris
 */
public class DeudorDAO {

    private final String archivoDeudores = "Data/Deudores.json";
    private final Gson gson = new Gson();
    private List<Deudor> deudores;

    public DeudorDAO() {
        cargarDeudores();
    }

    private void cargarDeudores() {
        try (FileReader reader = new FileReader(archivoDeudores)) {
            deudores = gson.fromJson(reader, new TypeToken<List<Deudor>>() {
            }.getType());
            if (deudores == null) {
                deudores = new ArrayList<>();
            }
        } catch (IOException e) {
            deudores = new ArrayList<>();
        }
    }

    public Deudor obtenerInformacion(String idDeudor) {
        for (Deudor deudor : deudores) {
            if (deudor.getDocumento().equals(idDeudor)) {
                return deudor;
            }
        }
        return null;
    }

    // Métodos adicionales recomendados para un DAO de Deudor
    public List<Deudor> listarTodos() {
        return new ArrayList<>(deudores);
    }

    public boolean existeDeudor(String idDeudor) {
        return obtenerInformacion(idDeudor) != null;
    }
}
