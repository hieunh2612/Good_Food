package com.example.myapplication.Adapter;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.ExtendedIngredient;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsViewHoder>  {

Context context;
List<ExtendedIngredient> list;

    public IngredientsAdapter(Context context, List<ExtendedIngredient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public IngredientsViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientsViewHoder(LayoutInflater.from(context).inflate(R.layout.list_meal,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHoder holder, int position) {

        holder.textView_ingredients_name.setText(list.get(position).name);
        holder.textView_ingredients_name.setSelected(true);
        String htmlString = list.get(position).original;
        Spanned  spanned = Html.fromHtml(htmlString);
        String quantityText = spanned.toString();
        holder.textView_ingredients_quatity.setText(quantityText);
        holder.textView_ingredients_quatity.setSelected(true);
        Picasso.get().load("https://spoonacular.com/cdn/igredients_100x100/"+ list.get(position).image).into(holder.imgView_ingredients);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class  IngredientsViewHoder extends RecyclerView.ViewHolder{

    TextView textView_ingredients_quatity,textView_ingredients_name;
    ImageView imgView_ingredients;
    public IngredientsViewHoder(@NonNull View itemView) {
        super(itemView);
        textView_ingredients_name = itemView.findViewById(R.id.textView_ingredients_name);
        textView_ingredients_quatity = itemView.findViewById(R.id.textView_ingredients_quantity);
        imgView_ingredients = itemView.findViewById(R.id.imgView_ingredients_name);

    }
}
