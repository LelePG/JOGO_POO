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
public class BossScorpion extends BossMonster{
   
    public BossScorpion(String nome){
        this.setNome(nome);
        this.setAtaque(20);
        this.setDefesa(16);
        this.setMax_energia(25);
        this.setEnergia(25);
        this.insereItem( new Defense_Weapon ("Light_Shield",3,"a fragile-looking shield.",2,5,25));
	this. insereItem(new Food("Scorpion_tail",15,30,"i'ts raw, but can still be eaten."));
    }
    @Override
    public void attack(Fighting_Character P) {
        if(P.getDefesa()<this.getAtaque()){
            P.decremento(this.getAtaque()/2);
            this.decremento(10-this.getAtaque());
        }
        else if(P.getDefesa()>=this.getAtaque()){
            P.decremento(this.getAtaque()-P.getDefesa()/2);
            this.decremento(P.getAtaque()/3);
        }
    }
    
    @Override
    public String classe(){
        return "BOSS SCORPION";
    }
        
   
    
    
    
}
