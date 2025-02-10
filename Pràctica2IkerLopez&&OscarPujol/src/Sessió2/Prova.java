package Sessió_2;

import java.util.Random;

public class Prova {

    public static void main(String[] args) {
    	
    	        String[] NOM_CARRERS = {
            "Carrer de la Pau", "Carrer de la Llum", "Carrer del Sol", "Carrer de la Lluna",
            "Carrer de les Flors", "Carrer de l'Aigua", "Carrer del Vent", "Carrer de la Terra",
            "Carrer del Foc", "Carrer de l'Aire"
        };
    	
        SenyalTransit[] senyals = new SenyalTransit[20];
        Random random = new Random();
        
       
        Poblacio poblacio = new Poblacio(10, "Barcelona");

        for (int i = 0; i < senyals.length; i++) {
            int identificador = i; 
            int tipus = random.nextInt(3) + 1; 
            Codi codi = new Codi(identificador, tipus); 
            Ubicacio ubicacio = new Ubicacio(random.nextInt(10), NOM_CARRERS[random.nextInt(NOM_CARRERS.length)]);
            int anyColocacio = 2000 + random.nextInt(23);
            String significat = "Significat " + i;

            
            poblacio.afegirUbicacio(ubicacio);

            if (random.nextBoolean()) {
                senyals[i] = new Advertencia(codi, ubicacio, anyColocacio, significat);
            } else {
                senyals[i] = new Reglamentacio(codi, ubicacio, anyColocacio, significat, random.nextDouble() * 100);
            }
        }

        provarMetodesPoblacio(poblacio);
        mostrarSenyals(senyals);
    }

    public static void mostrarSenyals(SenyalTransit[] senyals) {
        for (SenyalTransit senyal : senyals) {
            System.out.println(senyal);
        }
    }

    public static void provarMetodesPoblacio(Poblacio poblacio) {
        System.out.println("\n=== Pruebas de métodos de Poblacio ===");
        
        // Probar getNom
        System.out.println("Nombre de la población: " + poblacio.getNom());
        
        // Probar getQuants con letra específica
        System.out.println("Ubicaciones que empiezan con 'C': " + poblacio.getQuants('C'));
        
        // Probar getQuants total
        System.out.println("Total de ubicaciones: " + poblacio.getQuants());
        
        // Probar quantes para cada tipo de señal
        System.out.println("Señales de Advertencia: " + poblacio.quantes(Codi.ADVERTENCIA));
        System.out.println("Señales de Reglamentación: " + poblacio.quantes(Codi.REGLAMENTACIO));
        System.out.println("Señales de Indicación: " + poblacio.quantes(Codi.INDICACIO));
        
        // Probar toString de la población
        System.out.println("\nListado de ubicaciones por inicial:");
        System.out.println(poblacio.toString());
        
        // Probar eliminarUbicacio
        System.out.println("Ubicaciones eliminadas sin señales: " + poblacio.eliminarUbicacio());
        
        // Crear y probar eliminar una ubicación específica
        Ubicacio ubicacioTest = new Ubicacio(5, "Carrer de Prova");
        if (poblacio.afegirUbicacio(ubicacioTest)) {
            System.out.println("Ubicación de prueba añadida");
            if (poblacio.eliminarUbicacio(ubicacioTest)) {
                System.out.println("Ubicación de prueba eliminada correctamente");
            }
        }
    }
}
