/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.*;

/**
 *
 * @author lele
 */
public abstract class Potion extends Item {
    private int qualidade;
    public Potion(String nome, int peso, String description, int qualidade) {
        super(nome, peso, description);
        this.qualidade = qualidade;
        this.setDestroy(true);
    }
    
    public int getQualidade(){
        return this.qualidade;
    }
    
    public void setQualidade(int q){
        if(q>5){
            this.qualidade = 5;
            return;
        }
        else if(q<0){
            this.qualidade = 0;
            return;
        }
        this.qualidade = q;
    }
    
    @Override
    public String getDescription(){
        return super.getDescription() + ", quality : "+this.getQualidade();
    }
    
    public abstract String getPotionType();
    
    public abstract void use(Fighting_Character F);
    
}
