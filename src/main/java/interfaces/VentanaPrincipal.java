package interfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author JonathanLizama
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

      private JPanel panelSuperior, panelInferior;
      private JLabel titulo, imagen, informacion;
      private JTextField caja;
      private JButton cargar,salir;
      private VentanaTexto text;
      int contador = 0;

      private void configurarVentana() {
            this.setTitle("Estacionamiento");
            this.setSize(710, 500);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      public VentanaPrincipal getVentanaPrincipal() {
            return this;
      }

      public VentanaPrincipal() {
            super();
            configurarVentana();
            iniciarComponentes();
      }

      private void iniciarComponentes() {
            titulo = new JLabel();
            imagen = new JLabel();
            salir = new JButton();
            informacion = new JLabel();
            cargar = new JButton();
            panelInferior = new JPanel();
            panelSuperior = new JPanel();
            caja = new JTextField();

            panelSuperior();
            panelInferior();

      }

      private void panelSuperior() {
            titulo();
            anadirImagen();
            panelSuperior.setBackground(Color.WHITE);
            panelSuperior.setBounds(0, 0, 710, 220);
            panelSuperior.setLayout(null);
            this.add(titulo);
            this.add(imagen);
            this.add(panelSuperior);

      }

      private void anadirImagen() {
            imagen = new JLabel(new ImageIcon("C:\\Users\\Jeremias\\Documents\\NetBeansProjects\\POO\\lizama_7\\src\\main\\java\\interfaces\\400x400.jpg"));
            imagen.setBounds(450, 0, 250, 200);
            imagen.setOpaque(true);
            panelSuperior.add(imagen);
      }

      public void anadirCaja() {
            caja.setBounds(140, 300, 500, 30);
            panelInferior.add(caja);

      }

      private void titulo() {
            titulo.setBounds(25, 25, 450, 150);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            titulo.setText("Expresiones regulares");
            titulo.setForeground(Color.BLACK);
            titulo.setFont(new Font("Arial Black", Font.BOLD, 30));
            panelSuperior.add(titulo);
      }

      // Panel Inferior 
      private void panelInferior() {
            botonCargar();
            botonSalir();
            anadirCaja();
            informacion();
            panelInferior.setBackground(Color.BLUE);
            panelInferior.setBounds(0, 220, 710, 410);
            panelInferior.setLayout(null);
            this.add(cargar);
            this.add(salir);
            salir.addActionListener(this);
            cargar.addActionListener(this);
            this.add(caja);
            this.add(informacion);
            this.add(panelInferior);

      }

      private void informacion() {
            informacion.setBounds(33, 300, 130, 30);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            informacion.setText("Ingrese Ruta:");
            informacion.setForeground(Color.BLACK);
            informacion.setFont(new Font("Arial Black", Font.BOLD, 12));
            panelInferior.add(informacion);
      }

      private void botonCargar() {
            cargar.setText("Cargar Archivos");
            cargar.setForeground(Color.red);
            cargar.setBounds(250, 350, 250, 60);
            cargar.addActionListener(text);
            panelInferior.add(cargar);
      }
      
      private void botonSalir() {
            salir.setText("Salir");
            salir.setForeground(Color.blue);
            salir.setBounds(520, 430, 100, 30);
            salir.addActionListener(this);
            panelInferior.add(salir);
      }


      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cargar) {
                  if (contador == 0) {
                        VentanaTexto vent = new VentanaTexto(getVentanaPrincipal());
                        vent.setVisible(true);
                        this.setVisible(false);
                  } else {
                        text.setVisible(true);
                        this.setVisible(false);
                  }
            }else{
                  if(e.getSource() == salir){
                        dispose();   
                  }
            }

      }

      public void setVentanaTexto(VentanaTexto text) {
            this.text = text;
      }

      public JTextField getCaja() {
            return caja;
      }

}
