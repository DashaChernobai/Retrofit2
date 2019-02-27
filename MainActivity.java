package com.example.pupil.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView txtTitle,txtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTitle = findViewById(R.id.txtTitle);
        txtUrl = findViewById(R.id.txtUrl);
        getRecipe();
    }

    private void getRecipe() {
        Call<DataModel> call = Service.getApi().getRecipe();
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel dataModels = response.body();
                txtTitle.setText(dataModels.getTitle());
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                t.getMessage();
            }
        });
    }

}
