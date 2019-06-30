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
public class AttackWeapon extends Weapon {

    public AttackWeapon(String nome, int peso, String description, int damage, int defence, int durabilidade) {
        super(nome, peso, description, damage, defence, durabilidade);
    }

    @Override
    public void use(PersonagemQueLuta F) {
        this.setDurabilidade(this.getDurabilidade() - 1);
        if (this.getDurabilidade() <= 0) {
            this.setDestroy(true);
        }
    }

    public void addModificador(PersonagemQueLuta F) {
        F.setAtaque(F.getAtaque() + this.getDamage() / 2);
        F.setDefesa(F.getDefesa() + this.getDefense() / 3);
    }

    public void removeModificador(PersonagemQueLuta F) {
        F.setAtaque(F.getAtaque() - this.getDamage() / 2);
        F.setDefesa(F.getDefesa() - this.getDefense() / 3);
    }

    @Override
    public String getPrintLine() {
        return "attacked using " + this.getNome();
    }
}
