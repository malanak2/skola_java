package cz.malanak.History;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    public TransactionType type;
    public BigDecimal amountBefore;
    public BigDecimal amountAfter;
    public UUID origin;
    public Date date;
    public boolean wasSuccessful;

    public Transaction(TransactionType type, BigDecimal amountBefore, BigDecimal amountAfter, UUID origin, Date date, boolean wasSuccessful) {
        this.type = type;
        this.amountBefore = amountBefore;
        this.amountAfter = amountAfter;
        this.origin = origin;
        this.date = date;
        this.wasSuccessful = wasSuccessful;
    }
}
