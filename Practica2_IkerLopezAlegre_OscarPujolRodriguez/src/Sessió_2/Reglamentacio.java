package Sessió_2;

public class Reglamentacio extends SenyalTransit {
    // Informació específica de les senyals de reglamentació
    private String significatSenyal;    // Què vol dir la senyal
    public double diametre;             // Mida del cercle de la senyal

    // Constructor per crear una senyal de reglamentació amb mida estàndard
    public Reglamentacio(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal) {
        super(codi, ubicacio, anyColocacio);
        this.significatSenyal = significatSenyal;
        contReglamentacio++;            // Augmentem el comptador de senyals de reglamentació
        this.diametre = DIAMETRE_CIRCULAR;  // Posem la mida estàndard
    }
    
    // Constructor per crear una senyal de reglamentació amb mida personalitzada
    public Reglamentacio(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal, double diametre) {
        this(codi, ubicacio, anyColocacio, significatSenyal);
        this.diametre = diametre;       // Posem la mida que ens demanen
    }

    // Calcular l'àrea del cercle de la senyal
    public float area() {
        return (float) (Math.PI * Math.pow((this.diametre/2), 2));
    }
    
    // Obtenir la mida del diàmetre
    public double getDiametre() {return DIAMETRE_CIRCULAR;}
    
    // Mostrar tota la informació de la senyal
    public String toString() {
        return super.toString() +
                ",\n 	diametre: " + this.diametre +
                ",\n 	area: " + this.area() +
                ",\n 	descripció: " + this.significatSenyal +
                ",\n 	quantitat de Reglamentació: " + contReglamentacio;
    }
}