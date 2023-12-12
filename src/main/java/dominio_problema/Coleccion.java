package dominio_problema;

import datos.DatosVinilo;

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
    
    public int cantidadVinilosPorNombre(String name_Artist){
        int cantidad = 0;
        for (Vinilo vinilo : vinilos) {
            if (vinilo.getName_Artist().equalsIgnoreCase(name_Artist)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public Vinilo buscarViniloPorNombre(String nombre){
        for(int i = 0; i < vinilos.size(); i++){
            if(vinilos.get(i).getTitle_LP().equalsIgnoreCase(nombre)){
                return vinilos.get(i);
            }
        }
        return null;
    }
    public void eliminarVinilo(String nombre){
        for(int i = 0; i < vinilos.size(); i++){
            if(vinilos.get(i).getTitle_LP().equalsIgnoreCase(nombre)){
                vinilos.remove(i);
                guardarCambios();
            }
        }
    }

    public void cuantosVinilos(){
        int cantidad = 0;
        for (Vinilo vinilo : vinilos) {
            cantidad++;
        }
    }

    public int cuantosEspaciosQuedan(){
        return 100 - vinilos.size();
    }









    public boolean verificarTamaño() {
        return this.vinilos.size() < 100;
    }
}