package com.mycompany.p1lab2chuicoedith;
import java.io.BufferedReader;//Lectura de archivos
import java.io.BufferedWriter;//Escritura de archivos
import java.io.FileReader;//lee los caracteres de un archivo
import java.io.FileWriter;//escribe datos en un archivo
import java.io.IOException;//manejo de errores mediante la lectura y escritura de archivos
import java.util.Scanner;//lectura de datos en java
public class Clientes extends Heladeria {
    //Atributos 
    public String Nombre ;
    public String Apellido;
    public String CantidadHelados;
    public String Cedula;
    public String FormaPago;
    public String nSabores;
    public String uSabor;
    public String cambio;
    public String monto;
    //METODOS GET
    public String getNombre() {
        return this.Nombre;
    }
    public String getApellido() {
        return this.Apellido;
    }
    public String getNumeroCedula() {
        return this.Cedula;
    }
    public String getCantidadHelados() {
        return CantidadHelados;
    }
    public String getnSabores() {
        return nSabores;
    }
    public String getuSabor() {
        return uSabor;
    }
    //Constructor
    public Clientes(String Nombre, String Apellido, String CantidadHelados, String Cedula, String nSabores, String uSabor, String cambio, String ingredientes, String datosCLientes, float PrecioProductos, String RegistroFactura, String FormaPago, String monto) {
        super(ingredientes, datosCLientes, PrecioProductos, RegistroFactura);
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.CantidadHelados = CantidadHelados;
        this.Cedula = Cedula;
        this.nSabores = nSabores;
        this.uSabor = uSabor;
        this.cambio = cambio;
        this.FormaPago= FormaPago;
        this.monto = monto;
    }
    //Metodos
    public void PedirOrden(){
        //String cambio;
         String[]sabores= new String[10];
        Scanner scanner= new Scanner (System.in);
        System.out.print("=========== Bienvenido al sistema de pedidos ===========\n ");
        System.out.print("Le presento el menú de los sabores de helados"+ "\n y los precios para que me indique lo que desea\n");
        verMenu();
        System.out.print("\n Indique por favor cuantos helados desea pedir: ");
        CantidadHelados=scanner.nextLine();
         while (!CantidadHelados.matches("\\d+") || Integer.parseInt(CantidadHelados) < 1 || Integer.parseInt(CantidadHelados) > 5){
             System.out.print("Dato no valido, indique la cantidad con un numero (Maximo 5): ");
             CantidadHelados=scanner.nextLine();
         }
         //Convertir CantidadHelados a tipo int para poder usarlo en un for
        int nHelados = Integer.parseInt(CantidadHelados);
        PrecioProductos=0;
        System.out.print("Abierto desde el archivo SaboresHelado.jon\n");
        
        for (int i=1; nHelados >= i; i++){  
           System.out.print("Indique porfavor la cantidad de sabores del (" + i + ") helado," + "\neliga en las opciones de (1, 2, 4, 6, 8) del menu:\n");
           nSabores=scanner.nextLine();
           while (!nSabores.matches("\\d+") || Integer.parseInt(nSabores)!= 1 && Integer.parseInt(nSabores)!= 2 && Integer.parseInt(nSabores)!= 4 && Integer.parseInt(nSabores)!= 6 && Integer.parseInt(nSabores)!= 8){
             System.out.print("Dato no valido, indique la cantidad con un numero (1 / 2 / 4 / 6 / 8): ");
             nSabores=scanner.nextLine();
            }  
           int numSabores=Integer.parseInt(nSabores);
           //Estructura de control If que nos permite saber el valor que se va sumando
           //de acuerdo a la cantidad de sabores de helado seleccionados
           if (numSabores == 2) {
                PrecioProductos += 1.5;
            } else if (numSabores == 4) {
                PrecioProductos += 2;
            } else if (numSabores == 6) {
                PrecioProductos += 2.5;
            } else if (numSabores == 8) {
                PrecioProductos += 3;
            } else{
                PrecioProductos += 1;
            }      
           for (int e=1 ; numSabores>=e; e++){
               //Controla que los datos ingresados en sabor no sea uno diferente a los de la lista
              do {
                  Productos productos= new Productos();
                  productos.leerProductos();
                 System.out.print("Ingrese el " + e + " sabor : ");
                 uSabor = scanner.nextLine().trim();
                } while (!uSabor.equalsIgnoreCase("Manjar") && !uSabor.equalsIgnoreCase("Chocolate") &&
                  !uSabor.equalsIgnoreCase("Oreo") && !uSabor.equalsIgnoreCase("Vainilla") &&
                  !uSabor.equalsIgnoreCase("Ron Pasas") && !uSabor.equalsIgnoreCase("Nutella") &&
                  !uSabor.equalsIgnoreCase("Mora") && !uSabor.equalsIgnoreCase("Fresa") &&
                  !uSabor.equalsIgnoreCase("Chicle") && !uSabor.equalsIgnoreCase("Mango"));
                System.out.println("Sabor ingresado correctamente: " + uSabor);
                sabores[e]=uSabor;
            }
            System.out.print("Sabores ingresados para el " + i + " helado: \n");
            for (int f=1; f<=numSabores; f++){
            System.out.print( sabores[f]+ "\n");
            }
        }   
        System.out.print("Precio total: " +(PrecioProductos));
        
    }
    public void Pagar(){
        float cambio;
        Scanner scanner = new Scanner (System.in);
        System.out.print("\nIngrese su nombre: ");
        Nombre=scanner.nextLine();
        while(!Nombre.matches("[a-zA-Z]+")){
          System.out.print("Ingrese palabras sin datos numericos: ");
          Nombre=scanner.nextLine();
         }
        System.out.print("Ingrese su apellido: ");
        Apellido=scanner.nextLine();
        while (!Apellido.matches("[a-zA-Z]+")){
          System.out.print("Ingrese palabras sin datos numericos: ");
          Apellido=scanner.nextLine();
        }
        System.out.print("Ingrese su n de cedula: ");
        Cedula=scanner.nextLine();

        while (!Cedula.matches("\\d+") && Cedula.length() != 10){
            System.out.print("Dato no valido, debe tener 10 digitos y ser solo numeros: ");
            Cedula=scanner.nextLine();
        }
        while (!Cedula.matches("\\d+") || Cedula.length() != 10){
            System.out.print("Dato no valido, debe tener 10 digitos y ser solo numeros: ");
            Cedula=scanner.nextLine();
        }
    System.out.print("\nIndique de forma desea realizar su pago (Efectivo o Transferencia): ");
    FormaPago=scanner.nextLine();
    while (!FormaPago.equalsIgnoreCase("Efectivo") && !FormaPago.equalsIgnoreCase("Transferencia")){
     System.out.print("\nIngrese un mensaje valido (Efectivo o Transferencia)");
     FormaPago=scanner.nextLine().trim();
     }
    if (FormaPago.equalsIgnoreCase("Efectivo")){
        System.out.print("\nListo, el total de su compra a sido: " + PrecioProductos + ". Ingrese el monto a cancelar porfavor: \n");
        monto= scanner.nextLine();
        while (!monto.matches("\\d+")){
             System.out.print("Dato no valido, indique el monto en numero: ");
             monto=scanner.nextLine();
         }
        float fmonto = Float.parseFloat(monto);
        while(fmonto<PrecioProductos){
            System.out.print("El monto ingresado es insuficiente, intente de nuevo porfavor");
            fmonto= scanner.nextFloat();
        }
        if( fmonto>PrecioProductos){
            System.out.print("Listo, su cambio es:");
            cambio= fmonto-PrecioProductos;
            System.out.print(cambio+"\n");
            
        }else{
        
        }
    }else{
        System.out.print("Listo, aqui tiene el numero de cuenta al cual debe de transferir 2300012354\n");
    }
    CrearFactura(Nombre, Apellido);
    verFactura();
    RegistroClientesCSV.crearArchivoCSV( "|",Nombre+"     ", Apellido+"       ", Cedula+ "       ", CantidadHelados+ "             ", PrecioProductos+ "             " );
    }
    public void CrearFactura(String Nombre, String Apellido){
     //Clientes clientes= new Clientes ("","","","","","","","","",1,"","","");
     try (BufferedWriter writer = new BufferedWriter(new FileWriter("Factura.txt" ))) {
            writer.write("             Factura N 0001\n");
            writer.write("\n");
            writer.write("Cliente: "+ Nombre + " "+ Apellido + "\n" );
            writer.write("Cedula: " + Cedula+"\n" );
            writer.write("-----------------------------------------------\n");
            writer.write("Cantidad|  Detalle   | Precio final \n");
            writer.write(CantidadHelados + "       | Helados    | $" + PrecioProductos + "\n");
            writer.write("\n-----------------------------------------------\n");
            System.out.println("Datos guardados en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    public class LeerFactura {
    public String leerTXT(String direccion){//direccion del archivo
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader (new FileReader ("Factura.txt"));
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
    public void verMenu(){
        System.out.print("\n**** Este archivo se imprime mediante txt ****");
        System.out.print("\n=======MENU========\n ");
        LeerMenu a = new LeerMenu();
        System.out.println(a.leerTXT( "MenuHelados.txt"));
    }
    public void verFactura(){
        System.out.print("\n**** Este archivo se imprime mediante txt ****");
        System.out.print("\n       =======FACTURA========\n ");
        LeerFactura b = new LeerFactura();
        System.out.println(b.leerTXT( "Factura.txt"));
    }
}
   
