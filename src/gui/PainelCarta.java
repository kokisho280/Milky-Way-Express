/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.Image;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import logicaJogo.Aguarda_Compra;
import logicaJogo.Aguarda_Movimento;
import logicaJogo.Aguarda_Movimento_WormHole;
import logicaJogo.Jogo;

/**
 *
 * @author Utilizador
 */
public class PainelCarta  extends JPanel implements Observer,MouseListener{
    ModeloCarta modelo;
    private ImageIcon image1;
    boolean virada;
    String n;
    Image img;
    Jogo jogo; 
     
    PainelCarta(String nome, boolean v,ModeloCarta m,Jogo j)
    {
        jogo = j;
        modelo = m;
        modelo.addObserver(this);
        virada = v;
        n = nome;
        setVisible(v);
        if (jogo.getCartaActual().getNome().equals(nome)){
            image1 = createImageIcon("img/s"+nome+".jpg");
            img = image1.getImage();
        }else{
            image1 = createImageIcon("img/"+nome+".jpg");
            img = image1.getImage();
        }
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        this.repaint();
        addMouseListener(this);
    }
    
    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
        
        if(modelo.isPlaneta()){
            if(modelo.temQuadradoParaDesenhar()){
                if(modelo.temMercado1paraDesenhar())
                    desenhaMercado1(g,modelo.getColorMercado1());
                if(modelo.temMercado2paraDesenhar())
                    desenhaMercado2(g,modelo.getColorMercado2());
            }
        }
        if(modelo.isPirata()){
            if(modelo.temQuadradoParaDesenhar()){
                g.setColor(Color.BLACK); 
                g.fillRect(42,83,15,15);
            }
        }
    }
    
    public void desenhaMercado1(Graphics g, Color cor)
    {
        g.setColor(cor); 
        g.fillRect(35,84,15,15);
    }
    
    public void desenhaMercado2(Graphics g,Color cor)
    {
         g.setColor(cor);
         g.fillRect(51, 84, 15, 15);   
    }
    
    protected ImageIcon createImageIcon( String path )
    {  
        ClassLoader cl = this.getClass().getClassLoader();
        java.net.URL imgURL = cl.getResource(path);
        
        if ( imgURL != null){
            return new ImageIcon( imgURL );
        } else {
            System.err.println(" Nao encontrou o ficheiro: " + path);
            return null;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        Graphics gr = getGraphics();
        
        gr.setColor(Color.red);
        gr.drawLine(e.getX(), e.getX(), e.getY(), e.getY());
       
        if (jogo.getEstadoactual() instanceof Aguarda_Movimento) {
            image1 = createImageIcon("img/s"+n+".jpg");
            img = image1.getImage();
            repaint();  
            //image1 = createImageIcon("img/"+n+".jpg");
            //img = image1.getImage();
            
           jogo.move(n);   
        }
        else if (jogo.getEstadoactual() instanceof Aguarda_Movimento_WormHole) {
                jogo.moveW(n);
        }
        else if(jogo.getEstadoactual() instanceof Aguarda_Compra){
            if(modelo.isPirata())
                jogo.compra("illegal");
            else if (modelo.isPlaneta()){
                int x=e.getX();int y =e.getY();
                if(  x > 35 && x < 50 && y> 84 && y <100){
                    jogo.compra(modelo.getNameMercado1());
                }
                else if(  x > 51 && x < 67 && y> 84 && y <100){
                    jogo.compra(modelo.getNameMercado2());
                }
            }
        }   
    }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) { }
}