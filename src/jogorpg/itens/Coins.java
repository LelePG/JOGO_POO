/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.Fighting_Character;

/**
 *
 * @author lele
 */
public class Coins extends Item {
    private int coin_number;

    public Coins(String nome, int peso, String description, int number) {
        super(nome, peso, description);
        this.setCoinNumber(number);
    }
    
   public int setCoinNumber(int n){
       int i = this.getCoinNumber() + n;
       if(i<=1000){
           this.coin_number =i;
           return -1;//numero negativo indica que a operação foi realizada com sucesso
       }
       else if(i>1000){
           i -=1000;
           i*=(-1);//deixa o numero positivo
       }
       return i;
   }
   
   public int getCoinNumber(){
       return this.coin_number;
   }

    public boolean full(){
        if(this.getCoinNumber()>=1000){
            return true;
        }
        return false;
    }
    @Override
    public String getDescription(){
        return super.getDescription() +"("+Integer.toString(coin_number)+").";
    }
    @Override
    public void use(Fighting_Character F) {
        System.out.println("Not supported yet");
    }

    @Override
    public String getPrintLine() {
         System.out.println("Not supported yet");
         return "Not supported yet";
    }
    
    
}
