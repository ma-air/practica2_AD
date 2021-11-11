package practica2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirArchivo {

	public void escribir(File archivo, String datos) throws IOException {

		try {

			FileWriter fr = new FileWriter(archivo, true);

			fr.write(datos);
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
	}

	public String leerArchivo(File archivo) throws IOException {
		String frase = "";
		try {
			FileReader leer = new FileReader(archivo);
			int letra;
			while ((letra = leer.read()) != -1) {
				frase = frase + (char) letra;

			}
			leer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return frase;
	}

	public int Sumar(File archivo) throws IOException {
		String frase = "";
		int total = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			while ((frase = br.readLine()) != null) {
				total = total + Integer.parseInt(frase);

			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return total;
	}

	public String formatear(String[] correo) {
		String formato = "Destinatario:\t" + correo[0] + "\n\nAsunto:\t" + correo[1] + "\n\nCorreo:\n" + correo[2];
		return formato;
	}

	public String leerNumeroUsuarios(File archivo, int cantidadUsuarios) throws IOException {
		String resultado = "";
		cantidadUsuarios = cantidadUsuarios * 6;
		int contador = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			while (contador < cantidadUsuarios) {
				resultado = resultado + br.readLine() + "\n";
				contador++;
				if (contador % 6 == 0)
					resultado = resultado + "\n\n";

			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public String usuarioConcreto(File archivo, String DNI) throws IOException {
		String user = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			boolean encontrado = false;
			while (!encontrado) {
				
				String frase = br.readLine();
				String frase1 = frase;
				if (frase != null && frase.length() > 0) {
					frase1.replace(" ", "");
					String partes[] = frase1.split(":");
				

					if (partes[1].equals("\t"+DNI)) {
						
					

						int contador = 0;
						user = frase1;
						while (contador < 5) {
							user = user + "\n" + br.readLine();
							contador++;
						}
						encontrado = true;
						br.close();
					}
				}

			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return user;

	}

}
