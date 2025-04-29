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
        int opcion, tipoCliente, codigo_P, cant1 = 0, cant2 = 0 , cant3 = 0, cant4 = 0;
        double precio, presupuesto = 0;
        
        
        while(true){
            System.out.println("Bienvenido a Caja, que desea hacer?");
            System.out.println("Su Presupuesto es de: " + presupuesto);
            System.out.println("1. Para abrir Caja\n2. Para Ventas\n3. Para Compras\n4. Reportes\n5. Cierre de CAJA\n6. Salir del Sistema");

            opcion = entrada.nextInt();

            switch(opcion){     
                case 1: //Caja
                    System.out.println("Ha abierto caja!\nCuanto desea depositar?");
                    presupuesto = entrada.nextFloat();
                    break;
                case 2: //Venta
                    System.out.println("Bienvenido a ventas\nIntroduzca su tipo de cliente");
                    System.out.println("1. Para A\n2. Para B\n3. Para C");
                    tipoCliente = entrada.nextInt();
                        switch(tipoCliente)
                        {
                            case 1: // Tipo A
                                System.out.println("Codigo de productos:\n1. Azucar\n2. Avena\n3. Trigo\n4. Maiz");
                                System.out.print("Ingrese el Codigo del Producto que desea:");
                                codigo_P = entrada.nextInt();
                                System.out.println("-------------------------------------------------");
                                switch(codigo_P){
                                    case 1:
                                        System.out.println("Ha elegido Azucar! Su precio es de 30 Lps. por kilo");
                                        break;
                                    case 2:
                                        System.out.println("Ha elegido Avena! Su precio es de 25 Lps. por kilo");  
                                        break;
                                    case 3:
                                        System.out.println("Ha elegido Trigo! Su precio es de 32 Lps. por kilo");
                                        break;
                                    case 4:
                                        System.out.println("Ha elegido Maiz! Su precio es de 20 Lps. por kilo");      
                                        break;
                                    default:
                                        System.out.println("Porfavor, introduzca un codigo valido. por kilo");
                                }  
                            case 2: // Tipo B
                                System.out.println("Codigo de productos:\n1. Azucar\n2. Avena\n3. Trigo\n4. Maiz");
                                System.out.print("Ingrese el Codigo del Producto que desea:");
                                codigo_P = entrada.nextInt();
                                System.out.println("-------------------------------------------------");
                                switch(codigo_P){
                                    case 1:
                                        System.out.println("Ha elegido Azucar! Su precio es de 30 Lps. por kilo");
                                        break;
                                    case 2:
                                        System.out.println("Ha elegido Avena! Su precio es de 25 Lps. por kilo");  
                                        break;
                                    case 3:
                                        System.out.println("Ha elegido Trigo! Su precio es de 32 Lps. por kilo"); 
                                        break;
                                    case 4:
                                        System.out.println("Este producto no esta disponible para este tipo de cliente");  
                                        break;
                                    default:
                                        System.out.println("Porfavor, introduzca un codigo valido.");
                                }
                            case 3: // Tipo C
                                System.out.println("Codigo de productos:\n1. Azucar\n2. Avena\n3. Trigo\n4. Maiz");
                                System.out.print("Ingrese el Codigo del Producto que desea:");
                                codigo_P = entrada.nextInt();
                                System.out.println("-------------------------------------------------");
                                 switch(codigo_P){
                                    
                                    case 1:
                                       System.out.println("Este producto no esta disponible para este tipo de cliente");
                                       break;
                                    case 2:
                                       System.out.println("Este producto no esta disponible para este tipo de cliente");
                                        break;
                                    case 3:
                                       System.out.println("Este producto no esta disponible para este tipo de cliente");
                                       break;
                                    case 4:
                                        System.out.println("Ha elegido Maiz! precio es de 25 Lps. por kilo"); 
                                        break;
                                    default:
                                        System.out.println("Porfavor, introduzca un codigo valido.");
                                        
                                }                      
                        }
                case 3: //Compra

                case 4: //Reportes

                case 5: //Cierrie de CAJA

                case 6: //Salir del Sistema
                    break;
                default:
                    System.out.println("****OPCION INVALIDA*****");
            }
        }
        
    }
    
}
