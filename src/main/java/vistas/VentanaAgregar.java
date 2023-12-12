package vistas;

import dominio_problema.Coleccion;
import dominio_problema.Vinilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregar extends JFrame {
    private Coleccion coleccion;
    private JTextField name_ArtistField;
    private JTextField title_LPField;
    private JTextField yearField;
    private JButton agregarButton;

    public VentanaAgregar(Coleccion coleccion) {
        this.coleccion = coleccion;

        name_ArtistField = new JTextField(20);
        title_LPField = new JTextField(20);
        yearField = new JTextField(20);
        agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name_Artist = name_ArtistField.getText();
                String title_LP = title_LPField.getText();
                int year = Integer.parseInt(yearField.getText());
                coleccion.agregarVinilo(new Vinilo(name_Artist, title_LP, year));
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Nombre del Artista:"));
        add(name_ArtistField);
        add(new JLabel("Título del LP:"));
        add(title_LPField);
        add(new JLabel("Año:"));
        add(yearField);
        add(agregarButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}