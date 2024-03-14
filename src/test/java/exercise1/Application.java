package exercise1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Application {
    private static Logger logger= LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        //-----------------------------------------------MY SHOP--------------------------------------------------------

        Product mangiaPregaAma = new Product(965081126, "Mangia Prega Ama", "Books", 99.5);
        Product lombraDelVento = new Product(1234907632, "L'ombra del vento", "Books", 102.4);
        Product comeUnanotteABali = new Product(569441123, "Come una notte a Bali'", "Books", 13.80);
        Product unIndovinoMiDisse = new Product(393377900, "Un indovino mi disse", "Books", 25.70);
        Product unAltroGiroDiGiostra= new Product(324679045, "Un altro giro di giostra","Books", 165.9);

        Product pacifier = new Product(802472114, "Pacifier", "Baby", 17.80);
        Product pushchair = new Product(411168842, "Pushchair", "Baby", 150.25);
        Product bodySpray = new Product(300756789, "Spray", "Baby", 29.90);

        Product backpac = new Product(741256, "Backpac", "Boys", 79.90);
        Product shoes = new Product(616584, "Shoes", "Boys", 200.6);
        Product cap = new Product(259114, "Cap", "Boys", 39.90);


        //list of all products

        List<Product> listOfAallProducts= new ArrayList<>(Arrays.asList(mangiaPregaAma,lombraDelVento,comeUnanotteABali,unAltroGiroDiGiostra,unIndovinoMiDisse,pacifier,pushchair,bodySpray,backpac,shoes,cap));
        System.out.println(listOfAallProducts);

//------------------------------------------------CUSTOMERS-----------------------------------------------------------

        Customer benedetta= new Customer("Benedetta",2);
        Customer gianfranco= new Customer("Gianfranco",1);
        Customer tiziana= new Customer("Tiziana",3);
        Customer marco= new Customer("Marco",2);
        Customer noemi= new Customer("Noemi",4);

        // list of all customers

        List<Customer> customersList = new ArrayList<>(Arrays.asList(benedetta, gianfranco, tiziana, marco, noemi));
        System.out.println(customersList);

        //--------------------------------------ORDERS----------------------------------------
        Order benedettaOrder = new Order(customersList.get(0));
        Order gianfrancoOrder = new Order(customersList.get(1));
        Order tizianaOrder = new Order(customersList.get(2));
        Order marcoOrder = new Order(customersList.get(3));
        Order noemiOrder = new Order(customersList.get(4));


        Product dummy  = listOfAallProducts.get(4);
        Product nuppies  = listOfAallProducts.get(5);
        Product jeans = listOfAallProducts.get(2);
        Product tshirt = listOfAallProducts.get(6);
        Product peluche = listOfAallProducts.get(8);

        benedettaOrder.addProduct(dummy);
        benedettaOrder.addProduct(dummy);
        benedettaOrder.addProduct(pacifier);

        gianfrancoOrder.addProduct(jeans);
        gianfrancoOrder.addProduct(tshirt);

        tizianaOrder.addProduct(nuppies);
        tizianaOrder.addProduct(peluche);
        tizianaOrder.addProduct(dummy);

        marcoOrder.addProduct(peluche);
        marcoOrder.addProduct(tshirt);

        noemiOrder.addProduct(jeans);

        // creo lista ordini

        List<Order> ordersList= new ArrayList<>(Arrays.asList(benedettaOrder,gianfrancoOrder,tizianaOrder,marcoOrder,noemiOrder));
        System.out.println(ordersList);

//---------------------------------------------------------EXERCISE 1------------------------------------------
        System.out.println("-------------------LISTA PRODOTTI CATEGORIA BOOK CON PREZZO MAGGIORE DI 100€----------------------------");
        List<Product> booksList= listOfAallProducts.stream().filter(product -> product.getCategory().equals("Books")&& product.getPrice()>100).toList();
        System.out.println(booksList);

        //---------------------------------------------------EXERCISE 2-------------------------------------------


        System.out.println("---------------------------------LISTA PRODOTTI CATEGORIA BABY--------------------------------");

        List<Order> ordersBabyCategoryList= ordersList.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();
        System.out.println(ordersBabyCategoryList);

        //--------------------------------------------------EXERCISE 3------------------------------------------------------
        System.out.println("---------------------------LISTA PRODOTTI BOYS CON 10% DI SCONTO------------------------------------ ");

        List<Product> boysProductsList= listOfAallProducts.stream().filter(product -> product.getCategory().equals("Boys")).map(product -> {
            product.setPrice(product.getPrice() * 0.9);
            return product;
        }).toList();
        System.out.println(boysProductsList);

        // -------------------------------------------------ESERCIZIO 4--------------------------------------------------------
        System.out.println("----------------------LISTA PRODOTTI DI CLIENTI TIER 2 ORDINATI TRA 01/02 E 01/04 2021--------------------------");

        ordersList.stream().filter(order -> order.getCustomer().getTier() == 2 &&
                        order.getOrderDate().isAfter(LocalDate.parse("2021-02-01")) &&
                        order.getOrderDate().isBefore(LocalDate.parse("2021-04-01")))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());

        System.out.println("Prodotti ordinati da clienti di livello 2 tra l'01-Feb-2021 e l'01-Apr-2021:");
        tier2Products.forEach(System.out::println);






    }
}
