package meira.ricardo.br.receitaandroid.services;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //JsonWebToken tokenCreator = new JsonWebToken();


        Request request = chain.request();
        request = request.newBuilder()
               // .addHeader("Authorization", token)
                .build();

        return chain.proceed(request);
    }
}
