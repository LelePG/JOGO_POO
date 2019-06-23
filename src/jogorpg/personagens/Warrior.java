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
public class Warrior extends Personagem{
    
   private File warrior_lines;
    Scanner scanner;
    
    public Warrior(String nome) {
        this.setNome(nome);
        warrior_lines = new File("src/jogorpg/resources/Warrior_Lines.txt");
        scanner =null;
        try{
            scanner = new Scanner(warrior_lines);
            
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
           // if(!scanner.hasNext()){
            //System.out.println("I hope you know how to fight. You'll need it.");
            //}
        }    
        }catch (NoSuchElementException e){
             System.out.println("'Try to keep yourself alive. You won't be able to save your sister if you are dead!'");
         }   
                
    }
}
