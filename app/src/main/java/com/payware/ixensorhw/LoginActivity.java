package com.payware.ixensorhw;

import static com.payware.ixensorhw.api.RetrofitManager.STATUS_SUCCESS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.payware.ixensorhw.api.RespondAPI;
import com.payware.ixensorhw.api.RetrofitManager;
import com.payware.ixensorhw.databinding.ActivityLoginBinding;

import java.util.Objects;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.addLogAdapter(new AndroidLogAdapter());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvRegister.setOnClickListener(view -> {
            startActivity(new Intent(this,RegisterActivity.class));
            finish();
        });


        binding.btnLogin.setOnClickListener(view -> {
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("mail", binding.etEmail.getText().toString())
                    .addFormDataPart("passwd", binding.etPassword.getText().toString())
                    .build();

            RetrofitManager.getRetrofitClient().login(requestBody).enqueue(new Callback<RespondAPI>() {
                @Override
                public void onResponse(@NonNull Call<RespondAPI> call, Response<RespondAPI> response) {
                    RespondAPI respondAPI =response.body();
                    Logger.json(new Gson().toJson(response.body()));
                    if(Objects.requireNonNull(respondAPI).getStatus()==STATUS_SUCCESS) {
                        startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("token",respondAPI.getToken()));
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, respondAPI.getError(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<RespondAPI> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });
    }
}