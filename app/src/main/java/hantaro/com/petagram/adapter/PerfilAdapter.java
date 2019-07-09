package hantaro.com.petagram.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import hantaro.com.petagram.R;
import hantaro.com.petagram.model.PetUser;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilAdapterViewHolder>{

    List<PetUser> mPetUserList;
    Context mContext;

    public PerfilAdapter(List<PetUser> petUserList, Context context) {
        mPetUserList = petUserList;
        mContext = context;
    }


    @NonNull
    @Override
    public PerfilAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.perfil_cardview, viewGroup, false);
        return new PerfilAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PerfilAdapterViewHolder perfilAdapterViewHolder, int i) {
        perfilAdapterViewHolder.mTvLikes.setText(mPetUserList.get(i).getLikes() + "");
        ImageView imageView = perfilAdapterViewHolder.mImage;
        Picasso.with(mContext).load(mPetUserList.get(i).getImageUrl()).into(imageView);
    }

    @Override
    public int getItemCount() {
        if(mPetUserList == null){
            Toast.makeText(mContext, "PetUserEmpty", Toast.LENGTH_LONG).show();
            return 0;
        }else{
            return mPetUserList.size();
        }
    }

    public class PerfilAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView mTvLikes;
        ImageView mImage;

        public PerfilAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvLikes = itemView.findViewById(R.id.tv_count);
            mImage = itemView.findViewById(R.id.img_perfil);
        }
    }
}
