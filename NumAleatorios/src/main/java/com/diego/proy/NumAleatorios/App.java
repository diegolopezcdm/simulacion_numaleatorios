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
    	
    	List<Integer> lookUpTable = new ArrayList<Integer>(); 
    	
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
			
			if(lookUpTable.contains(raiz)){
				break;
			} else {
				lookUpTable.add(raiz);	
			}
			
			System.out.print(i+"\t"+raizOld+"\t"+mult+"\t"+raiz+"\t"+ri+"\n");
		}
        System.out.println("Longitud : " + lookUpTable.size());
        System.out.println();
        System.out.println("Developer: u201321275 Juan Diego Lopez Flores");
        System.out.println("Derechos Reservados - CopyRight");
    }
}
