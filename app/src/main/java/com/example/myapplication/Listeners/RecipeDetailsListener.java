package com.example.myapplication.Listeners;

import com.example.myapplication.Models.RecipeDetail;

public interface RecipeDetailsListener {
    void didFetch(RecipeDetail detail,String message);
    void didError(String message);
}
