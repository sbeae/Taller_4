package datos;

import dominio_problema.Vinilo;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DatosVinilo {

    String ruta;

    public DatosVinilo() {
        this.ruta = "src/main/java/datos/datos.txt";
    }

    public boolean existeArchivo() {
        //Se verifica si existe el archivo con el nombre "nombreArchivo"
        File file = new File(ruta);
        return file.exists();
    }

    public void crearArchivoVinilo() {
        File f = new File(ruta);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean archivoViniloVacio() {
        File archivo = new File(ruta);
        if (archivo.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea = reader.readLine();
                while (linea != null) {

                    if (!linea.trim().isEmpty()) {

                        return false;
                    }
                    linea = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    public ArrayList<Vinilo> obtenerViniloArchivo() {
        ArrayList<Vinilo> vinilos = new ArrayList<>();
        if (existeArchivo()) {

            if (archivoViniloVacio()) {
                return vinilos;
            } else {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(ruta));
                    String linea = reader.readLine();
                    while (linea != null) {
                        String[] datos = linea.split(",");
                        Vinilo vinilo = new Vinilo(datos[0], datos[1], Integer.parseInt(datos[2]));
                        vinilos.add(vinilo);
                        linea = reader.readLine();
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            crearArchivoVinilo();
            return obtenerViniloArchivo();
        }
        return vinilos;
    }
    public Vinilo obtenerDatosVinilo(String nombreVinilo) {
        if (existeArchivo()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(ruta));
                String linea = reader.readLine();
                while (linea != null) {
                    String[] datos = linea.split(",");
                    String name_Artist = datos[0];
                    String title_LP = datos[1];
                    int year = Integer.parseInt(datos[2]);
                    if (title_LP.equalsIgnoreCase(nombreVinilo)) {
                        return new Vinilo(name_Artist, title_LP, year);
                    }
                    linea = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe.");
        }
        return null;
    }
    public boolean eliminarVinilo(String nombreVinilo) {
        if (existeArchivo()) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(ruta));
                List<String> updatedLines = lines.stream()
                        .filter(line -> !line.contains(nombreVinilo))
                        .collect(Collectors.toList());

                Files.write(Paths.get(ruta), updatedLines);
                return lines.size() != updatedLines.size();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe.");
        }
        return false;
    }




    public void guardarCambios(ArrayList<Vinilo> vinilos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            for (Vinilo vinilo : vinilos) {
                writer.write(vinilo.toText());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
