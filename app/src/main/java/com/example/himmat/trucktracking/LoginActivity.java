package com.example.himmat.trucktracking;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.himmat.trucktracking.databinding.ActivityLoginBinding;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        ButterKnife.bind(this);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
    }

    @OnClick(R.id.txt_login)
    public void onClickLogin(){
        Intent intent = new Intent(this,NavigationActivity.class);
        startActivity(intent);
    }
}
