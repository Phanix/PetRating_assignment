package hantaro.com.petagram;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        List<Pet> petList = PetListFragment.petList;

        petList.add(new Pet("Akita", R.drawable.akita));
        petList.add(new Pet("Bulldog", R.drawable.bulldog));
        petList.add(new Pet("Eskimo", R.drawable.eskimo));
        petList.add(new Pet("Pitbull", R.drawable.pitbull));
        petList.add(new Pet("Shepherd", R.drawable.shepherd));

        petList.add(new Pet("Collie", R.drawable.collie));
        petList.add(new Pet("Beagle", R.drawable.beagle));
        petList.add(new Pet("Bolognese", R.drawable.bolognese));



        PetAdapter petAdapter = new PetAdapter(petList, getActivity());

        RecyclerView recyclerView = view.findViewById(R.id.rv_friends);
        //To perform
        petAdapter.setHasStableIds(true);
        recyclerView.setHasFixedSize(true);


        GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 3);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(petAdapter);

        return view;
    }

}
