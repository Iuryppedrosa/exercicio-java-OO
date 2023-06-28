package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        System.out.println(new Date());
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.next();

        System.out.print("Birth date (dd/mm/yyyy): ");
        Date dateBirth = sdf.parse(input.next());

        System.out.println("Enter Order Data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(input.next());

        Client client = new Client(name, email, dateBirth);
        Order order = new Order(new Date(), status, client);


        System.out.print("How many items to this order? ");
        int qtdItems = input.nextInt();
        for (int i = 0; i < qtdItems; i++) {
            System.out.print("Product name: ");
            String nameProduct = input.next();

            System.out.print("Product price: ");
            double productPrice = input.nextDouble();

            System.out.println("Enter the quantity of products: ");
            int qtdProducts = input.nextInt();

            Product product = new Product(nameProduct, productPrice);

            OrderItem orderItem = new OrderItem(qtdProducts, productPrice, product);
            order.addItem(orderItem);
        }

        System.out.println(order);


    }
}