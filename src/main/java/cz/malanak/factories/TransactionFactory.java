package cz.malanak.factories;

import cz.malanak.History.Transaction;
import cz.malanak.History.TransactionType;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.UUID;

public class TransactionFactory {
    public Transaction newTransaction(TransactionType type, BigDecimal before, BigDecimal after, UUID origin, boolean succesful) {
        Calendar c = Calendar.getInstance();
        return new Transaction(type, before, after, origin, c.getTime(), succesful);
    }
}
