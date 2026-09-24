package com.example.tmdb;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie_details);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        fetchMovieDetails();
    }

    private void fetchMovieDetails() {

        ApiService apiService =
                ApiClient.getClient().create(ApiService.class);

        int movieId = 1101383;

        Call<ResponseBody> call =
                apiService.getMoviesDetails(movieId);

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(
                    Call<ResponseBody> call,
                    Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(
                    Call<ResponseBody> call,
                    Throwable t) {

            }
        });
    }
}