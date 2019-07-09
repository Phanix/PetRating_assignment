package hantaro.com.petagram.vista.fragment;

import java.util.List;

import hantaro.com.petagram.adapter.PetAdapter;
import hantaro.com.petagram.model.Pet;

public interface IPetListFragment {


     void generarLinearLayoutVertical();

     PetAdapter crearAdaptador(List<Pet> petArrayList);

     void inicializarAdaptadorRV(PetAdapter adaptador);
}
