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
public class Witch extends Personagem {
    
    BufferedReader reader;
    
    public Witch(String nome) {
        this.setNome(nome);
        reader = new BufferedReader(new InputStreamReader(Fairy.class.getResourceAsStream("/jogorpg/resources/Witch_Lines.txt")));
       
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
            System.out.println("'Good luck, child.'");
        } catch (NullPointerException n){
           System.out.println("'Go away, before they arrive.'"); 
        }

    }
}
