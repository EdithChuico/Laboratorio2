package com.mycompany.p1lab2chuicoedith;
import java.io.*;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Productos {
    public void guardarProductosJson () {
        System.out.println("====================================");

            // Escribir lo que desee guardar en SaboresJSON
        JSONObject SaboresJSON = new JSONObject();
        SaboresJSON.put("Manjar         Chocolate   ",""); 
        SaboresJSON.put("Ron pasas      Oreo","");
        SaboresJSON.put("Nutella        Vainilla","" );
        SaboresJSON.put("Mora           Fresa" ,"");
        SaboresJSON.put("Mango          Chicle","" );
        // Nombre del archivo
        String archivoSabores = "SaboresHelado.json";
        //Guardar archivo
        try (FileWriter file = new FileWriter(archivoSabores)) {
            file.write(SaboresJSON.toJSONString());
            System.out.println("Se han guardado los sabores de helado disponibles en el archivo JSON correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public void leerProductos() {
 String archivoSabores = "SaboresHelado.json";
        try {
            // Crear un objeto JSONParser
            JSONParser parser = new JSONParser();
            // Leer el archivo JSON y convertirlo a un objeto JSON
            Object obj = parser.parse(new FileReader(archivoSabores));

            // Convertir el objeto JSON a JSONObject
            JSONObject saboresJSON = (JSONObject) obj;
            // Iterar sobre las claves y valores del JSON
            for (Object key : saboresJSON.keySet()) {
                String clave = (String) key;
                String valor = (String) saboresJSON.get(clave);
                System.out.println(clave + "  " + valor);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
