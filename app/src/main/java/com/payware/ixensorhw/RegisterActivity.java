package com.payware.ixensorhw;

import static com.payware.ixensorhw.api.RetrofitManager.STATUS_SUCCESS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.payware.ixensorhw.api.RespondAPI;
import com.payware.ixensorhw.api.RetrofitManager;
import com.payware.ixensorhw.databinding.ActivityRegisterBinding;

import java.util.Objects;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));

        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(view -> {
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("first_name", binding.etFirstName.getText().toString())
                    .addFormDataPart("last_name", binding.etLastName.getText().toString())
                    .addFormDataPart("mail", binding.etEmail.getText().toString())
                    .addFormDataPart("passwd", binding.etPassword.getText().toString())
                    .build();



            RetrofitManager.getRetrofitClient().register(requestBody).enqueue(new Callback<RespondAPI>() {
                @Override
                public void onResponse(Call<RespondAPI> call, Response<RespondAPI> response) {
                    RespondAPI respondAPI = response.body();
                    if(Objects.requireNonNull(respondAPI).getStatus()==STATUS_SUCCESS) {
                        startActivity(new Intent(RegisterActivity.this,MainActivity.class).putExtra("token",respondAPI.getToken()));
                        finish();
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, respondAPI.getError(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RespondAPI> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

}