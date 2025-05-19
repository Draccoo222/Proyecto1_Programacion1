/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_programacion_caja;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Samuel Vasquez
 */
public class Proyecto_Programacion_Caja{

    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        int opcion = 0, tipoCliente, codigo_P, rep;
        int cantVent = 0, cantCompras = 0, permiso = 0;;
        double presupuesto = 0, caja;
        double precio = 0, subtotal = 0;
        double cantAzucar = 0, cantTrigo = 0, cantMaiz = 0, cantAvena = 0;
        double stockAzucar = 0, stockTrigo = 0, stockMaiz = 0, stockAvena = 0;
        double mayorGanancia = 0, volVentas = 0, volCompras = 0, mayorGasto = 0, medioCompras = 0, medioVentas = 0;
        boolean cajaAbierta = false, cajaCerrada = false;

        while (opcion != 6) {
            System.out.println("\n======Bienvenido a Caja del Megasuper Sami's======");
            System.out.println("1. Para abrir Caja\n2. Para Ventas\n3. Para Compras\n4. Reportes\n5. Cierre de CAJA\n6. Salir del Sistema");
            System.out.println("==================================================");
            System.out.print("Introduzca un numero para la opcion que desea usar: ");
            try {
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1: //Caja
                        System.out.println("--------- ABRIR CAJA ---------");
                        System.out.print("Introduzca cantidad que quiere depositar: ");
                        caja = entrada.nextDouble();
                        if (caja >= 0) {
                            presupuesto += caja;
                            System.out.println("Caja abierta con: Lps. " + String.format("%.2f", presupuesto));
                            cajaAbierta = true;
                        } else {
                            System.out.println("\n******Porfavor, solamente puede agregar numeros mayores a 0******\n");
                            Thread.sleep(2000);
                        }
                        break;
                    case 2: //Venta
                        String prodVen = "";
                        String nombre = "";
                        subtotal = 0;
                        rep = 1;
                        double kg = 0;
                        if (cajaAbierta == false) {
                            System.out.println("\n>>>>ERROR, Primero debe abrir la caja!\n");
                            Thread.sleep(2000);
                        } else if (stockAvena == 0 && stockTrigo == 0 && stockAzucar == 0 && stockMaiz == 0) {
                            System.out.println("\n>>>>ERROR, Nesecita por lo menos tener un producto en stock!\n");
                            Thread.sleep(2000);
                        } else {
                            System.out.println("\n------------- VENTAS ------------");
                            System.out.print("Introduzca su tipo de cliente Segun el numero que lo representa ([1]Cliente A, [2]Cliente B, [3]Cliente C)");
                            tipoCliente = entrada.nextInt();
                            if (tipoCliente != 1 && tipoCliente != 2 && tipoCliente != 3) {
                                System.out.println("\n>>>>ERROR, introduzca un codigo valido\n");
                                Thread.sleep(2000);
                            }
                            do {
                                permiso = 0;
                                System.out.print("Introduzca el codigo del producto ([1]Azucar, [2]Avena, [3]Trigo, [4]Maiz): ");
                                codigo_P = entrada.nextInt();
                                switch (codigo_P) {
                                    case 1:
                                        if (tipoCliente == 1 || tipoCliente == 2) {
                                            permiso = 1;
                                        }
                                        nombre = "Azucar";
                                        precio = 30;
                                        break;
                                    case 2:
                                        permiso = 1;
                                        nombre = "Avena";
                                        precio = 25;
                                        break;
                                    case 3:
                                        if (tipoCliente == 1 || tipoCliente == 2) {
                                            permiso = 1;
                                        }
                                        nombre = "Trigo";
                                        precio = 32;
                                        break;
                                    case 4:
                                        if (tipoCliente == 1 || tipoCliente == 3) {
                                            permiso = 1;
                                        }
                                        nombre = "Maiz";
                                        precio = 20;
                                        break;
                                    default:
                                        System.out.println("\nPorfavor, introduzca un codigo valido");
                                        break;
                                }
                                if (permiso == 1) {
                                    System.out.println("Costo por kilo de " + nombre + " " + precio + "Lps.");
                                    System.out.print("Introduzca la cantidad que quiere en kg (kilogramos):");
                                    kg = entrada.nextDouble();
                                    double tot;

                                    boolean suficiente = true;
                                    switch (codigo_P) {
                                        case 1:
                                            if (kg > stockAzucar) {
                                                suficiente = false;
                                            }
                                            break;
                                        case 2:
                                            if (kg > stockAvena) {
                                                suficiente = false;
                                            }
                                            break;
                                        case 3:
                                            if (kg > stockTrigo) {
                                                suficiente = false;
                                            }
                                            break;
                                        case 4:
                                            if (kg > stockMaiz) {
                                                suficiente = false;
                                            }
                                            break;

                                    }
                                    if (kg > 0) {
                                        if (suficiente) {
                                            tot = precio * kg;
                                            subtotal += tot;
                                            switch (codigo_P) {
                                                case 1:
                                                    cantAzucar += kg;
                                                    stockAzucar -= kg;
                                                    break;
                                                case 2:
                                                    cantAvena += kg;
                                                    stockAvena -= kg;
                                                    break;
                                                case 3:
                                                    cantTrigo += kg;
                                                    stockTrigo -= kg;
                                                    break;
                                                case 4:
                                                    cantMaiz += kg;
                                                    stockMaiz -= kg;
                                                    break;

                                            }
                                            prodVen += ", " + nombre + " " + kg + "kg";
                                        } else {
                                            System.out.println("\n>>>ERROR, la cantidad solicitada del producto no esta disponible****\n");
                                            Thread.sleep(2000);
                                        }
                                    } else {
                                        System.out.println("\n>>>ERROR, introduzca una cantidad valida");
                                        Thread.sleep(2000);
                                    }
                                    System.out.println("Desea agregar otro producto?\n0-No\n1-Si");
                                    rep = entrada.nextInt();
                                } else {
                                    System.out.println("\n>>>ERROR, no puede comprar este producto\n");
                                    Thread.sleep(2000);
                                }
                            } while (rep == 1);

                            if (permiso == 1) {
                                double descuento = 0;
                                double impuesto = subtotal * 0.07;
                                if (subtotal >= 5000) {
                                    descuento = subtotal * 0.10;
                                } else if (subtotal >= 1000) {
                                    descuento = subtotal * 0.05;
                                }
                                double totpagar = subtotal + impuesto - descuento;

                                System.out.println("\n*************************************FACTURA*************************************");
                                System.out.println(String.format("%-50s", prodVen.substring(2, prodVen.length()), "Producto(s) Vendido(s) y Cantidad:"));
                                System.out.println(String.format("%-50s Lps. %.2f", "Subtotal:", subtotal));
                                System.out.println(String.format("%-50s Lps. %.2f", "Impuesto (7%):", impuesto));
                                System.out.println(String.format("%-50s Lps. %.2f", "Descuento:", descuento));
                                System.out.println(String.format("%-50s Lps. %.2f", "Total a pagar:", totpagar));
                                System.out.println("*********************************************************************************\n");

                                presupuesto += totpagar;
                                volVentas += totpagar;
                                medioVentas += totpagar;
                                permiso = 0;
                                nombre = "";
                                cantVent++;
                                double ganancia = subtotal - descuento;
                                if (ganancia > mayorGanancia) {
                                    mayorGanancia = ganancia;
                                }
                            }
                        }
                        break;
                    case 3: //Compra
                        double kgProv = 0;
                        if (cajaAbierta == false) {
                            System.out.println("\n*******ERROR, Primero debe abrir la caja.*******\n");
                            Thread.sleep(2000);
                        } else {
                            System.out.println("\n------------------------- COMPRAS ---------------------------");
                            System.out.println(String.format("%-25s kg %.2f", "Stock de Azucar:", stockAzucar));
                            System.out.println(String.format("%-25s kg %.2f", "Stock de Avena:", stockAvena));
                            System.out.println(String.format("%-25s kg %.2f", "Stock de Trigo:", stockTrigo));
                            System.out.println(String.format("%-25s kg %.2f", "Stock de Maiz:", stockMaiz));
                            System.out.println("-------------------------------------------------------------");
                            System.out.print("Porfavor, seleccione un proveedor introduciendo el numero que lo representa [1]A, [2]B, [3]C): ");
                            int prov = entrada.nextInt();
                            if (prov != 1 && prov != 2 && prov != 3) {
                                System.out.println("\n*****ERROR, introduzca un codigo valido*****\n");
                            } else {
                                System.out.print("Introduzca el codigo del producto ([1]Azucar, [2]Avena, [3]Trigo, [4]Maiz): ");
                                codigo_P = entrada.nextInt();
                                nombre = "";
                                permiso = 0;
                                switch (codigo_P) { // se crea un switch del codigo que introdujo el cliente para dar permiso de vender para cada proveedor
                                    case 1:
                                        if (prov == 1) {
                                            permiso = 1;
                                        }
                                        nombre = "Azucar";
                                        precio = 25;
                                        break;
                                    case 2:
                                        if (prov == 2 || prov == 3) {
                                            permiso = 1;
                                        }
                                        nombre = "Avena";
                                        if (prov == 2) {
                                            precio = 20;
                                        } else {
                                            precio = 22;
                                        }
                                        break;
                                    case 3:
                                        if (prov == 2 || prov == 3) {
                                            permiso = 1;
                                        }
                                        nombre = "Trigo";
                                        precio = 30;
                                        break;
                                    case 4:
                                        if (prov == 1) {
                                            permiso = 1;
                                        }
                                        nombre = "Maiz";
                                        precio = 18;
                                        break;
                                    default:
                                        System.out.println("Porfavor, introduzca un codigo valido");
                                        break;
                                }
                                if (permiso == 1) // Se revisa que el producto tenga permiso para ser vendido
                                {
                                    System.out.print("Introduzca cuanto quiere comprar del producto (en kilogramos):");
                                    kgProv = entrada.nextDouble();
                                    subtotal = precio * kgProv;
                                    if (kgProv > 0) {
                                        if (presupuesto >= subtotal) {
                                            cantCompras++;
                                            double total = presupuesto - subtotal;
                                            switch (codigo_P) {
                                                case 1:
                                                    stockAzucar += kgProv;
                                                    break;
                                                case 2:
                                                    stockAvena += kgProv;
                                                    break;
                                                case 3:
                                                    stockTrigo += kgProv;
                                                    break;
                                                case 4:
                                                    stockMaiz += kgProv;
                                                    break;
                                            }
                                            System.out.println("\n******Factura de Compra*****");
                                            System.out.println("Producto Comprado: " + nombre);
                                            System.out.println("Cantidad Comprada: " + kgProv + "kg");
                                            System.out.println("Total a pagar: " + subtotal);
                                            System.out.println("Presupuesto: " + presupuesto);

                                            presupuesto -= subtotal;
                                            volCompras += subtotal;
                                            medioCompras += subtotal;
                                            System.out.println("Presupuesto final: " + presupuesto);
                                            System.out.println("**************************");

                                            if (subtotal > mayorGasto) {
                                                mayorGasto = subtotal;
                                            }
                                        } else {
                                            System.out.println("No se puede comprar");
                                            Thread.sleep(2000);
                                            break;
                                        }
                                    } else {
                                        System.out.println("\n>>>>ERROR, introduzca una cantidad valida");
                                        Thread.sleep(2000);
                                    }
                                } else {
                                    System.out.println("\n>>>>ERROR, Proveedor no cuenta con dicho producto");
                                    Thread.sleep(2000);
                                }
                            }
                        }
                        break;
                    case 4: //Reportes
                        if (cajaAbierta == true) {
                            System.out.println("\n----------------------- REPORTES -----------------------");
                            System.out.println(String.format("%-30s Lps. %.2f", "Cantidad en la caja:", presupuesto));
                            System.out.println(String.format("%-30s", "Numero de Compras:", cantCompras));
                            System.out.println(String.format("%-30s", "Numero de Ventas:", cantVent));

                            medioCompras = medioCompras / cantCompras;
                            medioVentas = medioVentas / cantVent;

                            System.out.println(String.format("%-30s Lps. %.2f", "Valor Medio de Ventas:", medioVentas));
                            System.out.println(String.format("%-30s Lps. %.2f", "Valor Medio de Compras:", medioCompras));

                            double margenGan;
                            if (volVentas > volCompras) {
                                margenGan = volVentas - volCompras;
                                System.out.println(String.format("%-30s Lps. %.2f", "Margen de Ganancia Neta:", margenGan));
                            } else if (volCompras > volVentas) {
                                margenGan = volCompras - volVentas;
                                System.out.println(String.format("%-30s Lps. %.2f", "Margen de Perdidas Neta:", margenGan));
                            }
                            System.out.println(String.format("%-30s Lps. %.2f", "Volumen de Compras:", volCompras));
                            System.out.println(String.format("%-30s Lps. %.2f", "Volumen de Ventas:", volVentas));

                            System.out.println(String.format("%-30s Lps. %.2f", "Venta con Mayor Ganancia:", mayorGanancia));
                            System.out.println(String.format("%-30s Lps. %.2f", "Compra con Mayor Gasto:", mayorGasto));

                            //Calculo del producto estrella
                            double mayorCant = 0;
                            if (cantAzucar > mayorCant) {
                                mayorCant = cantAzucar;
                            }
                            if (cantAvena > mayorCant) {
                                mayorCant = cantAvena;
                            }
                            if (cantTrigo > mayorCant) {
                                mayorCant = cantTrigo;
                            }
                            if (cantMaiz > mayorCant) {
                                mayorCant = cantMaiz;
                            }
                            // Se crea un string que almacene los productos estrella, de manera de que puedan ser mas de uno
                            String productosEstrella = "";
                            if (cantAzucar == mayorCant && mayorCant > 0) {
                                productosEstrella += "Azucar, ";
                            }
                            if (cantAvena == mayorCant && mayorCant > 0) {
                                productosEstrella += "Avena, ";
                            }
                            if (cantTrigo == mayorCant && mayorCant > 0) {
                                productosEstrella += "Trigo, ";
                            }
                            if (cantMaiz == mayorCant && mayorCant > 0) {
                                productosEstrella += "Maiz, ";
                            }

                            if (productosEstrella.equals("")) {
                                System.out.println("Producto(s) Estrella: Ninguno");
                            } else {
                                System.out.println("Producto(s) Estrella: " + productosEstrella.substring(0, productosEstrella.length() - 2));
                                System.out.println("Por la cantidad de:  " + mayorCant + "kg");
                            }
                        } else {
                            System.out.println("\n>>> ERROR, pimero debe de abrir caja primero");
                            Thread.sleep(2000);
                        }
                        break;
                    case 5: //Cierrie de CAJA
                        if (cajaAbierta == true) { // Revisa si la caja ha sido abierta y si hay presupuesto para guardar
                            System.out.println("\n---------------- CIERRE DE CAJA -----------------");
                            System.out.println(String.format("%-30s Lps. %.2f", "Cantidad en la caja:", presupuesto));

                            double margenGan = volVentas - volCompras;
                            System.out.println(String.format("%-30s Lps. %.2f", "Margen de Ganancia Neta:", margenGan));
                            System.out.println("-------------------------------------------------");

                            System.out.print("Ingrese el dinnero que quiere dejar en el banco: ");
                            double cantGuard = entrada.nextDouble();
                            if (cantGuard <= presupuesto * 0.6) { // Se usa la condicion if para verificar que lo que quiera guardar el usuario solo pueda ser maximo el 60%
                                presupuesto -= cantGuard; // Se hace la resta de lo que se va a guardar
                                System.out.println("Se han guardado " + cantGuard + "Lps. Con exito");
                                System.out.println("Ahora queda " + presupuesto + " Para el dia siguiente");
                            } else if (cantGuard < 0) {
                                System.out.println("\n>>>ERROR, solo puede ingresar cantidades psoitivas.");
                                Thread.sleep(2000);
                            } else {
                                System.out.println("\n>>>Error, solo puede guardar maximo el 60% de lo que hay en caja.");
                                Thread.sleep(2000);
                            }
                            // Se renician todas las variables que se usan solamente a diario
                            cantAzucar = 0;
                            cantTrigo = 0;
                            cantMaiz = 0;
                            cantAvena = 0;
                            mayorGanancia = 0;
                            volVentas = 0;
                            volCompras = 0;
                            mayorGasto = 0;
                            medioCompras = 0;
                            medioVentas = 0;
                            cantVent = 0;
                            cantCompras = 0;

                            cajaAbierta = false;

                        } else {
                            System.out.println(">>>ERROR, primero debe abrir caja.");
                            Thread.sleep(2000);
                        }
                        break;
                    case 6: //Salir del Sistema
                        if(!cajaAbierta || !cajaCerrada){
                            System.out.println("Para poder salir del sistema, debe cerrar caja o abrirla.");
                        }else{
                             System.out.println("Fin del Programa, gracias por utilizarlo!");
                        }
                        break;
                    default:                       
                        System.out.println("\n****OPCION INVALIDA*****");
                        Thread.sleep(2000);
                        break;
                }
            } catch (InputMismatchException e) { // Con tel catch inputmismatch exception se evita que el programa se crashee por usar numeros no permitidos
                System.out.println("\n>>>PORFAVOR, Introduzca solamente numeros enteros.");
                Thread.sleep(2000);
                entrada.nextLine();

            }
        }
    }

}
