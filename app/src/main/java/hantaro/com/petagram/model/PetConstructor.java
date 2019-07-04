package hantaro.com.petagram.model;

import android.content.ContentValues;
import android.content.Context;

import java.text.DateFormat;
import java.util.List;

import hantaro.com.petagram.R;
import hantaro.com.petagram.db.ConstantsDataBase;
import hantaro.com.petagram.db.DataBase;

public class PetConstructor {

    private Context mContext;

    public PetConstructor(Context context){
        this.mContext = context;
    }

    /*
     petList.add(new Pet("Akita", R.drawable.akita));
        petList.add(new Pet("Bulldog", R.drawable.bulldog));
        petList.add(new Pet("Eskimo", R.drawable.eskimo));
        petList.add(new Pet("Pitbull", R.drawable.pitbull));
        petList.add(new Pet("Shepherd", R.drawable.shepherd));
        petList.add(new Pet("Collie", R.drawable.collie));
        petList.add(new Pet("Beagle", R.drawable.beagle));
        petList.add(new Pet("Bolognese", R.drawable.bolognese));


     */

    public List<Pet> getAllPets(){
        DataBase db = new DataBase(mContext);
        if(db.getAllPets() == null || db.getAllPets().size() == 0){
            insertData(db);
            return db.getAllPets();
        }
        return db.getAllPets();
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



    }


}
