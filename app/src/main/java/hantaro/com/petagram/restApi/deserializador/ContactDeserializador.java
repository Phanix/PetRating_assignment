package hantaro.com.petagram.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import hantaro.com.petagram.model.Pet;
import hantaro.com.petagram.model.PetUser;
import hantaro.com.petagram.restApi.ConstantesRestApi;
import hantaro.com.petagram.restApi.JsonKeys;
import hantaro.com.petagram.restApi.model.ContactResponse;

public class ContactDeserializador implements JsonDeserializer<ContactResponse> {
    @Override
    public ContactResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        ContactResponse contactResponse = gson.fromJson(json, ContactResponse.class);
        JsonArray contactResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        contactResponse.setPetList(deserializadorContactDeJon(contactResponseData));

        return contactResponse;
    }

    private List<PetUser> deserializadorContactDeJon(JsonArray contactResponseData){

        List<PetUser> pets = new ArrayList<>();

        for(int i = 0; i < contactResponseData.size(); i++){



        }

        return null;
    }
}
