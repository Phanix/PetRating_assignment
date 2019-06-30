package hantaro.com.petagram;

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

public class PetListFragment extends Fragment {
   public static final List<Pet> petList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pet_list_fragment, container, false);



        petList.add(new Pet("Akita", R.drawable.akita));
        petList.add(new Pet("Bulldog", R.drawable.bulldog));
        petList.add(new Pet("Eskimo", R.drawable.eskimo));
        petList.add(new Pet("Pitbull", R.drawable.pitbull));
        petList.add(new Pet("Shepherd", R.drawable.shepherd));

        petList.add(new Pet("Collie", R.drawable.collie));
        petList.add(new Pet("Beagle", R.drawable.beagle));
        petList.add(new Pet("Bolognese", R.drawable.bolognese));



        PetAdapter petAdapter = new PetAdapter(petList, getActivity());

        RecyclerView recyclerView = view.findViewById(R.id.rv_pets);
        //To perform
        petAdapter.setHasStableIds(true);
        recyclerView.setHasFixedSize(true);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(petAdapter);

        return view;
    }
}
