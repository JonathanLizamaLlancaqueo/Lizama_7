package gestorArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author JonathanLizama
 */
public class Lectura {

      /**
       * Lee y devuelve el texto con sus líneas pares.
       *
       * @param ruta del archivo de texto.
       * @return Texto sin líneas impares.
       * @throws FileNotFoundException
       * @throws IOException
       */
      public String lecturaPrimerTexto(String ruta) throws FileNotFoundException, IOException {
            File f = new File(ruta);
            if (f.exists()) {
                  String texto;
                  String lectura = "";
                  FileReader fr = new FileReader(ruta);
                  BufferedReader br = new BufferedReader(fr);
                  br.readLine();
                  while ((texto = br.readLine()) != null) {
                        br.readLine();
                        lectura = lectura + texto + "\n";

                  }
                  return lectura;
            }
            return "nada";
      }

      /**
       * Lee un texto, lo devuelve sin saltos de línea.
       *
       * @param ruta del archivo de texto.
       * @return Texto en línea recta.
       * @throws FileNotFoundException
       * @throws IOException
       */
      public String lecturaSegundoTexto(String ruta) throws FileNotFoundException, IOException {
            File f = new File(ruta);
            if (f.exists()) {
                  String texto;
                  String mensaje = "";
                  FileReader fr = new FileReader(ruta);
                  BufferedReader br = new BufferedReader(fr);
                  while ((texto = br.readLine()) != null) {
                        mensaje = mensaje + texto;
                  }
                  return mensaje;
            }
            return "no hay nada";
      }

}
