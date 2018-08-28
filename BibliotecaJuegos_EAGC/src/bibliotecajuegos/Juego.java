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
public class Juego {
    
    String nombre;
    String reglas;
    int estadoPartida; 
    
    public static final int PARTIDA_GANADA =1; 
    public static final int PARTIDA_PERDIDA = -1;
    public static final int PARTIDA_EN_CURSO =0; 
    

    public Juego(String nombre, String reglas) {
        this.nombre = nombre;
        this.reglas = reglas;
        this.estadoPartida = estadoPartida;
    }

    public Juego(String nombre, int estadoPartida) {
        this.nombre = nombre;
        this.estadoPartida = estadoPartida;
    }
    
    public void jugar(){
        
    }
    
    public void mostrarReglas(){
        System.out.println(this.reglas);
    }

    public static void main(String[] args){
 
}
}

