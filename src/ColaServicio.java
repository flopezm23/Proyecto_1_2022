import jdk.swing.interop.SwingInterOpUtils;
/*
Fernando Omar Lopez Morales
 */

import java.sql.Array;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
/*
Fernando Omar Lopez Morales 7690-21-20755
 */
public class ColaServicio extends Main {
 // En esta classe se maneja el estado de los tickets
    Scanner pegar = new Scanner(System.in);
Date hoje = new Date(); //variable para la fecha y hora
 Bitacora [] steps= new Bitacora[100]; //variable local para almacenar los datos del objeto anterior
 Ticket[] passos=new Ticket[100];
int contador=0;//variable para llevar el conteo de las bitacoras por que cada acción es un evento en la vitacora
int numeroTicket=0;//contador de tickets

 public void agregarTicket(Ticket novo){
  passos[numeroTicket]=novo; //todo nuevo ticket es almacenado
  numeroTicket++;//para cambiar al proximo espacio en el array

  Bitacora p = new Bitacora(contador,novo.getNitUsuario(),hoje," No hay mensaje aun "," Ticket creado");//crear bitacoras
  steps[contador]= p;//para almacenar las bitacoras en el arreglo steps
  contador++;

 }//final agregarTicket

 public void colaMesa(){
    //for para encontrar un ticket a trabajar
     String mensaje=""; //variable para obtener el mensaje
     int enough=0;//variable para solo tomar 1 ticket
     int identificador=0;//variable para marcar el objeto a revisar
     for(int j=0;j<(numeroTicket);j++){//for para mostrar los tickets
         if(passos[j].getCola().equals("mesa")&& passos[j].getEstado()=="Activo"&&enough==0) {//este if sirve para que solo obtenga 1 ticket por vez
             System.out.println("Ticket disponible para trabajar");
             System.out.println("Nit del usuario: " + passos[j].getNitUsuario() + " Identificacion: " + passos[j].getId() + " Problema: " + passos[j].getProblema() + " Estado: " + passos[j].getEstado() + " " + passos[j].getCola());
             identificador=j;
             enough++;
         }//fin del if
     }//fin del for
     System.out.println("Se resolvio el problema?, responde con un numero");
     System.out.println("1. SI");
     System.out.println("2. NO");
     int answer=pegar.nextInt();//captura de la respuesta

     if(answer==1){//si resolvio el problema
         System.out.println("Como resolviste el problema?");
         pegar.nextLine();//para evitar el salto
         mensaje=pegar.nextLine();//variable para capturar el mensaje
         passos[identificador].setCola("Cola Atendidos");//para actualizar el ticket de esta cola
         passos[identificador].setEstado(" Resuelto");
         Bitacora p = new Bitacora(contador,passos[identificador].getNitUsuario(),hoje,mensaje," Resuelto");//crear bitacoras
         steps[contador]= p;//para almacenar las bitacoras en el arreglo steps
     }
     if(answer==2){
         System.out.println("el ticket fue escalado");
         passos[identificador].setCola("soporte");//para actualizar el ticket de esta cola
         //colaSoporte(passos[identificador],identificador);//esta funcion activa el proximo departamento, no necesario para fines practicos
         Bitacora p = new Bitacora(contador,passos[identificador].getNitUsuario(),hoje,mensaje," Asignado a cola de soporte");//crear bitacoras
         steps[contador]= p;//para almacenar las bitacoras en el arreglo steps
     }
  contador++;
 }//final colaMesa

