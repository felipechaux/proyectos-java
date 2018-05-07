

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Automata {

    public static String[][] transiciones;
    public static String[] cadenas;
    public static String numcadenas;
    public static Map<Integer, String> map_estados, map_simbolos, map_estado_inicial, map_estado_aceptacion;
    public static int estado, simbolo, num;
    public static int band = 0, band2 = 0;

    public static void main(String[] args) throws IOException {
        String respuesta;
        String[] split;

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));


        map_simbolos = new LinkedHashMap<Integer, String>();
        map_estados = new LinkedHashMap<Integer, String>();
        map_estado_inicial = new LinkedHashMap<Integer, String>();
        map_estado_aceptacion = new LinkedHashMap<Integer, String>();


        //System.out.println("ingrese el alfabeto del automata");
        respuesta = buff.readLine();

        for (int i = 0; i < respuesta.length(); i++) {
            map_simbolos.put(i, respuesta.substring(i, i + 1));
        }
        //System.out.println("Estados");
        respuesta = buff.readLine();
        split = respuesta.split(",");
        for (int i = 0; i < split.length; i++) {
            map_estados.put(i, split[i]);
        }
        //System.out.println("Estado inicial");
        respuesta = buff.readLine();
        map_estado_inicial.put(0, respuesta);

        //System.out.println("Estados aceptacion");
        respuesta = buff.readLine();
        split = respuesta.split(",");
        for (int i = 0; i < split.length; i++) {
            map_estado_aceptacion.put(i, split[i]);

        }

        /*System.out.println("Simbolos " + map_simbolos);

        System.out.println("Estados " + map_estados);

        System.out.println("Estado inicial " + map_estado_inicial);

        System.out.println("Estado de aceptacion " + map_estado_aceptacion);*/

        //System.out.println("tamaño de matriz :" + map_estados.size() + " * " + map_simbolos.size());
        transiciones = new String[map_estados.size()][map_simbolos.size()];

        //System.out.println("complete la tabla de transiciones");

        for (int i = 0; i < map_estados.size(); i++) {

            for (int j = 0; j < map_simbolos.size(); j++) {
                // System.out.println("agregando transiciones " + i + " * " + j);
                System.out.print( map_estados.get(i) + "," + map_simbolos.get(j) + " ==> ? ");
                respuesta = buff.readLine();
                //transiciones[i][j] = "transicion #" + cont;
                transiciones[i][j] = respuesta;

            }

        }
       
        //System.out.println("Ingrese el numero de cadenas ");
        numcadenas = buff.readLine();
        cadenas = new String[(Integer.parseInt(numcadenas))];
        for (int i = 0; i < cadenas.length; i++) {
            //System.out.println("Ingrese cadena " + i);
            cadenas[i] = buff.readLine();
        }
        System.out.println("");

        for (int k = 0; k < cadenas.length; k++) {
            num = k + 1;
            System.out.println("Procesando cadena " + num + ": " + cadenas[k]);

            for (int x = 0; x < cadenas[k].length(); x++) {

                if (x == 0) {
                    for (int i = 0; i < map_estados.size(); i++) {

                        if (map_estados.get(i).equals(map_estado_inicial.get(0))) {
                            //  System.out.println("Clave de estado inicial : " + i+ "");
                            estado = i;

                        }
                    }
                    //System.out.println("Clave de estado fuera " + estado);

                    for (int j = 0; j < map_simbolos.size(); j++) {
                        if (map_simbolos.get(j).equals(cadenas[k].substring(0 + x, 1 + x))) {
                            simbolo = j;
                            //   System.out.println("Clave de simbolo: " + j + "");

                        }
                    }
                    //System.out.println("Clave de simbolo fuera " + simbolo);
                    System.out.println("(" + map_estados.get(estado) + "," + cadenas[k].substring(0 + x, 1 + x) + ")==> " + transiciones[estado][simbolo]);

                } else {

                    Procesar((transiciones[estado][simbolo]), (cadenas[k].substring(0 + x, 1 + x)));

                }

            }

            for (int j = 0; j < map_estado_aceptacion.size(); j++) {
                 //evaluacion de condiciones procesando cadenas
                // System.out.println("transiciones  :"+transiciones[estado][simbolo]+" y sus aceptaion :"+map_estado_aceptacion.get(j));
                if (((transiciones[estado][simbolo]).equals(map_estado_aceptacion.get(j)))) {

                    //System.out.println(" SII aceptacion ");
                    //necesario para evitar permitir la cadena vacia cuando se tiene un estado y trancicion  [0][0]
                    if (!cadenas[k].equals("")) {
                        band = 1;
                        break;
                    }

                }
                if (!(transiciones[estado][simbolo]).equals(map_estado_aceptacion.get(j))) {
                    // System.out.println(" NO aceptacion ");
                    band = 0;
                }

                if (((cadenas[k].equals("") && (map_estado_inicial.get(0).equals(map_estado_aceptacion.get(j)))))) {
                    // System.out.println("La cadena vacia si se permite ");
                    band = 1;
                    break;
                }
                if (!((cadenas[k].equals("") && (map_estado_inicial.get(0).equals(map_estado_aceptacion.get(j)))))) {
                    //System.out.println("La cadena vacia NO  se permite ");
                    band = 0;
                }

            }
            if (band == 1) {
                System.out.println("La cadena " + cadenas[k] + " pertenece al lenguaje ");
                System.out.println("");
            } else {
                System.out.println("La  cadena " + cadenas[k] + " NO pertenece al lenguaje ");
                System.out.println("");
            }
        }
    }
    //metodo que procesa el estado final y el simbolo siguiente
    public static void Procesar(String transicion, String cadena) {

        for (int i = 0; i < map_estados.size(); i++) {

            if (map_estados.get(i).equals(transicion)) {
                estado = i;
            }
        }
        for (int i = 0; i < map_simbolos.size(); i++) {
            if (map_simbolos.get(i).equals(cadena)) {
                simbolo = i;
            }
        }
        // System.out.println("clave 2 simbolo es : " + simbolo);
        System.out.println("(" + map_estados.get(estado) + "," + cadena + ")==> " + transiciones[estado][simbolo]);
    }
}
