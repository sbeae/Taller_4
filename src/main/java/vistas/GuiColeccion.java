package vistas;

import dominio_problema.Coleccion;
import dominio_problema.Vinilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiColeccion extends JFrame {
    private Coleccion coleccion;
    private JButton agregarViniloButton;
    private JButton existeViniloButton;
    private JButton cantidadVinilosPorNombreButton;
    private JButton buscarViniloPorNombreButton;
    private JButton eliminarViniloButton;
    private JButton cuantosVinilosButton;
    private JButton cuantosEspaciosQuedanButton;

    public GuiColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;

        agregarViniloButton = new JButton("Agregar Vinilo");
        agregarViniloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para agregar un vinilo
            }
        });

        existeViniloButton = new JButton("Existe Vinilo");
        existeViniloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para verificar si existe un vinilo
            }
        });

        cantidadVinilosPorNombreButton = new JButton("Cantidad de Vinilos por Nombre");
        cantidadVinilosPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para obtener la cantidad de vinilos por nombre
            }
        });

        buscarViniloPorNombreButton = new JButton("Buscar Vinilo por Nombre");
        buscarViniloPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para buscar un vinilo por nombre
            }
        });

        eliminarViniloButton = new JButton("Eliminar Vinilo");
        eliminarViniloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para eliminar un vinilo
            }
        });

        cuantosVinilosButton = new JButton("Cuantos Vinilos");
        cuantosVinilosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para obtener la cantidad de vinilos
            }
        });

        cuantosEspaciosQuedanButton = new JButton("Cuantos Espacios Quedan");
        cuantosEspaciosQuedanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para obtener la cantidad de espacios que quedan
            }
        });

        setLayout(new FlowLayout());
        add(agregarViniloButton);
        add(existeViniloButton);
        add(cantidadVinilosPorNombreButton);
        add(buscarViniloPorNombreButton);
        add(eliminarViniloButton);
        add(cuantosVinilosButton);
        add(cuantosEspaciosQuedanButton);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}