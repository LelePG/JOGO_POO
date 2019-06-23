/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.util.ArrayList;
import java.util.HashMap;
import jogorpg.itens.*;
import jogorpg.monsters.*;


/**
 *
 * @author lele
 */
public class Hero extends Fighting_Character{
    private HashMap<String,Item> inventario;
    private Coins moedas;
    private Attack_Weapon Attack_Weapon;
    private Defense_Weapon Shield;
    
    public Hero( int ataque, int defesa, int energia,float carregar) {
        super( ataque, defesa, energia,carregar);
        this.setMax_energia(35);
        moedas = new Coins("Coins1",1,"golden coins",100);
        inventario = new HashMap<String,Item>();
        this.pickItem(moedas);
        this.Attack_Weapon = null;
        this.Shield = null;
    }
    
    public Weapon getAttackWeapon(){
        return this.Attack_Weapon;
        
    }
    
    public Weapon getDefenseWeapon(){
        return this.Shield;
    }
    
    public boolean pickItem(Item i){
        if(i.getPeso()+this.pesoInventario()>this.getL_Peso()){
           // System.out.println("You can't carry this. It's too heavy for you.");
            return false;
        }
        inventario.put(i.getNome(),i); 
        return true;
    }
    
    
    
    public Item removerItem(String nome){
        Item aux;
        if(inventario.containsKey(nome)){
            aux = inventario.get(nome);
            inventario.remove(nome);
            return aux;
        }
        else{
           //Trato isso na Game System.out.println("You do not have this item.");
            return null;
        }
        
    }
    
    public String getInventarioString(){
        String ret = "Inventory: ";
        if(inventario.isEmpty()){
            return "Your inventory is empty. ";
        }
        for(String key: inventario.keySet()){
            ret+=" "+key;
        }
        return ret;
    }
    
    public int pesoInventario(){//for each que retorna o peso total do inventario
        int peso = 0;
        for(String keys: inventario.keySet()){
            peso += inventario.get(keys).getPeso();
        }
        return peso;
    }

    public void lutar(Monster M){
        M.attack(this);//A MECÂNICA DE ATAQUE PROPRIAMENTE TÁ RELACIONADA AO MONSTRO, E NÃO AO PERSONAGEM
        System.out.println("#################");
        System.out.println(this.getNome()+ " VS " + M.getNome());
        System.out.println("HERO STATUS:");
        this.imprimirStatus();
        if(!this.isAlive()){//Os decrementos de Monstro e de Personagem já matam eles quando for preciso
           System.out.println(this.getNome()+" WAS KILLED");
           System.out.println("#################");
           return;
       }
       if(!M.isAlive()){//caso o monstro tenha morrido, não imprime os status dele
           System.out.println(M.getNome()+" WAS KILLED");
           System.out.println("#################");
           return;
       }
       System.out.println("MONSTER STATUS:");
       M.imprimirStatus();
       System.out.println("#################");
      }  
    
    public void equipAttackWeapon(Attack_Weapon w){
        this.Attack_Weapon = w;
        w.addModificador(this);
    }
    
    public Weapon unequipAttackWeapon(){
        this.Attack_Weapon.removeModificador(this);
        Weapon aux = this.Attack_Weapon;
        this.Attack_Weapon = null;
        return aux;
    }
    
    public void equipShield(Defense_Weapon w){
        this.Shield = w;
        w.addModificador(this);
    }
    
    public Weapon unequipShield(){
        Weapon aux = this.Shield;
       this.Shield.removeModificador(this);
        this.Shield = null;
        return aux;
    }
    
    public void displayInventory(){
        if(inventario.isEmpty()){
            System.out.println("Your inventory is empty.");
            return;
        }
        inventario.forEach((k,v)->{
        System.out.println(v.getDescription()); });
       
        
    }
    @Override
    public void talk() {
        System.out.println("I must find Ilea.");
    }
    
    public String[] inventarioLabel(){
        String[] ret;
        int c=0;
        ret = new String[inventario.size()];
        for(Item key: inventario.values()){
            ret[c] = key.getDescription();
            c++;
        }
        
        return ret;
    }
    
}
