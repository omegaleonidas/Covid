package com.sidiq.covid19.network;

import android.provider.CallLog;

import com.sidiq.covid19.config.Constant;
import com.sidiq.covid19.model.CovidData;
import com.sidiq.covid19.model.ResponKota;
import com.sidiq.covid19.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET(Constant.HOME + Constant.LAST_DATA + Constant.LOCATION)
    Call<CovidData> getLast();

    @GET(Constant.HOME + Constant.ALL_DATA + Constant.LOCATION)
    Call<List<CovidData>> getAllData();

    @GET(Constant.HOME + Constant.KOTA + Constant.PADANG_PANJANG)
    Call<Response> getPadangPanjang();

    @GET(Constant.HOME + Constant.KOTA + Constant.PADANG)
    Call<Response> getPadang();
    @GET(Constant.HOME + Constant.KOTA + Constant.PAYAKUMBUH)
    Call<Response> getPayakumbuh();
    @GET(Constant.HOME + Constant.ALL_KOTA)
    Call<ResponKota> getAll_kota();

}
