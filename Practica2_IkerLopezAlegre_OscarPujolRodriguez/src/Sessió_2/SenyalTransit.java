package Sessió_2;

import java.util.GregorianCalendar;
import java.util.Random;

public abstract class SenyalTransit {
    // Mides estàndard per a cada tipus de senyal
    public static final double DIAMETRE_CIRCULAR = 50.0;      // Per a senyals rodones
    public static final double COSTAT_TRIANGULAR = 70.0;      // Per a senyals triangulars
    public static final double ALTURA_RECTANGULAR = 132.0;     // Altura de senyals quadrades
    public static final double AMPLADA_RECTANGULAR = 93.0;     // Amplada de senyals quadrades

    // Comptadors per a cada tipus de senyal
    protected static int contAdvertencia = 0;      // Quantes senyals d'advertència hi ha
    protected static int contReglamentacio = 0;    // Quantes senyals de reglamentació hi ha
    protected static int contIndicacio = 0;        // Quantes senyals d'indicació hi ha

    // Informació bàsica de la senyal
    private Codi codi;              // Identificador de la senyal
    private Ubicacio ubicacio;      // On està col·locada
    private int anyUbicacio;        // Quan es va posar

    // Constructor principal per crear una senyal
    public SenyalTransit(Codi codi, Ubicacio ubicacio, int anyColocacio) {
        this.codi = codi;
        if (ubicacio == null) {
            this.ubicacio = null;
            this.anyUbicacio = 0;
        } else {
            // Intentem posar la senyal en un número aleatori del carrer
            Random numero = new Random();
            this.ubicacio = ubicacio;
            if (ubicacio.afegirSenyal(this, numero.nextInt(1, 1000))) {
                this.anyUbicacio = anyColocacio;
            } else {
                this.ubicacio = null;
                this.anyUbicacio = 0;
            }
        }
    }

    // Constructors alternatius
    public SenyalTransit(Codi codi, Ubicacio ubicacio) {
        this(codi, ubicacio, obtenirAnyActual());
    }

    public SenyalTransit(Codi codi) {
        this(codi, null, obtenirAnyActual());
    }       

    // Obtenir l'any actual
    private static int obtenirAnyActual() {
        GregorianCalendar avui = new GregorianCalendar();
        return avui.get(1);
    }

    // Cada tipus de senyal ha de dir com calcular la seva àrea
    public abstract float area();

    // Treure una senyal del carrer
    public boolean retirarViaPublica() {
        if (this.ubicacio != null && ubicacio.treureSenyal(this)) {
            this.ubicacio = null;
            anyUbicacio = 0;
            return true;
        }
        return false;
    }

    // Treure moltes senyals alhora
    public int retirarViaPublica(SenyalTransit tot[]) { 
        int cont = 0;
        for (int i = 0; i < tot.length; i++) {
            if (tot[i] != null && tot[i].retirarViaPublica()) { 
                cont++;
            }
        }
        return cont;
    }

    // Obtenir l'adreça on està la senyal
    public String getUbicacio() { 
        if (this.ubicacio != null) {
            return ubicacio.getNomCarrer() + " " + ubicacio.getNumero(this);
        }
        return null;
    }

    // Moure la senyal a un altre carrer
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

    // Mètodes per obtenir informació de la senyal
    public Codi getCodi(){return this.codi;}
    public int getContAdvertencia() {return contAdvertencia;}
    public int getContReglamentacio() {return contReglamentacio;}
    public int getContIndicacio() {return contIndicacio;}
    
    // Mostrar tota la informació de la senyal
    public String toString() {
        return "SenyalTransit {\n" +
               "  Codi: " + codi.getIdentificador() + ",\n" +
               "  Ubicacio: " + ubicacio.getNomCarrer() + ",\n" +
               "  Any Ubicacio: " + this.anyUbicacio;
    }
}