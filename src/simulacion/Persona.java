/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

/**
 *
 * @author Usuario
 */
public class Persona {
    private final int pisoDestino;
    private final double peso;
    private final double pesoPromedioRegion = 67.9;

    public Persona(int pisoDestino, double peso) {
        this.pisoDestino = pisoDestino;
        this.peso = Math.abs(peso*pesoPromedioRegion);
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public double getPeso() {
        return peso;
    }
    
    
}
