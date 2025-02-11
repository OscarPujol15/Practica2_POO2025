package Sessió_1;

public class Ubicacio {
    // Informació bàsica del carrer
    private String nomCarrer;             // Nom del carrer
    private SenyalTransit senyals[];      // Llista de senyals al carrer
    private int numSenyals;               // Quantes senyals hi ha ara
    private int MAX_SENYALS;              // Quantes senyals hi caben com a màxim
    private int onEstanSenyals[];         // Número del carrer on està cada senyal

    // Crear un nou carrer amb un nom i espai per a un nombre màxim de senyals
    public Ubicacio(int Maxim, String carrer) {
        this.nomCarrer = carrer;
        this.senyals = new SenyalTransit[Maxim];
        this.onEstanSenyals = new int[Maxim];
        this.numSenyals = 0;
        this.MAX_SENYALS = Maxim;
    }

    // Obtenir informació del carrer
    public String getNomCarrer(){return this.nomCarrer;}
    public int getNumSenyals(){return this.numSenyals;}

    // Comprovar si dos carrers són el mateix
    public boolean equals(Ubicacio ubicacio){
        if(this.nomCarrer.equals(ubicacio.getNomCarrer())){
            return true;
        }
        else{
            return false;}
    }

    // Obtenir una senyal específica del carrer
    public SenyalTransit getSenyal(int quin){
        if (quin>this.numSenyals){
            return null;
        }
        else{
            return this.senyals[quin];
        }
    }

    // Trobar el número del carrer on està una senyal
    public int getNumero(SenyalTransit c){
        for (int i = 0; i<numSenyals; i++){
            if(this.senyals[i].equals(c)){
                return this.onEstanSenyals[i];
            }
        }
        return -1;
    }

    // Afegir una nova senyal al carrer
    public boolean afegirSenyal(SenyalTransit senyal, int numero) {
        if (senyal == null) {
            return false;
        }

        // Mirar si la senyal ja existeix
        for (int i = 0; i < numSenyals; i++) {
            if (senyals[i] != null && senyals[i].getCodi().equals(senyal.getCodi())) {
                return false;
            }
        }

        // Si no hi ha prou espai, fem el carrer més gran
        if (numSenyals >= MAX_SENYALS) {
            this.MAX_SENYALS += 10;
            SenyalTransit[] newSenyals = new SenyalTransit[MAX_SENYALS];
            int[] newOnEstanSenyals = new int[MAX_SENYALS];
            
            for (int i = 0; i < numSenyals; i++) {
                newSenyals[i] = this.senyals[i];
                newOnEstanSenyals[i] = this.onEstanSenyals[i];
            }
            this.senyals = newSenyals;
            this.onEstanSenyals = newOnEstanSenyals;
        }

        // Posem la nova senyal
        senyals[numSenyals] = senyal;
        onEstanSenyals[numSenyals] = numero;
        numSenyals++;
        return true;
    }

    // Treure una senyal del carrer
    public boolean treureSenyal(SenyalTransit c){
        for (int i = 0; i<this.numSenyals; i++){
            if (this.senyals[i].getCodi().equals(c.getCodi())){
                this.senyals[i] = this.senyals[numSenyals-1];
                this.onEstanSenyals[i] = this.onEstanSenyals[numSenyals-1];
                this.numSenyals--;
                this.senyals[numSenyals] = null;
                this.onEstanSenyals[this.numSenyals] = -1;
                return true;
            }
        }
        return false;
    }

    // Obtenir una llista de totes les senyals del carrer
    public String getSenyals(){
        String Identificador = " ";
        for (int i = 0; i<numSenyals; i++){
            Identificador += this.senyals[i].getCodi();
            if (i<numSenyals-1) {
                Identificador += " - ";
            }
        }
        return Identificador;
    }
}