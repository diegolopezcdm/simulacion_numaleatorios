package com.diego.proy.NumAleatorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		List<Float> lookUpTable = new ArrayList<Float>();
		Scanner scanner = new Scanner(System.in);
		
		int raiz;
		int a;
		int c;
		float m;
		
		System.out
				.println("///////////////////////////////////////////////////");
		System.out.println("GENERACION DE NUMEROS ALEATORIOS");
		System.out
				.println("///////////////////////////////////////////////////");
		System.out.println();
		
		System.out.print("Ingrese valor para la variable raiz : ");
	    raiz = scanner.nextInt();
	    System.out.print("Ingrese valor para la variable elemento multiplicativo : ");
	    a = scanner.nextInt();
	    System.out.print("Ingrese valor para la variable elemento aditivo : ");
	    c = scanner.nextInt();
	    System.out.print("Ingrese valor para la variable modulo : ");
	    m = scanner.nextInt();
		
		System.out.println();
		System.out.println("METODO CONGRUENCIAL");
		System.out.println();
		System.out.println("i\tXi\taXi+c\tmod\tri");
		System.out.println("-----------------------------------------");
		
		int index =0;
		
		while (true) {
			
			float raizOld = raiz;
			float mult = (raiz * a) + c;

			raiz = (int) (mult % m);
			float ri = ((raiz / m));

			if (lookUpTable.contains(ri)) {
				break;
			} else {
				lookUpTable.add(ri);
			}

			System.out.print(index + "\t" + raizOld + "\t" + mult + "\t" + raiz
					+ "\t" + ri + "\n");
			index++;
			
		}
		
		System.out.println("Longitud : " + lookUpTable.size());

		System.out.println();
		System.out
				.println("===================================================");
		System.out.println("PRUEBAS DE UNIFORMIDAD");
		System.out
				.println("===================================================");
		System.out.println("MEDIANTE PRUEBAS DE MEDIA");
		System.out
				.println("determinemos si el siguiente conjunto de números ri tiene valor esperado de 0,5 con un nivel de aceptación de 95%");

		float sum = 0;

		for (Float value : lookUpTable) {
			sum = sum + value;
		}
		int n = lookUpTable.size();
		float r = (sum / (lookUpTable.size()));
		r = (float) (Math.round(r * 10000.0) / 10000.0);
		float limiteSuperior = 0;
		float limiteInferior = 0;
		float alfa = (float) 0.05;
		alfa = alfa / 2;
		float z = 1 - alfa;
		alfa = (float) 1.96;
		boolean esAleatorio = false;
		String resultado;

		limiteInferior = (float) (0.5 - (alfa * (1 / (Math.sqrt(12 * n)))));
		// limiteInferior = (float) (Math.round (limiteInferior * 100000.0) /
		// 10000.0);
		limiteSuperior = (float) (0.5 + (alfa * (1 / (Math.sqrt(12 * n)))));
		// limiteSuperior = (float) (Math.round (limiteSuperior * 100000.0) /
		// 10000.0);

		if (r > limiteInferior && r < limiteSuperior) {
			esAleatorio = true;
			resultado = "Como " + r + " esta en el intervalo " + limiteInferior
					+ " y " + limiteSuperior
					+ ", entonces no se puede rechazar H0";
		} else {
			resultado = "Como " + r + " no esta en el intervalo "
					+ limiteInferior + " y " + limiteSuperior
					+ ", entonces se rechaza H0, y se aprueba H1";
		}

		System.out.println();
		System.out.println("n : " + n);
		System.out.println("Sum(ri)/n : " + r);
		System.out.println("Z(α/2) : " + z
				+ ", en la tabla normal su valor es : " + alfa);
		System.out.println("Limite inferior : " + limiteInferior);
		System.out.println("Limite superior : " + limiteSuperior);
		System.out.println("Resultado: " + resultado);

		if (!esAleatorio) {
			System.out.println("se aborta operacion ...");
			return;
		}

		System.out.println();
		System.out
				.println("===================================================");
		System.out.println("PRUEBAS DE ALEATORIEDAD");
		System.out
				.println("===================================================");
		System.out
				.println("determinemos si el siguiente conjunto de números ri tiene valor esperado de 0,5 con un nivel de aceptación de 95%");
		System.out.println();

		int c0 = 0;
		boolean mayorMediaFlag = false;
		float Uc0 = (2 * (n) - 1) / 3;
		float o2co = (16 * (n) - 19);
		o2co = o2co / 90;

		for (int i = 0; i < lookUpTable.size(); i++) {

			if (i == 0) {
				mayorMediaFlag = actualizarFlag(lookUpTable, i);
				imprimirFlag(mayorMediaFlag);
				c0++;
			} else if (i == lookUpTable.size()) {
				break;
			} else {

				if (lookUpTable.get(i) > 0.50 && mayorMediaFlag) {
					System.out.print(1);
				} else if (lookUpTable.get(i) < 0.50 && !mayorMediaFlag) {
					System.out.print(0);
				} else {
					mayorMediaFlag = actualizarFlag(lookUpTable, i);
					imprimirFlag(mayorMediaFlag);
					c0++;
				}

			}

		}

		float Z0 = (float) (c0 - Uc0);
		Z0 = (float) (Z0 / Math.sqrt(o2co));
		Z0 = (float) Math.abs(Z0);

		System.out.println();
		System.out.println();
		System.out.println("numero de rachas : " + c0);
		System.out.println("uC0 : " + Uc0);
		System.out.println("o2c0 : " + o2co);
		System.out.println("Z0 : " + Z0);
		System.out.println("Z(α/2) : " + z
				+ ", en la tabla normal su valor es : " + alfa);

		if (Z0 < alfa) {
			System.out
					.println("Z0 es menor que 1.96. No se puede rechazar, ya que los números del conjunto ri son independientes");
		} else {
			System.out
					.println("Z0 no es menor que 1.96. Se debe rechazar, ya que los números del conjunto ri no son independientes");
			return;
		}
		System.out.println();
		System.out
				.println("===================================================");
		System.out.println("CONCLUSIÓN");
		System.out
				.println("===================================================");
		System.out
				.println("Los números del conjunto ri pasaron la pruebas de aleatoriedad y uniformidad satisfactoriamente\nEntonces, podemos decir que tenemos un repositorio de números aleatorios");

		System.out.println();
		System.out.println();
		System.out.println("Developer: u201321275 Juan Diego Lopez Flores");
		System.out.println("Derechos Reservados - CopyRight");
	}

	private static void imprimirFlag(boolean mayorMediaFlag) {
		if (mayorMediaFlag) {
			System.out.print(1);
		} else {
			System.out.print(0);
		}
	}

	private static boolean actualizarFlag(List<Float> lookUpTable, int i) {
		boolean mayorMediaFlag;
		if (lookUpTable.get(i) > 0.50) {
			mayorMediaFlag = true;
		} else {
			mayorMediaFlag = false;
		}
		return mayorMediaFlag;
	}
}
