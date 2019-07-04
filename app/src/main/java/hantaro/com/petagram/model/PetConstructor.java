package hantaro.com.petagram.model;

import android.content.ContentValues;
import android.content.Context;

import java.text.DateFormat;
import java.util.List;

import hantaro.com.petagram.R;
import hantaro.com.petagram.db.ConstantsDataBase;
import hantaro.com.petagram.db.DataBase;

public class PetConstructor {

    private static final int LIKE = 1;
    private Context mContext;

    public PetConstructor(Context context){
        this.mContext = context;
    }

    public List<Pet> getAllPets(){
        DataBase db = new DataBase(mContext);
        if(db.getAllPets() == null || db.getAllPets().size() == 0){
            insertData(db);
        }
        db.close();
        return db.getAllPets();
    }

    public void insertLike(Pet pet){
        DataBase dataBase = new DataBase(mContext);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_LIKES_PET_ID_PET, pet.getId());
        contentValues.put(ConstantsDataBase.TABLE_PET_NUMBER_OF_LIKES, LIKE);
        dataBase.insertLike(contentValues);

    }

    public int getLike(Pet pet){
        DataBase dataBase = new DataBase(mContext);
        return dataBase.getPetLikes(pet);

    }

    public void insertData(DataBase db){


        ContentValues contentValues;
        contentValues= new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PET_NAME, "Bulldog");
        contentValues.put(ConstantsDataBase.TABLE_PET_IMAGE, R.drawable.bulldog);
        db.insertPet(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PET_NAME, "Eskimo");
        contentValues.put(ConstantsDataBase.TABLE_PET_IMAGE, R.drawable.eskimo);
        db.insertPet(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PET_NAME, "PitBull");
        contentValues.put(ConstantsDataBase.TABLE_PET_IMAGE, R.drawable.pitbull);
        db.insertPet(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PET_NAME, "Shepherd");
        contentValues.put(ConstantsDataBase.TABLE_PET_IMAGE, R.drawable.shepherd);
        db.insertPet(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PET_NAME, "Collie");
        contentValues.put(ConstantsDataBase.TABLE_PET_IMAGE, R.drawable.collie);
        db.insertPet(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PET_NAME, "Beagle");
        contentValues.put(ConstantsDataBase.TABLE_PET_IMAGE, R.drawable.beagle);
        db.insertPet(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PET_NAME, "Bolognese");
        contentValues.put(ConstantsDataBase.TABLE_PET_IMAGE, R.drawable.bolognese);
        db.insertPet(contentValues);

        db.close();

    }


}
