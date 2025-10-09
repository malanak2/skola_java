package cz.malanak.Serialization;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import cz.malanak.accounts.BaseAccount;
import cz.malanak.identification.Customer;
import jdk.jshell.spi.ExecutionControl;

public class Deserializer {
    public void deserialize(JsonObject o) throws ExecutionControl.NotImplementedException {
        Gson gson = new Gson();
        throw new ExecutionControl.NotImplementedException("To Implement");
    }
}
