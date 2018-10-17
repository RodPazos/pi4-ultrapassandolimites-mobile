package com.example.henrique.pi4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.henrique.pi4.Model.Login;
import com.example.henrique.pi4.service.RetrofitConfig;
import com.google.common.base.Strings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etSenha = findViewById(R.id.etSenha);
        final TextView tvResp = findViewById(R.id.tvResp);

        Button botao = findViewById(R.id.btnLogin);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Strings.isNullOrEmpty(etEmail.getText().toString()) || !Strings.isNullOrEmpty(etSenha.getText().toString())) {
                    Call<Login> call = new RetrofitConfig().getLOGINService().buscarUsuario(etEmail.getText().toString(), etSenha.getText().toString());

                    call.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            Login lgn = response.body();
                            tvResp.setText(lgn.toString());
                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Log.e("LOGINService ", "Erro ao buscar usuario:" + t.getMessage());
                        }
                    });

                }
            }
        });
    }
}
