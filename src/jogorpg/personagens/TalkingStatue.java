/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author lele
 */
public class TalkingStatue extends Personagem {
 private File Statue_Lines;
    Scanner scanner;
    public TalkingStatue(String nome) {
        this.setNome(nome);
        Statue_Lines = new File("src/jogorpg/resources/Statue_Lines.txt");
        scanner =null;
        try{
            scanner = new Scanner(Statue_Lines);
            
        }catch(FileNotFoundException e){
            System.out.println("Cannot talk to "+this.getNome());
        }
    }
    
    @Override
    public void talk(){
        try{
        String line = scanner.nextLine();
        
        while(scanner.hasNext() && !line.equals("--XX--")){
            System.out.println(line);
            line = scanner.nextLine();
            //if(!scanner.hasNext()){
            //System.out.println("Pick all you need, and drop what you don't. The King made this room for it.");
            //}
        }    
        }catch (NoSuchElementException e){
             System.out.println("'Pick all you need, and drop what you don't. The King made this room for it.'");
         }   
                
    }
    
}
