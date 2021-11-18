package com.company;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
    menu();
    }
    public static void menu() throws IOException {
        Scanner sc= new Scanner(System.in);
        String cont="o";
        AdressBook ola= new AdressBook();
        ola.list();
        do{
            System.out.println("Porfavor escoga que es lo que va a querer hacer\n1= Enlistar elementos. 2= Crear nuevo contacto." +
                    "3= Borrar un contacto 0= Salir");
            try{
                int eleccion= Integer.parseInt(sc.next());
                switch (eleccion){
                    case 1:
                        ola.list();
                        break;
                    case 2:
                        System.out.println("Cual es el numero del contacto nuevo?");String numero= sc.next();
                        System.out.println("Cual es el nombre del contacto nuevo?");String nombre= sc.next();
                        ola.create(numero, nombre);
                        break;
                    case 3:
                        System.out.println("Cuál es el numero del contacto a eleminar?");String num= sc.next();
                        ola.delete(num);
                        break;
                    case 0:
                        //ola.Save();
                        cont="n";
                        break;
                    default:
                        System.out.println("Opción Invalida, vuelva a escoger");
                        break;
                }}catch(java.lang.NumberFormatException exception){
                System.out.println("----No escribiste un numero intenta de nuevo---");}
        }while(cont.equals("o"));
    }
}
