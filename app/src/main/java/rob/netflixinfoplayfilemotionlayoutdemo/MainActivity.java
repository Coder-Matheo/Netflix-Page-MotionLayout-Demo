package rob.netflixinfoplayfilemotionlayoutdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface{

    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    List<String> movieList ;


    ImageView imageView, backImageView;


    int[] images ={R.drawable.film1, R.drawable.film2, R.drawable.film3, R.drawable.film4, R.drawable.film5, R.drawable.film6,
            R.drawable.film1, R.drawable.film2, R.drawable.film3, R.drawable.film4, R.drawable.film5, R.drawable.film6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<>();

        movieList.add("Spider Man");
        movieList.add("Iron Man");
        movieList.add("Dark");
        movieList.add("unbroken");
        movieList.add("WW2");
        movieList.add("Spider Man");
        movieList.add("Iron Man");
        movieList.add("Dark");
        movieList.add("unbroken");
        movieList.add("WW2");
        movieList.add("Spider Man");
        movieList.add("Iron Man");

        recyclerView = findViewById(R.id.recyclerview);
        recyclerAdapter = new RecyclerAdapter(movieList, images,  this);

        recyclerView.setAdapter(recyclerAdapter);

        backImageView = findViewById(R.id.backViewPager);


        initial();
    }

    private void initial() {

        imageView = findViewById(R.id.play_btn_imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ShowFileFragment showFileFragment = new ShowFileFragment();
                //FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
                /*Bundle data = new Bundle();
                data.putString("MyData", "Hallo");
                data.putString("MyData", "Hallo");
                data.putString("MyData", "Hallo");

                showFileFragment.setArguments(data);*/
                //fragmentTransaction.replace(R.id.play_imageView, showFileFragment).commit();

                Intent intent = new Intent(MainActivity.this, ShowFileActivity.class);
                intent.putExtra("fileImage", R.drawable.wallpaper_netflix);
                startActivity(intent);



            }
        });
    }


    @Override
    public void onItemClickInterface(int position) {
        Toast.makeText(this, movieList.get(position), Toast.LENGTH_SHORT).show();
        backImageView.setImageResource(images[position]);

    }

    @Override
    public void onLongItemClickInterface(int position) {
        Toast.makeText(this, movieList.get(position), Toast.LENGTH_SHORT).show();
    }
}