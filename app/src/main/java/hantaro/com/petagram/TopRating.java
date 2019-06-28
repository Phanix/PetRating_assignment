package hantaro.com.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopRating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rating);

        Toolbar toolbar = findViewById(R.id.actionbar);
        toolbar.findViewById(R.id.top_rated).setVisibility(View.INVISIBLE);
        toolbar.findViewById(R.id.back_arrow).setVisibility(View.VISIBLE);
        ImageView imageView = findViewById(R.id.back_arrow);
        imageView.setVisibility(View.VISIBLE);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setSupportActionBar(toolbar);



        Bundle bundle = getIntent().getExtras();
        Pet [] pets = (Pet[]) bundle.getSerializable("petArray");
        List<Pet> petList = Arrays.asList(pets);

        RecyclerView recyclerView = findViewById(R.id.rv_pets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        PetAdapter petAdapter = new PetAdapter(petList, this);
        recyclerView.setAdapter(petAdapter);
    }
}
