package vistas;

import dominio_problema.Coleccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCantidadVinilos extends JFrame {
    private Coleccion coleccion;
    private JTextField name_ArtistField;
    private JButton buscarButton;
    private JButton volverButton;

    public VentanaCantidadVinilos(Coleccion coleccion) {
        this.coleccion = coleccion;

        name_ArtistField = new JTextField(20);
        buscarButton = new JButton("Buscar");
        volverButton = new JButton("Volver");

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = name_ArtistField.getText();
                int cantidad = coleccion.cantidadVinilosPorNombre(nombre);
                JOptionPane.showMessageDialog(null, "Hay " + cantidad + " vinilos con el nombre " + nombre + " en la colección.");
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiColeccion(coleccion).setVisible(true);
                VentanaCantidadVinilos.this.dispose();
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Nombre del Artista:"));
        add(name_ArtistField);
        add(buscarButton);
        add(volverButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}