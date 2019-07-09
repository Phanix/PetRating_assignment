package hantaro.com.petagram.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import hantaro.com.petagram.adapter.PerfilAdapter;
import hantaro.com.petagram.R;
import hantaro.com.petagram.adapter.PetAdapter;
import hantaro.com.petagram.model.PetUser;
import hantaro.com.petagram.presenter.PerfilListFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragment{
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ImageView perfilImage ;
    TextView  perfilText;
    public PerfilFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

         recyclerView = view.findViewById(R.id.rv_friends);
         perfilImage = view.findViewById(R.id.perfil_image);
          perfilText  = view.findViewById(R.id.perfil_name);

        PerfilListFragmentPresenter perfilListFragmentPresenter = new PerfilListFragmentPresenter(this, getContext());



        return view;
    }

    @Override
    public void generarLinearLayoutVertical() {
         gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }

    @Override
    public PerfilAdapter crearAdaptador(List<PetUser> petArrayList) {
        PerfilAdapter perfilAdapter = new PerfilAdapter(petArrayList, getContext());
        return perfilAdapter;
    }

    @Override
    public void inicializarAdaptadorRV(PerfilAdapter adaptador) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adaptador);
    }

    public void showUserProfile(PetUser petUser) {
        if(petUser != null) {
            String imageUrl = petUser.getImageUrl();
            String name = petUser.getName();
            perfilText.setText(name);
            Log.i("Image", imageUrl);
            Picasso.with(getContext()).load(imageUrl).into(perfilImage);
        }
    }
}
