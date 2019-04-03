/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapoo;

/**
 *
 * @author Felipe
 */
public class JavaPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Planta planta = new Planta();
        
        AnimalCarnivoro animalC = new AnimalCarnivoro();
        
        planta.alimentarse();
        animalC.alimentarse();
      
    }
    
}
