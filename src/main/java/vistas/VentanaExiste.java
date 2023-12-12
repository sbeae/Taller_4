package vistas;

import dominio_problema.Coleccion;
import dominio_problema.Vinilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaExiste extends JFrame {
    private Coleccion coleccion;
    private JTextField title_LPField;
    private JButton buscarButton;
    private JButton volverButton;

    public VentanaExiste(Coleccion coleccion) {
        this.coleccion = coleccion;

        title_LPField = new JTextField(20);
        buscarButton = new JButton("Buscar");
        volverButton = new JButton("Volver");

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title_LP = title_LPField.getText();
                Vinilo vinilo = coleccion.buscarViniloPorNombre(title_LP);
                if (vinilo != null) {
                    JOptionPane.showMessageDialog(null, "El vinilo existe en la colección.");
                } else {
                    JOptionPane.showMessageDialog(null, "El vinilo no existe en la colección.");
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiColeccion(coleccion).setVisible(true);
                VentanaExiste.this.dispose();
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Título del LP:"));
        add(title_LPField);
        add(buscarButton);
        add(volverButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}