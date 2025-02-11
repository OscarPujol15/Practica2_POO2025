package Sessió_2;

public class Indicacio extends SenyalTransit {
    // Informació específica de les senyals d'indicació
    private String significatSenyal;    // Què vol dir la senyal
    private double altura, amplada;     // Mides del rectangle de la senyal

    // Constructor per crear una senyal d'indicació amb mida estàndard
    public Indicacio(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal) {
        super(codi, ubicacio, anyColocacio);
        this.significatSenyal = significatSenyal;
        contIndicacio++;                // Augmentem el comptador de senyals d'indicació
        this.altura = ALTURA_RECTANGULAR;    // Posem l'altura estàndard
        this.amplada = AMPLADA_RECTANGULAR; // Posem l'amplada estàndard
    }
    
    // Constructor per crear una senyal d'indicació amb mides personalitzades
    public Indicacio(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal, double altura, double amplada) {
        this(codi, ubicacio, anyColocacio, significatSenyal);
        this.altura = altura;           // Posem l'altura que ens demanen
        this.amplada = amplada;         // Posem l'amplada que ens demanen
    }

    // Calcular l'àrea del rectangle de la senyal
    public float area() {
        return (float) (this.altura * this.amplada);
    }
    
    // Obtenir les mides de la senyal
    public double getAltura() {return ALTURA_RECTANGULAR;}
    public double getAmplada() {return AMPLADA_RECTANGULAR;}
    
    // Mostrar tota la informació de la senyal
    public String toString() {
        return super.toString() +
                ",\n	altura: " + this.altura +
                ",\n	amplada: " + this.amplada +
                ",\n 	area: " + this.area() +
                ",\n 	descripció: " + this.significatSenyal +
                ",\n 	quantitat de Indicacio: " + contAdvertencia;
    }
}