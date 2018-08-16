package com.example.user.mvpsorter.Network;

import android.util.Log;

import com.example.user.mvpsorter.Model.NetObject;
import com.example.user.mvpsorter.UI.FinishInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Networking {

    public static void getData(final FinishInterface finishInterface) {
        /** Create handle for the RetrofitInstance interface*/
        GetNumberDataService service = RetrofitInstance.getRetrofitInstance().create(GetNumberDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<NetObject> call = service.getNumberData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NetObject>() {
            @Override
            public void onResponse(Call<NetObject> call, Response<NetObject> response) {
                finishInterface.onFinished(response.body().getNumbers());
            }

            @Override
            public void onFailure(Call<NetObject> call, Throwable t) {
                finishInterface.onFailure(t);

            }
        });
    }
}
