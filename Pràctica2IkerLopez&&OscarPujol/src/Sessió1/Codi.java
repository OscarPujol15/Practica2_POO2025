package Sessió1;

public class Codi {
  	private int tipus;
	private int identificador;

	public static final int PERILL = 1;
	public static final int REGLAMENTACIO = 2;
	public static final int INDICACIO = 3;


	public Codi(int identificador, int tipus){
		this.identificador = identificador;

		if (tipus<1 || tipus>3){
			this.tipus = INDICACIO;
		}
		else {
			this.tipus = tipus;
		}
	}

	public int getterTipus(){return this.tipus;}
	public int getIdentificador(){return this.identificador;}

	public int setTipus(int canvi){ this.tipus = canvi;}
	public int setIdentificador(int nouIde){this.identificador = nouIde;}

	public String getTipus(){

		switch(tipus){
		case 1:
			return "Perill";
			break;
		case 2:
			return "Reglamentació";
			break;
		case 3:
			return "Indicació";
			break;
		}
	}

	public boolean equals(Codi c){
		if (this.identificador == c.identificador && this.tipus == c.tipus){
			return true;
		}
		else{
			return false;
		}

	}
}

}
