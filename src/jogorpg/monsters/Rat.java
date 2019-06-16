/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;


import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Rat extends Monster{
    
    public Rat(String nome){
        this.setNome(nome);
        this.setAtaque(3);
        this.setDefesa(3);
        this.setMax_energia(6);
        this.setEnergia(6);
    }

    @Override
    public void attack(Personagem P) {
        P.decremento(this.getAtaque());
        this.decremento(P.getAtaque()/2);
    }

    @Override
    public String classe() {
        return "RAT";
    }
    
}
