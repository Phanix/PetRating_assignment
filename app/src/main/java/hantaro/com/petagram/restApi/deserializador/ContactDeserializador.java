package hantaro.com.petagram.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONObject;

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
            JsonObject contactResponseDataObject = contactResponseData.get(i).getAsJsonObject();

            JsonObject userJson  = contactResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String name = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imagJson = contactResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolution = imagJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlImage = stdResolution.get(JsonKeys.MEDIA_URL).getAsString();


            JsonObject likesJson = contactResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            PetUser petUser = new PetUser();
            petUser.setId(id);
            petUser.setLikes(likes);
            petUser.setName(name);
            petUser.setImageUrl(urlImage);

            pets.add(petUser);


        }

        return pets;
    }
}
