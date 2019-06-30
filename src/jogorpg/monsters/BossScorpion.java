/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.itens.*;
import jogorpg.personagens.PersonagemQueLuta;
/**
 *
 * @author lele
 */
public class BossScorpion extends BossMonster {

    public BossScorpion(String nome) {
        this.setNome(nome);
        this.setAtaque(20);
        this.setDefesa(16);
        this.setMax_energia(30);
        this.setEnergia(30);
        this.insereItem(new DefenseWeapon("Light_Shield", 3, "a fragile-looking shield.", 2, 5, 25));
        this.insereItem(new Food("Scorpion_tail", 15, 30, "i'ts raw, but can still be eaten."));
    }

    @Override
    public void attack(PersonagemQueLuta P) {
        if (P.getDefesa() < this.getAtaque() / 2) {
            P.decremento(this.getAtaque() / 2);
            this.decremento(P.getAtaque() / 3);
        } else if (P.getDefesa() >= this.getAtaque() / 2) {
            P.decremento(this.getAtaque() / 3 - P.getDefesa() / 2);
            this.decremento(P.getAtaque() / 3);
        }

    }

    @Override
    public String classe() {
        return "BOSS SCORPION";
    }

}
