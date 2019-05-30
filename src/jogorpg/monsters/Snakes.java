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
public class Snakes extends Monster {
    private boolean poison;
   
    public Snakes(String nome, boolean p){
        this.setNome(nome);
        this.poison = p;
        this.setMax_energia(7);
        this.setEnergia(7);
        if(this.poison){
            this.setAtaque(5);
            this.setDefesa(2);
        }
        else{
            this.setAtaque(3);
            this.setDefesa(3); 
        }
        
    }
    @Override
    public void attack(Personagem P){
        if(P.getDefesa()>this.getAtaque()){
            P.decremento(this.getAtaque()/4);
           this.decremento(P.getAtaque()/2);
    
        }
        else if(P.getDefesa()<=this.getAtaque()){
            P.decremento(5);
            this.decremento(1);
        }
        //adicionar envenenamento
    }
    @Override
    public void follow(Personagem P){
        System.out.println(P.getNome() + "is trying to charm the snake.");
        if(P instanceof Charmer){
        System.out.println("Now you have a pet Snake");
        }
        else{
            P.decremento(5);
            System.out.println("OUCH! The snake bit him");
        }
    }
     
    @Override
    public String classe(){
        return "SNAKE";
    }
   
    
    
   
    
}
