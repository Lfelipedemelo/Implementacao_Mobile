package com.example.trabalhoimplementacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.trabalhoimplementacao.model.Franchise;
import com.example.trabalhoimplementacao.model.Restaurant;
import com.example.trabalhoimplementacao.util.Utils;

import java.util.List;

public class FranchiseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        criarFranquias("");

        TextView tv = findViewById(R.id.txtPesquisarFranquia);
        tv.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                criarFranquias(tv.getText().toString());
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String title = item.getTitle().toString();
        if(title.equals("Voltar")){
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    protected void criarFranquias(String filtro) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.llFranquias);
        ll.removeAllViews();
        List<Restaurant> restaurantes = Utils.preencherRestaurantes();
        String restauranteSelecionado = getIntent().getStringExtra("restaurante");
        for (Restaurant r : restaurantes) {
            if(r.getName().contains(restauranteSelecionado)) {
                Franchise[] f = r.getFranchiseList();
                for(int i = 0; i < r.getFranchiseList().length; i++) {
                    if(f[i].getName().toUpperCase().contains(filtro.toUpperCase())) {
                        LinearLayout horizontal = new LinearLayout(this);
                        horizontal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        horizontal.setOrientation(LinearLayout.HORIZONTAL);

                        LinearLayout vertical = new LinearLayout(this);
                        vertical.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        vertical.setOrientation(LinearLayout.VERTICAL);

                        ll.addView(horizontal);

                        ImageView iv = new ImageView(getApplicationContext());
                        iv.setImageDrawable(getDrawable(f[i].getImage()));
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 200);
                        iv.setLayoutParams(lp);
                        horizontal.addView(iv);

                        horizontal.addView(vertical);

                        TextView t = new TextView(ll.getContext());
                        t.setText(f[i].getName());
                        t.setTextSize(22f);
                        t.setPadding(10, 30, 2, 0);
                        vertical.addView(t);

                        TextView address = new TextView(ll.getContext());
                        address.setText(f[i].getAddress());
                        address.setTextSize(14f);
                        address.setPadding(10, 2, 8, 0);
                        address.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                        vertical.addView(address);
                    }
                }
            }
        }
    }
}