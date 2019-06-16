/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.monsters.Monster;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class BigScorpion extends Monster{
   
    public BigScorpion(String nome){
        this.setNome(nome);
        this.setAtaque(7);
        this.setDefesa(6);
        this.setMax_energia(20);
        this.setEnergia(20);
    }
    @Override
    public void attack(Personagem P){
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
        return "BIG SCORPION";
    }
        
   
    
    
    
}
