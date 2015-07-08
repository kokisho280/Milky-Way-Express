/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiTexto;
import galaxy.Carta;
import galaxy.CartaPlanetaNonPirate;
import galaxy.CartaPlanetaPirata;
import galaxy.Cordenada;
import java.util.ArrayList;
import java.util.Scanner;
import logicaJogo.Aguarda_Compra;
import logicaJogo.Aguarda_Movimento;
import logicaJogo.Aguarda_Movimento_WormHole;
import logicaJogo.Aguarda_Venda;
import logicaJogo.Estado;

import logicaJogo.Jogo;
/**
 *
 * @author Ricardo
 */
public class IuTexto {
    
    private Jogo jogo;
    private boolean sair = false;
    String [][] tab = new String [7][9];
    
    public IuTexto(Jogo jogo) {
        this.jogo = jogo;
        
    }
    
    public void imprimeTabuleiro(){
        	ArrayList<Carta> tabu = jogo.getTabuleiro();
        Cordenada cord = new Cordenada(0,0);
        boolean f = false;
        for(int i=0; i<tab.length;i++)
        {
            for(int y=0; y<tab[i].length; y++){
                for(int k=0; k<tabu.size(); k++){
                    if(tabu.get(k).getCord().getX() == i && tabu.get(k).getCord().getY() == y){
                        if(tabu.get(k).isVirada())
                            tab[i][y] = "| "+tabu.get(k).getNome()+" | ";
                        else
                            tab[i][y] = " CARTA ";
                        f = true;
                    }
                }
                if (f)
                    System.out.print(tab[i][y]);
                else
                    System.out.print(" | - | ");
                f=false;
            }
            System.out.println("");
        }
    }
    
    void mostraMenu() {
        Estado e = jogo.getEstadoactual();
        
       
        if (e instanceof Aguarda_Venda) {
            imprimeTabuleiro();
            //dados jogador
            System.out.println("Escolha a opção");
            System.out.println("\n1 - Vender Cargo\n2 - Finalizar Venda");
        }
        if (e instanceof Aguarda_Compra) {
            imprimeTabuleiro();
            //dados jogador
            System.out.println("Escolha a opção");
            System.out.println("\n1 - Comprar good \n2 - Comprar Upgrade ATK \n3 - Comprar Upgrade Cargo \n4 - Finalizar Compra");
        }
        if (e instanceof Aguarda_Movimento) {
            imprimeTabuleiro();
            //dados jogador
            System.out.println("Escolha a opção");
            System.out.println("\n1 - Movimentar para carta  \n2 - Finalizar Turno");
        }
        if (e instanceof Aguarda_Movimento_WormHole) {
            imprimeTabuleiro();
            //dados jogador
            System.out.println("Escolha a opção");
            System.out.println("\n1 - Movimentar para WormHole");
        }
        
        
    }

