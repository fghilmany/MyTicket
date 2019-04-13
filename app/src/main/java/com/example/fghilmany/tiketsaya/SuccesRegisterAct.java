package com.example.fghilmany.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccesRegisterAct extends AppCompatActivity {

    Button btn_explore;
    TextView tv_sukses, tv_sukses2;
    ImageView iv_sukses;
    Animation btt,ttb,app_splash;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_register);

        btn_explore = findViewById(R.id.btn_explore);
        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(SuccesRegisterAct.this, HomeAct.class);
                startActivity(gotohome);
            }
        });

        tv_sukses = findViewById(R.id.tv_sukses);
        tv_sukses2 = findViewById(R.id.tv_sukses2);
        iv_sukses = findViewById(R.id.iv_sukses);

        //load animation
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);

        //run animation
        btn_explore.startAnimation(btt);
        iv_sukses.startAnimation(app_splash);
        tv_sukses.startAnimation(ttb);
        tv_sukses2.startAnimation(ttb);


    }
}
