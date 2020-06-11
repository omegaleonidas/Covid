package com.sidiq.covid19.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response{

    @SerializedName("results")
    private Results results = null;

    public Results getResults() {
        return results;
    }
}