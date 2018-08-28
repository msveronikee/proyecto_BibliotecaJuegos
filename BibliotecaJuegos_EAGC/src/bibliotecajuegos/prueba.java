/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecajuegos;

/**
 *
 * @author Alumno
 */
public class prueba {

    String[][] tablero = new String[3][3];

    public void ganaMaquina() {

                if (tablero[0][0] + tablero[0][1] + tablero[0][2]== "OOO") {
                    System.out.println("GANA LA MÁQUINA");
                }else if  (tablero[1][0] + tablero[1][1] + tablero[1][2]== "OOO"){
                    System.out.println("GANA LA MÁQUINA");
                }else if (tablero[2][0] + tablero[2][1] + tablero[2][2]== "OOO"){
                    System.out.println("GANA LA MÁQUINA");
                }
    }

    public static void main(String[] args) {

    }

}
