package Sessió1;

public class SenyalTransit {
	private Codi codi;
	private Ubicacio ubicacio;
	private int anyUbicacio;
	
	public SenyalTransit(Codi codi, Ubicacio ubicacio, int anyColocacio){
		this.codi = codi;
		Random numero = new Random();
		if (ubicacio==null) {
			this.anyUbicacio = 0;
		}
		else if (!ubicacio.afegirSenyal(this,numero.nextInt(1,300))){
			this.ubicacio = null;
			this.anyUbicacio = 0;
		}
		else {
			this.ubicacio = ubicacio;
			this.anyUbicacio = anyColocacio;
		}
	}
	
	public String donaTipusSenyal(){
		return codi.getTipus();
	}
	
	public boolean retirarViaPublica(){
		if (ubicacio.treureSenyal(this)){
			if (this.ubicacio!=null) {
				this.ubicacio = null;
				anyUbicacio = 0;
				return true;
			}
		}
		return false;
	}
	
	public String getUbicacio(){ 
		if (this.ubicacio != null){
		return ubicacio.getNomCarrer() + ubicacio.getNumero(this);}
		else{
		return null;
		}
	}
	
	public boolean canviarUbicacio (Ubicacio novaUbicacio){
		

		if(!ubicacio.afegirSenyal(this,novaUbicacio.getNumero(this))){
			return false;
		}
				else {
					ubicacio.treureSenyal(this);
					this.ubicacio = novaUbicacio;
					return true;
				}
			}
	
	public Codi getCodi(){return this.codi;}
}

