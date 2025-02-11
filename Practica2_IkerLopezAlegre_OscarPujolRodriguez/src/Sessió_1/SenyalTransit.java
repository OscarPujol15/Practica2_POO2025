package Sessió_1;

import java.util.Random;

public class SenyalTransit {
    // Guardem la informació bàsica de la senyal
    private Codi codi;                // El codi que identifica la senyal
    private Ubicacio ubicacio;        // On està col·locada la senyal
    private int anyUbicacio;          // L'any que es va posar la senyal
    
    // Constructor per crear una nova senyal
    public SenyalTransit(Codi codi, Ubicacio ubicacio, int anyColocacio) {
        this.codi = codi;
        // Si no hi ha ubicació, la senyal no està col·locada enlloc
        if (ubicacio == null) {
            this.ubicacio = null;
            this.anyUbicacio = 0;
        } else {
            // Provem de posar la senyal en un número aleatori del carrer
            Random numero = new Random();
            this.ubicacio = ubicacio;
            if (ubicacio.afegirSenyal(this, numero.nextInt(1, 300))) {
                this.anyUbicacio = anyColocacio;
            } else {
                // Si no es pot posar, la senyal queda sense ubicació
                this.ubicacio = null;
                this.anyUbicacio = 0;
            }
        }
    }
    
    // Treure una senyal del carrer
    public boolean retirarViaPublica() {
        if (this.ubicacio != null && ubicacio.treureSenyal(this)) {
            this.ubicacio = null;
            anyUbicacio = 0;
            return true;
        }
        return false;
    }
    
 // Obtenir l'adreça on està la senyal
    public String getUbicacio() { 
        if (this.ubicacio != null) {
            return ubicacio.getNomCarrer() + " " + ubicacio.getNumero(this);
        }
        return null;
    }
    
    // Canviar la senyal a un altre carrer
    public boolean canviarUbicacio(Ubicacio novaUbicacio) {
        if (novaUbicacio == null || this.ubicacio == null) {
            return false;
        }
        Random numero = new Random();
        if (novaUbicacio.afegirSenyal(this, numero.nextInt(1, 300))) {
            this.ubicacio.treureSenyal(this);
            this.ubicacio = novaUbicacio;
            return true;
        }
        return false;
    }
    
    // Obtenir el codi de la senyal
    public Codi getCodi(){return this.codi;}
}