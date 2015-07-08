/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import galaxy.Carta;
import galaxy.CartaPlanetaNonPirate;
import galaxy.CartaPlanetaPirata;
import galaxy.Food;
import java.awt.Color;
import java.util.Observable;


public class ModeloCarta extends Observable{
    Carta carta;
    ModeloCarta(Carta c){
        carta = c;
    }
    
    public boolean temQuadradoParaDesenhar()
    {
       if(carta  instanceof CartaPlanetaNonPirate)
       {
           CartaPlanetaNonPirate planeta = ( CartaPlanetaNonPirate)carta;
           
           if(planeta.getM1()== null && planeta.getM2() == null)
               return false;
           else
               return true;
       }
       else if(carta  instanceof CartaPlanetaPirata)
       {
           CartaPlanetaPirata planeta = ( CartaPlanetaPirata)carta;
           
           if(planeta.getMercado() == null)
               return false;
            else
               return true;
       }
       
       return false;
    }
    
    public boolean temMercado1paraDesenhar()
    {
        if(carta  instanceof CartaPlanetaNonPirate)
        {
            CartaPlanetaNonPirate planeta = ( CartaPlanetaNonPirate)carta;
            
            if(planeta.getM1()!= null)
                return true;
            else
                return false;
        }  
        return false;
    }
    
    public String getNameMercado1()
    {
        String nome ="";
        
        if(carta  instanceof CartaPlanetaNonPirate)
        {
            CartaPlanetaNonPirate planeta = ( CartaPlanetaNonPirate)carta;
            if(planeta.getM1()!= null)
                nome = planeta.getM1().getNome();
        }
        
        if(nome.equals("F"))
            return "food";
        else if(nome.equals("W"))
            return "water";
        else if(nome.equals("M"))
            return "medical";
        else
            return nome;
    }
    
    public String getNameMercado2()
    {
        String nome ="";
        if(carta  instanceof CartaPlanetaNonPirate)
        {
            CartaPlanetaNonPirate planeta = ( CartaPlanetaNonPirate)carta;
            if(planeta.getM2()!= null)
                nome = planeta.getM2().getNome();
        }
        if(nome.equals("F"))
            return "food";
        else if(nome.equals("W"))
            return "water";
        else if(nome.equals("M"))
            return "medical";
        else
            return nome;
        
    }
    
    public Color getColorMercado1()
    {
        Color cor;
        String nome = "";
        if(carta  instanceof CartaPlanetaNonPirate){
            CartaPlanetaNonPirate planeta = ( CartaPlanetaNonPirate)carta;
            nome = planeta.getM1().getNome();
        }
        else if(carta  instanceof CartaPlanetaPirata){
            CartaPlanetaPirata planeta = (CartaPlanetaPirata)carta;
            nome = planeta.getMercado().getNome();
        }
        if(nome.equals("F"))
            cor = Color.YELLOW;
        else if(nome.equals("W"))
            cor = Color.blue;
        else if(nome.equals("M"))
            cor = Color.red;
        else if(nome.equals("I"))
            cor = Color.black;
        else
            cor = Color.white;
        
        return cor;
    }
    
    public boolean temMercado2paraDesenhar()
    {
        if(carta  instanceof CartaPlanetaNonPirate)
        {
            CartaPlanetaNonPirate planeta = (CartaPlanetaNonPirate)carta;
            
            if(planeta.getM2()!= null)
                return true;
            else
                return false;
        }  
        return false;
    }
    
    public Color getColorMercado2()
    {
        Color cor;
        String nome = "";
        if(carta  instanceof CartaPlanetaNonPirate)
        {
            CartaPlanetaNonPirate planeta = ( CartaPlanetaNonPirate)carta;
            nome = planeta.getM2().getNome();
        }
        else if(carta  instanceof CartaPlanetaPirata)
        {
            CartaPlanetaPirata planeta = (CartaPlanetaPirata)carta;
            nome = planeta.getMercado().getNome();
        }
        if(nome.equals("F"))
            cor = Color.YELLOW;
        else if(nome.equals("W"))
            cor = Color.blue;
        else if(nome.equals("M"))
            cor = Color.red;
        else if(nome.equals("I"))
            cor = Color.black;
        else
            cor = Color.white;
        
        return cor;
    }
    
    public boolean isPirata()
    {
        if(carta instanceof CartaPlanetaPirata)
            return true;
        
        return false;
    }
    
    public boolean isPlaneta()
    {
        if(carta instanceof CartaPlanetaNonPirate)
            return true;
        return false;
    }
}
