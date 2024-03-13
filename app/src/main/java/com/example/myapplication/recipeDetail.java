package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Listeners.RecipeDetailsListener;
import com.example.myapplication.Models.RecipeDetail;
import com.squareup.picasso.Picasso;

public class recipeDetail extends AppCompatActivity {
    int id;
    TextView textView_meal_name,textView_meal_source,textView_meal_summary;
    ImageView imageView_meal_image;
    RecyclerView recyclerView_meal_ingredients;
    RequestManager manager;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        findViews();
        id =Integer.parseInt(getIntent().getStringExtra("id")) ;
        manager = new RequestManager(this);
        manager.getRecipeDetails(recipeDetailsListener,id);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading Detail...");
        dialog.show();
    }

    private void findViews() {
        textView_meal_name = findViewById(R.id.textView_meal_name);
        textView_meal_source = findViewById(R.id.textView_meal_src);
        textView_meal_summary = findViewById(R.id.textView_meal_summary);
        imageView_meal_image = findViewById(R.id.imageView_meal_img);
        recyclerView_meal_ingredients =findViewById(R.id.recycler_meal_ingredients);
    }
    private final RecipeDetailsListener recipeDetailsListener = new RecipeDetailsListener() {
        @Override
        public void didFetch(RecipeDetail detail, String message) {
            dialog.dismiss();
            textView_meal_name.setText((detail.title));
            textView_meal_source.setText((detail.sourceName));
            String htmlString = detail.summary;
            Spanned spanned = Html.fromHtml(htmlString);
            String summaryText = spanned.toString();
            Picasso.get().load(detail.image).into(imageView_meal_image);
            textView_meal_summary.setText((summaryText));
            Picasso.get().load(detail.image).into(imageView_meal_image);
        }


        @Override
        public void didError(String message) {

        }
    };
}