/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;


import galaxy.Cordenada;
import galaxy.Carta;
import galaxy.CartaEspaco;
import galaxy.CartaPlanetaNonPirate;
import galaxy.CartaPlanetaPirata;
import galaxy.CartaWormHole;
import galaxy.EmptyMarket;
import galaxy.Food;
import galaxy.GestorMercado;
import galaxy.Illegal;
import galaxy.Jogador;
import galaxy.MedicalSupplies;
import galaxy.Recurso;
import galaxy.Water;
import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Ricardo
 */
public class Jogo {
    
   int moedas;
   ArrayList<Recurso> reserva = new ArrayList<>();
   ArrayList<CartaPlanetaNonPirate> cartasPlaneta = new ArrayList<>();
   ArrayList<CartaPlanetaPirata> cartasPlanetaPirata = new ArrayList<>();
   ArrayList<CartaWormHole> cartasWormhole = new ArrayList<>();
   ArrayList<CartaEspaco> cartasEspaco = new ArrayList<>();
   ArrayList<Carta> tabuleiro= new ArrayList<>();
   ArrayList<Cordenada> cords= new ArrayList<>();
   
    private Carta cartaActual;
    private Estado estadoactual;
    private GestorMercado g;
    private Jogador j;
    
    public Jogo() {
        
        j = new Jogador();
        moedas = 30;
        
        criaCartas();
        inicializaTabuleiro();
        inicializaReserva();
        g = new GestorMercado(this);
        estadoactual = new Aguarda_Movimento(this, true);
        
    }
    public Estado getEstadoactual(){return estadoactual;}
    public GestorMercado getGestorMercado(){return g;}
    public void setEstado(Estado e){
        estadoactual = e;
    }
    public ArrayList <Carta> getTabuleiro(){return tabuleiro;}
    public Jogador getJogador(){
      return j;
  }
    public void inicializaReserva(){
        for(int i=0; i< 10;i++){
            reserva.add(new Food());
            reserva.add(new Water());
            reserva.add(new MedicalSupplies());
        }
        for(int i= 0; i< 6; i++){
            reserva.add(new Illegal());
            reserva.add(new EmptyMarket());
        }
    }
    public void inicializaTabuleiro(){
        cords.add(new Cordenada(4,0)); cords.add(new Cordenada(5,0)); cords.add(new Cordenada(3,1)); cords.add(new Cordenada(4,1));
         cords.add(new Cordenada(2,2)); cords.add(new Cordenada(3,2)); cords.add(new Cordenada(4,2)); cords.add(new Cordenada(1,3));
          cords.add(new Cordenada(2,3));  cords.add(new Cordenada(3,3));cords.add(new Cordenada(2,4));cords.add(new Cordenada(3,4));cords.add(new Cordenada(4,4));
          cords.add(new Cordenada(3,5));cords.add(new Cordenada(4,5));cords.add(new Cordenada(5,5));
          cords.add(new Cordenada(2,6));cords.add(new Cordenada(3,6));cords.add(new Cordenada(4,6));
          cords.add(new Cordenada(2,7));cords.add(new Cordenada(3,7));
          cords.add(new Cordenada(1,8));cords.add(new Cordenada(2,8));
          
          cartasWormhole.get(0).setCord(new Cordenada(6,0));
          cartasWormhole.get(1).setCord(new Cordenada(0,8));
          tabuleiro.add(cartasWormhole.get(0));
          tabuleiro.add(cartasWormhole.get(1));
          tabuleiro.get(0).setVirada(true);
          tabuleiro.get(1).setVirada(true);
          cartaActual = tabuleiro.get(0);
          cartasWormhole.remove(0);cartasWormhole.remove(0);
          for(int i = 0;i< cartasWormhole.size();i++)
          {
              int x = (int)(Math.random()*cords.size()) + 0;
              cartasWormhole.get(i).setCord(cords.get(x));
              tabuleiro.add(cartasWormhole.get(i));
              cords.remove(x);    
          }
        cartasWormhole.clear();
        for(int i = 0; i< cartasEspaco.size();i++){
            int x = (int)(Math.random()*cords.size()) + 0;
            cartasEspaco.get(i).setCord(cords.get(x));
            tabuleiro.add(cartasEspaco.get(i));
            cords.remove(x);
        }
        cartasEspaco.clear();
        for(int i = 0;i < cartasPlaneta.size();i++){
            int x = (int)(Math.random()*cords.size()) + 0;
            cartasPlaneta.get(i).setCord(cords.get(x));
            tabuleiro.add(cartasPlaneta.get(i));
            cords.remove(x);
        }
        cartasPlaneta.clear();
        for(int i = 0; i < cartasPlanetaPirata.size();i++){
            int x = (int)(Math.random()*cords.size()) + 0;
            cartasPlanetaPirata.get(i).setCord(cords.get(x));
            tabuleiro.add(cartasPlanetaPirata.get(i));
            cords.remove(x);
        }
        cartasPlanetaPirata.clear();
        
    }
    public ArrayList<Recurso> getReserva(){ return reserva;}
    public void vendeFood(){
        if(cartaActual instanceof CartaPlanetaNonPirate){
            if(j.getNave().temFoodparaVender())
            {
               reserva.add(j.getNave().retiraCubodaNave("F"));
               CartaPlanetaNonPirate p = (CartaPlanetaNonPirate) cartaActual; 
               int x = p.vendePlaneta(new Food());
               j.setCoins(j.getCoins() + x);
               moedas = moedas - x;
               
            }
        }
        if(cartaActual instanceof CartaPlanetaPirata){
            if(j.getNave().temFoodparaVender())
            {
                CartaPlanetaPirata p = (CartaPlanetaPirata) cartaActual;
                if(p.ListaPrecoPlaneta(new Food()) > 0){
                 int x = p.vendePlaneta(new Food());
                     
                     reserva.add(j.getNave().retiraCubodaNave("F"));
                     j.setCoins(j.getCoins() + x);
                    moedas = moedas - x;
                    
                }
            }
        }
    }
    public void vendeWater(){
        if(cartaActual instanceof CartaPlanetaNonPirate){
            if(j.getNave().temWaterparaVender())
            {
               reserva.add(j.getNave().retiraCubodaNave("W"));
               CartaPlanetaNonPirate p = (CartaPlanetaNonPirate) cartaActual; 
               int x = p.vendePlaneta(new Water());
               j.setCoins(j.getCoins() + x);
               moedas = moedas - x;
               
            }
        }
        if(cartaActual instanceof CartaPlanetaPirata){
            if(j.getNave().temWaterparaVender())
            {
                CartaPlanetaPirata p = (CartaPlanetaPirata) cartaActual;
                if(p.ListaPrecoPlaneta(new Water()) > 0){
                    int x = p.vendePlaneta(new Water());
                    
                    reserva.add(j.getNave().retiraCubodaNave("W"));
                    j.setCoins(j.getCoins() + x);
                    moedas = moedas - x;
                    
                }
            }
        }
    }
    public void vendeMedicalSupplies(){
        if(cartaActual instanceof CartaPlanetaNonPirate){
            if(j.getNave().temMedicalparaVender())
            {
               reserva.add(j.getNave().retiraCubodaNave("M"));
               CartaPlanetaNonPirate p = (CartaPlanetaNonPirate) cartaActual; 
               int x = p.vendePlaneta(new MedicalSupplies());
               j.setCoins(j.getCoins() + x);
               moedas = moedas - x;
               
            }
        }
        if(cartaActual instanceof CartaPlanetaPirata){
            if(j.getNave().temMedicalparaVender())
            {
                CartaPlanetaPirata p = (CartaPlanetaPirata) cartaActual;
                if(p.ListaPrecoPlaneta(new MedicalSupplies() ) > 0){
                int x = p.vendePlaneta(new MedicalSupplies());
                    
                    reserva.add(j.getNave().retiraCubodaNave("M"));
                    j.setCoins(j.getCoins() + x);
                     moedas = moedas - x;
                    
                }
            }
        }
    }
    public void vendeIllegal(){
        if(cartaActual instanceof CartaPlanetaNonPirate){
            if(j.getNave().totalIllegal() > 0)
            {
               reserva.add(j.getNave().retiraCubodaNave("I"));
               CartaPlanetaNonPirate p = (CartaPlanetaNonPirate) cartaActual; 
               int x = p.ListaPrecoPlaneta(new Illegal());
               x = x + 2;
               j.setCoins(j.getCoins() + x);
               moedas = moedas - x;
               
            }
        }
    }
    public void compraIllegal(){
        if(cartaActual instanceof CartaPlanetaPirata){
                CartaPlanetaPirata p = (CartaPlanetaPirata) cartaActual;
                if(j.getNave().temEspaco() && j.getCoins() > 0){
                    Recurso temp;
                   temp = p.compraIllegal();
                   if(temp != null){
                       j.getNave().colocaRecursoNave(temp);
                       j.setCoins(j.getCoins() - 1);
                       moedas = moedas--;
                       
                   }
                }
        }
    }
    public void comprarFood(){
         if(cartaActual instanceof CartaPlanetaNonPirate){
             CartaPlanetaNonPirate p = (CartaPlanetaNonPirate) cartaActual;
             if(j.getNave().temEspaco() && j.getCoins() > p.ListaPrecoPlaneta(new Food())){
                 Recurso temp;
                 temp = p.vaiBuscarfood();
                 if(temp != null)
                 {
                     j.getNave().colocaRecursoNave(temp);
                     int x = p.ListaPrecoPlaneta(temp);
                     j.setCoins(j.getCoins()-x);
                     moedas=moedas + x;
                 }
             }
         }
    }
    public void comprarWater(){
         if(cartaActual instanceof CartaPlanetaNonPirate){
             CartaPlanetaNonPirate p = (CartaPlanetaNonPirate) cartaActual;
             if(j.getNave().temEspaco() && j.getCoins() > p.ListaPrecoPlaneta(new Water())){
                 Recurso temp;
                 temp = p.vaiBuscarWater();
                 if(temp != null)
                 {
                     j.getNave().colocaRecursoNave(temp);
                     int x = p.ListaPrecoPlaneta(temp);
                     j.setCoins(j.getCoins()-x);
                     moedas=moedas + x;
                 }
             }
         }
    }
     public void comprarMedicalSupplies(){
         if(cartaActual instanceof CartaPlanetaNonPirate){
             CartaPlanetaNonPirate p = (CartaPlanetaNonPirate) cartaActual;
             if(j.getNave().temEspaco() && j.getCoins() > p.ListaPrecoPlaneta(new MedicalSupplies())){
                 Recurso temp;
                 temp = p.vaiBuscarMedical();
                 if(temp != null)
                 {
                     j.getNave().colocaRecursoNave(temp);
                     int x = p.ListaPrecoPlaneta(temp);
                     j.setCoins(j.getCoins()-x);
                     moedas=moedas + x;
                 }
             }
         }
    }
     public void compraArmas(){
        int x =j.aumentaAtaqueNave();
        if(x>0)
            moedas = moedas + x;
        
     }
     public void compraCarga(){
         int x =j.aumentaCargaNave();
        if(x>0)
            moedas = moedas + x;
     }
    public void criaCartas()
    {

        ArrayList <Integer> preco1 = new ArrayList<>(Arrays.asList(1,3,2,3));
        ArrayList <Integer> preco2 = new ArrayList<>(Arrays.asList(3,1,2,3));
        ArrayList <Integer> preco3 = new ArrayList<>(Arrays.asList(1,2,3,3));
        ArrayList <Integer> preco4 = new ArrayList<>(Arrays.asList(3,2,1,3));
        ArrayList <Integer> preco5 = new ArrayList<>(Arrays.asList(2,3,1,3));
        ArrayList <Integer> preco6 = new ArrayList<>(Arrays.asList(2,1,3,3));
        ArrayList <Integer> preco7 = new ArrayList<>(Arrays.asList(0,3,0));
        ArrayList <Integer> preco8 = new ArrayList<>(Arrays.asList(0,0,3));
        ArrayList <Integer> preco9 = new ArrayList<>(Arrays.asList(3,0,0));
        cartasPlaneta.add(new CartaPlanetaNonPirate(false,0,0,"Gethen",preco1));
        cartasPlaneta.add(new CartaPlanetaNonPirate(false,0,0,"Kiber",preco2));
        cartasPlaneta.add(new CartaPlanetaNonPirate(false,0,0,"Reverig",preco3));
        cartasPlaneta.add(new CartaPlanetaNonPirate(false,0,0,"Tiamat",preco4));
        cartasPlaneta.add(new CartaPlanetaNonPirate(false,0,0,"Lamarckia",preco5));
        cartasPlaneta.add(new CartaPlanetaNonPirate(false,0,0,"Arrakis",preco6));
        
        cartasPlanetaPirata.add(new CartaPlanetaPirata(false,0,0,"Whirl",preco7));
        cartasPlanetaPirata.add(new CartaPlanetaPirata(false,0,0,"Striterax",preco8));
        cartasPlanetaPirata.add(new CartaPlanetaPirata(false,0,0,"Asperta",preco9));
        
       for(int i=1;i <= 12;i++)
        cartasEspaco.add(new CartaEspaco(false,0,0,"ES"+i));
       for(int i=1;i <= 4;i++)
           cartasWormhole.add(new CartaWormHole(false,0,0,"W"+i));
       
    }
    
