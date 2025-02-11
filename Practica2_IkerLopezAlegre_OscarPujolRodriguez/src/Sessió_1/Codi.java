package Sessió_1;

public class Codi {
    // Guardem el tipus i el número de la senyal
    private int tipus;
    private int identificador;

    // Definim els tres tipus de senyals que existeixen
    public static final int PERILL = 1;
    public static final int REGLAMENTACIO = 2;
    public static final int INDICACIO = 3;

    // Constructor per crear una nova senyal amb el seu número i tipus
    public Codi(int identificador, int tipus){
        this.identificador = identificador;

        // Si el tipus no és vàlid, posem que és d'indicació
        if (tipus<1 || tipus>3){
            this.tipus = INDICACIO;
        }
        else {
            this.tipus = tipus;
        }
    }

    // Mètodes per obtenir la informació de la senyal
    public int getterTipus(){return this.tipus;}
    public int getIdentificador(){return this.identificador;}

    // Mètodes per canviar la informació de la senyal
    public int setTipus(int canvi){ this.tipus = canvi; return this.tipus;}
    public int setIdentificador(int nouIde){this.identificador = nouIde; return this.identificador;}

    // Retorna el nom del tipus de senyal en text
    public String getTipus(){
        switch(tipus){
        case 1:
            return "Perill";
        case 2:
            return "Reglamentació";
        case 3:
            return "Indicació";
        default: 
            return "Indicacio";
        }
    }

    // Comprova si dues senyals són iguals
    public boolean equals(Codi c){
        if (this.identificador == c.identificador && this.tipus == c.tipus){
            return true;
        }
        else{
            return false;
        }
    }

    // Mostra la informació de la senyal en text
    public String toString() {
        return "Codi{" + "tipus=" + tipus + ", identificador=" + identificador + '}';
    }
}