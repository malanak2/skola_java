package cz.malanak.Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import cz.malanak.History.Transaction;
import cz.malanak.accounts.BankAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.accounts.StudentAccount;
import cz.malanak.identification.Customer;

public class Serializer {
    public String serialize(Customer c) {
        return String.format("""
               {
                "name": "%s",
                "uuid": "%s"
               }
               """, c.name, c.uuid);
    }
    public String serialize(BankAccount account) {
        return String.format("""
               {
                "type": "Bank",
                "uuid": "%s",
                "owner": "%s",
                "balance": "%s"
               }
               """, account.uuid, account.owner.uuid, account.getBalance().toString());
    }
    public String serialize(SaveAccount account) {
        return String.format("""
               {
                "type": "Save",
                "uuid": "%s",
                "owner": "%s",
                "balance": "%s",
                "interest_rate": "%s"
               }
               """, account.uuid, account.owner.uuid, account.getBalance().toString(), account.get_interest_rate());
    }
    public String serialize(StudentAccount account) {
        return String.format("""
               {
                "type": "Student",
                "uuid": "%s",
                "owner": "%s",
                "balance": "%s",
                "isic": "%s",
                "school": "%s"
               }
               """, account.uuid, account.owner.uuid, account.getBalance().toString(), account.get_isic(), account.get_school());
    }

    public String serialize(Transaction t) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        return mapper.writeValueAsString(t);
    }

    public static class Xml {
        public static String serialize(Customer c) throws JsonProcessingException {
            XmlMapper mapper = new XmlMapper();
            return mapper.writeValueAsString(c);
        }

    public static String serialize(BankAccount account) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(account);
    }
    public static String serialize(SaveAccount account) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(account);

    }
    public static String serialize(StudentAccount account) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(account);
    }
}
}