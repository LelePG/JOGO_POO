package jogorpg.world_of_zuul;

import jogorpg.personagens.Personagem;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import jogorpg.itens.Item;
import jogorpg.monsters.Monster;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Room 
{
    private String description;
    private String name;
    private HashMap<String, Room> exits; // stores exits of this room.
    private HashMap<String,Personagem> pessoas;
    private HashMap<String,Monster> monstros;
    private HashMap<String,Item> itens;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String name) 
    {
        this.name = name;
        this.description = description;
        exits = new HashMap<String, Room>();
        pessoas = new HashMap<String,Personagem>();
        monstros = new HashMap<String,Monster>();
        itens = new HashMap<String,Item>();
    }
    
    //GETTERS
    public String getName(){
         return this.name;
     }
      
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }
    
    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *     People: mom,dad
     *     Monsters: spider1,spider2
     *     Items: fork,spoon
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + "\n" + getPessoasString() +"\n"+ getMonstrosString() +"\n"+getItensString();
    }
    
    
    //EXIT RELATED
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
     /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
     public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += "-" + exit + "-";
        }
        return returnString;
    }
          /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    //END EXIT RELATED
    
    
    //PERSON RELATED
    /**
     * Puts a character in this room
     * @param nome Person's name
     * @param p Reference to person's object
     */
    public void setPessoa(String nome, Personagem p){
        pessoas.put(nome, p);
    }
    
    /**
     * Return a String describing which characters are in the room
     * @return list of all characters in the room
     */
    public String getPessoasString(){
        String ret = "People: ";
        if(pessoas.isEmpty()){
            return "You see none around.";
        }
        Set<String> keys = pessoas.keySet();
        for(String pessoas: keys){
            ret+="-" + pessoas+"-";
        }
        return ret;
    }
    
    /**
     * Removes a person from the room
     * @param nome Name of the person that shall be removed from the room
     */
    public void mataPessoa(String nome){
        if(pessoas.containsKey(nome)){
           pessoas.remove(nome);
        }
        else{
            System.out.println("ERROR, person not found");
        }
    }
    
    public Personagem getPessoa(String nome){
        if(pessoas.containsKey(nome)){
           return pessoas.get(nome);
        }
        else{
            return null;
        }
    }
    //END PERSON RELATED
    
    //MONSTER RELATED
     public void setMonstro(String nome, Monster m){
        monstros.put(nome, m);
     }
     
     public String getMonstrosString(){//Pegar a classe do bicho
        String ret = "Monsters : ";
        if(monstros.isEmpty()){
            return "There are no monsters around. You are safe.";
        }
        for(String key: monstros.keySet()){
            ret+="-" + key+"-"  ;
        }
        return ret;
    }
     
     public void mataMonstro(String nome){
        if(monstros.containsKey(nome)){
            monstros.remove(nome);
        }
        else{
            System.out.println("ERROR, monster not found.");
        }
    }
     
     public Monster getMonstro(String nome){//DEVERIA RETORNAR O MONSTRO COM O QUAL EU QUERO LUTAR, MAS POR ALGUM MOTIVO SEMPRE RETORNA NULL PRA MAIN
        if(monstros.containsKey(nome)){
           return monstros.get(nome);
        }
        else{
            return null;
        }
        
    }
     public boolean sairSala(){
         return monstros.isEmpty();
     }
     
     public void emptyMonsters(Room R){
         for(Monster m: monstros.values()){
            m.dropAll(R);
        }
         monstros.clear();
     }
     
     public String[] monstroLabel(){
        String[] ret;
        int c=0;
        ret = new String[monstros.size()];
        for(Monster key: monstros.values()){
            ret[c] = key.getNome();
            c++;
        }
        
        return ret;
    }
    //END MONSTER RELATED
     
    //ITEM RELATED
     
     public void setItem(String nome, Item i){
         itens.put(nome, i);
     }
     
    public String getItensString(){
        String ret = "Itens: ";
        if(itens.isEmpty()){
            return "There are no itens here.";
        }
        for(String key: itens.keySet()){
            ret+="-"+key+"-";
        }
        return ret;
    }
    
    public Item getItem(String nome){//DEVERIA RETORNAR O ITEM QUE EU QUERO PEGA
        if(itens.containsKey(nome)){
           return itens.get(nome);
        }
        else{
            return null;
        }
        
    }
    
    public void removeItem(String nome){
        if(itens.containsKey(nome)){
            itens.remove(nome);
        }
        else{
            System.out.println("This item does not exist");
        }
        
    }
 
}

