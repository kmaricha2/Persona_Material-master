package com.example.android.persona_material;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 30/04/2018.
 */


public class Metodos {

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSel;
        Random r = new Random();
        fotoSel = r.nextInt(fotos.size());
        return fotos.get(fotoSel);
    }

}
