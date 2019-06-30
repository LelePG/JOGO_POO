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
public class Key extends Item {

    public Key(String nome, int peso, String descrip) {
        super(nome, peso, descrip);
    }

    @Override
    public void use(PersonagemQueLuta F) {
        System.out.println("You have to try to open something with the key.");
    }

    @Override
    public String getPrintLine() {
        return "You have to try to open something with the key.";
    }

}
