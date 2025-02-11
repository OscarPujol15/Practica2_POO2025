package Sessió_2;

public class Ubicacio {

	private String nomCarrer;
	private SenyalTransit senyals[];
	private int numSenyals;
	private int MAX_SENYALS;
	private int onEstanSenyals[];

	public Ubicacio(int Maxim, String carrer) {
		this.nomCarrer = carrer;
		this.senyals = new SenyalTransit[Maxim];
		this.onEstanSenyals = new int[Maxim];
		this.numSenyals = 0;
		this.MAX_SENYALS = Maxim;
	}

	public String getNomCarrer(){return this.nomCarrer;}
	public int getNumSenyals(){return this.numSenyals;}
	public int getMaxSenyals(){return this.MAX_SENYALS;}

	public boolean equals(Ubicacio ubicacio){
		if(this.nomCarrer.equals(ubicacio.getNomCarrer())){
			return true;
		}
		else{
			return false;}
	}

	public SenyalTransit getSenyal(int quin){
		if (quin>this.numSenyals){
			return null;
		}
		else{
			return this.senyals[quin];
		}
	}

	public int getNumero(SenyalTransit c){
		for (int i = 0; i<numSenyals; i++){
			if(this.senyals[i].equals(c)){
				return this.onEstanSenyals[i];
			}
		}
		return -1;
	}

    public boolean afegirSenyal(SenyalTransit senyal, int numero) {
        if (senyal == null) {
            return false;
        }

        // Comprobar si ya existe
        for (int i = 0; i < numSenyals; i++) {
            if (senyals[i] != null && senyals[i].getCodi().equals(senyal.getCodi())) {
                return false;
            }
        }

        // Ampliar si es necesario
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

        senyals[numSenyals] = senyal;
        onEstanSenyals[numSenyals] = numero;
        numSenyals++;
        return true;
    }

	public boolean treureSenyal(SenyalTransit c){
		for (int i = 0; i<this.numSenyals; i++){
			if (this.senyals[i].getCodi().equals(c.getCodi())){
				this.senyals[i] = this.senyals[numSenyals-1];
				this.onEstanSenyals [i] = this.onEstanSenyals[numSenyals-1];
				this.numSenyals--;
				this.senyals [numSenyals] = null;
				this.onEstanSenyals[this.numSenyals] = -1;
				return true;
			}
		}
		return false;

	}

	public String getSenyals(){
		String Identificador= " ";
		for (int i = 0; i<numSenyals; i++){
			Identificador += this.senyals[i]. getCodi();
			if (i<numSenyals-1) {
				Identificador += " - ";
			}
		}
		return Identificador;
	}
}
