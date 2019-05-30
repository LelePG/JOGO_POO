/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.monsters.Monster;
import jogorpg.personagens.Charmer;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Scorpion extends Monster{
   
    public Scorpion(String nome){
        this.setNome(nome);
        this.setAtaque(6);
        this.setDefesa(4);
        this.setMax_energia(6);
        this.setEnergia(4);
    }
    @Override
    public void attack(Personagem P){
        if(P.getAtaque()>this.getAtaque()){
            P.decremento(this.getAtaque()/3);
            this.decremento(P.getAtaque()/2);
        }
        else if(P.getDefesa()<=this.getAtaque()){
            P.decremento(this.getAtaque()- P.getDefesa());
            this.decremento(this.getAtaque()/2);
        }

    }
    @Override
    public void follow(Personagem P){
        System.out.println(P.getNome() + "is trying to charm the scorpion.");
        if(P instanceof Charmer){
        System.out.println("Now you have a pet Scorpion");
        }
        else{
            P.decremento(6);
            System.out.println("OUCH! The scorpion bit him");
        }
    }
    
    @Override
    public String classe(){
        return "SCORPION";
    }
   
    
    
    
}
