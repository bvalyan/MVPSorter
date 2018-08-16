package com.example.user.mvpsorter.Network;


import com.example.user.mvpsorter.Model.NetObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNumberDataService
{
    @GET("API/jsonI.php?length=40&type=uint8")
    Call<NetObject> getNumberData();
}