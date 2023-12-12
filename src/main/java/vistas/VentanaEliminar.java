package vistas;

import dominio_problema.Coleccion;
import datos.DatosVinilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminar extends JFrame {
    private Coleccion coleccion;
    private DatosVinilo datosVinilo;
    private JTextField name_ArtistField;
    private JButton eliminarButton;
    private JButton volverButton;

    public VentanaEliminar(Coleccion coleccion) {
        this.coleccion = coleccion;
        this.datosVinilo = new DatosVinilo();

        name_ArtistField = new JTextField(20);
        eliminarButton = new JButton("Eliminar");
        volverButton = new JButton("Volver");

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = name_ArtistField.getText();
                boolean eliminado = datosVinilo.eliminarVinilo(nombre);
                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "El vinilo ha sido eliminado de la colección.");
                } else {
                    JOptionPane.showMessageDialog(null, "El vinilo no existe en la colección.");
                }
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiColeccion(coleccion).setVisible(true);
                VentanaEliminar.this.dispose();
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Nombre del Vinilo(LP):"));
        add(name_ArtistField);
        add(eliminarButton);
        add(volverButton);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}