    public  Carta getCartaActual(){
        return cartaActual;
    }
    
    public void explore()
    {
        int x = cartaActual.getCord().getX()+1;
        int y = cartaActual.getCord().getY()+1;
        
        
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getCord().getX() == x && tabuleiro.get(i).getCord().getY() == y){
                tabuleiro.get(i).setVirada(true);
            }
        }
        
        x = cartaActual.getCord().getX()+1;
        y = cartaActual.getCord().getY();
        
        
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getCord().getX() == x && tabuleiro.get(i).getCord().getY() == y){
                tabuleiro.get(i).setVirada(true);
            }
        }
        
        x = cartaActual.getCord().getX()+1;
        y = cartaActual.getCord().getY()-1;
        
        
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getCord().getX() == x && tabuleiro.get(i).getCord().getY() == y){
                tabuleiro.get(i).setVirada(true);
            }
        }
        
        x = cartaActual.getCord().getX();
        y = cartaActual.getCord().getY()+1;
        
        
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getCord().getX() == x && tabuleiro.get(i).getCord().getY() == y){
                tabuleiro.get(i).setVirada(true);
            }
        }
        
        x = cartaActual.getCord().getX()-1;
        y = cartaActual.getCord().getY()+1;
        
        
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getCord().getX() == x && tabuleiro.get(i).getCord().getY() == y){
                tabuleiro.get(i).setVirada(true);
            }
        }
        
        x = cartaActual.getCord().getX()-1;
        y = cartaActual.getCord().getY()-1;
        
        
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getCord().getX() == x && tabuleiro.get(i).getCord().getY() == y){
                tabuleiro.get(i).setVirada(true);
            }
        }
        
        x = cartaActual.getCord().getX()-1;
        y = cartaActual.getCord().getY();
        
        
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getCord().getX() == x && tabuleiro.get(i).getCord().getY() == y){
                tabuleiro.get(i).setVirada(true);
            }
        }
        
        x = cartaActual.getCord().getX();
        y = cartaActual.getCord().getY()-1;
        
        
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getCord().getX() == x && tabuleiro.get(i).getCord().getY() == y){
                tabuleiro.get(i).setVirada(true);
            }
        }

    }
    public void vende(String oque){
        setEstado(estadoactual.vende(oque));
    }
    public void finalizarVenda(){
        setEstado(estadoactual.terminaVenda());
    }
    public void finalizarCompra(){
        setEstado(estadoactual.terminaCompra());
    }
    public void finalizarMovimento(){
        setEstado(estadoactual.terminaMovimento());
    }
    public void compra(String oque){
        setEstado(estadoactual.compra(oque));
    }
    
    public void move(String destino){
        for(int i=0; i<tabuleiro.size();i++){
            if(tabuleiro.get(i).getNome().equalsIgnoreCase(destino))
                setEstado(estadoactual.movimento(tabuleiro.get(i)));
        }
    }
    
    public void moveW(String nome){
        setEstado(estadoactual.MovimentoW(nome));
    }
   
    //move algoritmo
    public boolean move(Carta dest){
        boolean flag=false;
        int paga=0;
        for(int i=0; i<tabuleiro.size();i++){
            if((dest.getCord().getX()==tabuleiro.get(i).getCord().getX() && (dest.getCord().getY()==tabuleiro.get(i).getCord().getY()))&& tabuleiro.get(i).isVirada() && !dest.getNome().equals(cartaActual.getNome())){
                flag=true;
            }
        }
        if(flag== true){
            for(int i=0; i<tabuleiro.size();i++){
                if((dest.getCord().getX()==tabuleiro.get(i).getCord().getX() && (dest.getCord().getY()==tabuleiro.get(i).getCord().getY()))&& tabuleiro.get(i).isVirada()){
                    if(abs(dest.getCord().getX() - cartaActual.getCord().getX()) > abs(dest.getCord().getY() - cartaActual.getCord().getY()))
                        paga = abs(dest.getCord().getX() - cartaActual.getCord().getX());
                    else if(abs(dest.getCord().getX() - cartaActual.getCord().getX()) < abs(dest.getCord().getY() - cartaActual.getCord().getY()))
                        paga = abs(dest.getCord().getY() - cartaActual.getCord().getY());
                    else
                        paga = abs(dest.getCord().getX() - cartaActual.getCord().getX());
                    j.setCoins(j.getCoins()-paga);
                    cartaActual=dest;
                }
            }
            return true;
        }else
            return false;
    }
    
    public boolean termina(){
        return termina1() || termina2();
    }
    
    public boolean termina1(){
        if(j.getCoins() <= 0)
            return true;
        return false;
    }
    
    public boolean termina2(){
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).isVirada()==false){
                return false;
            }
        }
        if(!(cartaActual.getCord().getX()==0 && cartaActual.getCord().getY()== 8))
            return false;
        j.setCoins(j.getCoins()-10);
        return true;
    }
    
    public boolean cartaWH(String nomeC){
        for(int i=0; i<tabuleiro.size();i++){
            if(tabuleiro.get(i).getNome().equalsIgnoreCase(nomeC) && tabuleiro.get(i) instanceof CartaWormHole && !tabuleiro.get(i).getNome().equals(this.cartaActual))
            {moveWH(tabuleiro.get(i));return true;}
        }
        return false;
    }
    
    public void moveWH(Carta destino){
        for(int i=0; i<tabuleiro.size(); i++){
            if(tabuleiro.get(i).getNome().equalsIgnoreCase(destino.getNome()))
                cartaActual = destino;
        }
    }
}
