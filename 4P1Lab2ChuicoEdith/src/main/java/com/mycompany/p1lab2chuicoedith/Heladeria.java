package com.mycompany.p1lab2chuicoedith;
import java.util.Scanner;
import java.io.*;
public class Heladeria {
    public String ingredientes;
    public String datosCLientes;
    public float PrecioProductos=0;
    public String RegistroFactura;

    public Heladeria(String ingredientes, String datosCLientes, float PrecioProductos, String RegistroFactura) {
        this.ingredientes = ingredientes;
        this.datosCLientes = datosCLientes;
        this.PrecioProductos = PrecioProductos;
        this.RegistroFactura = RegistroFactura;
    }
    public void Acciones (){
    Clientes clientes= new Clientes ("","","","","","","","","",1,"","","");

    Scanner scanner = new Scanner (System.in);
    String opcionUsuario;
    System.out.print("\n======================================================\n");
    System.out.print("     Universidad de las fuerzas armadas Espe\n");
    System.out.print("Nombre: Edith Chuico\n");
    System.out.print("Carrera: ITIN- 2do Semestre\n");
    System.out.print("Curso: Programación orientada a objetos\n");
    System.out.print("Docente: Ing.Veronica Martinez\n");
    
    do{
    System.out.print("\n=============================\n");
    System.out.print(" **Bienvenidos a la heladeria DeliFrost**\n");
    System.out.print("\nQue desea hacer?");
            System.out.print("\n1. Hacer pedido" + "\n2. Ver registro de clientes"+"\n3. Inventario"+"\n4. Salir de la heladeria");
            System.out.println("\nEscoja una opcion: ");
            opcionUsuario=scanner.nextLine();
         while (!opcionUsuario.matches("\\d+") || Integer.parseInt(opcionUsuario) < 1 || Integer.parseInt(opcionUsuario) > 4){
             System.out.print("Opcion no valida, indique la cantidad con un numero (De 1 a 4)");
             opcionUsuario=scanner.nextLine();
         }
         int opcion= Integer.parseInt(opcionUsuario);
            switch (opcion){
                case 1:
                    clientes.PedirOrden();
                    clientes.Pagar();
                    
                    break;
                case 2:
                    System.out.print("        Base de datos de clientes ingresados"+"\n Este listado se obtiene desde el archivo DatosCliente.csv");
                    leerArchivoCSV();
                    break;
                case 3:
                    System.out.print("Se visualizan los sabores de helados disponibles\n");
                    Productos productos = new Productos();
                    productos.guardarProductosJson();
                    productos.leerProductos();
                    break;
                case 4:
                   System.out.print("Gracias por su tiempo");
                    break;
            }
    }while(Integer.parseInt(opcionUsuario)!=4);
    }  
    public  void guardarMenu (){  
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("MenuHelados.txt"))) {
            writer.write("Menu\n");
            writer.write("Precios\n");
            writer.write("1 = Cono simple/ 1 Sabor ($1,00)\n");
            writer.write("2 = Cono doble/ 2 Sabores ($ 1,50)\n");
            writer.write("3 = Pequeño/ 4 Sabores ($ 2,00)\n");
            writer.write("4 = Mediano/ 6 Sabores ($ 2,50)\n");
            writer.write("5 = Grande/ 8 Sabores ($ 3,00)\n");
            System.out.println("Datos guardados en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    public class LeerMenu {
    public String leerTXT(String direccion){//direccion del archivo
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader (new FileReader ("MenuHelados.txt"));
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }   
        }catch (IOException e){
            System.err.println("No se encontro el archivo");
        }
        return texto; 
    }
}
     public class RegistroClientesCSV {
    public static void crearArchivoCSV(String delim, String... info) {
        final String NEXT_LINE = "\n";
        try {
            // Asisgnación del nombre con el que se va a guardar el archivo 
            String file = "DatosCliente.csv";
            FileWriter fw = new FileWriter(file, true);

            // Encabezado del archivo CSV
            fw.append(NEXT_LINE);
            fw.append("| Nombre    | ").append("Apellido     |  ").append("Cedula      |").append("Cantidad    |").append("Valor total a pagar");
            fw.append(NEXT_LINE).append(delim);
            // Información del usuario
            for (String value : info) {
                fw.append(value).append(delim);
            }
            fw.append(NEXT_LINE);

            fw.flush();
            fw.close();
            System.out.println("Archivo CSV creado con éxito en: " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
}
    public void leerArchivoCSV() {
   final String DELIMITER = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("DatosCliente.csv"))) {
            String line;
            // Lee la primera línea del código
            line = br.readLine();
            System.out.println(line);
            // Lee todas las lineas del codigo en caso de que hayan
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(DELIMITER);
                for (String dato : datos) {
                    System.out.print(dato + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("El archivo CSV aún no ha sido creado.");
        } 
    }
}

