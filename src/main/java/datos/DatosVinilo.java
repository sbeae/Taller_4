package datos;

import dominio_problema.Vinilo;
import java.io.*;
import java.util.ArrayList;

public class DatosVinilo {

    String ruta;
    public DatosVinilo(){
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
                    // Verificar si la línea contiene datos válidos
                    if (!linea.trim().isEmpty()) {
                        // Si encontramos al menos una línea con datos, el archivo no está vacío
                        return false;
                    }
                    linea = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Si no se encuentra ninguna línea con datos válidos, consideramos el archivo como vacío
        return true;
    }

    public ArrayList<Vinilo> obtenerViniloArchivo() {
        ArrayList<Vinilo> vinilos = new ArrayList<>();
        if (existeArchivo()) {
            //Si el archivo estaba vacío, se retorna un arreglo vacío
            if (archivoViniloVacio()) {
                return vinilos;
            }else {
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
        }else {
            crearArchivoVinilo();
            return obtenerViniloArchivo();
        }
        return vinilos;
    }


    public void guardarCambios(ArrayList<Vinilo> vinilos) {
        if (existeArchivo()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false))) {
                for (Vinilo vinilo : vinilos) {
                    bw.write(vinilo.toString());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            crearArchivoVinilo();
            guardarCambios(vinilos);
        }

    }








}
