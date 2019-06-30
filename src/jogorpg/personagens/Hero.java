/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import jogorpg.itens.*;
import jogorpg.monsters.*;


/**
 *
 * @author lele
 */
public class Hero extends Fighting_Character{
    
    private Coins moedas;
   
    
    public Hero( int ataque, int defesa, int energia,float carregar) {
        super( ataque, defesa, energia,carregar);
        this.setMax_energia(35);
        moedas = new Coins("Coins1",1,"golden coins",100);
       
        this.pickItem(moedas);
  
    }
    
    
    

    public void lutar(Monster M){
        M.attack(this);//A MECÂNICA DE ATAQUE PROPRIAMENTE TÁ RELACIONADA AO MONSTRO, E NÃO AO PERSONAGEM
        this.equipmentModifiers(M);//depois da batalha são adicionados os valores de modificadores caso o herói tenha algum equipamento
        System.out.println("#################");
        System.out.println(this.getNome()+ " VS " + M.getNome());
        System.out.println("HERO STATUS:");
        this.imprimirStatus();
        if(!this.isAlive()){//Os decrementos de Monstro e de Personagem já matam eles quando for preciso
           System.out.println(this.getNome()+" WAS KILLED");
           System.out.println("#################");
           return;
       }
       if(!M.isAlive()){//caso o monstro tenha morrido, não imprime os status dele
           System.out.println(M.getNome()+" WAS KILLED");
           System.out.println("#################");
           return;
       }
       System.out.println("MONSTER STATUS:");
       M.imprimirStatus();
       System.out.println("#################");
      }  
    
    
    @Override
    public void talk() {
        System.out.println("I must find Ilea.");
    }
    
    
     public int sorte(int diceSides){
        int roll=0;
        Random rand = new Random();
        roll = rand.nextInt(diceSides)+1;
        return roll;
    }
    
}
