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
public class Bat extends Monster{
 public Bat(String nome){
        this.setNome(nome);
        this.setAtaque(2);
        this.setDefesa(4);
        this.setMax_energia(10);
        this.setEnergia(10);
    }
    @Override
    public void attack(Personagem P){
        if(P.getDefesa()>this.getAtaque()){
            P.decremento(this.getAtaque()/2);
            this.decremento(P.getAtaque()/3);
        }
        else if(P.getDefesa()<=this.getAtaque()){
            P.decremento(this.getAtaque()+1);
            this.decremento(1);
         }
    }
    @Override
    public void follow(Personagem P){
        System.out.println(P.getNome() + "is trying to charm the bat.");
        if(P instanceof Charmer){
        System.out.println("Now you have a pet Bat");
        }
        else{
            System.out.println("OUCH! The bat bit him");
            P.decremento(3);
        }
    }
    @Override
    public String classe(){
        return "BAT";
    }
}