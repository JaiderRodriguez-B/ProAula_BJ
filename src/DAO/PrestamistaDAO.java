/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class PrestamistaDAO {

    private final String archivoPrestamistas = "Data/Prestamistas.json";
    private final Gson gson = new Gson();
    private List<Prestamista> prestamistas;

    public PrestamistaDAO() {
        cargarPrestamistas();
    }

    private void cargarPrestamistas() {
        try (FileReader reader = new FileReader(archivoPrestamistas)) {
            prestamistas = gson.fromJson(reader, new TypeToken<List<Prestamista>>() {
            }.getType());
            if (prestamistas == null) {
                prestamistas = new ArrayList<>();
            }
        } catch (IOException e) {
            prestamistas = new ArrayList<>();
        }
    }

    public Prestamista obtenerInformacion(String idPrestamista) {
        for (Prestamista prestamista : prestamistas) {
            if (prestamista.getDocumento().equals(idPrestamista)) {
                return prestamista;
            }
        }
        return null;
    }
}
