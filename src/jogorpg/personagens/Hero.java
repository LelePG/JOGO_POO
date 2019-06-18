/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.util.HashMap;
import jogorpg.itens.Item;
import jogorpg.itens.Weapon;
import jogorpg.monsters.Monster;


/**
 *
 * @author lele
 */
public class Hero extends Fighting_Character{
    private HashMap<String,Item> inventario;
    private int moedas = 0;
    
    public Hero( int ataque, int defesa, int energia,float carregar) {
        super( ataque, defesa, energia,carregar);
        this.setMax_energia(35);
        inventario = new HashMap<String,Item>();
    }
    
    
    public void pickItem(Item i){
        if(i.getPeso()+this.pesoInventario()>this.getL_Peso()){
            System.out.println("You can't carry this. It's too heavy for you.");
            return;
        }
        else{
            inventario.put(i.getNome(),i); 
            this.incrementaStatus((Weapon)i);
        }
    }
    
    public Item removerItem(String nome){
        Item aux;
        if(inventario.containsKey(nome)){
            aux = inventario.get(nome);
            inventario.remove(nome);
            if(aux instanceof Weapon){
                this.decrementaStatus((Weapon)aux);
            }
            return aux;
        }
        else{
           // System.out.println("You do not have this item.");
            return null;
        }
        
    }
    
    
    private void decrementaStatus(Weapon w){
        this.setAtaque(this.getAtaque() - w.getDamage()/2);
        this.setDefesa(this.getDefesa() - w.getDefense()/2);
    }

    private void incrementaStatus(Weapon w){
        this.setAtaque(this.getAtaque() + w.getDamage()/2);
        this.setDefesa(this.getDefesa() + w.getDefense()/2);
    }
    public String getInventarioString(){
        String ret = "Inventory: ";
        if(inventario.isEmpty()){
            return "Your iventory is empty. ";
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

    @Override
    public void talk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
