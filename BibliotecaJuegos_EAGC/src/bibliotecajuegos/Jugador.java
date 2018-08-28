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
public class Jugador {
    String nombre; 
    double saldoDisponible; 

    public Jugador(String nombre, double saldoDisponible) {
        this.nombre = nombre;
        this.saldoDisponible = saldoDisponible;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldoDisponible() {
        return this.saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public void reducirSaldo(double monto){
        this.saldoDisponible -= monto; 
    }
    
    
  public void  aumentarSaldo(double monto){
      
    this.saldoDisponible += monto;
    }

    
    
}
