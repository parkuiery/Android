package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.practiceapp.databinding.ActivityLoginBinding;
import com.example.practiceapp.login.LogInRequest;
import com.example.practiceapp.login.LogInResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginLgoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogIn();
            }
        });
    }

    private void LogIn() {
        String userId = binding.loginIdEt.getText().toString();
        String userPw = binding.loginPwEt.getText().toString();

        if(userId.length() == 0) {
            Toast.makeText(LoginActivity.this, "아이디를 입력해주세요",Toast.LENGTH_SHORT).show();
        } else if (userPw.length() == 0) {
            Toast.makeText(LoginActivity.this , "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
        }else {
            LogInResponse();
        }
    }

    private void LogInResponse() {
        String userId = binding.loginIdEt.getText().toString();
        String userPw = binding.loginPwEt.getText().toString();

        LogInRequest logInRequest = new LogInRequest(userId, userPw);
        SeverApi severApi = ApiProvider.getInstnace().create(SeverApi.class);

        severApi.Login(logInRequest).enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "로그인에 성공 했습니다!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "로그인에 실패 했습니다" ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}