    void corre() {
        startGame();
        while (!jogo.termina()) {
            pedeOpcao();
        }
    }
    public void listaInfo(){
        System.out.println("Posicao actual: "+jogo.getCartaActual().getNome()+ " coins: "+jogo.getJogador().getCoins()+" Ataque: "
               + jogo.getJogador().getNave().getForca()+ " Carga: "+jogo.getJogador().getNave().getCapacidade());
        if(jogo.getJogador().getNave().getCarga().size()>0)
            System.out.println("Items na Nave: " +jogo.getJogador().getNave().getCarga().toString());
        
        if(jogo.getEstadoactual() instanceof Aguarda_Venda){
            if(jogo.getCartaActual() instanceof CartaPlanetaNonPirate){
                System.out.println("Planeta: "+ jogo.getCartaActual().getNome()+" Preco:Water: "
                        +((CartaPlanetaNonPirate)jogo.getCartaActual()).Listar(0)+ " Food: " + ((CartaPlanetaNonPirate)jogo.getCartaActual()).Listar(1)
                +" Medical: "+ ((CartaPlanetaNonPirate)jogo.getCartaActual()).Listar(2)+" Illegal: "+((CartaPlanetaNonPirate)jogo.getCartaActual()).Listar(3));
                if(((CartaPlanetaNonPirate)jogo.getCartaActual()).getM1()!=null)
                System.out.println("\nMercado1: "+((CartaPlanetaNonPirate)jogo.getCartaActual()).getM1().toString());
                 if(((CartaPlanetaNonPirate)jogo.getCartaActual()).getM2()!=null)
                System.out.println("Mercado2: "+((CartaPlanetaNonPirate)jogo.getCartaActual()).getM2().toString());
            }
            if(jogo.getEstadoactual() instanceof Aguarda_Venda){
            if(jogo.getCartaActual() instanceof CartaPlanetaPirata){
                System.out.println("Planeta: "+ jogo.getCartaActual().getNome()+" Preco:Water: "
                        +((CartaPlanetaPirata)jogo.getCartaActual()).Listar(0)+ " Food: " + ((CartaPlanetaPirata)jogo.getCartaActual()).Listar(1)
                +" Medical: "+ ((CartaPlanetaPirata)jogo.getCartaActual()).Listar(2));
                if(((CartaPlanetaPirata)jogo.getCartaActual()).getMercado()!=null)
                    System.out.println("\nMercado: "+((CartaPlanetaPirata)jogo.getCartaActual()).getMercado().toString());
            }
            
            }
       }
        if(jogo.getEstadoactual() instanceof Aguarda_Compra){
            if(jogo.getCartaActual() instanceof CartaPlanetaNonPirate){
                System.out.println("Planeta: "+ jogo.getCartaActual().getNome()+" Preco:Water: "
                        +((CartaPlanetaNonPirate)jogo.getCartaActual()).Listar(0)+ " Food: " + ((CartaPlanetaNonPirate)jogo.getCartaActual()).Listar(1)
                +" Medical: "+ ((CartaPlanetaNonPirate)jogo.getCartaActual()).Listar(2)+" Illegal: "+((CartaPlanetaNonPirate)jogo.getCartaActual()).Listar(3));
                 if(((CartaPlanetaNonPirate)jogo.getCartaActual()).getM1()!=null)
                System.out.println("\nMercado1: "+((CartaPlanetaNonPirate)jogo.getCartaActual()).getM1().toString());
                 if(((CartaPlanetaNonPirate)jogo.getCartaActual()).getM2()!=null)
                System.out.println("Mercado2: "+((CartaPlanetaNonPirate)jogo.getCartaActual()).getM2().toString());
                 
                
            }
            if(jogo.getCartaActual() instanceof CartaPlanetaPirata){
                System.out.println("Planeta: "+ jogo.getCartaActual().getNome()+" Preco:Water: "
                        +((CartaPlanetaPirata)jogo.getCartaActual()).Listar(0)+ " Food: " + ((CartaPlanetaPirata)jogo.getCartaActual()).Listar(1)
                +" Medical: "+ ((CartaPlanetaPirata)jogo.getCartaActual()).Listar(2));
                if(((CartaPlanetaPirata)jogo.getCartaActual()).getMercado()!=null)
                    System.out.println("\nMercado: "+((CartaPlanetaPirata)jogo.getCartaActual()).getMercado().toString());
                
            }
            
        }
    }
    void pedeOpcao() 
    {
        int op;
        Scanner sc = new Scanner(System.in);
        mostraMenu();
        Estado e = jogo.getEstadoactual();
        listaInfo();
        
        if (e instanceof Aguarda_Venda) {
            while (!sc.hasNextInt());
            op = sc.nextInt();
            if (op == 1) {
                System.out.println("Selecione item a vender food water medical illegal");
                String item = sc.next();
                jogo.vende(item);
            }
            if (op == 2) {
                jogo.finalizarVenda();
            } 
            
        }
        if (e instanceof Aguarda_Compra) {          
            while (!sc.hasNextInt());
            op = sc.nextInt();
            if (op == 1) {
                System.out.println("\nEscolha cargo a comprar: (food water medical illegal)2");
                
                String item = sc.next();
                jogo.compra(item);
            }
            if (op == 2) {
                jogo.compra("arma");
            }
            if(op == 3){
                jogo.compra("carga");
            }
            if(op == 4){
                jogo.finalizarCompra();
            }
        }
        if (e instanceof Aguarda_Movimento) {
            while (!sc.hasNextInt());
            op = sc.nextInt();
            if (op == 1) {
                System.out.println("Carta destino?");
                String d = sc.next();
                jogo.move(d);
            }
            
            if (op == 2) {
                jogo.finalizarMovimento();
            }
        }
        if (e instanceof Aguarda_Movimento_WormHole) {
            while (!sc.hasNextInt());
            op = sc.nextInt();
            if (op == 1) {
                System.out.println("Escolha o WormHole!");
                String WH = sc.next();
                jogo.moveW(WH);
            }
            if (op == 2) {
                jogo.getEstadoactual().terminaMovimento();
            }
        }
       
    }
    
    public void startGame(){
//        System.out.println("Comecar jogo para uma pessoa?(s/n");
//        Scanner s = new Scanner(System.in);
//        String op = s.next();
//        if(op.equals("s")){
//            
//        }
    }

    
}
