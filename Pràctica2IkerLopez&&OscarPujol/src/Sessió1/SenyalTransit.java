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
		if (!ubicacio.treureSenyal(SenyalTransit)){
		}
		else {
			setUbicacio(null);
			if (this.anyubicacio>0){
				anyubicacio = 0;
			}
			else{
			}
		}
	}
}

}
