/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author edu
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1;
    }

    private void initComponents() {
        botonera = new PanelBotones();
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        this.setLayout(new BorderLayout());
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);
        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        String valor = boton.getText();
        areaTexto.append(valor);
        valor = areaTexto.getText();
        int res = 0, num1 = 0, num2 = 0;
        String simbolo = "";
        System.out.println(valor);
        if (valor.contains("C")) {
            valor = "";
            areaTexto.setText(valor);
            res = 0;
            num1 = 0;
            num2 = 0;
        }
        if (valor.contains("=")) {
            String[] s = valor.split("\\s*[+\\-*/=]\\s*");
            simbolo = valor.replaceAll("[\\d\\s=]", "");
            System.out.println(simbolo);
            num1 = Integer.parseInt(s[0]);
            System.out.println(num1);
            num2 = Integer.parseInt(s[1]);
            System.out.println(num2);
            switch (simbolo) {
                case "+" -> {
                    res = num1 + num2;
                }
                case "-" -> {
                    res = num1 - num2;
                }
                case "*" -> {
                    res = num1 * num2;
                }
                case "/" -> {
                    res = num1 / num2;
                }
            }
            areaTexto.setText(valor + res);
        }
    }
}
