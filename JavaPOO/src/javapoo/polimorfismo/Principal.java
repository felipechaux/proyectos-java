/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapoo.polimorfismo;

/**
 *
 * @author Felipe
 */
public class Principal {

    public static void main(String[] args) {

        Vehiculo misVehiculos[]=new Vehiculo[3];
        
        misVehiculos[0]=new Vehiculo("AXS", "Ford", "A1");
        misVehiculos[1]= new VehiculoDeportivo(1, "SDSDA", "Ferrari", "AA5r");
        misVehiculos[2]= new VehiculoTurismo(4, "AAAD2", "Tirin", "2019");
        
        
        for (Vehiculo vehiculos: misVehiculos){
            System.out.println(""+vehiculos.mostrarDatos());
            System.out.println("");
        }

    }
}
