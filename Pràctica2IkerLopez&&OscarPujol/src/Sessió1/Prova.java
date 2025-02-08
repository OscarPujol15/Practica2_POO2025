package Sessió_1;

public class Prova {
    public static void main(String[] args) {
        // Create a new Ubicacio
        Ubicacio ubicacio = new Ubicacio(5, "Carrer Major");
        
        // Create some traffic signals
        Codi codi1 = new Codi(Codi.ADVERTENCIA, 1);
        Codi codi2 = new Codi(Codi.REGLAMENTACIO, 2);
        
        SenyalTransit senyal1 = new SenyalTransit(codi1, ubicacio, 1998);
        SenyalTransit senyal2 = new SenyalTransit(codi2, ubicacio, 2003);
        
        // Ahora sí podemos usar afegirSenyal
        System.out.println("Adding signal 1: " + ubicacio.afegirSenyal(senyal1, 10));
        System.out.println("Adding signal 2: " + ubicacio.afegirSenyal(senyal2, 20));
        
        // Print all signals
        System.out.println("\nAll signals: " + ubicacio.getSenyals());
        
        // Test removing a signal
        System.out.println("\nRemoving signal 1: " + ubicacio.treureSenyal(senyal1));
        
        // Print signals after removal
        System.out.println("Signals after removal: " + ubicacio.getSenyals());
    }
}