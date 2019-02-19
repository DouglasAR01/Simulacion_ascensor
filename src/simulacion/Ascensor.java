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
import java.util.ArrayList;
public class Ascensor {

    private final int pisos;
    private final int cantidadMaximaPersonas;
    private final int pesoMaximo;
    private ArrayList<Persona> personas; //Tiene que ser un arraylist
    private double pesoActual;
    private boolean subiendo;
    private int pisoActual;

    public Ascensor(int pisos, int cantMPersonas, int pesoMax){
        this.pisos = pisos;
        this.cantidadMaximaPersonas = cantMPersonas;
        this.pesoMaximo = pesoMax;
        this.subiendo = true;
        this.pisoActual = 0;
        this.personas = new ArrayList();
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

    public boolean agregarPersona(Persona persona){
        if(personas.size()<cantidadMaximaPersonas){
            personas.add(persona);
            return true;
        }
        return false;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public boolean getSubiendo() {
        return subiendo;
    }

    public void setSubiendo(boolean subiendo) {
        this.subiendo = subiendo;
    }
    
    public int bajarPasajeros(){
        if(personas.size()>0){
            int contador = 0;
            for (int i = 0; i<personas.size(); i++){
                if(personas.get(i).getPisoDestino()==pisoActual){
                    contador++;
                    personas.remove(i);
                }
            }
            return contador;
        }
        return 0;
    }

    public int avanzar(){
        if (pisoActual<pisos && subiendo==true){
          pisoActual+=1;
        }else{
          subiendo = false;
          if (pisoActual>0 && subiendo == false) {
              pisoActual-=1;
          }else{
            subiendo = true;
          }
        }
        return this.bajarPasajeros();
    }
}
