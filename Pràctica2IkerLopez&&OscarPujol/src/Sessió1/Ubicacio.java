package Sessió1;

public class Ubicacio {

	private String nomCarrer;
	private SenyalTransit senyals[];
	private int numSenyals;
	private int MAX_SENYALS;
	private int onEstanSenyals[];
	
	public Ubicacio(int Maxim, String carrer){
		this.nomCarrer = carrer;
		this.senyals [] = new senyals [Maxim];
		this.numSenyals = 0;
		this.MAX_SENYALS = Maxim;
		this.onEstanSenyals [] = new int [Maxim];
	}
	
	public String getNomCarrer(){return this.nomCarrer;}
	public int getNumSenyals(){return this.numSenyals;}
	
	public boolean equals(Ubicacio ubicacio){
		if(this.nomCarrer.equals(ubicacio.getNomCarrer();)){
		return true;
		else{
		return false;}
	}
	
	public SenyalTransit getSenyal(int quin){
		if (quin>this.numSenyal){
			return null;
		}
		else{
		return this.senyals[quin];
		}
	}
	
	public int getNumero(SenyalTransit c){
		for (int i = 0; i<numSenyals; i++){
			if(this.senyal [i].equals(ubicacio.getNomCarrer());
				return this.onEstanSenyals[i];
			}
		}
		return -1;
	}
	
	public boolean afegirSenyal(SenyalTransit c, int numero){
		if (this.numSenyal == this.MAX_SENYALS){
		this.MAX_SENYALS += 10;
		int onEstanSenyalsDos [] = new int [this.MAX_SENYALS];
		SenyalTransit senyalsDos [] = new SenyalTransit [this.MAX_SENYALS];
		for (int i = 0; i<this.MAX_SENYALS; i++){
			this.senyalsDos[i] = this.senyals[i];
			this.onEstanSenyalsDos [i] = this.onEstanSenyals [i];
		}
		senyals = this.senyalsDos;
		onEstanSenyals = this.onEstanSenyalsDos;
		}
		
		for (int i = 0; i<this.numSenyals; i++){
			if (this.senyals.get(i).getcodi().equals(c.getCodi())){
			return false;
			}
			else{
				if (this.senyals [i] == null){
				this.senyls [i] = c;
				this.onEstanSenyals[i] = numero;
				return true;
				
				}
			}
		}
	}
	
	boolean treureSenyal(SenyalTransit c){
		for (int i = 0; i<this.numSenyals; i++){
			if (this.senyals.get(i).getcodi().equals(c.getCodi())){
			this.senyal[i] = this.senyal[numSenyals-1];
			this.onEstanSenyals [i] = this.onEstanSenyals[numSenyals-1];
			this.numSenyals--;
			this.senyals [numSenyals] = null;
			this.onEstanSenyals[numsenyals] = -1;
			return true;
			}
			else{
			return false;
			}
		}
	}
	
	String getSenyals(Jconsole){
		for (int i = 0; i<numSenyals; i++){
		console.print (this.senyal.get(i).getcodi() + " - ");
		}
	}
}
