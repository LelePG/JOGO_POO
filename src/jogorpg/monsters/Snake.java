/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.personagens.PersonagemQueLuta;

/**
 *
 * @author lele
 */
public class Snake extends Monster {

    private final boolean poison;

    public Snake(String nome, boolean p) {
        this.setNome(nome);
        this.poison = p;
        this.setMax_energia(7);
        this.setEnergia(7);
        if (this.poison) {
            this.setAtaque(5);
            this.setDefesa(2);
            this.setMoedas(20);
        } else {
            this.setAtaque(3);
            this.setDefesa(3);
            this.setMoedas(20);
        }

    }

    @Override
    public void attack(PersonagemQueLuta P) {
        if (P.getDefesa() > this.getAtaque()) {
            P.decremento(this.getAtaque() / 4);
            this.decremento(P.getAtaque() / 2);

        } else if (P.getDefesa() <= this.getAtaque()) {
            P.decremento(5);
            this.decremento(1);
        }
        if (this.poison && this.getEnergia() < 2 && !P.isPoisoned()) {
            P.setPoison(true);
            System.out.println("YOU ARE POISONED");
        }
    }

    @Override
    public String classe() {
        return "SNAKE";
    }

}
