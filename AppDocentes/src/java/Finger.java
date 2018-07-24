
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class Finger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        String home = System.getProperty("user.home");
        System.out.println("home " + home + "\\Downloads");

        String sDirectorio = "Downloads";
        File f = new File(home + "\\Downloads\\");

        if (f.exists()) {
            System.out.println("existe directorio");
        } else {
            System.out.println("no existe directorio");
        }
        File[] ficheros = f.listFiles();
      //  Arrays.sort(ficheros);
        for (int x = 0; x < ficheros.length; x++) {
            System.out.println(ficheros[x].getName());
           // System.out.println("orrden");
//            if(ficheros[x].getName().equals("jsfReporte.xls")){
//                System.out.println("si existe felipe");
//            }else{
//                System.out.println("no existe felipe");
//            }
            
        }

//        Date fechaActual2=new Date();
//        
//        SimpleDateFormat fechaFormat,horaFormat;
//        
//        fechaFormat = new SimpleDateFormat("yyyy-dd-MM");
//        horaFormat=new SimpleDateFormat("HH:mm");
//        
//        System.out.println("hora "+horaFormat.format(fechaActual));
//        
//  
//        System.out.println("actual fecha ->"+fechaFormat.format(fechaActual));
//        String hora1H = "13";
//        String hora1M = "00";
//
//        String hora2H = "13";
//        String hora2M = "10";
//
//        int hora1 = Integer.parseInt(hora1H);
//        int min1 = Integer.parseInt(hora1M);
//
//        int hora2 = Integer.parseInt(hora2H);
//        int min2 = Integer.parseInt(hora2M);
//
//        System.out.println("hora1 : " + hora1 + " minutos1 " + min1);
//        System.out.println("hora2 : " + hora2 + " minutos2 " + min2);
//
////        int hora1, min1, hora2, min2; // ...
//        int horamin1 = hora1 * 60 + min1;
//        int horamin2 = hora2 * 60 + min2;
//        int totalminutos = horamin2 - horamin1;
//        if (totalminutos < 0) {
//            totalminutos += 60 * 24; // intervalo corta medianoche
//        }
//        //horas -> totalminutos > h * 60
//        System.out.println("minutos transcurridos  -> " + totalminutos);
//        boolean bool = totalminutos == 10;
//        System.out.println(" -> " + bool);
    }

}
