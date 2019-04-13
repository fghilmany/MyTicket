package com.example.fghilmany.tiketsaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccesBuyTicketAct extends AppCompatActivity {

    Animation btt,ttb,app_splash;
    ImageView iv_sukses_ticket;
    TextView tv_sukses_ticket, tv_sukses_desc;
    Button btn_view_ticket, btn_my_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_buy_ticket);

        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);

        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);
        btn_view_ticket = findViewById(R.id.btn_view_ticket);
        iv_sukses_ticket = findViewById(R.id.iv_sukses_ticket);
        tv_sukses_ticket = findViewById(R.id.tv_sukses_ticket);
        tv_sukses_desc = findViewById(R.id.tv_sukses_desc);

        //run animation
        btn_my_dashboard.startAnimation(btt);
        btn_view_ticket.startAnimation(btt);

        iv_sukses_ticket.startAnimation(app_splash);

        tv_sukses_ticket.startAnimation(ttb);
        tv_sukses_desc.startAnimation(ttb);
    }
}
