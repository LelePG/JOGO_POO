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
public class DefenseWeapon extends Weapon {

    public DefenseWeapon(String nome, int peso, String description, int damage, int defence, int durabilidade) {
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
        F.setAtaque(F.getAtaque() + this.getDamage() / 3);
        F.setDefesa(F.getDefesa() + this.getDefense() / 2);
    }

    public void removeModificador(PersonagemQueLuta F) {
        F.setAtaque(F.getAtaque() - this.getDamage() / 3);
        F.setDefesa(F.getDefesa() - this.getDefense() / 2);
    }

    @Override
    public String getPrintLine() {
        return "defended with " + this.getNome();
    }

}
