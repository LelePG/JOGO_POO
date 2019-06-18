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
public class Poison_Potion extends Potion{
  
    public Poison_Potion(String nome, int peso, String description, int qualidade) {
        super(nome, peso, description, qualidade);
    }

  

    @Override
    public void use(Fighting_Character F) {
        if(F.isPoisoned() && this.getQualidade()>=0){
            F.setPoison(false);
        }
    }
    
}
