package com.diego.proy.NumAleatorios;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	List<Float> lookUpTable = new ArrayList<Float>(); 
    	
    	int raiz=6;
        int a=6;
        int c=6;
        float m=5;     
        System.out.println("GENERACION DE NUMEROS ALEATORIOS");
        System.out.println("METODO CONGRUENCIAL");
        System.out.println();
        System.out.println("i\tXi\taXi+c\tmod\tri");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < 10; i++) {
        	float raizOld=raiz;
        	float mult = (raiz *a)+c;
        	
			raiz = (int) (mult%m);
			float ri =((raiz/m));
			
			if(lookUpTable.contains(ri)){
				break;
			} else {
				lookUpTable.add(ri);	
			}
			
			System.out.print(i+"\t"+raizOld+"\t"+mult+"\t"+raiz+"\t"+ri+"\n");
		}
        System.out.println("Longitud : " + lookUpTable.size());
        
        System.out.println();        
        System.out.println("===================================================");
        System.out.println("PRUEBAS DE ALEATORIEDAD");
        System.out.println("MEDIANTE PRUEBAS DE MEDIA");
        System.out.println("determinemos si el siguiente conjunto de números ri tiene valor esperado de 0,5 con un nivel de aceptación de 95%");
        
        float sum=0;
        
        for (Float value : lookUpTable) {
        	sum=sum+value;
		}
        int n = lookUpTable.size();
        float r = (sum/(lookUpTable.size()));
        r=(float) (Math.round (r * 10000.0) / 10000.0);
        float limiteSuperior=0;
        float limiteInferior=0;
        float alfa=(float)0.05;
        alfa = alfa/2;
        float z = 1- alfa;
        alfa = (float)1.96;
        boolean esAleatorio=false;
        String resultado;
        
        limiteInferior = (float) (0.5-(alfa*(1/(Math.sqrt(12*n)))));
        //limiteInferior = (float) (Math.round (limiteInferior * 100000.0) / 10000.0);
        limiteSuperior = (float) (0.5+(alfa*(1/(Math.sqrt(12*n)))));
        //limiteSuperior = (float) (Math.round (limiteSuperior * 100000.0) / 10000.0);
        
        if(r>limiteInferior && r<limiteSuperior){
        	esAleatorio=true;
        	resultado="Aprobado";
        } else {
        	resultado="Rechazado";
		}
        
        System.out.println();
        System.out.println("n : "+n);
        System.out.println("Sum(ri)/n : "+r);
        System.out.println("Z(α/2) : "+z+", en la tabla normal su valor es : " + alfa);
        System.out.println("Limite inferior : "+limiteInferior);
        System.out.println("Limite superior : "+limiteSuperior);
        System.out.println("Resultado: " + resultado);
        
        if(!esAleatorio){
        	System.out.println("se aborta operacion ...");
        	return;
        }
        
        System.out.println();
        System.out.println("===================================================");
        System.out.println("PRUEBAS DE UNIFORMIDAD");
        
        System.out.println();
        System.out.println();
        System.out.println("Developer: u201321275 Juan Diego Lopez Flores");
        System.out.println("Derechos Reservados - CopyRight");
    }
}
