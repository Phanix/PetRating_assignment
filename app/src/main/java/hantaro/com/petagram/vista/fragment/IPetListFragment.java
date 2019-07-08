package hantaro.com.petagram.vista.fragment;

import java.util.ArrayList;
import java.util.List;

import hantaro.com.petagram.adapter.PetAdapter;
import hantaro.com.petagram.model.Pet;

public interface IPetListFragment {


    public void generarLinearLayoutVertical();

    public PetAdapter crearAdaptador(List<Pet> petArrayList);

    public void inicializarAdaptadorRV(PetAdapter adaptador);
}
