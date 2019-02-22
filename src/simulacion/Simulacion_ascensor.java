/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Simulacion_ascensor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Para un hotel pequeño
        int pisos = 5;
        int cantidadMaximaPersonas = 10;
        int[] registroAbordos = new int[24];
        int[] registroSalidas = new int[24];
        Random random = new Random();
        Ascensor ascensor = new Ascensor(pisos, cantidadMaximaPersonas,1000);
        double[] distribucion = {
            0.0215,0.0176,0.0098,0.0117,0.0137,0.0176,0.0234, //De las 00:00 hasta las 06:00
            0.0449,0.0723,0.0684,0.0605,0.0527,0.0781,0.0449, // 07:00 a 13:00
            0.0352,0.0332,0.0391,0.0488,0.082,0.0723,0.0508, //14:00 a 20:00
            0.0391,0.0332,0.0293 //21:00 a 23:00
        };
        for (int hora = 0; hora<24;hora++){
            for(int segundo = 0; segundo<3600; segundo+=6){ //Se hace la suposición de que cada 6 segs se sube un piso
                registroSalidas[hora] += ascensor.avanzar();
                if(random.nextDouble()<=distribucion[hora]){
                    Persona persona = new Persona(random.nextInt(pisos),1); //Arrreglar lo del peso
                    if(ascensor.agregarPersona(persona)){
                        registroAbordos[hora]+=1;
                    }
                }
            }
            System.out.println("Personas que abordaron y salieron del ascensor, respectivamente, a las "+i+
                    " ["+registroAbordos[i]+", "+registroSalidas[i]+"]");
        }
    }

}
