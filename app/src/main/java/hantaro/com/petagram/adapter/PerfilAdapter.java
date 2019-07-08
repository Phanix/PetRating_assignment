package hantaro.com.petagram.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hantaro.com.petagram.R;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilAdapterViewHolder>{

    private static final String [] NUMBER_OF_BONES = {"1", "2", "3", "6", "0", "5", "10", "7", "9", "10"};

    @NonNull
    @Override
    public PerfilAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.perfil_cardview, viewGroup, false);
        return new PerfilAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PerfilAdapterViewHolder perfilAdapterViewHolder, int i) {
        perfilAdapterViewHolder.mTextViewCounr.setText(NUMBER_OF_BONES[i]);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class PerfilAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView mTextViewCounr;

        public PerfilAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewCounr = itemView.findViewById(R.id.tv_count);
        }
    }
}
