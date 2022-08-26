/*
Fernando Omar Lopez Morales
 */

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        boolean continuar=false;//para el do while

        Scanner capta= new Scanner(System.in);
        ColaServicio pracola= new ColaServicio();
//        capta.nextLine();//evitar salto
        //lectura masiva atraves de un archivo
        //Archivo de JSON
        String dados = new String(Files.readAllBytes(Paths.get("./informacion.json")));
        JSONArray arreglototal = new JSONArray(dados);
        for(int i = 0; i < arreglototal.length(); i++) {//for para repetir por el numerod de arreglos en el JSON
            JSONObject elementos = arreglototal.getJSONObject(i);
            Object nituser = elementos.get("nitUsuario");
            String problemauser = elementos.getString("problema");
            String queue = elementos.getString("cola");
            String nitrealuser = "";
            if (nituser instanceof Integer) {// if para convertir de int a String
                nitrealuser = nituser.toString();
            } else {
                nitrealuser = nituser.toString();
            }//fin del else
            //Crear Ticket
            //System.out.println("Nit: "+ nituser+"  problema  "+problemauser+" Cola: "+queue);
            Ticket vale = new Ticket(nitrealuser, (i+1), problemauser, "Activo", queue);
            pracola.agregarTicket(vale);
        }//fin del for

        System.out.println("Bienvenido al sistema de Soporte ");
        System.out.println("Por favor ingrese su Nit");
        capta.nextLine();//evitar salto
        System.out.println("Por favor identifique su rol escribiendo el numero indicado");
        //comienzo del do
        do {
            System.out.println("1. Mesa");
            System.out.println("2. Soporte");
            System.out.println("3. Desarrollador");
            int rol = capta.nextInt();

            switch (rol) {
                case 1:
                    pracola.colaMesa();
                    break;
                case 2:
                    pracola.colaSoporte();
                    break;
                case 3:
                    pracola.colaDesarrollo();
                    break;
            }//fin de switch

            System.out.println("Si No desea resolver otro ticket escriba 1, de lo contrario cualquier numero");
            int continua = capta.nextInt();
            if (continua==1){
                continuar=false;
            }
        }while (continuar);
        System.out.println("");
        System.out.println("Reporte 1");
        pracola.reporte1();
        System.out.println("Reporte 2");
        pracola.reporte2();
        System.out.println("Reporte 3");
        pracola.reporte3();

    }//fin de public static void
}//fin de public main