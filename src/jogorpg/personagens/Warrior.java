/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lele
 */
public class Warrior extends Personagem{
     BufferedReader reader;
    public Warrior(String nome) {
        this.setNome(nome);
        reader = new BufferedReader(new InputStreamReader(Fairy.class.getResourceAsStream("/jogorpg/resources/Warrior_Lines.txt")));
       
    }
    
    @Override
    public void talk(){
       // String line = null;  
        try {
            String line = reader.readLine();
            while(!(line.equals("--XX--"))){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("'I hope you know how to figth. You'll need it.");
        } catch (NullPointerException n){
           System.out.println("'Try to keep yourself alive. You won't be able to save your sister if you are dead."); 
        }

    }
}
