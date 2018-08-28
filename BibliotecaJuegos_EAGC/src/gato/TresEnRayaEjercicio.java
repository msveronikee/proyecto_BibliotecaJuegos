/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

/**
 *
 * @author Alumno
 */
//Clases de utilidad
import bibliotecajuegos.Juego;
import utils.Utils;

/*
 *               o|_|X
 *               _|x|_
 *               x| |o
 * ImplementaciÃ³n de la clase TresEnRaya
 * Simula una partida del clÃ¡sico juego "Gato"
 * Donde el jugador jugarÃ¡ con la ficha 'X' y la computadora con la ficha 'O'
 * 
 */
public class TresEnRayaEjercicio extends Juego {

    static final int CARA = 0;
    static final int CRUZ = 1;

    static final String FICHA_J = "X";              //Ficha del jugador
    static final String FICHA_AI = "O";             //Ficha de la computadora

    static final int TURNO_J = 0;                   //Turno del jugador sera con 0
    static final int TURNO_AI = 1;                  //Turno de la computadora sera con 1

    String[][] tablero;                             //Espacios en el juego
    int turno;                                      //Quien va primero
    int contadorCasillas;                           //Cuenta cuantas casillas estan ocupadas en el arreglo

    /*
     * Constructor de la clase TresEnRaya
     * Inicializa el tablero y asigna los atributos de instancia
     */
    public TresEnRayaEjercicio(String nombre, String reglas) {
        super(nombre, reglas);                      //Asignamos los atributos
        //en la superclase
        this.tablero = new String[3][3];            //Inicializamos el tablero
    }

    /*
     * ImplementaciÃ³n del mÃ©todo jugar para TresEnRaya
     * Al final modifica el estado del atributo estadoPartida
     */
    @Override
    public void jugar() {
        //Pre-llenamos el arreglo con _ para que no se vea todo junto
        llenarTablero();
        imprimirTablero();

        //decidimos quien empieza
        System.out.print("Â¿Cara (" + CARA + ") o Cruz (" + CRUZ + ")?: ");
        int eleccionMoneda = Utils.leerNumero();

        //   0  o  1    ==   0 o 1
        turno = (eleccionMoneda == lanzarMoneda()) ? TURNO_J : TURNO_AI;

        while (contadorCasillas < 9 && estadoPartida == PARTIDA_EN_CURSO) {
            //Si empieza jugador
            if (turno == TURNO_J) {
                colocarFichaJugador();
            } else {
                colocarFichaMaquina();
            }

            //Aumentamos 1 al contador de casillas ocupadas e imprimimos el tablero
            contadorCasillas++;
            imprimirTablero();

            //Verificamos si en el ultimo tiro hubo ganador
            if (hayGanador()) {
                //Devolvemos al ganador de la partida
                //1 si gano el jugador, -1 si gano la computadora
                estadoPartida = (turno == TURNO_J) ? PARTIDA_GANADA : PARTIDA_PERDIDA;
                break;
            }

            //Verificamos que queden casillas disponibles
            System.out.println("\n");
            if (contadorCasillas >= 9) {
                //Ya no se puede tirar
                break;
            }

            //Cambiamos de jugador
            if (turno == TURNO_J) {
                turno = TURNO_AI;
            } else {
                turno = TURNO_J;
            }
        }
    }

    /*
     * Getter para obtener el valor del atributo tablero de la clase TresEnRaya
     */
    public String[][] getTablero() {
        return this.tablero;
    }

    /*
     * Procedimiento para preparar el tablero llenando todas las posicione con u
     * simbolo _
     */
    //Ejrcicio, llenar los elementos del arreglo con puros simbolos de guion bajo
    public void llenarTablero() {

    }

    /*
     * Procedimiento para imprimir todos los valores actuales del tablero
     * Imprime los tiros del jugador como de la mÃ¡quina
     */
    //Ejercicio, mostrar todos los valores del arreglo en forma de cuadricula (Como el juego de Gato)
    public void imprimirTablero() {
        //tablero.length cuenta el nÃºmero de filas que tuiene el arreglo
        //tablero[N].length cuenta el nÃºmero de columnas en la fila N

    }

    public int lanzarMoneda() {
        //Cara es 0, cruz es 1
        //Devolvemos un valor entre 0 y 1
        int moneda = Utils.generarAleatorio(0, 1);

        //Informamos al usuario que lado de la "moneda" cayÃ³
        if (moneda == CARA) {
            System.out.println("CayÃ³ Cara");
        } else {
            System.out.println("CayÃ² Cruz");
        }

        return moneda;
    }

    public void colocarFichaJugador() {

        boolean estaOcupada = true;
        int fila = 0;
        int columna = 0;

        while (estaOcupada) {

            System.out.print("Seleccione la fila donde desea tirar: ");
            fila = Utils.leerNumero();
            System.out.print("Seleccione la columna donde desea tirar: ");
            columna = Utils.leerNumero();

            //Validamos que se elija una casilla vÃ¡lida para el arreglo
            if ((fila < tablero.length || columna < tablero[0].length)
                    || (fila >= 0 || columna >= 0)) {
                //Se valida que no este tirando en una casilla ocupada
                if (!tablero[fila][columna].equals("_")) {
                    System.out.println("Esa casilla ya estÃ¡ ocupada");
                    continue;
                }
            } else {
                System.out.println("No existe Esa casilla");
                continue;
            }

            estaOcupada = false;
        }

        tablero[fila][columna] = "X";
    }

    public void colocarFichaMaquina() {
        boolean estaOcupada = true;
        int fila = 0;
        int columna = 0;

        while (estaOcupada) {
            //Devuelve un numero entre 0 y la longitud de la fila/columna
            //Se asume que el arreglo bidimensional esta declarado y lleno
            fila = Utils.generarAleatorio(0, tablero.length - 1);
            columna = Utils.generarAleatorio(0, tablero[0].length - 1);

            if (tablero[fila][columna] != "_") {
                //Esa casilla ya estÃ¡ ocupada
                continue;
            }

            estaOcupada = false;
        }
        tablero[fila][columna] = "O";
    }

    /*
     *   MÃ¨todo para revisar si despuÃ©s del tiro existe un ganador de la partida
     *   Se comprueban filas, columnas y diagonales iguales
     *
     *   Por ejemplo: Si el tablero en las posiciones [0][0]  -  [0][1]  y  [0][2]
     *   que representa las 3 primeras columnas de la primera fila del arreglo
     *   son iguales, es decir (las 3 posiciones son 'X' o las 3 son 'O') entonces
     *   el jugador que acaba de tirar ha ganado
     */
    //EJERCICIO EN CLASE
    //USO DE IF CON ANDS o EQUALS CON CONCATENACIÃ“N DE CADENAS
    public boolean hayGanador() {
        final String GANA_X = FICHA_J + FICHA_J + FICHA_J;   //Aux "XXX" para comparar fila/columa/diagonal ganadora para Jugador

        final String GANA_O = "OOO";                         //Aux "OOO" para comparar fila/columa/diagonal ganadora para computadora

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] + tablero[j][i] == "OO") {

                }

            }

            String fila, columna, diagonal;
            boolean hayGanador = false;

            return hayGanador;
        }
    
}
