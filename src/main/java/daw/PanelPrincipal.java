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
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        String valor = "", simbolo;
        int num;
        // Si es un botón
        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());
            valor = ((JButton) o).getText();
            areaTexto.append(valor);
            String[] split = valor.split("\\s*[+\\-*/]\\s*");
            int num1 = Integer.parseInt(split[0]);
            System.out.println(num1);
            int num2 = Integer.parseInt(split[2]);
            System.out.println(num2);
        }

    }
}
