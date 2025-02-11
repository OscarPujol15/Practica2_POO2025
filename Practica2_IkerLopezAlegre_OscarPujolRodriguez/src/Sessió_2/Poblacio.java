package Sessió_2;

public class Poblacio {
    // Informació bàsica de la població
    private String nom;                 // Nom de la població
    private Ubicacio[][] magatzem;      // Llista de carrers ordenats per lletra
    private int[] comptador;            // Comptador de carrers per cada lletra

    // Constructor per crear una nova població
    public Poblacio(int Maxim, String nomPoblacio) {
        magatzem = new Ubicacio[26][Maxim];  // 26 lletres de l'abecedari
        this.nom = nomPoblacio;
        comptador = new int[26];
        for(int i = 0; i<26; i++) {
            comptador[i] = 0;
        }
    }

    // Obtenir el nom de la població
    public String getNom() {return this.nom;}

    // Comptar carrers que comencen per una lletra específica
    public int getQuants(char inici) { 
        int contador = 0;
        char Inici = Character.toUpperCase(inici); 
        int idx = (int) Inici - 65;

        if (idx < 0 || idx >= 26) {
            return 0;
        }

        for (int i = 0; i < comptador[idx]; i++) {
            if (magatzem[idx][i] != null) {
                contador++;
            }
        }
        return contador;
    }

    // Comptar tots els carrers de la població
    public int getQuants() {
        int quants = 0;
        for (int i = 0; i < 26; i++) {
            char inici = (char) (i + 65);
            quants += getQuants(inici);
        }
        return quants;
    }

    // Afegir un nou carrer a la població
    public boolean afegirUbicacio(Ubicacio c) {
        String CarrerString = c.getNomCarrer();
        char inicial = Character.toUpperCase(CarrerString.charAt(0)); 
        int idx = inicial - 65; 

        // Comprovar si el carrer ja existeix
        int j = 0;
        while (j < comptador[idx]) {
            if (c.equals(magatzem[idx][j])) {
                return false;
            }
            j++;
        }
        
        // Si no hi ha espai, no podem afegir més carrers
        if (comptador[idx] == magatzem[idx].length) {return false;} 

        // Afegim el nou carrer
        magatzem[idx][comptador[idx]] = c;
        comptador[idx] += 1;
        return true;
    }

    // Eliminar un carrer específic
    public boolean eliminarUbicacio(Ubicacio c) {
        String CarrerString = c.getNomCarrer();
        char inicial = Character.toUpperCase(CarrerString.charAt(0));
        int idx = inicial - 65;

        for (int j = 0; j < comptador[idx]; j++) {
            if (c.equals(magatzem[idx][j])){
                magatzem[idx][j] = magatzem[idx][comptador[idx] - 1];
                magatzem[idx][comptador[idx] - 1] = null;
                comptador[idx]--;
                return true;
            }
        }
        return false;
    }

    // Eliminar tots els carrers sense senyals
    public int eliminarUbicacio() {
        int cont = 0;
        for (int i = 0; i < 26; i++) {
            int j = 0;
            while(j < comptador[i]){
                if (magatzem[i][j].getNumSenyals() == 0 && eliminarUbicacio(magatzem[i][j])) {
                    cont++;
                }
                else {j++;}
            }
        }
        return cont;
    }

    // Mostrar tots els carrers ordenats per lletra
    public String toString() {
        String resultat = "";
        for (int i = 0; i < 26; i++) {
            char inicial = (char) (i + 65);
            resultat += inicial + ": ";
            for (int j = 0; j < getQuants(inicial); j++) {
                if(magatzem[i][0] == null) {
                    resultat += "No hi ha cap ubicacions iniciades amb el caracter " + inicial;
                } else {
                    resultat += magatzem[i][j].getNomCarrer() + ", ";
                }
            }
            resultat += "\n";
        }
        return resultat;
    }

    // Comptar quantes senyals hi ha de cada tipus
    public int quantes(int tipus) {
        int contAdvertencia = 0;
        int contReglamentacio = 0;
        int contIndicacio = 0;

        // Recorrem tots els carrers buscant senyals
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
        
        // Retornem el comptador segons el tipus demanat
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