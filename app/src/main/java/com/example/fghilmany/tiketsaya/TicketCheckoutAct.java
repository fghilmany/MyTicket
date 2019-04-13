package com.example.fghilmany.tiketsaya;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TicketCheckoutAct extends AppCompatActivity {

    Button btn_buy_ticket,btn_min_ticket, btn_plus_ticket;
    TextView tv_jumlah_ticket, tv_total_harga, tv_my_balance;
    Integer valueJumlahTikcet = 1;
    Integer myBalance = 200;
    Integer totalHarga = 0;
    Integer hargaTicket = 75;
    ImageView notif_uang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosuccessticket = new Intent(TicketCheckoutAct.this, SuccesBuyTicketAct.class);
                startActivity(gotosuccessticket);
            }
        });

        btn_min_ticket = findViewById(R.id.btn_min_ticket);
        btn_plus_ticket = findViewById(R.id.btn_plus_ticket);
        tv_jumlah_ticket = findViewById(R.id.tv_jumlah_ticket);

        tv_total_harga = findViewById(R.id.tv_total_harga);
        tv_jumlah_ticket = findViewById(R.id.tv_jumlah_ticket);

        tv_jumlah_ticket = findViewById(R.id.tv_jumlah_ticket);
        tv_my_balance = findViewById(R.id.tv_my_balance);
        notif_uang = findViewById(R.id.notif_tdk_cukup_uang);

        //setting value baru untuk beberapa component
        tv_jumlah_ticket.setText(valueJumlahTikcet.toString());
        tv_my_balance.setText("US$ "+myBalance+"");
        totalHarga = hargaTicket*valueJumlahTikcet;
        tv_total_harga.setText("US$ "+totalHarga+" ");

        //secara dafult , menghide btn_min_ticket
        btn_min_ticket.animate().alpha(0).setDuration(300).start();
        btn_min_ticket.setEnabled(false);
        notif_uang.setVisibility(View.GONE);


        btn_min_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueJumlahTikcet-=1;
                tv_jumlah_ticket.setText(valueJumlahTikcet.toString());
                if (valueJumlahTikcet < 2){
                    btn_min_ticket.animate().alpha(0).setDuration(300).start();
                    btn_min_ticket.setEnabled(false);
                }
                totalHarga = hargaTicket*valueJumlahTikcet;
                tv_total_harga.setText("US$ "+totalHarga+" ");

                if (totalHarga < myBalance){
                    btn_buy_ticket.animate().translationY(0).alpha(1).setDuration(350).start();
                    btn_buy_ticket.setEnabled(true);
                    tv_my_balance.setTextColor(Color.parseColor("#203DD1"));

                    notif_uang.setVisibility(View.GONE);

                }
            }
        });

        btn_plus_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueJumlahTikcet+=1;
                tv_jumlah_ticket.setText(valueJumlahTikcet.toString());
                if (valueJumlahTikcet > 1){
                    btn_min_ticket.animate().alpha(1).setDuration(300).start();
                    btn_min_ticket.setEnabled(true);
                }

                totalHarga = hargaTicket*valueJumlahTikcet;
                tv_total_harga.setText("US$ "+totalHarga+" ");

                if (totalHarga > myBalance){
                    btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(350).start();
                    btn_buy_ticket.setEnabled(false);

                    tv_my_balance.setTextColor(Color.parseColor("#D1206B"));
                    notif_uang.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
