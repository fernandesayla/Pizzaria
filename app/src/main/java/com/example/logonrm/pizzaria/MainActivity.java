package com.example.logonrm.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private String username;

    @BindView(R.id.username)
    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            username = getIntent().getStringExtra("USERNAME");

            tvUsername.setText(username);
            // R.id.tvAgTimeCasa = timeCasa;

        }

        if (savedInstanceState != null){
            username = savedInstanceState.getString("USERNAME");

        }

        tvUsername.setText(username);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("USERNAME", username);


    }

}
