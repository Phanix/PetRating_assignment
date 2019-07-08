package hantaro.com.petagram.presenter;

import android.content.Context;

import java.util.List;

import hantaro.com.petagram.model.Pet;
import hantaro.com.petagram.model.PetConstructor;
import hantaro.com.petagram.vista.fragment.IPetListFragment;
import hantaro.com.petagram.vista.fragment.PetListFragment;

public class PetListFragmentPresenter implements IPetListFragmentPresenter {

    private PetListFragment petListFragment;
    private List<Pet> mPetArrayList;

    private Context mContext;

    public PetListFragmentPresenter(PetListFragment petListFragment, Context context) {
        this.petListFragment = petListFragment;
        mContext = context;
        getDataFromDB();
    }

    @Override
    public void getDataFromDB() {
        PetConstructor petConstructor = new PetConstructor(mContext);
        mPetArrayList = petConstructor.getAllPets();
        showData();
    }

    @Override
    public void showData() {
        petListFragment.generarLinearLayoutVertical();
        petListFragment.inicializarAdaptadorRV(petListFragment.crearAdaptador(mPetArrayList));
    }
}
