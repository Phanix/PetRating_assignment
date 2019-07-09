package hantaro.com.petagram.vista.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hantaro.com.petagram.adapter.PetAdapter;
import hantaro.com.petagram.R;
import hantaro.com.petagram.model.Pet;
import hantaro.com.petagram.model.PetConstructor;
import hantaro.com.petagram.presenter.PetListFragmentPresenter;

public class PetListFragment extends Fragment implements IPetListFragment{
   public static  List<Pet> petList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    PetAdapter petAdapter;
    RecyclerView  recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pet_list_fragment, container, false);

        recyclerView = view.findViewById(R.id.rv_pets);


        PetListFragmentPresenter petListFragmentPresenter = new PetListFragmentPresenter(this, getContext());

        return view;
    }

    @Override
    public void generarLinearLayoutVertical() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public PetAdapter crearAdaptador(List<Pet> petArrayList) {
        PetAdapter petAdapter = new PetAdapter(petArrayList, getActivity());
        return petAdapter;
    }


    @Override
    public void inicializarAdaptadorRV(PetAdapter adaptador) {
        adaptador.setHasStableIds(true);
        recyclerView.setAdapter(adaptador);
        recyclerView.setHasFixedSize(true);
    }
}
