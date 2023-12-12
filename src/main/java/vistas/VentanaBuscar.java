package vistas;

import dominio_problema.Coleccion;
import dominio_problema.Vinilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBuscar extends JFrame {
    private Coleccion coleccion;
    private JTextField name_ArtistField;
    private JButton buscarButton;
    private JButton volverButton;
    private JLabel viniloInfoLabel;

    public VentanaBuscar(Coleccion coleccion) {
        this.coleccion = coleccion;

        name_ArtistField = new JTextField(20);
        buscarButton = new JButton("Buscar");
        volverButton = new JButton("Volver");
        viniloInfoLabel = new JLabel();

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = name_ArtistField.getText();
                Vinilo vinilo = coleccion.mostrarDatosvinilotxt(nombre);
                if (vinilo != null) {
                    JOptionPane.showMessageDialog(null, "Nombre del artista: " + vinilo.getName_Artist() + ", Nombre del LP: " + vinilo.getTitle_LP() + ", Año: " + vinilo.getYear());
                } else {
                    JOptionPane.showMessageDialog(null, "El vinilo no existe en la colección.");
                }
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiColeccion(coleccion).setVisible(true);
                VentanaBuscar.this.dispose();
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Nombre del Vinilo(LP):"));
        add(name_ArtistField);
        add(buscarButton);
        add(volverButton);
        add(viniloInfoLabel);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
