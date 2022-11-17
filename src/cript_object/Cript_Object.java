package cript_object;

public class Cript_Object {
	private String MensajeOriginal;
	private String mensajeEncriptado;
	private char array[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', '!', '?', '-', ',', '.', '_' };

	public Cript_Object() {
	}

	public Cript_Object(String mensajeOriginal) {
		this.MensajeOriginal = mensajeOriginal;
		mensajeEncriptado = mensajeOriginal;
	}

	public void encriptarCesar(int numero) {
		StringBuilder sb = new StringBuilder();
		char caracter = ' ';

		for (int i = 0; i < MensajeOriginal.length(); i++) {
			for (int x = 0; x < array.length; x++) {

				int posicio = numero + x;

				if (array[x] == MensajeOriginal.charAt(i)) {

					caracter = MensajeOriginal.charAt(i);

					if (posicio >= array.length) {

						posicio = posicio - array.length;

						caracter = array[posicio];

						sb.append(caracter);
					} else {
						caracter = array[numero + x];

						sb.append(caracter);
					}
				}
			}
		}

		mensajeEncriptado = sb.toString();
		System.out.println(mensajeEncriptado);

	}

	public void desencriptarCesar(int numero) {
		StringBuilder sb = new StringBuilder();
		char caracter = ' ';

		for (int i = 0; i < mensajeEncriptado.length(); i++) {
			for (int x = 0; x < array.length; x++) {
				int posicio = x - numero;

				if (array[x] == mensajeEncriptado.charAt(i)) {
					caracter = mensajeEncriptado.charAt(i);

					if (posicio <= 0) {
						posicio = array.length - Math.abs(posicio);
						caracter = array[posicio];
						sb.append(caracter);
					} else {
						caracter = array[x - numero];

						sb.append(caracter);
					}
				}
			}
		}
		mensajeEncriptado = sb.toString();
		System.out.println(mensajeEncriptado);

	}

	public void encriptarMonoalfabético(String palabra) {

		int numeroDivisor = 0;
		int numeroDividible = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < palabra.length(); i++) {
			int j;
			for (j = 0; j < i; j++)
				if (palabra.charAt(i) == palabra.charAt(j))
					break;

			if (j == i) {
				sb.append(palabra.charAt(i));
				numeroDivisor++;
			}

		}

		sb = sb.append(String.valueOf(array));
		for (int i = 0; i < array.length; i++) {
			int j;
			for (j = 0; j < i; j++)
				if (sb.charAt(i) == sb.charAt(j))
					break;
			if (j == i) {
				sb2.append(sb.charAt(i));
				numeroDividible++;
			}
		}

		System.out.println(sb2.toString());

		int numeroX = numeroDividible / numeroDivisor;

		System.out.println(numeroDivisor);

		System.out.println(array.length);
		char matriz[][] = new char[numeroX][numeroDivisor];
		int deu = 0;
		int recorrerAlfabeto = 0;
		int resta = 0;
		for (int n = 0; n < numeroX; n++) {
			for (int b = 0; b < numeroDivisor; b++) {
				deu = b * n;
				matriz[n][b] = sb2.charAt(recorrerAlfabeto);

				recorrerAlfabeto++;

			}

		}

		for (int n = 0; n < numeroX; n++) {
			for (int b = 0; b < numeroDivisor; b++) {
				System.out.println(matriz[n][b]);
			}
		}

	}
	
	
	
	
	public void desencriptarMonoalfabético(String palabra) {

	}
}
