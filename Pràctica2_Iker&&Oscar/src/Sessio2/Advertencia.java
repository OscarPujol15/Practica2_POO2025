package Sessio2;

	public class Advertencia extends SenyalTransit{

		private String significatSenyal;
		public double costat;

		public Advertencia(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal) {
			super(codi, ubicacio, anyColocacio);
			this.significatSenyal = significatSenyal;
			contAdvertencia++;
			this.costat = COSTAT_TRIANGULAR;
		}

		public Advertencia(Codi codi, Ubicacio ubicacio, int anyColocacio, String significatSenyal, double costat) {
			this(codi, ubicacio, anyColocacio, significatSenyal);
			this.costat = costat;
		}

		
		public float area() {
			return (float) ((this.costat * this.costat)/2);
		}

		public double getCostat() {return COSTAT_TRIANGULAR;}

		
		public String toString() {
			return super.toString() +
					", costat: " + this.costat +
					", area: " + this.area() +
					", descripció: " + this.significatSenyal +
					", quantitat: " + contAdvertencia;
		}

	}

