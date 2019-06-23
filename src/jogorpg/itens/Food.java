/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.Fighting_Character;



/**
 *
 * @author lele
 */
public class Food extends Item{
    private int give_energy;
    
    public Food(String nome, int peso, int give_energy, String description) {
        super(nome, peso, description);
        this.give_energy = give_energy;
        this.setDestroy(true);
    }

    @Override
    public void use(Fighting_Character F) {
        F.setEnergia(F.getEnergia()+this.give_energy);
    }

    @Override
    public String getPrintLine() {
        return this.getNome()+" restored some of your energy.";
    }
    
}
