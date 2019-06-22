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
public class Musician extends Personagem{
    private File musician_lines;
    Scanner scanner;
    
    public Musician(String nome) {
        this.setNome(nome);
        musician_lines = new File("Musician_Lines.txt");
        scanner =null;
        try{
            scanner = new Scanner(musician_lines);
            
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
          //  if(!scanner.hasNext()){
          //  System.out.println("You should not stay here kid. Your sister may not have much time left.");
           // }
        }    
        }catch (NoSuchElementException e){
             System.out.println("I wish you good luck. I'll write a song about you if I ever get out of here");
         }   
                
    }
 
}
