package Sessió_2;

public class Codi {
    // Informació bàsica del codi de la senyal
    private int tipus;          // Quin tipus de senyal és
    private int identificador;  // Número únic de la senyal

    // Definim els tres tipus de senyals que hi ha
    public static final int ADVERTENCIA = 1;      // Senyal triangular d'advertència
    public static final int REGLAMENTACIO = 2;    // Senyal rodona de reglamentació
    public static final int INDICACIO = 3;        // Senyal quadrada d'indicació

    // Constructor per crear un nou codi de senyal
    public Codi(int identificador, int tipus){
        this.identificador = identificador;
        // Si el tipus no és correcte, posem que és d'indicació
        if (tipus<1 || tipus>3){
            this.tipus = INDICACIO;
        }
        else {
            this.tipus = tipus;
        }
    }

    // Mètodes per obtenir la informació del codi
    public int getterTipus(){return this.tipus;}
    public int getIdentificador(){return this.identificador;}

    // Mètodes per canviar la informació del codi
    public int setTipus(int canvi){ this.tipus = canvi; return this.tipus;}
    public int setIdentificador(int nouIde){this.identificador = nouIde; return this.identificador;}

    // Obtenir el nom del tipus de senyal en text
    public String getTipus(){
        switch(tipus){
        case 1:
            return "Advertencia";
        case 2:
            return "Reglamentació";
        case 3:
            return "Indicació";
        default:
            return null;
        }
    }

    // Comprovar si dos codis són iguals
    public boolean equals(Codi c){
        if (this.identificador == c.identificador && this.tipus == c.tipus){
            return true;
        }
        else{
            return false;
        }
    }

    // Mostrar la informació del codi en text
    public String toString() {
        return "Codi{" + "tipus=" + tipus + ", identificador=" + identificador + '}';
    }
}