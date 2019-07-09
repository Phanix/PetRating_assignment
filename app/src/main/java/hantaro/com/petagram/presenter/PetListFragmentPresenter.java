package hantaro.com.petagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import hantaro.com.petagram.model.Pet;
import hantaro.com.petagram.model.PetConstructor;
import hantaro.com.petagram.model.PetUser;
import hantaro.com.petagram.restApi.adapter.RestApiAdapter;
import hantaro.com.petagram.restApi.model.ContactResponse;
import hantaro.com.petagram.restApi.model.EndpointsApi;
import hantaro.com.petagram.vista.fragment.IPetListFragment;
import hantaro.com.petagram.vista.fragment.PetListFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetListFragmentPresenter implements IPetListFragmentPresenter {


    private List<Pet> mPetArrayList;
    private List<PetUser> mPetUsers;
    private PetListFragment petListFragment;
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
