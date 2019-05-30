/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.personagens.Charmer;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class BigSnake extends Monster{
 
   
    public BigSnake(String nome){
        this.setNome(nome);
        this.setAtaque(8);
        this.setDefesa(6);
        this.setMax_energia(17);
        this.setEnergia(17);
    }
    
    @Override
    public void attack(Personagem P){
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
    public void follow(Personagem P){
        System.out.println(P.getNome() + "is trying to charm the Big snake.");
        if(P instanceof Charmer){
        System.out.println("Now you have a HUGE pet Snake");
        }
        else{
            P.decremento(8);
            System.out.println("OUCH! The Big snake bit him");
        }
    }
    @Override
    public String classe(){
        return "BIG SNAKE";
    }
   
    
    
   
    
}


