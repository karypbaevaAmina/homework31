package kg.attractor.java.homework.domain;

import kg.attractor.java.homework.RestaurantOrders;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Customer {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private final String fullName;
    private final String email;

    public Customer(String fullName, String domain) {
        this.fullName = fullName;
        this.email = fullName.toLowerCase().replace(' ', '.') + domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(fullName, customer.fullName) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email);
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    }












