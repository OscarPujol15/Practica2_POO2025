package Sessió1;

public class SenyalTransit {
	private Codi codi;
	private Ubicacio ubicacio;
	private int anyUbicacio;
	
	public SenyalTransit(Codi codi, Ubicacio ubicacio, int anyColocacio){
		this.codi = codi;
		if (!afegirSenyal(SenyalTransit)){
			this.ubicacio = null;
		}
		else {
			this.ubicacio = ubicacio;
		}
		this.anyUbicacio = anyColocacio;
	}
	
	public String donaTipusSenyal(){
		return codi.getTipus();
	}
	
	public boolean retirarViaPublica(){
		if (ubicacio.treureSenyal(SenyalTransit)){
		setUbicacio(null);
			if (this.anyubicacio!=0){
				anyUbicacio = 0;
			}
		}
	}
	
	public String getUbicacio(){ 
		if (this.ubicacio != null){
		return ubicacio. + ubicacio.}
		else{
		return null;
		}
		// Preguntar
	}
	
	public boolean canviarUbicacio (Ubicacio novaUbicacio){
		if(ubicacio.afegirSenyal(SenyalTransit, int)){
			ubicacio.treureSenyal(SenyalTransit);
			this.ubicacio = novaUbicacio;
			return true; //Preguntar
		}
	}
	
	public Codi getCodi(){return getIdentificador();}
}
