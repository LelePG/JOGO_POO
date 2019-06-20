/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

/**
 *
 * @author lele
 */
public abstract class PersonagemComInventario extends Personagem{
    private float l_peso;

    public PersonagemComInventario(float l_peso) {
        this.l_peso = l_peso;
    }
    
    
    public float getL_Peso(){
        return this.l_peso;
    }
    
    @Override
    public abstract void talk();
    
}
