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
public class Ascensor {
    
    private final int pisos;
    private final int cantidadMaximaPersonas;
    private final int pesoMaximo;
    private final Persona[] personas;
    private double pesoActual;
    
    public Ascensor(int pisos, int cantMPersonas, int pesoMax){
        this.pisos = pisos;
        this.cantidadMaximaPersonas = cantMPersonas;
        this.pesoMaximo = pesoMax;
        this.personas = new Persona[cantidadMaximaPersonas];
    }

    public int getPisos() {
        return pisos;
    }

    public int getCantidadMaximaPersonas() {
        return cantidadMaximaPersonas;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public Persona[] getPersonas() {
        return personas;
    }
    
    public void agregarPersona(Persona persona){
        
    }
    
    public void eliminarPersona(){
        
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }
}
