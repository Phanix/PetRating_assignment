package hantaro.com.petagram;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hantaro.com.petagram.db.ConstantsDataBase;
import hantaro.com.petagram.db.DataBase;
import hantaro.com.petagram.model.Pet;
import hantaro.com.petagram.model.PetConstructor;


public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetAdapterViewHolder>{

    List<Pet> mPets;

    Activity mActivity;

    public PetAdapter(List<Pet> pets, Activity activity) {
        mPets = pets;
        mActivity = activity;
    }

    @NonNull
    @Override
    public PetAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.pet_cardview, viewGroup, false);
        return new PetAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetAdapterViewHolder pet, final int i) {
        pet.petImage.setImageResource(mPets.get(i).getImage());

        pet.boneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPets.get(i).setRating(mPets.get(i).getRating() + 1);
                pet.petRating.setText(mPets.get(i).getRating() + "");
                PetConstructor petConstructor = new PetConstructor(mActivity);
                petConstructor.insertLike(mPets.get(i));
            }
        });
        PetConstructor petConstructor  = new PetConstructor(mActivity);
        int likes = petConstructor.getLike(mPets.get(i));
        pet.petName.setText(mPets.get(i).getName());
        pet.petRating.setText(likes + "");

    }

    @Override
    public int getItemCount() {
        return mPets.size();
    }

    public class PetAdapterViewHolder extends RecyclerView.ViewHolder{

        private ImageView petImage;
        private TextView petName;
        private TextView petRating;
        private ImageButton boneImage;
        public PetAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.img_pet);
            petName = itemView.findViewById(R.id.tv_pet_name);
            petRating = itemView.findViewById(R.id.tv_rating);
            boneImage = itemView.findViewById(R.id.white_bone);
        }
    }
}