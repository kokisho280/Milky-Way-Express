/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy;

import java.util.ArrayList;

/**
 *
 * @author Utilizador
 */
public class Dado {
    ArrayList<Integer> normal = new ArrayList<>();
    ArrayList<String> cor = new ArrayList<>();
    
    public Dado(){
        for(int i=1;i <= 6;i++)
                normal.add(i);
        cor.add("white");cor.add("red");cor.add("blue");cor.add("black");cor.add("white");cor.add("yellow");
    }
    public int lancaDadoNormal(){
        int v = (int)(Math.random()*6);
        return normal.get(v);
    }
    public String lancaDadoCor(){
        int v = (int)(Math.random()*6);
        return cor.get(v);
    }
}
