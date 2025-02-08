package Sessió_2;

public class Poblacio {

	private String nom;
	private Ubicacio[][] magatzem;
	private int[] comptador;

	public Poblacio(int Maxim, String nomPoblacio) {
		magatzem = new Ubicacio[26][Maxim];
		this.nom = nomPoblacio;
		comptador = new int[26];
		for(int i = 0; i<26; i++) {
			comptador[i] = 0;
		}
	}



	public String getNom() {return this.nom;}

	public int getQuants(char inici) { 
		int contador = 0;
		char upperInici = Character.toUpperCase(inici); 
		int idx = upperInici - 65;

		while (magatzem[idx] != null) {
			contador++;
			idx++;
		} 
		return contador;
	}

	public int getQuants() {
		int quants = 0;
		for (int i = 0; i < 26; i++) {
			char inici = (char) (i + 65);
			quants += getQuants(inici);
		}
		return quants;
	}

	public boolean afegirUbicacio(Ubicacio c) {
		String CarrerString = c.getNomCarrer();
		char inicial = Character.toUpperCase(CarrerString.charAt(0)); 

		int idx = inicial - 65; 

		int j = 0;
		boolean equals = false;
		while (magatzem[idx][j] != null) {
			if (c.equals(magatzem[idx][j])) {
				equals = true;
			}
			j++;
		}

		if (getQuants(inicial) < comptador[idx] && c != null && !equals) {
			magatzem[idx][getQuants(inicial)] = c;
			comptador[idx] += 1;
			return true;
		}
		return false;
	}

	public boolean eliminarUbicacio(Ubicacio c) {
		String CarrerString = c.getNomCarrer();
		char inicial = Character.toUpperCase(CarrerString.charAt(0));
		int idx = inicial - 65;

		for (int j = 0; j < comptador[idx]; j++) {
			if (magatzem[idx][j].equals(c)) {
				magatzem[idx][j] = magatzem[idx][comptador[idx] - 1];
				magatzem[idx][comptador[idx] - 1] = null; 
				comptador[idx]--;
				return true;
			}
		}
		return false;
	}

	public int eliminarUbicacio() {
		int cont = 0;
		for (int i = 0; i < 26; i++) {
			int j = 0;
			while(magatzem[i][j]!= null){
				if (magatzem[i][j].getNumSenyals() == 0 && eliminarUbicacio(magatzem[i][j])) {
					cont++;
				}
				j++;
			}
		}
		return cont;
	}

	public String toString() {
		String resultat = "";
		for (int i = 0; i < 26; i++) {
			char inicial = (char) (i + 65);
			resultat += inicial + ": ";
			for (int j = 0; j < getQuants(inicial); j++) {
				if(magatzem[i][0] == null) {
					resultat += "No hi ha cap ubicacions iniciades amb el caracter" + inicial;
				} else {
					resultat += magatzem[i][j].getNomCarrer() + ", ";
				}
			}
			resultat += "\n";
		}
		return resultat;
	}

	public int quantes(int tipus) {
		int contAdvertencia = 0;
		int contReglamentacio = 0;
		int contIndicacio = 0;

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < comptador[i]; j++) {
				if (magatzem[i][j] != null) {
					for (int k = 0; k < magatzem[i][j].getNumSenyals(); k++) {
						SenyalTransit senyal = magatzem[i][j].getSenyal(k);
						if (tipus == 1 && senyal instanceof Advertencia){
							contAdvertencia++;
						}
						else if(tipus == 2 && senyal instanceof Reglamentacio){
							contReglamentacio++;
						}
						else if(tipus == 3 && senyal instanceof Indicacio) {
							contIndicacio++;
						}
					}
				}
			}
		}
		switch(tipus){
		case 1:
			return contAdvertencia;
		case 2:
			return contReglamentacio;
		case 3:
			return contIndicacio;
		}
		
		return -1;

	}
}