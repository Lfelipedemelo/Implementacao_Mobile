package com.example.trabalhoimplementacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.trabalhoimplementacao.model.Restaurant;
import com.example.trabalhoimplementacao.util.Utils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        criarRestaurantes("");
        TextView tv = (TextView) findViewById(R.id.txtFiltrar);
        tv.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                criarRestaurantes(tv.getText().toString());
                return false;
            }
        });
    }

    protected void criarRestaurantes(String filtro){
        LinearLayout ll = (LinearLayout) findViewById(R.id.lblFranquais);
        ll.removeAllViews();
        List<Restaurant> restaurantes = Utils.preencherRestaurantes();

        for (Restaurant r: restaurantes){
            if(r.getName().toUpperCase().contains(filtro.toUpperCase()) || r.getDescription().toUpperCase().contains(filtro.toUpperCase())){
                LinearLayout horizontal = new LinearLayout(this);
                horizontal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                horizontal.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout vertical = new LinearLayout(this);
                vertical.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                vertical.setOrientation(LinearLayout.VERTICAL);

                ll.addView(horizontal);

                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageDrawable(getDrawable(r.getImage()));
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200,200);
                iv.setLayoutParams(lp);
                horizontal.addView(iv);

                horizontal.addView(vertical);

                TextView t = new TextView(ll.getContext());
                t.setText(r.getName());
                t.setTextSize(22f);
                t.setPadding(10,30,2,0);
                vertical.addView(t);

                TextView descricao = new TextView(ll.getContext());
                descricao.setText(r.getDescription());
                descricao.setTextSize(14f);
                descricao.setPadding(10,2,8,0);
                descricao.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                vertical.addView(descricao);

                horizontal.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(getBaseContext(), FranchiseActivity.class);
                        myIntent.putExtra("restaurante", r.getName());
                        startActivity(myIntent);
                    }
                });
            } else {
                continue;
            }
        }
    }
}