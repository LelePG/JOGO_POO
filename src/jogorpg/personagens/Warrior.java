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
        warrior_lines = new File("Warrior_Lines.txt");
        scanner =null;
        try{
            scanner = new Scanner(warrior_lines);
            
        }catch(FileNotFoundException e){
            System.out.println("mm");
        }
    }

     @Override
    public void talk(){
        try{
        String line = scanner.nextLine();
        
        while(scanner.hasNext() && !line.equals("--XX--")){
            System.out.println(line);
            line = scanner.nextLine();
            if(!scanner.hasNext()){
            System.out.println("You can leave me now, dear. It's an order.");
            }
        }    
        }catch (NoSuchElementException e){
             System.out.println("You can leave me now, dear. It's an order.");
         }   
                
    }
}
