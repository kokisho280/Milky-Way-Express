
package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logicaJogo.Aguarda_Compra;
import logicaJogo.Aguarda_Movimento;
import logicaJogo.Aguarda_Venda;
import logicaJogo.Jogo;

public class Principal2 extends JFrame
{
    PainelTabuleiro ptab;
    PainelShip pship;
    JPanel pWest;
    JButton btermina;
    JLabel lb = new JLabel();
    JLabel lb1 = new JLabel();
    JLabel lb2 = new JLabel();
    Jogo jogo;

    Container cp;
   
    Principal2(String nome,int x, int y, int w, int h,Jogo j)
    {
        super(nome);
        jogo = j;
        setLocation(x,y);
        setSize(w,h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
        inicializa();
    }
    
    public void inicializa()
    {
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(ptab = new PainelTabuleiro(jogo),BorderLayout.CENTER);
        pship = new PainelShip(new ModeloNave(jogo));
        cp.add(pWest = new JPanel(),BorderLayout.WEST);
        btermina = new JButton("Termina");
           
        pWest.add(pship); 
        pWest.add(lb);
        pWest.add(btermina);
        pWest.add(lb1);
        pWest.add(lb2);
        updateLabel();
            
        btermina.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){   
                if(jogo.getEstadoactual() instanceof Aguarda_Movimento)
                    jogo.finalizarMovimento();
                else if(jogo.getEstadoactual() instanceof Aguarda_Venda)
                    jogo.finalizarVenda();
                else if(jogo.getEstadoactual() instanceof Aguarda_Compra)
                    jogo.finalizarCompra();
                updateTabuleiro();
                updateLabel();
            }
        });
    }
    public void updateTabuleiro(){
        cp.remove(ptab);
        ptab=new PainelTabuleiro(jogo);
        cp.add(ptab,BorderLayout.CENTER);
        
        revalidate();
        repaint();      
    }
    public void updateLabel(){
        if (!jogo.termina())
        {
            lb.setText(""+ jogo.getCartaActual().getNome());
            if(jogo.getEstadoactual() instanceof Aguarda_Movimento)
                lb1.setText("MOVIMENTO");
            else if(jogo.getEstadoactual() instanceof Aguarda_Venda)
                lb1.setText("VENDA");
            else if(jogo.getEstadoactual() instanceof Aguarda_Compra)
                lb1.setText("COMPRA");
            else
                lb1.setText("WORMHOLE");
            lb2.setText(" "+jogo.getJogador().getCoins());
        }else
            lb1.setText("GAME OVER");
    }

    public static void main(String[] args) {
      Principal2  g =  new Principal2("A minha janela",600,600,600,600,new Jogo());
    }
}
