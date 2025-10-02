package cz.malanak.Services;

import cz.malanak.Serialization.Serializer;
import cz.malanak.accounts.BankAccount;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.accounts.SaveAccount;
import cz.malanak.accounts.StudentAccount;
import cz.malanak.factories.SerializerFactory;
import cz.malanak.identification.Customer;

public class SaveData {
    public static String SaveData(BaseAccount[] accounts, Customer[] customers) {
        StringBuilder sb = new StringBuilder();
        Serializer s = SerializerFactory.createSerializer();
        sb.append("""
                {
                    "customers": [
                """);
        for (Customer c : customers) {
            sb.append(String.format("""
                    %s,
                    """, s.serialize(c)));
        }
        sb.deleteCharAt(sb.length() - 2); // delete extra comma
        sb.append("""
                    ],
                    "accounts": [
                """);
        for (BaseAccount a : accounts) {
            if (a instanceof BankAccount) {
                sb.append(String.format("""
                    %s,
                    """, s.serialize((BankAccount) a)));
            }
            if (a instanceof SaveAccount) {
                sb.append(String.format("""
                    %s,
                    """, s.serialize((SaveAccount) a)));
            }
            if (a instanceof StudentAccount) {
                sb.append(String.format("""
                    %s,
                    """, s.serialize((StudentAccount) a)));
            }
        }

        sb.deleteCharAt(sb.length() - 2); // delete extra comma
        sb.append("""
                    ]
                }
                """);
        return sb.toString();
    }
}
