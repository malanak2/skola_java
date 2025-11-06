package cz.malanak.Services;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.inject.Inject;
import cz.malanak.Serialization.Serializer;
import cz.malanak.accounts.BaseAccount;

public class SerializerService {
    @Inject
    Serializer serializer;
    public void serializeTransactionsForAccount(BaseAccount account) {
        JsonMapper mapper = new JsonMapper();

    }
}
