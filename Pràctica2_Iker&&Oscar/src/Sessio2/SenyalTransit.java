package Sessio2;

import java.util.GregorianCalendar;
import java.util.Random;

public abstract class SenyalTransit {
	
	public static final double DIAMETRE_CIRCULAR = 50.0; 
	public static final double COSTAT_TRIANGULAR = 70.0; 
	public static final double ALTURA_RECTANGULAR = 132.0; 
	public static final double AMPLADA_RECTANGULAR = 93.0; 

	protected int contAdvertencia = 0;
	protected int contReglamentacio = 0;
	protected int contIndicacio = 0;

	private Codi codi;
	private Ubicacio ubicacio;
	private int anyUbicacio;

	public SenyalTransit(Codi codi, Ubicacio ubicacio, int anyColocacio) {
		this.codi = codi;
		if (ubicacio == null) {
			this.ubicacio = null;
			this.anyUbicacio = 0;
		} else {
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

	public SenyalTransit(Codi codi, Ubicacio ubicacio) {
		this(codi, ubicacio, obtenirAnyActual());
    }

	public SenyalTransit(Codi codi) {
        this(codi, null, obtenirAnyActual());
    }       
	
	private static int obtenirAnyActual() {
	        GregorianCalendar avui = new GregorianCalendar();
	        int anyActual = avui.get(1);
	        return anyActual;
	       
	    }

	public abstract float area();

	public boolean retirarViaPublica() {
		if (this.ubicacio != null && ubicacio.treureSenyal(this)) {
			this.ubicacio = null;
			anyUbicacio = 0;
			return true;
		}
		return false;
	}

	public int retirarViaPublica(SenyalTransit tot[]) { 
		int cont = 0;
		for (int i = 0; i < tot.length; i++) {
			if (tot[i] != null && tot[i].retirarViaPublica()) { 
				cont++;
			}
		}
		return cont;
	}


	public String getUbicacio() { 
		if (this.ubicacio != null) {
			return ubicacio.getNomCarrer() + " " + ubicacio.getNumero(this);
		}
		return null;
	}

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

	public Codi getCodi(){return this.codi;}
	public int getContAdvertencia() {return this.contAdvertencia;}
	public int getContReglamentacio() {return this.contReglamentacio;}
	public int getContIndicacio() {return this.contIndicacio;}
	
	public String toString() {
	    return "SenyalTransit " +
	           "codi: " + codi.getIdentificador() +
	           ", ubicacio: " + ubicacio.getNomCarrer() +
	           ", anyUbicacio: " + this.anyUbicacio;
	}

}
