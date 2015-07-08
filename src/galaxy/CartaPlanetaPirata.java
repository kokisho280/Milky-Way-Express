
package galaxy;

import java.util.ArrayList;



public class CartaPlanetaPirata extends Carta {
    
    Illegal mercado = new Illegal();
    ArrayList<Integer> preco;
    
    
    public CartaPlanetaPirata(boolean virada, int linha, int coluna,String name, ArrayList<Integer> p) {
        super(virada, linha, coluna,name);
        this.mercado = null;
        preco = p;
        
    }

    public Illegal getMercado() {
        return mercado;
    }

    public int compraMercado(){//so vende illegal retorna o preço
        if(mercado != null)
        {
            mercado = null;
            return 1;
        }
        return 0;
    }
   public Recurso compraIllegal(){
       Illegal temp;
       if(mercado != null){
           temp = mercado;
           mercado = null;
           return temp;
         }
       return null;
   }
    public int ListaPrecoPlaneta(Recurso r){
       if(r instanceof Water)
           return preco.get(0);
       else if(r instanceof Food)
           return preco.get(1);
       else if(r instanceof MedicalSupplies)
           return preco.get(2);
       else return 0;
   }
    public Integer Listar(int i){
        return preco.get(i);
    }
    public int vendePlaneta(Recurso r){
        int p;
        p= ListaPrecoPlaneta(r);
        if(p == 0)
            return 0;
        if(mercado != null)
            return p+1;
        else
            return p;
            
    }
    public boolean reabasteceMercado(){
        if(mercado == null)
            return true;
        return false;
    }
    public void setMercadoPirata(Illegal I){
        mercado = I;
    }
}
