package principal;
import datos.DatosVinilo;
import dominio_problema.Coleccion;
import dominio_problema.Vinilo;
import vistas.GuiColeccion;

import javax.swing.*;
import java.util.ArrayList;

public class launcher {
    public static void main(String[] args){
        Coleccion coleccion = new Coleccion();
        ArrayList<Vinilo> vinilos = coleccion.obtenerListaVinilos();
        SwingUtilities.invokeLater(() -> new GuiColeccion(coleccion));
    }
}