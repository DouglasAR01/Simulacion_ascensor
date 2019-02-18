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
    private Persona[] personas; //Tiene que ser un arraylist
    private int personasMontadas;
    private double pesoActual;
    private boolean subiendo;
    private int pisoActual;

    public Ascensor(int pisos, int cantMPersonas, int pesoMax){
        this.pisos = pisos;
        this.cantidadMaximaPersonas = cantMPersonas;
        this.pesoMaximo = pesoMax;
        this.personas = new Persona[cantidadMaximaPersonas];
        this.subiendo = true;
        this.pisoActual = 0;
        this.personasMontadas = 0;
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

    public boolean agregarPersona(Persona persona){
        if (personasMontadas<cantidadMaximaPersonas) {
            personasMontadas+=1;
            //ARREGLAR
        }
    }

    public void eliminarPersona(){

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
        return pesoActual;
    }

    public void setSubiendo(boolean subiendo) {
        this.subiendo = subiendo;
    }

    public void avanzar(){
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
        this.bajarPasajeros();
    }
}
