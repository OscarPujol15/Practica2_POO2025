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

        for (int i = 0; i < senyals.length; i++) {
            int identificador = i; // Identificador único
            int tipus = random.nextInt(3) + 1; // Tipo aleatorio entre 1 y 3
            Codi codi = new Codi(identificador, tipus); // Crear objeto Codi
            Ubicacio ubicacio = new Ubicacio(random.nextInt(10), NOM_CARRERS[random.nextInt(NOM_CARRERS.length)]);
            int anyColocacio = 2000 + random.nextInt(23); // Año entre 2000 y 2022
            String significat = "Significat " + i;

            if (random.nextBoolean()) {
                senyals[i] = new Advertencia(codi, ubicacio, anyColocacio, significat);
            } else {
                senyals[i] = new Reglamentacio(codi, ubicacio, anyColocacio, significat, random.nextDouble() * 100);
            }
        }

        mostrarSenyals(senyals);
    }

    public static void mostrarSenyals(SenyalTransit[] senyals) {
        for (SenyalTransit senyal : senyals) {
            System.out.println(senyal);
        }
    }
}