package hantaro.com.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Pet> petList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.action_bar_custom);
        setSupportActionBar(toolbar);

        ImageView imageView = findViewById(R.id.top_rated);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TopRating.class);
                Pet [] pets = new Pet[petList.size()];
                int i = 0;
                //Create array from the list
                for(Pet pet : petList){
                    pets[i] = pet;
                    i++;
                }
                //Sort the array
                for(int x = 0; x < petList.size() - 1; x++){
                   for(int y = x; y < petList.size(); y++){
                       if(pets[x].getRating() < pets[y].getRating()){
                           Pet pet = pets[x];
                           pets[x] = pets[y];
                           pets[y] = pet;
                       }
                   }
                }
                //Create a new array with the 5 most rated
                Pet [] petsRated = new Pet[5];
                for(int x = 0; x < 5; x++){
                    petsRated[x] = pets[x];
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("petArray", petsRated);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        petList = new ArrayList<>();

        petList.add(new Pet("Hippopotamus", R.drawable.hippo));
        petList.add(new Pet("Dog", R.drawable.dog));
        petList.add(new Pet("Lion", R.drawable.lion));
        petList.add(new Pet("Monkey", R.drawable.monkey));
        petList.add(new Pet("Rabbit", R.drawable.rabbit));
        petList.add(new Pet("Tiger", R.drawable.tiger));
        petList.add(new Pet("Cat", R.drawable.cat));


        PetAdapter petAdapter = new PetAdapter(petList, this);

        RecyclerView recyclerView = findViewById(R.id.rv_pets);
        //To perform
        petAdapter.setHasStableIds(true);
        recyclerView.setHasFixedSize(true);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(petAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_contact:
                Intent intent  = new Intent(MainActivity.this, Contact.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
