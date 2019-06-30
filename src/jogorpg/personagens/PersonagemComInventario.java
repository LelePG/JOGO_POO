/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.util.HashMap;
import jogorpg.itens.Item;

/**
 *
 * @author lele
 */
public abstract class PersonagemComInventario extends Personagem {

    private final float l_peso;
    private HashMap<String, Item> inventario;

    public PersonagemComInventario(float l_peso) {
        this.l_peso = l_peso;
        inventario = new HashMap<>();
    }

    public float getL_Peso() {
        return this.l_peso;
    }

    public boolean pickItem(Item i) {
        if (i.getPeso() + this.pesoInventario() > this.getL_Peso()) {
            // System.out.println("You can't carry this. It's too heavy for you.");
            return false;
        }
        inventario.put(i.getNome(), i);
        return true;
    }

    public Item removerItem(String nome) {
        Item aux;
        if (inventario.containsKey(nome)) {
            aux = inventario.get(nome);
            inventario.remove(nome);
            return aux;
        } else {
            //Trato isso na Game System.out.println("You do not have this item.");
            return null;
        }

    }

    public String getInventarioString() {
        String ret = "Inventory: ";
        if (inventario.isEmpty()) {
            return "Your inventory is empty. ";
        }
        for (String key : inventario.keySet()) {
            ret += " " + key;
        }
        return ret;
    }

    public int pesoInventario() {//for each que retorna o peso total do inventario
        int peso = 0;
        for (String keys : inventario.keySet()) {
            peso += inventario.get(keys).getPeso();
        }
        return peso;
    }

    public void displayInventory() {
        if (inventario.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
        inventario.forEach((k, v) -> {
            System.out.println(v.getDescription());
        });

    }

    public boolean inventarioVazio() {
        return inventario.isEmpty();
    }

    @Override
    public abstract void talk();

}
