package Sessió_2;

public class Indicacio extends SenyalTransit{
	
	private String significatSenyal;
	private double altura, amplada;

	public Indicacio(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal) {
		super(codi, ubicacio, anyColocacio);
		this.significatSenyal = significatSenyal;
		contIndicacio++;
		this.altura = ALTURA_RECTANGULAR;
		this.amplada = AMPLADA_RECTANGULAR;
	}
	
	public Indicacio(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal, double altura, double amplada) {
		this(codi, ubicacio, anyColocacio, significatSenyal);
		this.altura = altura;
		this.amplada = amplada;
	}

	
	public float area() {
		return (float) (this.altura*this.amplada);
	}
	
	public double getAltura() {return ALTURA_RECTANGULAR;}
	public double getAmplada() {return AMPLADA_RECTANGULAR;}
	
	
	public String toString() {
		return super.toString() +
				", costat: " + this.altura +
				", costat: " + this.amplada +
				", area: " + this.area() +
				", descripció: " + this.significatSenyal +
				", quantitat de Indicació: " + contIndicacio;
	}
}
