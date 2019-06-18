/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.monsters.Monster;
import jogorpg.personagens.Fighting_Character;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Scorpion extends Monster{
   private boolean poison;
    public Scorpion(String nome, boolean p){
        this.setNome(nome);
        this.setAtaque(6);
        this.setDefesa(4);
        this.setMax_energia(10);
        this.setEnergia(10);
        this.setMoedas(70);
        this.poison = p;
    }
    @Override
    public void attack(Fighting_Character P) {
        if(P.getAtaque()>this.getAtaque()){
            P.decremento(this.getAtaque()/3);
            this.decremento(P.getAtaque()/2);
        }
        else if(P.getDefesa()<=this.getAtaque()){
            P.decremento(this.getAtaque()- P.getDefesa());
            this.decremento(this.getAtaque()/2);
        }
        if(this.poison && this.getEnergia()<5 && !P.isPoisoned()){
            P.setPoison(true);
            System.out.println("YOU ARE POISONED");
        }

    }
    @Override
    public String classe(){
        return "SCORPION";
    }
   
    
    
    
}
