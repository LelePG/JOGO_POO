/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.PersonagemQueLuta;

/**
 *
 * @author lele
 */
public class Food extends Item {

    private final int give_energy;

    public Food(String nome, int peso, int give_energy, String description) {
        super(nome, peso, description);
        this.give_energy = give_energy;
        this.setDestroy(true);
    }

    @Override
    public void use(PersonagemQueLuta F) {
        F.setEnergia(F.getEnergia() + this.give_energy);
    }

    @Override
    public String getPrintLine() {
        return this.getNome() + " restored some of your energy.";
    }

}
