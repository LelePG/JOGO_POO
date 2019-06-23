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
    public BossSnake(String nome){
        this.setNome(nome);
        this.setAtaque(18);
        this.setDefesa(16);
        this.setMax_energia(25);
        this.setEnergia(25);
        this.insereItem(new Defense_Weapon("Metal_Shield",10," a metal Shield.",4,23,35));
	this. insereItem(new Attack_Weapon("Heavy_Spear",8,"a heavy spear.",20,10,35));
       this. insereItem(new Food("Snake_tail",8,20,"i'ts raw, but can still be eaten."));
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


