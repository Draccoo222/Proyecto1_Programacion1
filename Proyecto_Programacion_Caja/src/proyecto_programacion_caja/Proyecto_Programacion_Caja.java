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
        double presupuesto = 0, caja;
        double precio = 0, totPrecVen = 0, subtotal = 0;
        double cant, cantAzucar = 0, cantTrigo = 0, cantMaiz = 0, cantAvena = 0;
        double stockAzucar = 0, stockTrigo = 0, stockMaiz = 0, stockAvena = 0;
        double mayorGanancia = 0, volVentas = 0, volCompras = 0, mayorGasto = 0, medioCompras = 0, medioVentas = 0;
        int cantVent = 0, cantCompras = 0, permiso = 0;;
        
        
        while(opcion != 6){
            System.out.println("======Bienvenido a Caja del Megasuper Sami's======");
            System.out.println("1. Para abrir Caja\n2. Para Ventas\n3. Para Compras\n4. Reportes\n5. Cierre de CAJA\n6. Salir del Sistema");
            System.out.println("==================================================");
            System.out.print("Introduzca un numero para la opcion que desea usar: ");
            opcion = entrada.nextInt();
            System.out.println("==================================================");
            switch(opcion){     
                case 1: //Caja
                    System.out.println("Ha abierto caja! Cuanto desea depositar?");
                    System.out.print("Introduzca cantidad que quiere depositar: ");
                    caja = entrada.nextDouble();
                    presupuesto += caja;
                    System.out.println("Caja abierta con: Lps. " + String.format("%.2f", presupuesto));
                    break;
                case 2: //Venta
                    String prodVen = "";
                    String nombre = "";
                    subtotal = 0;
                    double kg = 0;
                    if(presupuesto <= 0){
                        System.out.println("\n*******ERROR, Primero debe abrir la caja.*******\n");
                         try{
                               Thread.sleep(2000);
                             }  
                        catch(Exception e){
                                break;
                             }
                    }else if(stockAvena  == 0 && stockTrigo == 0 && stockAzucar == 0 && stockMaiz == 0 ){
                         System.out.println("\n*******ERROR, Nesecita por lo menos tener un producto en stock!.*******\n");
                        try{
                            Thread.sleep(2000);
                        }  
                        catch(Exception e){
                            break;
                             }
                    }else{                   
                    System.out.println("Bienvenido a ventas\nIntroduzca su tipo de cliente");
                    System.out.println("1. Para A\n2. Para B\n3. Para C");
                    tipoCliente = entrada.nextInt();
                      if(tipoCliente != 1 && tipoCliente != 2 && tipoCliente != 3){
                        System.out.println("ERROR, introduzca un codigo valido");
                        try{
                            Thread.sleep(2000);
                        }  
                        catch(Exception e){
                            break;
                        }
                    }
                    do{
                        permiso = 0;              
                        System.out.println("Introduzca el codigo del producto\n1.Azucar\n2.Avena\n3.Trigo\n4.Maiz");
                        codigo_P = entrada.nextInt();
                        
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
                                break;
                        }
                        if(permiso ==1){
                            System.out.println("Introduzca la cantidad que quiere en kg (kilogramos):");
                            kg = entrada.nextDouble();
                            double tot = precio*kg;
                            subtotal += tot;
                            totPrecVen += precio;
                            
                            
                            switch(codigo_P){
                                case 1: cantAzucar += kg; stockAzucar -= kg; break;
                                case 2: cantAvena += kg;  stockAvena -= kg;; break;
                                case 3: cantTrigo += kg;  stockTrigo -= kg; break;  
                                case 4: cantMaiz += kg;   stockMaiz -= kg; break;
                            
                            }
                        }else{
                             System.out.println("\nERROR, no puede comprar este producto\n");
                             try{
                               Thread.sleep(2000);
                             }  
                             catch(Exception e){  
                                break;  
                             }  
                        }
                        prodVen += ", " + nombre + " " + kg + "kg";
                        System.out.println("Desea agregar otro producto?\n0-No\n1-Si");
                        rep = entrada.nextInt();
                    } while(rep == 1);
                    
                        if(permiso ==1){
                        double descuento = 0;
                        double impuesto = subtotal * 0.07;
                        if(subtotal >= 5000) descuento = subtotal * 0.10;
                        else if(subtotal >= 1000) descuento = subtotal * 0.05; 
                        double totpagar = subtotal + impuesto - descuento;
                        
                        System.out.println("*************************************FACTURA*************************************");
                        System.out.println(String.format("%-25s Lps. %.2f", "Producto(s) Vendido(s) y Cantidad:", prodVen.substring(2, prodVen.length())));
                        System.out.println(String.format("%-25s Lps. %.2f", "Subtotal:", subtotal));
                        System.out.println(String.format("%-25s Lps. %.2f", "Impuesto (7%):", impuesto));
                        System.out.println(String.format("%-25s Lps. %.2f", "Descuento:", descuento));
                        System.out.println(String.format("%-25s Lps. %.2f", "Total a pagar:", totpagar));
                        System.out.println("*********************************************************************************\n");
                        
                        presupuesto += totpagar;
                        volVentas += totpagar;
                        medioVentas += totpagar;
                        permiso = 0;
                        nombre = "";
                        cantVent++;
                        double ganancia = subtotal - descuento;
                        if(ganancia > mayorGanancia) mayorGanancia = ganancia;
                        }
                    }
                    break;
                case 3: //Compra
                    if(presupuesto <= 0){
                        System.out.println("\n*******ERROR, Primero debe abrir la caja.*******\n");
                         try{
                               Thread.sleep(2000);
                             }  
                        catch(Exception e){
                                break;
                             }
                     }else{
                    System.out.println("Bienvenido a compras!");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Stock de Avena: en kg (kilogramos)" + String.format("%.2f", stockAvena));
                    System.out.println("Stock de Trigo: en kg (kilogramos)" + String.format("%.2f", stockTrigo));
                    System.out.println("Stock de Maiz: en kg (kilogramos)" + String.format("%.2f", stockMaiz));
                    System.out.println("Stock de Azucar: en kg (kilogramos)" + String.format("%.2f", stockAzucar));
                    System.out.println("-------------------------------------------------------------");
                    System.out.print("Porfavor, seleccione un proveedor introduciendo el numero que lo representa (1-A, 2-B, 3-C): ");
                    int prov = entrada.nextInt();
                        if(prov != 1 && prov != 2 && prov != 3){
                            System.out.println("ERROR, introduzca un codigo valido");
                            try{
                                Thread.sleep(2000);
                            }  
                            catch(Exception e){
                                break;
                            }
                        }
                    System.out.println("Introduzca el codigo del producto\n1.Azucar\n2.Avena\n3.Trigo\n4.Maiz");
                    codigo_P = entrada.nextInt();
                    nombre = "";
                    permiso = 0;
                        switch(codigo_P){
                                case 1:
                                    if (prov == 1)  permiso = 1;
                                    nombre = "Azucar";
                                    precio = 30;
                                    break;
                                case 2:
                                    if (prov == 2 || prov == 3) permiso = 1; 
                                    nombre = "Avena";
                                    if (prov == 2) precio = 20; else precio = 25;
                                    break;              
                                case 3:
                                    if (prov == 2 || prov == 3)  permiso = 1;
                                    nombre = "Trigo";
                                    precio = 32;
                                    break;  
                                case 4:
                                    if (prov == 1)  permiso = 1;
                                    nombre = "Maiz";
                                    precio = 20;
                                    break; 
                                default:
                                    System.out.println("Porfavor, introduzca un codigo valido");    
                                    break;
                            }
                        if(permiso == 1){
                            System.out.print("Introduzca cuanto quiere comprar del producto (en kilogramos):");
                            kg = entrada.nextInt();
                            subtotal = precio*kg;                           
                            if(presupuesto>= subtotal){
                                cantCompras++;
                                double total = presupuesto - subtotal;    
                                switch(codigo_P){
                                    case 1:
                                        stockAzucar += kg; break;
                                    case 2:
                                        stockAvena += kg; break;
                                    case 3:
                                        stockTrigo += kg; break;
                                    case 4:
                                        stockMaiz += kg; break;
                                }
                                System.out.println("******Factura de Compra*****");
                                System.out.println("Producto Comprado: " + nombre);
                                System.out.println("Cantidad Comprada: " + kg + "kg");
                                System.out.println("Total a pagar: " + subtotal);
                                System.out.println("Presupuesto: " + presupuesto);

                                presupuesto -= subtotal;
                                volCompras += subtotal;
                                medioCompras += subtotal;
                                System.out.println("Presupuesto final: " + presupuesto);
                                
                                if(subtotal > mayorGasto) mayorGasto = subtotal;
                            }
                            else{
                                System.out.println("No se puede comprar");
                                break;
                           }
                        }
                        else{
                            System.out.println("Proveedor no cuenta con dicho producto");
                        }
                    }
                    break;
                case 4: //Reportes
                    System.out.println("Cantidad en la caja: " + String.format("%.2f", presupuesto) + "Lps.");
                    System.out.println("Numero de Compras: " + cantCompras);
                    System.out.println("Numero de Ventas : " + cantVent);
                    
                    medioCompras = medioCompras/cantCompras;
                    medioVentas =  medioVentas/cantVent;
                   
                    System.out.println("Valor Medio de Ventas: " + String.format("%.2f", medioVentas) + "Lps.");
                    System.out.println("Valor Medio de Compras: " + String.format("%.2f", medioCompras) + "Lps.");
                    
                    double margenGan = volVentas - volCompras;
                    System.out.println("Margen de Ganancia Neta: " + String.format("%.2f", margenGan) + "Lps.");
                    System.out.println("Volumen de Compras: " + String.format("%.2f", volCompras) + "Lps." );       
                    System.out.println("Volumen de Ventas: " +  String.format("%.2f", volVentas) + "Lps." );
                    
                    System.out.println("Venta con Mayor Ganancia: " + String.format("%.2f", mayorGanancia) + "Lps.");
                    System.out.println("Compra con Mayor Gasto: " + String.format("%.2f", mayorGasto) + "Lps.");
                    
                    //Calculo del producto estrella
                    double mayorCant = 0;
                    String prodGanadores = "";
                    if(cantAzucar > mayorCant && cantAzucar == mayorCant){
                        mayorCant = cantAzucar;
                        prodGanadores += "Azucar" + ", ";
                    }
                    if(cantAvena > mayorCant && cantAvena == mayorCant){
                        mayorCant = cantAvena;
                        prodGanadores += "Avena" + ", ";
                    }
                    if(cantTrigo > mayorCant && cantTrigo == mayorCant){
                        mayorCant = cantTrigo;
                        prodGanadores += "Trigo" + ", ";
                    }
                    if(cantMaiz  > mayorCant && cantMaiz == mayorCant){
                        mayorCant = cantMaiz;
                        prodGanadores += "Maiz" + ", ";
                    }
                    if (mayorCant == 0) {
                       System.out.println("Producto(s) Estrella: " + prodGanadores);
                    }
                    else{
                    System.out.println("Producto(s) Estrella: " + prodGanadores.substring(0, prodGanadores.length() - 2));}
                    break;
                case 5: //Cierrie de CAJA

                case 6: //Salir del Sistema
                    System.out.println("Fin del Programa, gracias por utilizarlo!");
                    break;
                default:
                    System.out.println("****OPCION INVALIDA*****");
                    break;
            }
        }
        
    }
    
}
