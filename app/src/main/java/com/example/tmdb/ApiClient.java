package com.example.tmdb;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://api.themoviedb.org";

    private static final String TOKEN =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1YjFiYzcyZTJhNWYyMTUxYjNjMDQ3NGU1YzUyZjA2MCIsIm5iZiI6MTc4OTQ3NTEzOS42NzcsInN1YiI6IjZhYTkzOTQzMTBhNWYwN2I3MGZiMjUyNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.W-SIlyegvfW-2B_nVQvU0WoAp1WlWOh2NXc55Pujq_M";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {

                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Authorization", "Bearer " + TOKEN)
                                .addHeader("accept", "application/json")
                                .build();

                        return chain.proceed(request);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}