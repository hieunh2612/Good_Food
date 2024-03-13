package com.example.myapplication.Listeners;

import com.example.myapplication.Models.RandomRecipeApiResponse;

public interface RandomRecipeListener {
    void didFetch(RandomRecipeApiResponse response,String message);
    void didError(String message);
}
