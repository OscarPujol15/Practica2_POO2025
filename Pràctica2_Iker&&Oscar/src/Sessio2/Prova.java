package Sessió_2;

public class Prova {

    public static void main(String[] args) {
        // Creem alguns objectes bàsics per començar
    	Ubicacio ubicacio1 = new Ubicacio(101, "Avinguda Diagonal");
    	Ubicacio ubicacio2 = new Ubicacio(102, "Barceloneta");
    	Ubicacio ubicacio3 = new Ubicacio(103, "Carrer d'Aragó");
    	Ubicacio ubicacio21 = new Ubicacio(103, "Carrer de Felip II");
    	Ubicacio ubicacio4 = new Ubicacio(104, "Diagonal Mar");
    	Ubicacio ubicacio5 = new Ubicacio(105, "El Born");
    	Ubicacio ubicacio6 = new Ubicacio(106, "Francesc Macià");
    	Ubicacio ubicacio7 = new Ubicacio(107, "Gràcia");
    	Ubicacio ubicacio8 = new Ubicacio(108, "Hospitalet de Llobregat");
    	Ubicacio ubicacio9 = new Ubicacio(109, "Joanic");
    	Ubicacio ubicacio10 = new Ubicacio(110, "La Rambla");
    	Ubicacio ubicacio11 = new Ubicacio(111, "Montjuïc");
    	Ubicacio ubicacio12 = new Ubicacio(112, "Nou Barris");
    	Ubicacio ubicacio13 = new Ubicacio(113, "Passeig de Gràcia");
    	Ubicacio ubicacio14 = new Ubicacio(114, "Quatre Camins");
    	Ubicacio ubicacio15 = new Ubicacio(115, "Raval");
    	Ubicacio ubicacio16 = new Ubicacio(116, "Sagrada Família");
    	Ubicacio ubicacio17 = new Ubicacio(117, "Tibidabo");
    	Ubicacio ubicacio18 = new Ubicacio(118, "Universitat");
    	Ubicacio ubicacio19 = new Ubicacio(119, "Vall d'Hebron");
    	Ubicacio ubicacio20 = new Ubicacio(120, "Zona Franca");
    	

        // Creem alguns codis per a les senyals
        Codi codiAdvertencia = new Codi(1, Codi.ADVERTENCIA);
        Codi codiReglamentacio = new Codi(2, Codi.REGLAMENTACIO);
        Codi codiIndicacio = new Codi(3, Codi.INDICACIO);

        // Creem les senyals de trànsit
        Advertencia advertencia1 = new Advertencia(codiAdvertencia, ubicacio1, 2020, "Perill de gel");
        Reglamentacio reglamentacio1 = new Reglamentacio(codiReglamentacio, ubicacio2, 2019, "Stop");
        Indicacio indicacio1 = new Indicacio(codiIndicacio, ubicacio3, 2021, "Direcció Barcelona");
        
        // Provem el mètode toString() de les senyals
        System.out.println("=== Provant el mètode toString() de 3 senyals ===");
        System.out.println(advertencia1);
        System.out.println(reglamentacio1);
        System.out.println(indicacio1);

        // Provem el mètode area() de les senyals
        System.out.println("\n=== Provant el mètode area() de les senyals ===");
        System.out.println("Àrea de l'advertència: " + advertencia1.area());
        System.out.println("Àrea de la reglamentació: " + reglamentacio1.area());
        System.out.println("Àrea de la indicació: " + indicacio1.area());

        // Provem el mètode retirarViaPublica()
        
        System.out.println("\n=== Provant el mètode retirarViaPublica() ===");
        System.out.println("Advertència retirada de la via pública: " + advertencia1.retirarViaPublica());
        System.out.println("Reglamentació retirada de la via pública: " + reglamentacio1.retirarViaPublica());
        System.out.println("Indicació retirada de la via pública: " + indicacio1.retirarViaPublica());

        // Provem el mètode canviarUbicacio()
        System.out.println("\n=== Provant el mètode canviarUbicacio() ===");
        System.out.println("Canviant ubicació de l'advertència a una nova ubicació: " + advertencia1.canviarUbicacio(ubicacio2));
        System.out.println("Canviant ubicació de la reglamentació a una nova ubicació: " + reglamentacio1.canviarUbicacio(ubicacio3));
        System.out.println("Canviant ubicació de la indicació a una nova ubicació: " + indicacio1.canviarUbicacio(ubicacio1));

        // Provem la classe Poblacio
        System.out.println("\n=== Provant la classe Poblacio ===");
        Poblacio poblacio = new Poblacio(10, "Barcelona");

        // Afegim ubicacions a la població
        System.out.println("Afegint ubicacions a la població...");
        poblacio.afegirUbicacio(ubicacio1);  
        poblacio.afegirUbicacio(ubicacio2);
        poblacio.afegirUbicacio(ubicacio3);
        poblacio.afegirUbicacio(ubicacio4);
        poblacio.afegirUbicacio(ubicacio5);
        poblacio.afegirUbicacio(ubicacio6);
        poblacio.afegirUbicacio(ubicacio7);
        poblacio.afegirUbicacio(ubicacio8);
        poblacio.afegirUbicacio(ubicacio9);
        poblacio.afegirUbicacio(ubicacio10);
        poblacio.afegirUbicacio(ubicacio11);
        poblacio.afegirUbicacio(ubicacio12);
        poblacio.afegirUbicacio(ubicacio13);
        poblacio.afegirUbicacio(ubicacio14);
        poblacio.afegirUbicacio(ubicacio15);
        poblacio.afegirUbicacio(ubicacio16);
        poblacio.afegirUbicacio(ubicacio17);
        poblacio.afegirUbicacio(ubicacio18);
        poblacio.afegirUbicacio(ubicacio19);
        poblacio.afegirUbicacio(ubicacio20);
        poblacio.afegirUbicacio(ubicacio21);
  
        // Mostrem les ubicacions afegides
        System.out.println("\nUbicacions a la població:");
        System.out.println(poblacio);

        // Provem el mètode eliminarUbicacio()
        System.out.println("\n=== Provant el mètode eliminarUbicacio(Ubicacio B) ===");
        System.out.println("Eliminant ubicació: " + poblacio.eliminarUbicacio(ubicacio2));
        System.out.println("Ubicacions després d'eliminar:");
        System.out.println(poblacio);

        // Provem el mètode quantes() per comptar senyals
        System.out.println("\n=== Provant el mètode quantes() ===");
        System.out.println("Quantitat d'advertències: " + poblacio.quantes(Codi.ADVERTENCIA));
        System.out.println("Quantitat de reglamentacions: " + poblacio.quantes(Codi.REGLAMENTACIO));
        System.out.println("Quantitat d'indicacions: " + poblacio.quantes(Codi.INDICACIO));

        // Provem el mètode eliminarUbicacio() sense paràmetres
        System.out.println("\n=== Provant el mètode eliminarUbicacio() sense paràmetres ===");
        System.out.println("Ubicacions eliminades: " + poblacio.eliminarUbicacio());

        // Mostrem les ubicacions després d'eliminar
        System.out.println("\nUbicacions després d'eliminar les que no tenen senyals:");
        System.out.println(poblacio);
    }
}
