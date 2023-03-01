package com.engeto;

import java.time.LocalDate;
import java.util.*;

public class MainCustomer {

    public static void main(String[] args) {
        //porovnaniRetezcu();
        //list();
        //set();
        //collections();
        //compare();
        //map();

    }
    private static void map(){
        Map<Integer,String> mapOfFriends = new TreeMap<>();
        mapOfFriends.put(-45,"Vit");
        mapOfFriends.put(2,"Jana");
        mapOfFriends.put(3,"Karel");
        mapOfFriends.put(1989,"Vaclav");
        mapOfFriends.put(2,"Jana");
        System.out.println(mapOfFriends);
        mapOfFriends.forEach((k,v) -> System.out.print(k + " => " + v));
        System.out.println("\n");
        System.out.println(mapOfFriends.get(1989));
        System.out.println(mapOfFriends.getOrDefault(1988,"NEEXISTUJE"));
    }

    private static void compare() {
        Customer karel1 = new Customer(1,"Karel", LocalDate.of(2000,12,13));
        Set<Customer> customers = new HashSet<>();
        customers.add(karel1);
        customers.add(karel1);
        Customer karel2 = new Customer(1,"Karel",LocalDate.of(2000,12,13));
        customers.add(karel2);
        customers.forEach(customer -> System.out.print(customer+" "));
        System.out.println("\n--Este raz inac");
        customers.forEach(c -> System.out.print(c+" , ") );
        System.out.println("\n");
        List<Customer> listOfCustomers =new ArrayList<>();
        Customer roman = new Customer(2,"Roman",LocalDate.now());
        Collections.addAll(listOfCustomers, karel2, roman, karel1);
        listOfCustomers.forEach(c -> System.out.print(c+", "));
        System.out.println();
        //Vypis pozotriedeni
        System.out.println("Po zotriedeni");
        Collections.sort(listOfCustomers);
        listOfCustomers.forEach(customer -> System.out.print(customer+" , " ));
        System.out.println();
        Collections.sort(listOfCustomers,
                new Comparator<Customer>() {
                    @Override
                    public int compare(Customer o1, Customer o2) {
                        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                    }
                }.reversed());
        listOfCustomers.forEach(customer -> System.out.print(customer+" , " ));
        System.out.println();
    }

    private static void collections() {
        List<Integer> ints1 = new LinkedList<>();
        Collections.addAll(ints1,151,84,36);
        List<Integer> ints2 = ints1; // je tu len jedna kolekcia v dvoch premennych
        List<Integer> ints3 = new LinkedList<>(ints1); // vytvori sa kopia kolekcie z ints1 do inst3
        // ints2.remove(84);
        // berie ako index a snazi sa odstr. 85-ty prvok, ale ten tam nie je a nic sa neudeje.
        ints1.forEach(System.out::println);
        System.out.println("\n");
        ints2.remove(Integer.valueOf(84));
        // aby to bral ako odstran prvok - cislo 84 z troj prvkoveho zoznamu, specificke spravanie pre cisla
        ints1.forEach(System.out::println);
        System.out.println("\n");
        ints3.forEach(System.out::println);
        System.out.println(Collections.max(ints3));
        System.out.println(Collections.min(ints3));
    }

    private static void list() {
        List<String> listOfFriend = new ArrayList<>();
        // List       "cokolvek (=akykolvek zoznam) co splnuje poziadavky rozhrania list"
        // a vsetky llisty maju nejake spolocne vlastnosti.
        // new - "to uz hovorim ktore konkretne auto(analogicky k prihladu ktory konkretny list) si idem zobrat"
        listOfFriend.add("Vit");
        Collections.addAll(listOfFriend,"Jana","Karel","Edita","Jana");
        String next = "Eduard";
        listOfFriend.add(next);
        listOfFriend.add(next);
        for (String friend: listOfFriend){
            System.out.println(friend);
        } //pre kazdy prvok typu String ktory si oznacim ako friend zo zoznamu listOfFriend urob.....
        System.out.println("Treti prvok"+listOfFriend.get(2)); // treti prvok indexy su od nuly!!!!
        listOfFriend.remove(2); // odstranim Karla
        System.out.println("Treti prvok po odstraneni"+listOfFriend.get(2));
        listOfFriend.remove("Jana"); // ostranim PRVU Janu
        System.out.println("---");
        listOfFriend.forEach(System.out::println);
        //tzv. stream mapa
        //na kazdy prvok zoznamu listOfFriends pouzij tuto funkciu.
        // identifikator funkcie System.out a za 2-ma dvojbodkami nazov funkcie println bez okruhlych zatvoriek.
        System.out.println("----");
        listOfFriend.forEach(friend ->System.out.println(friend));
        //pre kazdy prvok oznaceny ako friend zo zoznamu listOfFriends pouzij funkciu System.out.println
        System.out.println("Velkost zoznamu:"+listOfFriend.size());
        System.out.println("_____");
        listOfFriend.forEach(friend ->System.out.print(friend+ " "));
        System.out.println("\n ");
        //mozem to urobit aj takto, u kratsieho zapisu cez :: ,to neide
    }

    private static void set() {
        Set<String> setOfFriend = new HashSet<String>() { // alebo TreeSet<>() ak chcem zoradenu mnozinu
        };
        setOfFriend.add("Vit");
        Collections.addAll(setOfFriend,"Jana","Karel","Edita","Jana");
        String next = "Eduard";
        setOfFriend.add(next);
        setOfFriend.add(next);
        for (String friend: setOfFriend){
            System.out.println(friend);
        }
        System.out.println("-------");
        //  Neda sa -   System.out.println("Treti prvok"+setOfFriend.get(2)); // mnozina neindexuje!!!!
        setOfFriend.remove(2); // odstranil by som prvok 2, kedze tam nie je, tak neodstranim nic
        setOfFriend.forEach(System.out::println);
        setOfFriend.remove("Karel"); // ostranim Karla
        System.out.println("---");
        setOfFriend.forEach(friend ->System.out.print(friend+ " "));
        System.out.println("\n ");
        System.out.println("Velkost zoznamu:"+setOfFriend.size());
        String name = "Edita";
        System.out.print(name);
        if(setOfFriend.contains(name)){
            System.out.println(" je v zozname");
        } else {
            System.out.println(" nie je v zozname");
        }

    }

    private static void porovnaniRetezcu() {
        String first = "Ahoj";
        String second = "Aho";
        second += "j";
        System.out.print(first+" a "+second);
        if(first.equals(second)){
            // first == second nefunguje, lebo porovnavam 2 rozne objekty
            // typu String (ktory je objektovym typom)
            System.out.println(" su rovnake");
        }
        else{
            System.out.println(" su odlisne");
        }
    }
}
