package practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("\n0. SALIR \n" + "1. Practica 1 \n" + "2. Practica 2 \n" + "3. Practica 3 \n"
				+ "4. Practica 4 \n" + "******ELIGE EL NUMERO DE LA PRACTICA******: ");
		Scanner sc = new Scanner(System.in);
		String ruta = "src/";
		String nombreArchivo = "Datos.txt";
		File archivo = new File(ruta, nombreArchivo);
		EscribirArchivo escribir = new EscribirArchivo();
		int eleccion = sc.nextInt();

		if (eleccion == 1) {

			System.out.println("Ver user (1) o añadir(2)");
			int numer = sc.nextInt();
			if (numer == 1) {
				System.out.println("Deseas ver todos los usuarios(1), los N primeros (2) o uno en concreto (3)");
				numer = sc.nextInt();
				if (numer == 1)
					System.out.println(escribir.leerArchivo(archivo));
				else if (numer == 2) {
					System.out.println("Cuantos usuarios quieres ver?");
					int usuarios = sc.nextInt();
					System.out.println(escribir.leerNumeroUsuarios(archivo, usuarios));

				}
				else if (numer ==3) {
					System.out.println("Introduce el DNI ");
					String queDNI = sc.next();
					System.out.println(escribir.usuarioConcreto(archivo, queDNI));
				}
				
			} else {
				System.out.println("Escriba DNI, nombre, apellidos, nacimiento y telefono ");
				String DNI = sc.next();
				String nombre = sc.next();
				sc.nextLine();
				String apellidos = sc.nextLine();
				String nacimiento = sc.next();
				String telefono = sc.next();

				String formateado = "DNI:\t" + DNI + "\nNombre:\t" + nombre + "\nApellidos:\t" + apellidos
						+ "\nFecha Nacimiento:\t" + nacimiento + "\nTelefono:\t" + telefono + "\n\n";

				try {
					escribir.escribir(archivo, formateado);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else if (eleccion == 2) {
			String nombre = "Numeros.txt";
			archivo = new File(ruta, nombre);
			System.out.println("Introduce numeros, utiliza el 0 para cancelar");
			int poklonskaya = 1;

			while (poklonskaya != 0) {
				poklonskaya = sc.nextInt();
				String num = poklonskaya + "\n";
				escribir.escribir(archivo, num);
			}
			System.out.println("Numeros!!\n" + escribir.leerArchivo(archivo) + "\n___________");

			System.out.println("Suma: " + escribir.Sumar(archivo));
			archivo.delete();
		}

		else if (eleccion == 3) {
			String[] correo = new String[3];
			System.out.println("Introduce el Destinatario");
			correo[0] = sc.next();
			System.out.println("Introduce el asunto");
			sc.nextLine();
			correo[1] = sc.nextLine();
			System.out.println("Introduce el cuerpo del correo");
			correo[2] = sc.nextLine();

			String formato = escribir.formatear(correo);
			archivo = new File(ruta, "Correo.txt");
			escribir.escribir(archivo, formato);

		}
	}

}
