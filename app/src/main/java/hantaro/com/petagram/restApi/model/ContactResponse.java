package hantaro.com.petagram.restApi.model;

import java.util.List;

import hantaro.com.petagram.model.Pet;
import hantaro.com.petagram.model.PetUser;

public class ContactResponse {

    List<PetUser> mPetList;

    public List<PetUser> getPetList(){
        return mPetList;
    }

    public void setPetList(List<PetUser> petList){
        this.mPetList = petList;
    }

}
