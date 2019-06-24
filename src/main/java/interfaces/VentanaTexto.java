package interfaces;

import gestorArchivos.Lectura;
import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author JonathanLizama
 */
public class VentanaTexto extends JFrame implements ActionListener {

      private JTextArea cuadro;
      private JButton botonFormatear, botonVolver;
      private VentanaPrincipal princ;
      private JPanel panelInferior, panelSuperior;

      private void configurarVentana() {
            this.setTitle("Estacionamiento");
            this.setSize(710, 500);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      public VentanaTexto(VentanaPrincipal princ) {
            super();
            configurarVentana();
            iniciarComponentes();
            this.princ = princ;
      }

      private void iniciarComponentes() {
            cuadro = new JTextArea();
            botonFormatear = new JButton();
            botonVolver = new JButton();
            panelInferior = new JPanel();
            panelSuperior = new JPanel();

            panelSuperior();
            panelInferior();

      }

      private void panelSuperior() {
            botonFormatear();
            botonVolver();
            panelSuperior.setBackground(Color.WHITE);
            panelSuperior.setBounds(0, 0, 710, 150);
            panelSuperior.setLayout(null);
            this.add(botonFormatear);
            this.add(botonVolver);
            this.add(panelSuperior);
      }

      private void botonFormatear() {
            botonFormatear.setText("Formatear Archivo");
            botonFormatear.setForeground(Color.black);
            botonFormatear.setBounds(100, 50, 200, 60);
            botonFormatear.addActionListener(this);
            panelSuperior.add(botonFormatear);
      }

      private void botonVolver() {
            botonVolver.setText("Cargar Nuevo Archivo");
            botonVolver.setForeground(Color.black);
            botonVolver.setBounds(400, 50, 200, 60);
            botonVolver.addActionListener(this);
            panelSuperior.add(botonVolver);
      }

      private void panelInferior() {
            cuadroTexto();
            panelInferior.setBackground(Color.BLUE);
            panelInferior.setBounds(0, 150, 710, 350);
            panelInferior.setLayout(null);
            this.add(cuadro);
            this.add(panelInferior);

      }

      private void cuadroTexto() {
            cuadro.setBounds(100, 160, 550, 300);
            cuadro.setBorder(new LineBorder(Color.BLACK));
            
            panelInferior.add(cuadro);
      }

      public void mostrarTexto() throws IOException {
            Lectura lec = new Lectura();
            String ruta = princ.getCaja().getText();
                  switch (ruta) {
                        case "C:\\Users\\Jeremias\\Documents\\NetBeansProjects\\POO\\lizama_7\\Archivos\\archivo1.txt":
                              cuadro.setText(lec.lecturaPrimerTexto(ruta));
                              break;
                        case "C:\\Users\\Jeremias\\Documents\\NetBeansProjects\\POO\\lizama_7\\Archivos\\archivo2.txt":
                              cuadro.setText(lec.lecturaSegundoTexto(ruta));
                              break;
                        default:
                              JOptionPane.showMessageDialog(this, "Introduzca una ruta válida por favor.");
                              break;
                  }
            }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonFormatear) {
                  try {
                        mostrarTexto();
                  } catch (IOException ex) {
                        Logger.getLogger(VentanaTexto.class.getName()).log(Level.SEVERE, null, ex);
                  }
                 
            } else if (e.getSource() == botonVolver) {
                  princ.setVisible(true);
                  this.setVisible(false);
                  dispose();
            }
      }

}
