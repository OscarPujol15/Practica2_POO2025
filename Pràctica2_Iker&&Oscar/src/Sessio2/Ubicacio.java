package Sessio2;

import Sessio1.SenyalTransit;

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

	public boolean afegirSenyal(SenyalTransit c, int numero){
		if (this.numSenyals == this.MAX_SENYALS){
			this.MAX_SENYALS += 10;
			int onEstanSenyalsDos [] = new int [this.MAX_SENYALS];
			SenyalTransit senyalsDos [] = new SenyalTransit [this.MAX_SENYALS];
			for (int i = 0; i<this.MAX_SENYALS; i++){
				senyalsDos[i] = this.senyals[i];
				onEstanSenyalsDos [i] = this.onEstanSenyals [i];
			}
			senyals = senyalsDos;
			onEstanSenyals = onEstanSenyalsDos;
		}
		
		for (int i =0; i<this.numSenyals; i++) {
			if (this.senyals[i].getCodi().equals(c.getCodi())) {
				return false;
			}		
		}
		c = senyals[numSenyals];
		numero = onEstanSenyals[numSenyals];
		this.numSenyals++;
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