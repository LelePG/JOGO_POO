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
public abstract class Weapon extends Item {

    private final int damage;
    private final int defence;
    private int durabilidade;

    public Weapon(String nome, int peso, String description, int damage, int defence, int durabilidade) {
        super(nome, peso, description);
        this.damage = damage;
        this.defence = defence;
        this.durabilidade = durabilidade;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDefense() {
        return this.defence;
    }

    public int getDurabilidade() {
        return this.durabilidade;
    }

    public void setDurabilidade(int d) {
        int max_durab = 30;
        if (d > max_durab) {
            this.durabilidade = max_durab;
            return;
        }
        this.durabilidade = d;
    }

    @Override
    public abstract String getPrintLine();

    @Override
    public abstract void use(PersonagemQueLuta F);

}
