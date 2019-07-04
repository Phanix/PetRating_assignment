package hantaro.com.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import hantaro.com.petagram.model.Pet;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, ConstantsDataBase.DATABASE_NAME, null, ConstantsDataBase.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTablePet = "CREATE TABLE " + ConstantsDataBase.TABLE_PETS + "(" +
                ConstantsDataBase.TABLE_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantsDataBase.TABLE_PET_NAME + " TEXT, " +
                ConstantsDataBase.TABLE_PET_IMAGE + " INTEGER)";

        String createTableLikes = "CREATE TABLE " + ConstantsDataBase.TABLE_PET_LIKES + "(" +
                ConstantsDataBase.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantsDataBase.TABLE_LIKES_PET_ID_PET + " INTEGER, " +
                ConstantsDataBase.TABLE_PET_NUMBER_OF_LIKES + " INTEGER," +
                "FOREIGN KEY (" + ConstantsDataBase.TABLE_LIKES_PET_ID_PET +") " +
                "REFERENCES " + ConstantsDataBase.TABLE_PETS + "(" + ConstantsDataBase.TABLE_PET_ID + ")" +
                ")";


        db.execSQL(createTablePet);
        db.execSQL(createTableLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantsDataBase.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantsDataBase.TABLE_PET_LIKES);
    }

    public List<Pet> getAllPets(){
        List<Pet> petList = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantsDataBase.TABLE_PETS;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext()){

            Pet pet = new Pet();
            pet.setId(cursor.getInt(0));
            pet.setName(cursor.getString(1));
            pet.setImage(cursor.getInt(2));

            String query_likes = "SELECT COUNT(" + ConstantsDataBase.TABLE_PET_NUMBER_OF_LIKES +")" +
                    " FROM " + ConstantsDataBase.TABLE_PET_LIKES +
                    " WHERE " + ConstantsDataBase.TABLE_LIKES_PET_ID_PET + "=" + pet.getId();
            Cursor cursorLikes = db.rawQuery(query_likes, null);
            if(cursor.moveToNext()){
                pet.setRating(cursorLikes.getInt(0));
            }else{
                pet.setRating(0);
            }

            petList.add(pet);
        }
        return petList;
    }

    public void insertPet(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ConstantsDataBase.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertLike(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ConstantsDataBase.TABLE_PET_LIKES, null, contentValues);
        db.close();
    }

    public int getPetLikes(Pet pet){

        int likes = 0;

        String query_likes = "SELECT COUNT(" + ConstantsDataBase.TABLE_PET_NUMBER_OF_LIKES +")" +
                " FROM " + ConstantsDataBase.TABLE_PET_LIKES +
                " WHERE " + ConstantsDataBase.TABLE_LIKES_PET_ID_PET + "=" + pet.getId();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query_likes, null);
        if(cursor.moveToNext()){
            likes = cursor.getInt(0);
        }
        db.close();

        return likes;
    }

}
