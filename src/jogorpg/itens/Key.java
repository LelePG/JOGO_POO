/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.Fighting_Character;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Key extends Item {
    
    public Key(String nome, int peso, String descrip) {
        super(nome, peso,descrip);
    }

    @Override
    public void use(Fighting_Character F) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}