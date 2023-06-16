package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.practiceapp.databinding.ActivitySignupBinding;
import com.example.practiceapp.signUp.SignupRequest;
import com.example.practiceapp.signUp.SignupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signupSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup();
            }
        });
    }

    private void Signup() {
        String userId = binding.signupIdEt.getText().toString();
        String userPw = binding.signupPwEt.getText().toString();
        String userPwCheck = binding.signupPwCheckEt.getText().toString();

        if(userId.length()==0|| userPw.length()==0||userPwCheck.length()==0){
            Toast.makeText(SignupActivity.this, "모든 항목을 입력해주세요",Toast.LENGTH_SHORT).show();
        }else {
            SignupResponse(userId,userPw, userPwCheck);
        }
    }

    public void SignupResponse(String userId, String userPw, String userPwCherck) {
        SeverApi severApi = ApiProvider.getInstnace().create(SeverApi.class);

        SignupRequest signupRequest = new SignupRequest(userId, userPw, userPwCherck);

        severApi.Signup(signupRequest).enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(SignupActivity.this, "회원가입에 성공했습니다",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(SignupActivity.this,"오류", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "통신에 실패하였습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}