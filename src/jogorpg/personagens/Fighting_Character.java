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
public abstract class Fighting_Character extends PersonagemComInventario{
    private int ataque;
    private int defesa;
    private float energia;
    private int max_energia;
    private int valor_maximo_atributos;
    public Fighting_Character(int ataque, int defesa, int energia, float carregar) {
        super(carregar);
        this.ataque = ataque;
        this.defesa = defesa;
        this.energia = energia;
        this.valor_maximo_atributos = 30;
    }
    public int getMax_energia(){
        return this.max_energia;
    } 

    public int getDefesa() {
        return defesa;
    }
    public float getEnergia(){
        return this.energia;
    }

    public int getAtaque() {
        return ataque;
    }
    
     public void setMax_energia(int i){
        this.max_energia = i;
    }
    
    public void setEnergia(float energia) {
        if(energia>this.max_energia){
            this.energia = max_energia;
        }
        this.energia = energia;
    }
    
     public void setAtaque(int ataque) {
        this.ataque = ataque;
        if(this.ataque>this.valor_maximo_atributos){
            this.ataque=this.valor_maximo_atributos;
        }
    }
    
    public void setDefesa(int def){
        this.defesa =def;
        if(this.defesa>this.valor_maximo_atributos){
            this.defesa = this.valor_maximo_atributos;
        }
    }
     public void decremento(float n){
        if(this.getEnergia()>0 && this.getEnergia()<=this.getMax_energia()){
            this.energia-=n;
        if(this.getEnergia()<=0){
             this.died();
            }
        }
    }
        
      public void imprimirStatus(){
        System.out.println("# Name: "+ this.getNome());
        System.out.println("# Energy: "+ this.getEnergia());
        System.out.println("# Attack: "+this.ataque);
        System.out.println("# Defence: "+this.getDefesa());
        
     }
     public abstract void talk();
}
