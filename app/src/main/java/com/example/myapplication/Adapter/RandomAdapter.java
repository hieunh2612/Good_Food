package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Listeners.RecipeClick;
import com.example.myapplication.Models.Recipe;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomAdapter extends RecyclerView.Adapter<RandomViewHolder> {
    Context context;

    public RandomAdapter(Context context, List<Recipe> list,RecipeClick click) {
        this.context = context;
        this.list = list;
        this.click = click;
    }

    List<Recipe> list;
    RecipeClick click;



    @NonNull
    @Override
    public RandomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomViewHolder(LayoutInflater.from(context).inflate(R.layout.list_random,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomViewHolder holder, int position) {
        holder.textTitle.setText(list.get(position).title);
        holder.textTitle.setSelected(true);
        holder.txtHeath.setText(list.get(position).aggregateLikes+" Likes");
        holder.text_serving.setText(list.get(position).servings+" Servings");

        holder.txtTime.setText(list.get(position).readyInMinutes+" Minutes");
        Picasso.get().load(list.get(position).image).into(holder.img_food);
        holder.random_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onRecipeClicked(String.valueOf(list.get(holder.getAdapterPosition()).id));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class RandomViewHolder extends RecyclerView.ViewHolder{
    CardView random_List;
    TextView textTitle,text_serving,txtHeath,txtTime;
    ImageView img_food;

    public RandomViewHolder(@NonNull View itemView) {
        super(itemView);
        random_List = itemView.findViewById(R.id.random_list);
        textTitle = itemView.findViewById(R.id.text_tilte);
        text_serving = itemView.findViewById(R.id.text_servings);
        txtHeath = itemView.findViewById(R.id.text_heath);
        txtTime = itemView.findViewById(R.id.txtTime);
        img_food = itemView.findViewById(R.id.img_food);


    }
}
