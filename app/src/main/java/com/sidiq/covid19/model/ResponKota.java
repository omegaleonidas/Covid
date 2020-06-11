package com.sidiq.covid19.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponKota{

    @SerializedName("results")
    private List<ResultsItem> results;

    public List<ResultsItem> getResults() {
        return results;
    }

    public void setResults(List<ResultsItem> results) {
        this.results = results;
    }
}