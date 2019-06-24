/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gestorArchivos.Lectura;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeremias
 */
public class testLizama_7 {
      private Lectura lec;
      
      public testLizama_7() {
      }
      
      @Before
      public void setUp() {
            lec = new Lectura();
      }
      
      
      /**
     * Prueba el método lecturaPrimerTexto con un archivo que no existe.
     *
     * @throws IOException
     */
    @Test
    public void testTexto1() throws IOException {
        assertEquals(lec.lecturaPrimerTexto("vacio.txt"), "nada");
    }

    /**
     * Prueba el método lecturaSegundoTexto con un archivo que no existe.
     *
     * @throws IOException
     */
    @Test
    public void testTexto2() throws IOException {
       
        assertEquals( lec.lecturaSegundoTexto("nada.txt"), "no hay nada");
    }
      
      
      
      
      
      
      
      
      @After
      public void tearDown() {
      }

    
}
