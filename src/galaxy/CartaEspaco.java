
package galaxy;

public class CartaEspaco extends Carta {
    
   
    
    public CartaEspaco(boolean virada, int linha, int coluna,String n) {
        super(virada,linha,coluna,n);
        
       
    }

    

    @Override
    public void setVirada(boolean virada) {
        super.setVirada(virada);
    }

    @Override
    public boolean isVirada() {
        return super.isVirada();
    }
    
}
