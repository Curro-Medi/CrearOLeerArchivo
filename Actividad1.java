package Actividad_de_clase;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Actividad1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		double[] regisdecim = {0.0,1.5,3.0,4.5,5.2};
		
		File archivo = new File("C:/Users/Curro/Desktop/2º DAM/Acceso a datos/pruebas", "/ficheroAleatorio.dat");
		
		
		
		if (!archivo.exists()) {	//	!archivo.exists() si no existe el archivo

			try {
				
				RandomAccessFile flujo = new RandomAccessFile(archivo, "rw");
				
				for (double i: regisdecim) {
					
					flujo.writeDouble(i);
				}
				
			
			}catch(Exception e){
				
				e.printStackTrace();
			}
			
			
		}else {
			
			try {
				
			RandomAccessFile flujo = new RandomAccessFile(archivo, "r");
			
			
			do {
				
				System.out.println("Valor: " + flujo.readDouble());
				
			} while (flujo.getFilePointer()<flujo.length());
			
			System.out.println("Longitud del fichero: " + flujo.length() + " Bytes");
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
		//ejercicio 2 cambiar un registro
		
		double newValor = 3.14; //nuevo valor 
		
		try {
			
		RandomAccessFile flujo = new RandomAccessFile(archivo, "rw"); //leo
		
		long posicionPuntero = 24;	//el tamaño en bytes
		
		flujo.seek(posicionPuntero);	//cojo la posicion del puntero
		flujo.writeDouble(newValor);	//y escribo el nuevo valor
		
		flujo.close();					
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
