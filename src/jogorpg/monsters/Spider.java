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
public class Spider extends Monster{
    private boolean poison;
    public Spider(String nome,boolean p){
        this.setNome(nome);
        this.setMax_energia(13);
        this.setEnergia(13);
        this.poison = p;
        if(this.poison){
            this.setAtaque(7);
            this.setDefesa(4);
        }
        else{
            this.setAtaque(5);
            this.setDefesa(5);
        }
        
        
    }
    @Override
    public void attack(Personagem P){
        if(P.getDefesa()>this.getAtaque()){
            P.decremento(this.getAtaque());
            this.decremento(this.getDefesa()/2);
        }
        else if(P.getDefesa()<=this.getAtaque()){
            P.decremento(this.getAtaque()/3);
            this.decremento(P.getAtaque()/this.getAtaque());
         }
    }
    @Override
    public void follow(Personagem P){
        System.out.println(P.getNome() + "is trying to charm the spider.");
        if(P instanceof Charmer){
        System.out.println("Now you have a pet spider");
        }
        else{
            System.out.println("OUCH! The spider bit him");
            P.decremento(3);
        }
    }
    @Override
    public String classe(){
        return "SPIDER";
    }
}
