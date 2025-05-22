/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import clases.Cobrador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CobradorDAO {

    private static final String CARPETA_DATA = "src/Data/";
    private static final String ARCHIVO_JSON = "cobradores.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Obtiene la ruta completa del archivo JSON
     *
     * @return Ruta completa del archivo
     */
    private String obtenerRutaCompleta() {
        return CARPETA_DATA + ARCHIVO_JSON;
    }

    /**
     * Verifica y crea la carpeta Data si no existe
     */
    private void verificarEstructuraDirectorio() {
        File directorio = new File(CARPETA_DATA);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }

    /**
     * Carga todos los cobradores desde el archivo JSON
     *
     * @return Lista de cobradores
     */
    public List<Cobrador> cargarCobradores() {
        verificarEstructuraDirectorio();
        List<Cobrador> cobradores = new ArrayList<>();
        File archivo = new File(obtenerRutaCompleta());

        // Si el archivo no existe, retornar lista vacía
        if (!archivo.exists()) {
            return cobradores;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            Type tipoLista = new TypeToken<List<Cobrador>>() {
            }.getType();
            cobradores = gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            System.err.println("Error al cargar cobradores: " + e.getMessage());
        }

        return cobradores != null ? cobradores : new ArrayList<>();
    }

    /**
     * Guarda todos los cobradores en el archivo JSON
     *
     * @param cobradores Lista de cobradores a guardar
     * @return true si se guardó correctamente, false si hubo error
     */
    public boolean guardarCobradores(List<Cobrador> cobradores) {
        verificarEstructuraDirectorio();
        File archivo = new File(obtenerRutaCompleta());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            gson.toJson(cobradores, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar cobradores: " + e.getMessage());
            return false;
        }
    }

    /**
     * Registra un nuevo cobrador
     *
     * @param cobrador Cobrador a registrar
     * @return true si se registró correctamente, false si hubo error
     */
    public boolean registrarCobrador(Cobrador cobrador) {
        // Validar que no exista un cobrador con el mismo documento
        if (buscarCobrador(cobrador.getDocumento()) != null) {
            System.err.println("Ya existe un cobrador con este documento");
            return false;
        }

        List<Cobrador> cobradores = cargarCobradores();
        cobradores.add(cobrador);
        return guardarCobradores(cobradores);
    }

    /**
     * Modifica un cobrador existente
     *
     * @param documento Documento del cobrador a modificar
     * @param cobradorActualizado Cobrador con los datos actualizados
     * @return true si se modificó correctamente, false si no se encontró o hubo
     * error
     */
    public boolean modificarCobrador(String documento, Cobrador cobradorActualizado) {
        List<Cobrador> cobradores = cargarCobradores();
        boolean encontrado = false;

        for (int i = 0; i < cobradores.size(); i++) {
            if (cobradores.get(i).getDocumento().equals(documento)) {
                cobradores.set(i, cobradorActualizado);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.err.println("No se encontró el cobrador con documento: " + documento);
            return false;
        }

        return guardarCobradores(cobradores);
    }

    /**
     * Busca un cobrador por su documento
     *
     * @param documento Documento del cobrador a buscar
     * @return El cobrador encontrado o null si no existe
     */
    public Cobrador buscarCobrador(String documento) {
        List<Cobrador> cobradores = cargarCobradores();

        for (Cobrador cobrador : cobradores) {
            if (cobrador.getDocumento().equals(documento)) {
                return cobrador;
            }
        }

        return null;
    }

    /**
     * Elimina un cobrador por su documento
     *
     * @param documento Documento del cobrador a eliminar
     * @return true si se eliminó correctamente, false si no se encontró o hubo
     * error
     */
    public boolean eliminarCobrador(String documento) {
        List<Cobrador> cobradores = cargarCobradores();
        boolean removido = cobradores.removeIf(c -> c.getDocumento().equals(documento));

        if (!removido) {
            System.err.println("No se encontró el cobrador con documento: " + documento);
            return false;
        }

        return guardarCobradores(cobradores);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package DAO;

import clases.Cobrador;
import clases.Deudor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC PERSONAL

public class CobradorDAO {

    private final String archivoCobradores = "Data/Cobradores.json";
    private final Gson gson = new Gson();
    private List<Cobrador> cobradores;

    public CobradorDAO() {
        File directorio = new File("Data");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        cargarCobradores();
    }

    private void cargarCobradores() {
        File archivo = new File(archivoCobradores);
        // Si el archivo no existe o está vacío, inicializar lista vacía
        if (!archivo.exists() || archivo.length() == 0) {
            cobradores = new ArrayList<>();
            return;
        }

        try (FileReader reader = new FileReader(archivo)) {
            // Verificar si el archivo tiene contenido válido
            if (archivo.length() > 0) {
                cobradores = gson.fromJson(reader, new TypeToken<List<Cobrador>>(){}.getType());
                if (cobradores == null) {
                    cobradores = new ArrayList<>();
                }
            } else {
                cobradores = new ArrayList<>();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al leer el archivo de cobradores: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            cobradores = new ArrayList<>();
        }
    }

    private void guardarCobradores() {
        File archivo = new File(archivoCobradores);
        
        try {
            // Asegurar que el archivo no es de solo lectura
            if (archivo.exists() && !archivo.canWrite()) {
                archivo.setWritable(true);
            }
            
            try (FileWriter writer = new FileWriter(archivo)) {
                gson.toJson(cobradores, writer);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar cobradores: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
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
 */
