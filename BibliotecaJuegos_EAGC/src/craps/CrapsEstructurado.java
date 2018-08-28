package craps;

//Importamos una Clase que nos permite utilizar métodos para generar números aleatorios
import java.util.Random;

/**
 * Definimos la CLASE que demuestra la forma de jugar CRAPS
 * 
 * class es una palabra reservada para definir una CLASE
 * CrapsEstructurado es el nombre que nosotros le damos a la CLASE
 *
 */
class CrapsEstructurado {

    //Definimos una variable de tipo de dato String (Cadena de caracteres) que como valor va a tener las reglas del juego
    static String reglas = "Un jugador tira dos dados. Cada dado tiene 6 caras con un rango de valores de 1 a 6.\n"
                  + "Una vez que los dados dejan de moverse, se calcula la suma de los dados.\n"
                  + "Si la suma es 7 u 11 en el primer tiro el jugador gana. Si la suma es 2, 3 o 12 en el primer tiro, el jugador pierde.\n"
                  + "Si la suma de los dados es diferente a (7, 11, 2, 3 o 12), esta suma se convierte en el \"punto\" del jugador.\n"
                  + "para ganar, el jugador debe seguir tirando los dados hasta obtener de nuevo su \"punto\". "
                  + "El jugador pierde si obtiene un 7 antes de obtener su punto.";
    
    //Definimos una variable llamada 'nombre' de tipo de dato String y la inicializamos con el nombre del Juego 'CRAPS'
    static String nombre = "CRAPS";

    //Definimos el método main (es el primero que va a ejecutar nuestro programa)
    //Aqui va a empezar el programa y aqui va a acabar
    public static void main(String[] args) {
        //print es un método que definimos para imprimir cosas en la consola o pantalla
        //Imprimimos un mensaje de Bienvenida y otro donde indicamos que explicaremos las reglas
        //Después imprimimos las reglas del juego que definimos arriba en la variable 'reglas'
        print("\n\t\t\t\t\tBienvenido a CRAPS\n");  // \t Es un tabulador (Aporx. el equivalente a 4 espacios)
        print("\nTe explicaré las reglas:\n");      // \n Es un salto de línea
        print(reglas);

        //Mandamos a llamar la ejecución del método jugar que definimos más abajo
        jugar();
        
        //Aqui termina nuestro programa
    }

    /**
     * Aqui definimos el método jugar()
     * Implementación del método jugar para la Clase Craps
     */
    public static void jugar() {
        
        //Definimos una variable llamada miPunto, sirve para guardar la suma de los dados cuando no cae 7, 11, 2, 3 ni 12 en el PRIMER tiro
        int miPunto = 0;
        
        //Definimos una variable booleana (true o false) que sirve para saber si el juego ya acabo o tenemos que seguir tirando dados
        boolean juegoAcabo;
        
        //Declaramos una variable llamada 'sumaDeDados' en la cual guardamos el valor que nos devuelve el método tirarDados()
        int sumaDeDados = tirarDados();
        
        //Este switch, solo es para evaluar el PRIMER LANZAMIENTO DE LOS DADOS
        //Hacemos un switch (Podríamos haberlo hecho con if-else) para evaluar si en el PRIMER tiro ganamos o perdimos
        switch(sumaDeDados) {
            case 7:
            case 11:
                //Si la suma de los dados cayó 7 u 11
                //Imprimimos en pantalla que el jugador ha ganado
                //Ponemos la variable de juegoAcabo en true, porque ya sabemos el resultado del juego
                //Y ponemos break, para que no evalue los demás casos
                print("Usted ha ganado");
                juegoAcabo = true;
                break;
            case 2:
            case 3:
            case 12:
                //Si la suma de los dados cayó 2, 3 o 12
                //Imprimimos en pantalla que el jugador ha perdido
                //Ponemos la variable de juegoAcabo en true, porque ya sabemos el resultado del juego
                //Y ponemos break, para que no evalue los demás casos
                print("Usted ha perdido");
                juegoAcabo = true;
                break;
            default:
                //Si no cayó 7, 11, 2, 3 ni 12
                //Entonces el juego aún no acaba
                //Guardamos el "tiro" (la suma de los dados) en una variable 'miPunto' para poderla comparar después
                //Ponemos la variable en false para indicar que el juego aún no acaba
                //Aqui el break es opcional, porque es el último CASO
                miPunto = sumaDeDados;
                print("El punto del jugador es: " + miPunto);
                juegoAcabo = false;
                break;
        }

        //Tenemos que seguir tirando los dados MIENTRAS no salga 7 o miPunto
        //En este caso, MIENTRAS el juego no haya acabado
        while (juegoAcabo == false) {
            //Volvemos a tirar los dados
            sumaDeDados = tirarDados();
            
            if (sumaDeDados == miPunto) {
                //Si la suma del nuevo lanzamiento de dados da como valor el punto del jugador en su primer tiro
                //Entonces gana
                print("Usted ha ganado");
                
                //Debemos indicar al programa que el juego ya termino para que pueda salir del while
                juegoAcabo = true;
            } else if (sumaDeDados == 7) {
                //Si la suma del nuevo lanzamiento de dados da como valor 7
                //Entonces pierde
                print("Usted ha perdido");
                
                //Debemos indicar al programa que el juego ya termino para que pueda salir del while
                juegoAcabo = true;
            }
        }
        
        //Aqui termina el método jugar, porque ya sabemos el resultado final
    }

    /**
     * Realiza la simulación del lanzamiento de dos dados, devolviendo la suma de dos valores aleatorios entre 1 y 6
     * 
     * @return La suma de los dos tiros de los dados, un valor entre 2 y 12
     */
    static public int tirarDados() {
        //Random es una Clase con métodos que nos permite generar numeros aleatorios
        Random numerosAleatorios = new Random();
        
        //el método nextInt de la Clase Random genera un número aleatorio entre 0 y el (valor - 1) que recibe como argumento
        //Es decir, nextInt(6) genera un valor aleatorio entre 0 y 5
        //Devuelve un numero entre 0 y 5, le sumamos 1 para que sea el rango de valores validos en un dado, es decir entre 1 y 6
        int dado1 = numerosAleatorios.nextInt(6) + 1;
        int dado2 = numerosAleatorios.nextInt(6) + 1;
        
        //Mostramos un mensaje en pantalla indicando que cayó en cada "dado lanzado" y la suma de estos
        print("El jugador tiró: " + dado1 + " + " + dado2 + " = " + (dado1 + dado2));
        
        //Regresamos la suma de los números (dados) generados aleatoriamente
        return (dado1 + dado2);
    }
    
    /*
    * Este método solo sirve para acortar la forma en que tenemos que imprimir mensajes en la pantalla
    * Recibe el texto que queremos imprimir y lo muestra
    */
    static public void print(String texto) {
        //La CLASE System tiene un OBJETO out que se encarga de hacer operaciones de salida
        //El OBJETO out tiene un método 'println' que se encarga de mostrar datos en la consola o pantalla del usuario.
        System.out.println(texto);
    }
}
