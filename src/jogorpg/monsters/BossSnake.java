/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;


import jogorpg.itens.*;
import jogorpg.personagens.Fighting_Character;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class BossSnake extends BossMonster{
    private Item i;
   
    public BossSnake(String nome){
        this.setNome(nome);
        this.setAtaque(18);
        this.setDefesa(16);
        this.setMax_energia(25);
        this.setEnergia(25);
        i = new Weapon("Dark-Shield",2,"A Dark Iron Shield.",0,4,20);
    }
    
    @Override
    public void attack(Fighting_Character P) {
        if(P.getDefesa()>this.getAtaque()){
            P.decremento(this.getAtaque()/2);
            this.decremento(P.getDefesa()- this.getAtaque());
        }
        else if(P.getDefesa()<=this.getAtaque()){
            P.decremento(3);
            this.decremento(2);
        }
    }
    @Override
    public String classe(){
        return "BOSS SNAKE";
    }
   
    
    
   
    
}


