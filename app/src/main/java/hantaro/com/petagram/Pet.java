package hantaro.com.petagram;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Pet implements Serializable {

    private String mName;
    private int rating;
    private int mImage;

    public Pet(String name, int image) {
        mName = name;
        this.rating = 0;
        mImage = image;
    }



    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }


}