 public void colaSoporte(){ //el int ticket es para identificar el numero en el arreglo del ticket escalado
//for para encontrar un ticket a trabajar
     String mensaje=""; //variable para obtener el mensaje
     int enough1=0;//variable para solo tomar 1 ticket
     int identificador=0;//variable para marcar el objeto a revisar
     for(int j=(numeroTicket-1);j>0;j--){//for para mostrar los tickets, en este caso comienza revisar desde el ultimo
         if(passos[j].getCola().equals("soporte")&& passos[j].getEstado()=="Activo"&&enough1==0) {//este if sirve para que solo obtenga 1 ticket por vez
             System.out.println("Ticket disponible para trabajar");
             System.out.println("Nit del usuario: " + passos[j].getNitUsuario() + " Identificacion: " + passos[j].getId() + " Problema: " + passos[j].getProblema() + " Estado: " + passos[j].getEstado() + " " + passos[j].getCola());
             identificador=j;
             enough1++;
         }//fin del if
     }//fin del for

     System.out.println("Se resolvio el problema?, responde con un numero");
     System.out.println("1. SI");
     System.out.println("2. NO");
     int answer=pegar.nextInt();//captura de la respuesta

     if(answer==1){
         System.out.println("Como resolviste el problema?");
         pegar.nextLine();//para evitar el salto
         mensaje=pegar.nextLine();//variable para capturar el mensaje
         passos[identificador].setCola("Cola Atendidos");//para actualizar el ticket de esta cola
         passos[identificador].setEstado(" Resuelto");
         Bitacora p = new Bitacora(contador,passos[identificador].getNitUsuario(),hoje,mensaje," Resuelto");//crear bitacoras
         steps[contador]= p;//para almacenar las bitacoras en el arreglo steps
     }//final if
     if(answer==2){
         System.out.println("el ticket fue escalado");
         passos[identificador].setCola("desarrollo");//para actualizar el ticket de esta cola
         //colaSoporte(passos[identificador],identificador);//esta funcion activa el proximo departamento, no necesario para fines practicos
         Bitacora p = new Bitacora(contador,passos[identificador].getNitUsuario(),hoje,mensaje," Asignado a cola de desarrollador");//crear bitacoras
         steps[contador]= p;//para almacenar las bitacoras en el arreglo steps
     }//final if
  contador++;
 }//final colaSoporte

 public void colaDesarrollo(){
     //for para encontrar un ticket a trabajar
     String mensaje=""; //variable para obtener el mensaje
     int enough=0;//variable para solo tomar 1 ticket
     int identificador=0;//variable para marcar el objeto a revisar

     //asignacion de un ticket random

     for(int j=0;j<(numeroTicket);j++){//for para mostrar los tickets
         Random sx = new Random();
         int x= sx.nextInt((numeroTicket - 0) + 1) + 0;
         if(x<numeroTicket){
     if(passos[x].getCola().equals("desarrollo")&& passos[x].getEstado()=="Activo"&&enough==0) {//este if sirve para que solo obtenga 1 ticket por vez
         System.out.println("Ticket disponible para trabajar");
         System.out.println("Nit del usuario: " + passos[x].getNitUsuario() + " Identificacion: " + passos[x].getId() + " Problema: " + passos[x].getProblema() + " Estado: " + passos[x].getEstado() + " " + passos[x].getCola());
         identificador = x;
         enough++;
     }//fin del if del x
     }//fin del if
     }//fin del for
     //fin del ticket random

         System.out.println("Como resolviste el problema?");
         pegar.nextLine();//para evitar el salto
         mensaje=pegar.nextLine();//variable para capturar el mensaje
         passos[identificador].setCola("Cola Atendidos");//para actualizar el ticket de esta cola
         passos[identificador].setEstado(" Resuelto");
         Bitacora p = new Bitacora(contador,passos[identificador].getNitUsuario(),hoje,mensaje," Resuelto");//crear bitacoras
         steps[contador]= p;//para almacenar las bitacoras en el arreglo steps

  contador++;
 }//final colaDesarrollo

public void mostrarcolaMesa(){
    System.out.println("TICKETS");
    for(int j=0;j<(numeroTicket+1);j++){//for para mostrar los tickets
        if(passos[j].getCola().equals("mesa")) {
            System.out.printf("Nit del usuario: " + passos[j].getNitUsuario() + " Identificacion: " + passos[j].getId() + " Problema: " + passos[j].getProblema() + " Estado: " + passos[j].getEstado() + " " + passos[j].getCola());
        }//fin del if
    }//fin del for
}//fin mostrarcolaMesa
public void reporte1(){ //funcion para mostrar los resultados, reporte1
    System.out.println("BITACORAS");
  for(int i=0;i<(contador);i++){//for para mostrar las bitacoras
      System.out.println("00"+steps[i].getCorrelativo()+" Nit:"+steps[i].getNitSoporte()+" Fecha y Hora: "+steps[i].getFechaHora()+"Mensaje: "+steps[i].getMensaje()+" Evento: "+steps[i].getEvento());
  }//fin del for
    System.out.println("TICKETS");
  for(int j=0;j<(numeroTicket);j++){//for para mostrar los tickets
      System.out.println("Nit del usuario: "+passos[j].getNitUsuario()+" Identificacion: "+passos[j].getId()+" Problema: "+passos[j].getProblema()+" Estado: "+passos[j].getEstado()+" "+passos[j].getCola());
  }//fin del for
}//fin de mostrar

