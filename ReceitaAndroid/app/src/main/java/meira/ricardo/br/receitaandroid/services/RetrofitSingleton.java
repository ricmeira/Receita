package meira.ricardo.br.receitaandroid.services;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import meira.ricardo.br.receitaandroid.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static RetrofitSingleton instance = null;
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;

    private RetrofitSingleton() {
        Log.d("RetrofitSingleton","Constructor called");
        //Log.d("RetrofitSingleton",MainActivity.MAIN_URL);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .build();

        Gson gson = new GsonBuilder().create();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constants.MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public static RetrofitSingleton getInstance() {
        if(instance == null) {
            instance = new RetrofitSingleton();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }
}
