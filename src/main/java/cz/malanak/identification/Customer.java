package cz.malanak.identification;

import java.util.UUID;

public class Customer {
    public final UUID uuid;
    public String name;


    public Customer(String name) {
        uuid = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
         return uuid + ", " + name;
    }
}
