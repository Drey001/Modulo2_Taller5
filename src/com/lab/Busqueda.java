package com.lab;

import java.util.Arrays;

public class Busqueda {

	static Integer[] arreglo = { 2, 5, 9, 58, 36, 78, 84 };

	static Integer clave = 78;

	public int secuencial() {
		int resultado = -1;

		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] == clave) {
				resultado = i;
				break;
			}
		}

		return resultado;
	}
	
	/**
	 * Suponiendo que la lista est� almacenada como un array, los �ndices de la lista son: bajo = 0
		y alto = n-1 y n es el n�mero de elementos del array, los pasos a seguir:
		1. Calcular el �ndice del punto central del array central = (bajo + alto)/2 (divisi�n entera)
		2. Comparar el valor de este elemento central con la clave:
			a. Si a[central] < clave, la nueva sublista de b�squeda tiene por valores extremos de
			su rango bajo = central+1..alto.
			b. Si clave < a[central], la nueva sublista de b�squeda tiene por valores extremos de su
			rango bajo..central-1.
		El algoritmo se termina bien porque se ha encontrado la clave o porque el valor de bajo excede
		a alto y el algoritmo devuelve el indicador de fallo de -1 (b�squeda no encontrada).
	 * @return
	 */
	public int binaria() {
		int resultado = -1;
		int i,desde=0,hasta=0;
		Arrays.sort(arreglo);
		int central = (arreglo.length-1)/2;
		if(arreglo[central]==clave)
			resultado = arreglo[central];
		else if(clave<=arreglo[central]){
			desde = 0;
			hasta = central-1;
		}else{
			desde=central+1;
			hasta=(arreglo.length)-1;
		}
		if (resultado==-1){
			for (i=desde; i<=hasta; i++){
				if (arreglo[i]==clave){
					resultado = i;
					break;
				}
			}
		}
		return resultado;
	}

	public static void main(String[] args) {
		Busqueda busqueda = new Busqueda();
		
		int posicion = busqueda.binaria();
		
		if(posicion == -1) {
			System.out.println("Valor no encontrado");
		}else {
			System.out.println("El valor clave " + clave + " encontrado en posicion " + posicion );
		}
		
	}
}
