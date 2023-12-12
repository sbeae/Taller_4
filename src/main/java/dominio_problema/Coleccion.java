package dominio_problema;

import datos.DatosVinilo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Vinilo> vinilos;
    private DatosVinilo gestorArchivo;
    private String nombre;

    public Coleccion() {
        vinilos = new ArrayList<>();
        gestorArchivo = new DatosVinilo();
    }
    public ArrayList<Vinilo> obtenerListaVinilos(){
        return vinilos;
    }


    public void guardarCambios() {
        gestorArchivo.guardarCambios(this.vinilos);
    }

    public boolean agregarVinilo(Vinilo vinilo) {
        if (verificarTamaño()) {
            vinilos.add(vinilo);
            guardarCambios();
            return true;
        }
        return false;
    }
    public boolean existeVinilo(String name_Artist){
        for (Vinilo vinilo : vinilos) {
            if (vinilo.getName_Artist().equalsIgnoreCase(name_Artist)) {
                return true;
            }
        }
        return false;
    }

    public Vinilo mostrarDatosvinilotxt(String nombre){
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name_Artist = parts[0];
                String title_LP = parts[1];
                int year = Integer.parseInt(parts[2]);
                if (title_LP==(nombre)) {
                    return new Vinilo(name_Artist, title_LP, year);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int cantidadVinilosPorNombre(String name_Artist){
        int cantidad = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String artistName = parts[0];
                if (artistName.equalsIgnoreCase(name_Artist)) {
                    cantidad++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cantidad;
    }

    public Vinilo buscarViniloPorNombre(String nombre){
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name_Artist = parts[0];
                String title_LP = parts[1];
                int year = Integer.parseInt(parts[2]);
                if (title_LP.equalsIgnoreCase(nombre)) {
                    return new Vinilo(name_Artist, title_LP, year);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




    public int cuantosEspaciosQuedan(){
        return 100 - vinilos.size();
    }

    public boolean verificarTamaño() {
        return this.vinilos.size() < 100;
    }
}