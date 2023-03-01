package com.engeto;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RegisterOfPurchases {
    public static void main(String[] args) {
        List<Purchase> purchases = new ArrayList<>();
//        purchases.add(new Purchase("Pečivo",Category.FOOD,BigDecimal.valueOf(548.10),LocalDate.of(2021,8,9)));
//        purchases.add(new Purchase("Benzín (28 l)",Category.OTHERS,BigDecimal.valueOf(935.0),LocalDate.of(2021,8,8)));
//
        for (Purchase purchase : purchases){
            System.out.println(purchase.getPurchaseDate()+" "+purchase.getDescription()+" "+"("+purchase.getPrice()+" Kč)");
        }

    }
    public List<Purchase> getPurchases() {
        // Vrátíme kopii seznamu.
        // Pokud následně někdo v kopii provede změny, neovlivní tím
        //  náš seznam.
        return new ArrayList<>(getPurchases());
    }

    private List<Purchase> purchaseList = new ArrayList<>();

    public static RegisterOfPurchases importFromFile(
            String filename, String delimiter)
            throws PurchaseException {
        String nextLine = "";
        String[] items = new String[1];
        LocalDate date;
        BigDecimal price;
        Category category;
        String description;
        int lineNumber = 0;

        RegisterOfPurchases result = new RegisterOfPurchases();

        // try-with-resources ... automaticky uzavře otevřené zdroje (soubory, síťových spojení...)
        try (Scanner scanner =
                     new Scanner(new BufferedReader(
                             new FileReader(filename)))) {
            // Zpracuj otevřený soubor:
            while (scanner.hasNextLine()) {
                lineNumber++;
                // Zpracuj další řádek:
                nextLine = scanner.nextLine();
                // Kontrolní výpis: System.out.println(nextLine);
                items = nextLine.split(delimiter);
                date = LocalDate.parse(items[0]);
                price = new BigDecimal(items[1]);
                category = Category.valueOf(items[2]);
                description = items[3];
                result.addPurchase(
                        new Purchase(description, category, price, date));
            }
        } catch (NumberFormatException e) {
            throw new PurchaseException(
                    "Špatně zadané číslo: "+items[1]+" na řádku číslo "
                            +lineNumber+":\n"
                            +nextLine +"\n"+e.getLocalizedMessage());
        } catch (IllegalArgumentException e) {
            throw new PurchaseException(
                    "Špatně zadaná kagetorie: "+items[2]+" na řádku číslo "
                            +lineNumber+":\n"
                            +nextLine +"\n"+e.getLocalizedMessage());
        } catch (DateTimeParseException e) {
            throw new PurchaseException(
                    "Špatně zadané datum: "+items[0]+" na řádku číslo "
                            +lineNumber+":\n"
                            +nextLine +"\n"+e.getLocalizedMessage());
        } catch (FileNotFoundException e) {
            throw new PurchaseException(
                    "Soubor "+filename+" nebyl nalezen!\n"+e.getLocalizedMessage());
        }
        return result;
    }

    public void exportToFile(String filename, String delimiter) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Purchase purchase : purchaseList) {
                writer.println(
                        purchase.getPurchaseDate()
                                +delimiter
                                +purchase.getPrice()
                                +delimiter
                                +purchase.getCategory()
                                +delimiter
                                +purchase.getDescription()
                );

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPurchase(Purchase purchase) {
        purchaseList.add(purchase);
    }

    public void removePurchase(Purchase purchase) {
        purchaseList.remove(purchase);
    }

    public List<Purchase> purchasesAfter(LocalDate limit) {
        List<Purchase> result = new ArrayList<>();
        for (Purchase purchase : purchaseList) {
            if (purchase.getPurchaseDate().isAfter(limit)) {
                result.add(purchase);
            }
        }
        return result;
    }

    public BigDecimal totalPrice() {
        BigDecimal result = BigDecimal.ZERO;
        for (Purchase purchase : purchaseList) {
            result = result.add(purchase.getPrice());
        }
        return result;
    }

    public int numberOfPurchases() {
        return purchaseList.size();
    }

    public BigDecimal averagePrice() throws PurchaseException {
        if (numberOfPurchases() < 0) throw new RuntimeException("Počet nákupů je záporný!");
        if (numberOfPurchases() == 0) {
            throw new PurchaseException(
                    "Nelze počítat průměr - nemáme žádná data!");
        }
        BigDecimal averagePrice = totalPrice().divide(
                BigDecimal.valueOf(numberOfPurchases()), RoundingMode.HALF_UP);
        return averagePrice;
    }
}