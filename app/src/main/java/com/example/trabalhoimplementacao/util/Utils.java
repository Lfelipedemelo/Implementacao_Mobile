package com.example.trabalhoimplementacao.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.trabalhoimplementacao.R;
import com.example.trabalhoimplementacao.model.Franchise;
import com.example.trabalhoimplementacao.model.Restaurant;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public final class Utils {


    public static List<Restaurant> preencherRestaurantes(){

        //CRIANDO AS FRANQUIAS
        Franchise mc1 = new Franchise("Mc Presidente Kennedy", "Av presidente kennedy"
        , "São José", R.drawable.mcpresidentekennedy);
        Franchise mc2 = new Franchise("Mc Shopping Itaguaçu", "R. Gerôncio Thives"
                , "São José", R.drawable.mcshoppingitaguacu);
        Franchise mc3 = new Franchise("Mc Trajano", "R. Trajano"
                , "Florianópolis", R.drawable.mctrajano);

        Franchise[] franquiasMc = new Franchise[]{mc1,mc2,mc3};

        Franchise bk1 = new Franchise("BK Shopping Itaguaçu", "R. Gerôncio Thives, 1079"
                , "São José", R.drawable.bkgeronciothives);
        Franchise bk2 = new Franchise("BK Presidente Kennedy", "Av. Presidente Kennedy"
                , "São José", R.drawable.bkpkennedy);
        Franchise bk3 = new Franchise("BK Shopping Continente", "Rodovia Br-101 Km 211"
                , "São José", R.drawable.bkshoppingcontinente);

        Franchise[] franquiasBk = new Franchise[]{bk1,bk2,bk3};

        Franchise ws1 = new Franchise("Wendy's Head Island", "2 Natures Way"
                , "Hilton Head Island", R.drawable.wendys1);
        Franchise ws2 = new Franchise("Wendy's Panama Beach", "8720 Thomas Dr"
                , "Panama City Beach", R.drawable.wendys2);
        Franchise ws3 = new Franchise("Wendy's Weston", "1904 Weston Rd"
                , "Weston", R.drawable.wendys3);

        Franchise[] franquiasWs = new Franchise[]{ws1,ws2,ws3};

        Franchise bb1 = new Franchise("Bob's Shake", "Av. Leoberto Leal"
                , "São José", R.drawable.bobsshakell);
        Franchise bb2 = new Franchise("Bob's Angeloni Capoeiras", "Av. Gov. Ivo Silveira"
                , "Florianópolis", R.drawable.bobscapoeiras);
        Franchise bb3 = new Franchise("Bob's Estreito", "R. Gen. Eurico Gaspar Dutra"
                , "Weston", R.drawable.bobsgeneral);

        Franchise[] franquiasBb = new Franchise[]{bb1,bb2,bb3};

        //CRIANDO OS RESTAURANTES
        Restaurant mcDonalds = new Restaurant("McDonalds", "Rede de fast-food tradicional conhecida por ter ótimos hambúrgueres e batatas fritas."
        , R.drawable.mcdonaldslogo, franquiasMc);
        Restaurant burgerKing = new Restaurant("Burger King", "Rede de restaurantes, fundada nos Estados Unidos por James McLamore e David Edgerton."
                , R.drawable.bk, franquiasBk);
        Restaurant wendys = new Restaurant("Wendy's", "Cadeia de restaurantes dos Estados Unidos, fundada em 1969 em Columbus, no estado do Ohio."
                , R.drawable.wendys, franquiasWs);
        Restaurant bobs = new Restaurant("Bob's", "Bob's é uma rede brasileira de restaurantes foodservice fundada em 1952."
                , R.drawable.bobs, franquiasBb);

        List<Restaurant> restaurantes = new ArrayList<>();
        restaurantes.add(bobs);
        restaurantes.add(burgerKing);
        restaurantes.add(mcDonalds);
        restaurantes.add(wendys);
        return restaurantes;
    }
}
