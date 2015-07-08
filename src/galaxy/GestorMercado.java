/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy;

import java.util.ArrayList;
import logicaJogo.Jogo;

/**
 *
 * @author Utilizador
 */
public class GestorMercado {
    
    
    Dado d;
    Jogo j;
    public GestorMercado( Jogo p){
        d = new Dado();
        j= p;
    }
    public void addCuboReserva(Recurso r){
        j.getReserva().add(r);
        
    }
    public Recurso retiraCuboReserva(String s){
        Recurso temp = null;
         ArrayList<Recurso> r = j.getReserva();
         for(int i = 0; i< r.size();i++){
             if(r.get(i).getNome().equals(s)){
                 temp = r.get(i);
                 r.remove(i);
                 return temp;
             }
         }
         return temp;
        
    }
        public void reabastecePirata(CartaPlanetaPirata p){
            if(p.reabasteceMercado()){
                Illegal i = (Illegal) retiraCuboReserva("I");
                p.setMercadoPirata(i);
            }
                
        }
        public void reabasteceNonPirata(CartaPlanetaNonPirate planeta){
             String cor;
                          
                if(planeta.m1 == null || planeta.m1 instanceof EmptyMarket){
                    do{
                       cor = d.lancaDadoCor();
                        switch (cor) {
                            case "blue":
                                planeta.m1= retiraCuboReserva("W");
                                break;
                            case "red":
                                planeta.m1=retiraCuboReserva("M");
                                break;
                            case "yellow":
                                planeta.m1=retiraCuboReserva("F");
                                break;
                            case "black":
                                int f = d.lancaDadoNormal();
                                if(f > j.getJogador().getNave().getForca())
                                    j.getJogador().setCoins(j.getJogador().getCoins() - (f - j.getJogador().getNave().getForca()));
                                break;
                            default:
                                planeta.m1= retiraCuboReserva("E");
                                int t = j.getJogador().getNave().totalIllegal();
                                if(t > 0)
                                {
                                    for(int ii = 0; ii< t;ii++){
                                        addCuboReserva(j.getJogador().getNave().retiraCubodaNave("I"));
                                        j.getJogador().setCoins(j.getJogador().getCoins()-4);
                                    }
                                }  break;
                        }
                        
                    }while(cor.equals("black"));
                    //Lanca 2x if illegal on board
                     int t = j.getJogador().getNave().totalIllegal();
                     if(t > 0){
                         for(int i = 0; i < 2;i++){
                            cor = d.lancaDadoCor();
                            if(cor.equals("white"))
                            {
                                for(int ii = 0; ii< t;ii++){
                                    addCuboReserva(j.getJogador().getNave().retiraCubodaNave("I"));
                                    j.getJogador().setCoins(j.getJogador().getCoins()-4);
                                }
                                
                            }
                            else if (cor.equals("black"))
                            {
                                int f = d.lancaDadoNormal();
                                if(f > j.getJogador().getNave().getForca())
                                    j.getJogador().setCoins(j.getJogador().getCoins() - (f - j.getJogador().getNave().getForca()));
                            
                            }
                        }
                     }
             }
         
        }
        public void reabasteceNonPirata1(CartaPlanetaNonPirate planeta){
             String cor;
                          
                if(planeta.m2 == null || planeta.m2 instanceof EmptyMarket){
                    do{
                       cor = d.lancaDadoCor();
                        switch (cor) {
                            case "blue":
                                planeta.m2= retiraCuboReserva("W");
                                break;
                            case "red":
                                planeta.m2=retiraCuboReserva("M");
                                break;
                            case "yellow":
                                planeta.m2=retiraCuboReserva("F");
                                break;
                            case "black":
                                int f = d.lancaDadoNormal();
                                if(f > j.getJogador().getNave().getForca())
                                    j.getJogador().setCoins(j.getJogador().getCoins() - (f - j.getJogador().getNave().getForca()));
                                break;
                            default:
                                planeta.m2= retiraCuboReserva("E");
                                int t = j.getJogador().getNave().totalIllegal();
                                if(t > 0)
                                {
                                    for(int ii = 0; ii< t;ii++){
                                        addCuboReserva(j.getJogador().getNave().retiraCubodaNave("I"));
                                        j.getJogador().setCoins(j.getJogador().getCoins()-4);
                                    }
                                }  break;
                        }
                        
                    }while(cor.equals("black"));
                    //Lanca 2x if illegal on board
                     int t = j.getJogador().getNave().totalIllegal();
                     if(t > 0){
                         for(int i = 0; i < 2;i++){
                            cor = d.lancaDadoCor();
                            if(cor.equals("white"))
                            {
                                for(int ii = 0; ii< t;ii++){
                                    addCuboReserva(j.getJogador().getNave().retiraCubodaNave("I"));
                                    j.getJogador().setCoins(j.getJogador().getCoins()-4);
                                }
                                
                            }
                            else if (cor.equals("black"))
                            {
                                int f = d.lancaDadoNormal();
                                if(f > j.getJogador().getNave().getForca())
                                    j.getJogador().setCoins(j.getJogador().getCoins() - (f - j.getJogador().getNave().getForca()));
                            
                            }
                        }
                     }
             }
         
        }
        
        public void reabasteceAllPlanets(){
            ArrayList <Carta> t = j.getTabuleiro();
            ArrayList <Carta> reabastece = new ArrayList<>();
            for(int col = 8; col >= 0; col--)
            {
                for(int lin = 0; lin < 7;lin++){
                    for(int i = 0; i < t.size();i++){
                        if(t.get(i).getCord().getX() == lin && t.get(i).getCord().getY() == col && t.get(i).isVirada()==true)
                            reabastece.add(t.get(i));
                    }
                }
                
            }
            for(int i = reabastece.size() - 1; i >= 0; i--)
            {
                if(reabastece.get(i) instanceof CartaPlanetaPirata)
                {
                    CartaPlanetaPirata p = (CartaPlanetaPirata)reabastece.get(i);
                    
                    reabastecePirata(p);
                }
                else if(reabastece.get(i) instanceof CartaPlanetaNonPirate)
                {
                    CartaPlanetaNonPirate p = (CartaPlanetaNonPirate)reabastece.get(i);
                    
                    reabasteceNonPirata(p);reabasteceNonPirata1(p);
                }
            }
            
        }
        
}


