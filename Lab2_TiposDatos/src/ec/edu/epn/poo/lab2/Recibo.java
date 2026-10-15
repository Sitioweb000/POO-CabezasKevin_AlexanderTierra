package ec.edu.epn.poo.lab2;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Recibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double IVA = 0.15;                 // IVA de Ecuador
        int codigo = 127;                        // código de factura
        Locale ec = Locale.forLanguageTag("es-EC");
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Producto 1: ");
        String producto = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Precio unitario: ");
        double precio = sc.nextDouble();
        sc.nextLine();                           // consume el Enter pendiente

        System.out.print("Producto 2: ");
        String producto2 = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad2 = sc.nextInt();
        System.out.print("Precio unitario: ");
        double precio2 = sc.nextDouble();

        double subtotal1 = cantidad * precio;
        double subtotal2 = cantidad2 * precio2;
        double subtotal = subtotal1 + subtotal2;
        double iva = subtotal * IVA;
        double total = subtotal + iva;

        System.out.println();
        System.out.println("=========== RECIBO ===========");
        System.out.printf(ec, "Factura: %08d%n", codigo);
        System.out.printf(ec, "%-14s %4s %10s%n",
                "Producto", "Cant", "Subtotal");
        System.out.printf(ec, "%-14.14s %4d %,10.2f%n",
                producto, cantidad, subtotal1);
        System.out.printf(ec, "%-14.14s %4d %,10.2f%n",
                producto2, cantidad2, subtotal2);
        System.out.println("------------------------------");
        System.out.printf(ec, "%-19s %,10.2f%n", "IVA 15 %", iva);
        System.out.printf(ec, "%-19s %,10.2f%n", "TOTAL", total);

        NumberFormat moneda = NumberFormat.getCurrencyInstance(ec);
        System.out.println("Total a pagar: " + moneda.format(total));
        sc.close();

	}

}
