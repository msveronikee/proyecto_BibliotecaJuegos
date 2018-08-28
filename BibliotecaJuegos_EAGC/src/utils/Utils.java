package utils;

import java.util.Random;
import java.util.Scanner;


public class Utils {
    static Random numerosAleatorios = new Random();

    /*
    *   Shortcut para el método System.out.print   ->   print
    *   Imprime texto y deja cursor en la misma línea
    */
    static void print(Object texto) {
        System.out.print(texto);
    }

    /*
    *   Shortcut para el método System.out.println   ->   print
    *   Imprime texto y un salto de línea
    */
    static void println(Object texto) {
        System.out.println(texto);
    }

    /*
    *   Solicitamos la entrada de un número al usuario
    *   Si ingresa otra cosa que no sea un número, le pedimos que lo reingrese
    *
    *   @return el numero ingresado por el usuario
    */
    
    //Sin el modificador public no trasciende paquetes
    //Para explicar los miembros de clase sin modificador
    public static int leerNumero() {
        boolean wenttocatch = false;
        
        //Objeto Scanner para leer la entrada del usuario
        Scanner scan = new Scanner(System.in);
        int numero = 0;
        do{
            System.out.print("Ingresa un número: ");
            if(scan.hasNextInt()){
                numero = scan.nextInt();
                wenttocatch = true;
            } else {
                scan.nextLine();
                System.out.println("Ingresa un número válido");
            }
        } while(!wenttocatch);
        
        return numero;
    }
    
    /*
    *   Solicitamos la entrada de un número al usuario
    *   Si ingresa otra cosa que no sea un número, le pedimos que lo reingrese
    *
    *   @return el numero ingresado por el usuario
    */
    
    //Sin el modificador public no trasciende paquetes
    //Para explicar los miembros de clase sin modificador
    public static double leerDecimal() {
        boolean wenttocatch = false;
        
        //Objeto Scanner para leer la entrada del usuario
        Scanner scan = new Scanner(System.in);
        double numero = 0;
        do{
            System.out.print("Ingresa un número: ");
            if(scan.hasNextDouble()){
                numero = scan.nextDouble();
                wenttocatch = true;
            } else {
                scan.nextLine();
                System.out.println("Ingresa un número válido");
            }
        } while(!wenttocatch);
        
        return numero;
    }

    /*
    *   Solicitamos la entrada de un número al usuario
    *   Si ingresa otra cosa que no sea un número, le pedimos que lo reingrese
    *
    *   @return el numero ingresado por el usuario
    */
    static String leerCadena(String mensaje) {
        boolean wenttocatch = false;

        //Objeto Scanner para leer la entrada del usuario
        Scanner scan = new Scanner(System.in);
        String texto = "";
        do{
            System.out.print(mensaje);
            if(scan.hasNext()){
                texto = scan.next();
                wenttocatch = true;
            } else {
                scan.nextLine();
                System.out.println("Valor inválido");
            }
        } while(!wenttocatch);

        return texto;
    }

    /*
    * Mètodo para generar un nùmero aleatorio entre un nùmero y otro
    * de forma inclusiva
    */
    public static int generarAleatorio(int menor, int mayor) {
        if (menor >= mayor) {
            return menor;
        }

        //nextInt devuelve un valor entre menor y el mayor inclusivos
        mayor++;
        return numerosAleatorios.nextInt(mayor - menor) + menor;
    }
}
