/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import galaxy.Spaceship;
import java.awt.Color;
import java.util.Observable;
import logicaJogo.Jogo;

/**
 *
 * @author Utilizador
 */
public class ModeloNave extends Observable{
    Spaceship nave;
    Jogo j;
    
    ModeloNave(Jogo n){
        nave = n.getJogador().getNave();
        j=n;
    }
    
    public int getAtaque(){
       return nave.getForca();
    }
    
    public int getCapacidade(){
        return nave.getCapacidade();
    }
    
    public int temParaDesenhar(int i){
        if(nave.getCarga().isEmpty())
            return 0;
        else if(nave.getCarga().size()> i)
           return 1;
        else
           return 0;    
    }
    
    public void aumentaAtaque()
    {
        j.compra("arma");
        setChanged();
        notifyObservers();
    }
    public void aumentaCarga()
    {
        j.compra("carga");
        setChanged();
        notifyObservers();
    }
    
    public void vendeCarga(int i)
    {
        String nome="";
        if(!nave.getCarga().isEmpty() && nave.getCarga().size()>i)
            nome = nave.getCarga().get(i).getNome();
       
        if(nome.equals("F"))
            nome ="food";
        else if(nome.equals("W"))
            nome = "water";
        else if(nome.equals("M"))
            nome = "medical";
        else if(nome.equals("I"))
            nome ="illegal";
        j.vende(nome);
        setChanged();
        notifyObservers();
    }
    
    public Color getCor(int i)
    {
        Color cor;
        String nome = nave.getCarga().get(i).getNome();
        if(nome.equals("F"))
            cor = Color.YELLOW;
        else if(nome.equals("W"))
            cor = Color.blue;
        else if(nome.equals("M"))
            cor = Color.red;
        else
               cor = Color.black;
                
        return cor;
    }
}
