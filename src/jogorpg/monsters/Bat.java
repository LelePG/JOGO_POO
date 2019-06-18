/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.personagens.Fighting_Character;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Bat extends Monster{
 public Bat(String nome){
        this.setNome(nome);
        this.setAtaque(5);
        this.setDefesa(4);
        this.setMax_energia(10);
        this.setEnergia(10);
        this.setMoedas(2);
    }
    @Override
    public String classe(){
        return "BAT";
    }

    @Override
    public void attack(Fighting_Character P) {
        if(P.getDefesa()>this.getAtaque()){
            P.decremento(this.getAtaque()/2);
            this.decremento(P.getAtaque()/3);
        }
        else if(P.getDefesa()<=this.getAtaque()){
            P.decremento(this.getAtaque()+1);
            this.decremento(1);
         }
    }
}