/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import galaxy.Spaceship;
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
import logicaJogo.Aguarda_Venda;

/**
 *
 * @author Utilizador
 */
public class PainelShip extends JPanel implements Observer,MouseListener{
    private ImageIcon image1;
    Image img;
    ModeloNave modelo;
    
    PainelShip(ModeloNave m)
    {
        modelo = m;
        modelo.addObserver(this);
        setVisible(true);
        image1 = createImageIcon("img/spaceship.jpg");
        
        img = image1.getImage();
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        this.revalidate();
        this.repaint();
        addMouseListener(this);
    }
    
    protected ImageIcon createImageIcon( String path ){
        
        ClassLoader cl = this.getClass().getClassLoader();
        java.net.URL imgURL = cl.getResource(path);
        
        if ( imgURL != null){
            return new ImageIcon( imgURL );
        } else {
            System.err.println(" Nao encontrou o ficheiro: " + path);
            return null;
        }
    }
        
     public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
        desenhaAtaque(g,modelo.getAtaque());
        desenhaCarga1(g);
        desenhaCarga2(g);
        desenhaCarga3(g);
       
     }
    public void desenhaCarga1(Graphics g)
    {
        if(modelo.temParaDesenhar(0)==1)
        {
            g.setColor(modelo.getCor(0));
            g.fillRect(23,72, 15, 15);
        }
    }
    public void desenhaCarga2(Graphics g)
    {
        if(modelo.temParaDesenhar(1)==1)
        {
            g.setColor(modelo.getCor(1));
            g.fillRect(43,72, 15, 15);
        }
    }
    public void desenhaCarga3(Graphics g)
    {
        if(modelo.getCapacidade()==2)
        {
            g.setColor(Color.GRAY);
            g.fillRect(61,72, 15, 15);
        }
        else if(modelo.temParaDesenhar(2)==1)
        {
            g.setColor(modelo.getCor(2));
            g.fillRect(61,72, 15, 15);
        }
    }
    
    public void desenhaAtaque(Graphics g,int f)
    {
        g.setColor(Color.GRAY);
        if(f==3)
            g.fillRect(42,20, 15, 15);
        if(f==4)
            g.fillRect(22,41, 15, 15);
        if(f==5)
            g.fillRect(62,41, 15, 15);
    }
    
    @Override
    public void update(Observable o, Object arg) 
    {
        revalidate();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        if(modelo.j.getEstadoactual() instanceof Aguarda_Compra){
            int x=e.getX();int y =e.getY();
             if(  x > 22 && x < 37 && y> 41 && y < 57)
                 modelo.aumentaAtaque();
             else if(x > 62 && x < 78 && y > 41 && y < 57)
                 modelo.aumentaAtaque();
             else if(x > 61 && x < 77 && y> 72 && y < 88)
                 modelo.aumentaCarga();
        }
        else if(modelo.j.getEstadoactual() instanceof Aguarda_Venda){
            int x=e.getX();int y =e.getY();
             if(  x > 23 && x < 39 && y> 72 && y < 88)
                modelo.vendeCarga(0);
             else if( x > 43 && x < 59 && y> 72 && y < 88)
                 modelo.vendeCarga(1);
             else if(x > 61 && x < 77 && y> 72 && y < 88)
                 modelo.vendeCarga(2);
        }
    }
        
    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
     
}
