/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_programacion_caja;
import java.util.Scanner;
/**
 *
 * @author Samuel Vasquez
 */
public class Proyecto_Programacion_Caja {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0, tipoCliente, codigo_P,rep;
        double precio = 0, presupuesto = 0, caja, subtotal = 0;
        double totPrecVen = 0;
        double cant, cantAzucar = 0, cantTrigo = 0, cantMaiz = 0, cantAvena = 0;
        double mayorGanancia = 0, volVentas = 0 , volCompras = 0, mayorGasto = 0;
        int cantVent = 0  ,permiso = 0;;
        
        
        while(opcion != 6){
            System.out.println("Bienvenido a Caja del Megasuper Sami's");
            System.out.println("--------------------------------------");        
            System.out.println("1. Para abrir Caja\n2. Para Ventas\n3. Para Compras\n4. Reportes\n5. Cierre de CAJA\n6. Salir del Sistema");
            System.out.println("--------------------------------------");
            System.out.print("Introduzca un numero para la opcion que desea usar:");
            opcion = entrada.nextInt();

            switch(opcion){     
                case 1: //Caja
                    System.out.println("Ha abierto caja!\nCuanto desea depositar?");
                    caja = entrada.nextFloat();
                    presupuesto += caja;
                    System.out.println("Caja abierta con: Lps. " + String.format("%.2f", caja));
                    break;
                case 2: //Venta
                    if(presupuesto <= 0){
                         System.out.println("\n*******ERROR, Primero debe abrir la caja.*******\n");
                         break;
                    }else{ 
                    
                    System.out.println("Bienvenido a ventas\nIntroduzca su tipo de cliente");
                    System.out.println("1. Para A\n2. Para B\n3. Para C");
                    tipoCliente = entrada.nextInt();
                      if(tipoCliente != 1 && tipoCliente != 2 && tipoCliente != 3){
                        System.out.println("ERROR, introduzca un codigo valido");
                        break;
                    
                    }
                      
                    do{
                    System.out.println("Introduzca el codigo del producto\n1.Azucar\n2.Avena\n3.Trigo\n4.Maiz");
                    codigo_P = entrada.nextInt();
                    
                   
                    String nombre;
                    
                    
                    switch(codigo_P){
                            case 1:
                                if(tipoCliente == 1 || tipoCliente == 2 ) permiso = 1;
                                nombre = "Azucar";
                                precio = 30;
                                break;
                            case 2:
                                permiso = 1;
                                nombre = "Avena";
                                precio = 25;
                                break;              
                            case 3:
                                if(tipoCliente == 1 || tipoCliente == 2 ) permiso = 1;
                                nombre = "Trigo";
                                precio = 32;
                                break;  
                            case 4:
                                if(tipoCliente == 1 || tipoCliente == 3 ) permiso = 1;
                                nombre = "Maiz";
                                precio = 20;
                                break; 
                            default:
                                System.out.println("Porfavor, introduzca un codigo valido");     
                        }
                    
                        if(permiso ==1){
                            System.out.println("Introduzca la cantidad que quiere en kg (kilogramos):");
                            double kg = entrada.nextDouble();
                            double tot = precio*kg;
                            subtotal += tot;
                            totPrecVen += precio;
                            cantVent++;
                            
                            switch(codigo_P){
                                case 1: cantAzucar += kg; break;
                                case 2: cantAvena += kg; break;
                                case 3: cantTrigo += kg; break;  
                                case 4: cantMaiz += kg; break;
                            
                            }
                        }else{
                               System.out.println("\nERROR, no puede comprar este producto\n");
                               break;
                        }
                        System.out.println("Desea agregar otro producto?\n0-No\n1-Si");
                        rep = entrada.nextInt();
                    } while(rep == 1);
                    
                        if(permiso ==1){
                        double descuento = 0;
                        double impuesto = subtotal * 0.07;
                        if(subtotal >= 5000) descuento = subtotal * 0.10;
                        else if(subtotal >= 1000) descuento = subtotal * 0.05;
                        
                        double totpagar = subtotal + impuesto - descuento;
                    
                        System.out.println("-----------------FACTURA-----------------");
                        System.out.println("Subtotal: Lps." + String.format("%.2f", subtotal));
                        System.out.println("Impuesto: Lps." + String.format("%.2f", impuesto));
                        System.out.println("Descuento: Lps." + String.format("%.2f", descuento));
                        System.out.println("Total a Pagar: Lps." + String.format("%.2f", totpagar));
                        System.out.println("-----------------------------------------\n");
                        
                        presupuesto += totpagar;
                        volVentas += totpagar;
                        
                        double ganancia = subtotal - descuento;
                        if(ganancia > mayorGanancia) mayorGanancia = ganancia;
                        }
                    }
                    break;
                case 3: //Compra

                case 4: //Reportes

                case 5: //Cierrie de CAJA

                case 6: //Salir del Sistema
                    System.out.println("Fin del Programa, gracias por utilizarlo!");
                    break;
                default:
                    System.out.println("****OPCION INVALIDA*****");
            }
        }
        
    }
    
}