    public void reporte2(){//tickets por cola
        System.out.println("TICKETS");
        System.out.println("Cola Mesa");
        for(int j=0;j<(numeroTicket);j++){//for para mostrar los tickets
            if (passos[j].getCola().equals("mesa")) {//if para identificar una cola especifica
                System.out.println("Nit del usuario: " + passos[j].getNitUsuario() + " Identificacion: " + passos[j].getId() + " Problema: " + passos[j].getProblema() + " Estado: " + passos[j].getEstado() + " " + passos[j].getCola());
            }//fin if
        }//fin del for
        System.out.println("Cola Soporte");
        for(int j=0;j<(numeroTicket);j++){//for para mostrar los tickets de la cola soporte
            if (passos[j].getCola().equals("soporte")) {//if para identificar una cola especifica
                System.out.println("Nit del usuario: " + passos[j].getNitUsuario() + " Identificacion: " + passos[j].getId() + " Problema: " + passos[j].getProblema() + " Estado: " + passos[j].getEstado() + " " + passos[j].getCola());
            }//fin if
        }//fin del for
        System.out.println("Cola Desarrolladores");
        for(int j=0;j<(numeroTicket);j++){//for para mostrar los tickets
            if (passos[j].getCola().equals("desarrollo")) {//if para identificar una cola especifica
                System.out.println("Nit del usuario: " + passos[j].getNitUsuario() + " Identificacion: " + passos[j].getId() + " Problema: " + passos[j].getProblema() + " Estado: " + passos[j].getEstado() + " " + passos[j].getCola());
            }//fin if
        }//fin del for
        System.out.println("Tickets resueltos");
        for(int j=0;j<(numeroTicket);j++){//for para mostrar los tickets resueltos
            if (passos[j].getEstado()==" Resuelto") {//if para identificar una cola especifica
                System.out.println("Nit del usuario: " + passos[j].getNitUsuario() + " Identificacion: " + passos[j].getId() + " Problema: " + passos[j].getProblema() + " Estado: " + passos[j].getEstado() + " " + passos[j].getCola());
            }//fin if
        }//fin del for

    }//fin reporte 2

    public void reporte3(){
        for(int j=0;j<(numeroTicket);j++){//for para mostrar los tickets
            System.out.println("TICKET");
            System.out.println("Nit del usuario: "+passos[j].getNitUsuario()+" Identificacion: "+passos[j].getId()+" Problema: "+passos[j].getProblema()+" Estado: "+passos[j].getEstado()+" "+passos[j].getCola());
            String avaliador=passos[j].getNitUsuario();
            System.out.println("BITACORAS");
            for(int i=0;i<(contador);i++){//for para mostrar las bitacoras
                if(avaliador==steps[i].getNitSoporte()) {//condicional para mostrar solo las bitacoras de este usuario
                    System.out.println("Numero de ticket____NIT___________________Fecha y Hora____________________________Mensaje_______________________________Evento_____________________");
                    String ceros1="000";
                    String ceros2="00";
                    if(steps[i].getCorrelativo()<=9) {
                        System.out.println(ceros1 + steps[i].getCorrelativo() + "               " + steps[i].getNitSoporte() + "           " + steps[i].getFechaHora() + "        " + steps[i].getMensaje() + "                     " + steps[i].getEvento());
                    }else{
                        System.out.println(ceros2 + steps[i].getCorrelativo() + "               " + steps[i].getNitSoporte() + "           " + steps[i].getFechaHora() + "        " + steps[i].getMensaje() + "                     " + steps[i].getEvento());
                    }//final else
                }//fin if
            }//fin del for
        }//fin del for de tickets
    }//fin reporte3

}
