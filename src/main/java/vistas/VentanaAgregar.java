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
    private JButton volverButton;


    public Vinilo crearVinilo() {
        String nombre = (name_ArtistField.getText()).toLowerCase();
        String titulo = (title_LPField.getText()).toLowerCase();
        int año = Integer.parseInt(yearField.getText());
        return new Vinilo(nombre, titulo, año);
    }
    private void agregarNuevoVinilo() {
        Vinilo vinilo = crearVinilo();
        coleccion.agregarVinilo(vinilo);
        JOptionPane.showMessageDialog(this, "Vinilo agregada correctamente");
    }



    public VentanaAgregar(Coleccion coleccion) {
        this.coleccion = coleccion;

        volverButton = new JButton("Volver");
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiColeccion(coleccion).setVisible(true);
                VentanaAgregar.this.dispose();
            }
        });

        setLayout(new FlowLayout());
        name_ArtistField = new JTextField(20);
        title_LPField = new JTextField(20);
        yearField = new JTextField(20);
        agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarNuevoVinilo();
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
        add(volverButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}