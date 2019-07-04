package hantaro.com.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import hantaro.com.petagram.model.Pet;

public class TopRating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rating);

        Toolbar toolbar = findViewById(R.id.actionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.findViewById(R.id.top_rated).setVisibility(View.INVISIBLE);



        Bundle bundle = getIntent().getExtras();
        Pet[] pets = (Pet[]) bundle.getSerializable("petArray");
        List<Pet> petList = Arrays.asList(pets);

        RecyclerView recyclerView = findViewById(R.id.rv_pets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        PetAdapter petAdapter = new PetAdapter(petList, this);
        recyclerView.setAdapter(petAdapter);
    }
}
