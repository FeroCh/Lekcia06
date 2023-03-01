package com.engeto;



import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Customer implements Comparable<Customer>{
    // implements Comparable - povieme IntelliJ, ze chceme aby Custome bolo
    // porovnavatelne => klik na ziarovku vyberieme compare to a vytvori
    // porovnavaciu metodu - compareTo uplne dolu
    private int id;
    private String name;
    private LocalDate dateOfBirth;

    public Customer(int id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // ak je to uplne rovnaky objekt tak vrati true
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }
    //Rychly filter, vyradi polozky ktore sa urcite nezhoduju, pokracovat bude porovnanie cez equals.
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return name + "("+id+" "+dateOfBirth+")";
    }

    @Override
    public int compareTo( Customer other) {
        // tu povieme, ako sa zakaznici budu standardne porovnavat,
        // metoda vracia 0, zaporne alebo kladne cislo
        //kde 0 znamena ze su rovnaky, - hodnota ze porovnavany objekt je mensi,
        // + hodnota, ze porovnavany objekt je vacsi
        int compareNames = name.compareTo(other.name);
        if (compareNames == 1){
            return compareNames;
        }
        return compareNames;
    }
}
