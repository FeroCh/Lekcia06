package com.engeto;
import java.time.LocalDate;

public class Hlavna5 {
    public static final String FILENAME = "purchases.csv";
    public static final String DELIMITER = ";";
    //public static final String DELIMITER = "\t"; // tabulátor
    public static final int STATUS_CANNOT_READ_FILE = 1;

    public static void main(String[] args) {
        RegisterOfPurchases purchases = null;
        try {
            purchases =
                    RegisterOfPurchases.importFromFile(
                            FILENAME, DELIMITER);
        } catch (PurchaseException e) {
            System.err.println(
                    "Chyba při čtení souboru " + FILENAME
                            + ":\n" + e.getLocalizedMessage());
            System.exit(STATUS_CANNOT_READ_FILE);
        }

        // Výpisy:
        System.out.println("Všechny položky:");
        for (Purchase purchase :
                purchases.purchasesAfter(LocalDate.EPOCH)) {
            System.out.println(purchase);
        }

        System.out.println(
                "Celková cena: " + purchases.totalPrice() + " Kč");

        try {
            System.out.println(
                    "Průměrná cena: " + purchases.averagePrice() + " Kč");
        } catch (PurchaseException ex) {
            System.err.println(
                    "Nelze počítat průměrnou cenu, dokud nejsou vloženy nákupy!\n"
                            + ex.getLocalizedMessage());
            // Rychlé řešení: ex.printStackTrace();
        }

        purchases.exportToFile(FILENAME, DELIMITER);
    }
}

