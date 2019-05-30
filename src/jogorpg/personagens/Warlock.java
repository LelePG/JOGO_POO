/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Warlock extends Personagem{
    
    public Warlock(int força, int ataque, int defesa, int energia,float carregar) {
        super(força, ataque, defesa, energia,carregar);
        this.setNome("Devon");
    }
    
    public void heal(Personagem P){
        P.setEnergia(P.getEnergia()+2);
        this.setEnergia(this.getEnergia()-1);
        if(this.getEnergia()<=0){
            System.out.println("Devon's dead");
        }
    }
    
}
