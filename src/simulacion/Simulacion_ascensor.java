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
        /**
         * PARÁMETROS DE CONFIGURACIÓN
         * La escala es el número estimado máximo de personas que se esperaría 
         * esperen fuera del ascensor en cada piso. Dom [1, inf)
         * Valores recomendados:
         * 1. Edificio: 1 a 3.
         * 2. Hotel: 5 hasta 10.
         * 3. Centro comercial pequeño: 11 a 15.
         * 4. Centro comercial grande: 20 a 30.
         * Más de 30 no sería muy realista.
         */        
        int escala = 20;
        int pisos = 5;
        int cantidadMaximaPersonas = 10;
        int pesoMaximo = 500; //En KG
        
        int[] registroAbordos = new int[24];
        int[] registroSalidas = new int[24];
        Random random = new Random();
        Ascensor ascensor = new Ascensor(pisos, cantidadMaximaPersonas,pesoMaximo);
        
        /**
         * INICIO DE LA SIMULACIÓN
         */
        for (int hora = 0; hora<24;hora++){
            for(int segundo = 0; segundo<3600; segundo+=6){ //Se hace la suposición de que cada 6 segs se sube un piso
                registroSalidas[hora] += ascensor.avanzar();
                int cant = Simulacion_ascensor.generarPersonas(hora, escala, random);
                for(int cPersonas = 0; cPersonas<cant;cPersonas++){
                    Persona persona = new Persona(random.nextInt(pisos),random.nextGaussian());
                    if(ascensor.agregarPersona(persona)){
                        registroAbordos[hora]+=1;
                    }else{
                        System.out.println("Ascensor lleno a las "+hora+":"+(segundo/60));
                        System.out.println("Peso total: "+ascensor.getPesoActual());
                        System.out.println("Peso con la nueva persona abordo: "+(ascensor.getPesoActual()+persona.getPeso()));
                        break;
                    }
                }
            }
            /**
             * Resultados de la simulación.
             */
            System.out.println("Personas que abordaron y salieron del ascensor, respectivamente, a las "+hora+
                    " ["+registroAbordos[hora]+", "+registroSalidas[hora]+"]");
        }
    }
    
    /**
     * Función que genera el número de personas basada en una distribución dada una escala
     * @param hora
     * @param escala
     * @param random
     * @return personas : Cantidad de personas que ingresarán al ascensor.
     */
    private static int generarPersonas(int hora,int escala, Random random){
        final double[] distribucion = {
            0.0215,0.0176,0.0098,0.0117,0.0137,0.0176,0.0234, //De las 00:00 hasta las 06:00
            0.0449,0.0723,0.0684,0.0605,0.0527,0.0781,0.0449, // 07:00 a 13:00
            0.0352,0.0332,0.0391,0.0488,0.082,0.0723,0.0508, //14:00 a 20:00
            0.0391,0.0332,0.0293 //21:00 a 23:00
        };
        int aux = random.nextInt(escala-1)+1;
        int cant = (int)Math.sqrt(random.nextInt(aux)*random.nextInt(aux))+1;
        int personas = 0;
        for (int i=0; i<cant; i++){
            if(random.nextDouble()<distribucion[hora]){
                personas++;
            }
        }
        return personas;
    }
}
