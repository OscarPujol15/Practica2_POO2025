package Sessio2;

public class Reglamentacio extends SenyalTransit{
	
	private String significatSenyal;
	public double diametre;

	public Reglamentacio(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal) {
		super(codi, ubicacio, anyColocacio);
		this.significatSenyal = significatSenyal;
		this.contReglamentacio++;
		this.diametre = DIAMETRE_CIRCULAR;
	}
	
	public Reglamentacio(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal, double diametre) {
		this(codi, ubicacio, anyColocacio, significatSenyal);
		this.diametre = diametre;
	}


	public float area() {
		return (float) (Math.PI*Math.pow((this.diametre/2),2));
	}
	
	public double getDiametre() {return DIAMETRE_CIRCULAR;}
	
	
	public String toString() {
		return super.toString() +
				", diametre: " + this.diametre +
				", area: " + this.area() +
				", descripció: " + this.significatSenyal +
				", quantitat: " + this.contReglamentacio;
	}

	
}
