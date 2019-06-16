package jogorpg.world_of_zuul;

import java.io.*;
import jogorpg.itens.*;
import jogorpg.monsters.*;
import jogorpg.personagens.Hero;
import java.awt.Desktop;
import java.util.Scanner;


/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private boolean finished;
    private File registro;//File that I'm writing ing
    private PrintWriter escrita;//Object to print in my file
    private Hero h;

    /**
     * Create the game, initialise its internal map and creates the game_log_file.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        finished = false;
        try{//try to create a file names Game_log
            registro = new File("Game_Log.txt");
            if(!registro.exists()){//if this file doesn't exist, it's created. If it does, it's overwrited
                registro.createNewFile();
            }
            escrita = new PrintWriter(registro);
        } catch (IOException e){//If something goes wrong in creating the file, an exeption in caught.
            System.out.println("AN ERROR HAS OCURRED. CANNOT CREATE YOUR GAME LOG");
        }
        h = new Hero(8,8,35,5);
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room long_stone_corridor, jail, library, wet_stone_corridor, storage_room,alchemy_lab,monster_nest, gate,boss_room;
        Bat bat1,bat2,bat3,bat4;
        Rat rat1,rat2,rat3,rat4,rat5;
        Snake snake1,snake2,snake3,snake4;
        Spider spider1,spider2,spider3,spider4;
        BigScorpion bigscorpion1,bigscorpion2;
        BigSnake bigsnake1,bigsnake2;
        Scorpion scorpion1,scorpion2,scorpion3,scorpion4;
        
        // create the rooms
        long_stone_corridor = new Room("in a long stone corridor. There are noises somewhere.","Long Stone Corridor");
        jail = new Room("in some kind of jail. There are some people caged. They seem to be sleeping.","Jail");
        library = new Room("in a dusty old library. There are old books everywhere. ","Library");
        wet_stone_corridor = new Room("in a stone corridor. The walls are wet, there must be water nearby.","Wet Stone Corridor");
        storage_room = new Room("in a weird storage room. There are all kinds of things around.","Storage Room");
        alchemy_lab = new Room("in an alchemy lab. There are some books on the shelves and lots of bottles with colouful liquids inside.","Alchemy Lab");
        monster_nest = new Room("in a monster nest. You better be careful here.","Monster Nest");
        gate = new Room("in a big iron gate. There's a tunnel with weird noises comming from it.","Iron Gate");
        boss_room = new Room("in a tunnel. There's a key to open the gate. But is is guarded by a monster", "Boss Room");
        
        //creating monsters
        bat1 = new Bat("bat1");
        bat2 = new Bat("bat2");
        bat3 = new Bat("bat3");
        bat4 = new Bat("bat4");
        
        rat1 = new Rat("rat1");
        rat2 = new Rat("rat2");
        rat3 = new Rat("rat3");
        rat4 = new Rat("rat4");
        rat5 = new Rat("rat5");
        
        snake1 = new Snake("snake1",false);
        snake2 = new Snake("snake2",true);
        snake3 = new Snake("snake3",true);
        snake4 = new Snake("snake4",false);
        
        spider1 = new Spider("spider1",false);
        spider2 = new Spider("spider2",true);
        spider3 = new Spider("spider3",false);
        spider4 = new Spider("spider4",false);
        
        bigscorpion1 = new BigScorpion("bigscorpion1");
        bigscorpion2 = new BigScorpion("bigscorpion2");
        
        bigsnake1 = new BigSnake("bigsnake1");
        bigsnake2 = new BigSnake("bigsnake2");
        
        scorpion1 = new Scorpion("scorpion1",true);
        scorpion2 = new Scorpion("scorpion2",false);
        scorpion3 = new Scorpion("scorpion3",true);
        scorpion4 = new Scorpion("scorpion4",true);
        
        
        
        // initialise room exits, monsters, characters and items
        long_stone_corridor.setExit("east", jail);
        long_stone_corridor.setMonstro(bat1.getNome(),bat1);
        long_stone_corridor.setMonstro(bat2.getNome(),bat2);
        long_stone_corridor.setMonstro(spider1.getNome(),spider1);
        //long_stone_corridor.setItem("Espada", i);
        
        jail.setExit("west", long_stone_corridor);
        jail.setExit("east", library);
        jail.setMonstro(rat1.getNome(),rat1);
        jail.setMonstro(spider2.getNome(),spider2);
        
        library.setExit("west",jail);
        library.setExit("north",storage_room);
        library.setExit("south", alchemy_lab);
        library.setExit("east",wet_stone_corridor);
        library.setMonstro(spider3.getNome(),spider3);
        library.setMonstro(spider4.getNome(),spider4);
        library.setMonstro(snake1.getNome(),snake1);
        
        storage_room.setExit("south",library);
        storage_room.setMonstro(rat3.getNome(), rat3);
        storage_room.setMonstro(rat4.getNome(), rat4);
        storage_room.setMonstro(scorpion3.getNome(), scorpion3);
        storage_room.setMonstro(bigscorpion1.getNome(), bigscorpion1);
        
        alchemy_lab.setExit("north",library);
        alchemy_lab.setMonstro(scorpion1.getNome(), scorpion1);
        alchemy_lab.setMonstro(scorpion2.getNome(), scorpion2);
        alchemy_lab.setMonstro(rat2.getNome(), rat2);
        alchemy_lab.setMonstro(snake2.getNome(), snake2);
        
        wet_stone_corridor.setExit("west",library);
        wet_stone_corridor.setExit("south", gate);
        wet_stone_corridor.setExit("east",monster_nest);
        wet_stone_corridor.setMonstro(bigscorpion2.getNome(),bigscorpion2);
        
        gate.setExit("north", wet_stone_corridor);
        gate.setExit("west",boss_room);
        gate.setMonstro(bat3.getNome(),bat3);
        gate.setMonstro(bat4.getNome(),bat4);
        gate.setMonstro(snake3.getNome(),snake3);
        
        boss_room.setExit("east", gate);
        
        monster_nest.setExit("west",wet_stone_corridor);
        monster_nest.setMonstro(bigsnake1.getNome(),bigsnake1);
        monster_nest.setMonstro(bigsnake2.getNome(),bigsnake2);
        monster_nest.setMonstro(rat5.getNome(),rat5);
        monster_nest.setMonstro(snake4.getNome(),snake4);
        monster_nest.setMonstro(scorpion4.getNome(),scorpion4);
        
        currentRoom = long_stone_corridor;
        
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {   
        printWelcome();
        escrita.println("----------------------------------");
        escrita.println(h.getNome() + " has entered the dungeon.");
        escrita.println("----------------------------------");

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        escrita.close();//closing PrintWriter
        //So, here the game if over, all I have to do is ask if the person wants to display the game log
        this.showGameLog();
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void showGameLog(){
        Scanner c = new Scanner(System.in);//creates a scanner so I can read the input
        String cont;//and a String to save it
        System.out.println("Do you want to open your Game Log? Y/N ");
        cont = c.nextLine();//reads the answer
        if(cont.equals("Y") || cont.equals("y")){//if the person wants to show the game log...
            Desktop d = Desktop.getDesktop();
            if(!Desktop.isDesktopSupported()){//test if I can open the file
                System.out.println("Cannot open file.");
                 return;
                }
            try {
                d.open(registro);
            } catch (IOException ex) {
            System.out.println("Error. Game Log cannot be opened.");
            }
            
        }
    }
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to the World of Zuul! What's your name? ");
        h.setNome(s.nextLine());
        System.out.println("Well, "+h.getNome()+ ", you have a dungeon to explore.");
        System.out.println("Remember, you must get out alive. Good luck.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
            escrita.println("----------------------------------");
            escrita.println(h.getNome()+" quitted the game.");
            escrita.println("----------------------------------");
        }
        else if(commandWord ==CommandWord.ATTACK){
            attackMonster(command);
            if(!h.isAlive()){
                System.out.println("\n######################");
                System.out.println("######GAME OVER#######");
                System.out.println("######################");
                
                escrita.println("----------------------------------");
                escrita.println(h.getNome() + " Died. Game over");
                escrita.println("----------------------------------");
                wantToQuit = true;
            }
        }
        else if(commandWord == CommandWord.DROP){
            dropItem(command);
        }
        else if(commandWord == CommandWord.PICK){
            pickItem(command);
        }
        else if(commandWord == CommandWord.USE){
            
        }
        else if(commandWord==CommandWord.TALK){
            
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    
    private void printHelp() 
    {
        System.out.println("You find yourself in a strange cave. ");
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println();
        System.out.println( currentRoom.getExitString() + "\n" + currentRoom.getPessoasString() +"\n"+ currentRoom.getMonstrosString() +"\n"+currentRoom.getItensString());
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
        escrita.println("----------------------------------");
        escrita.println(h.getNome()+ " entered " + currentRoom.getName()+".");
    }
    /**
     * Try to attack a monster. If the monster is not found
     * return an error message
     * @param command 
     */
     private void attackMonster(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Attack who?");
            return;
        }

        String name = command.getSecondWord();
        
        Monster m = currentRoom.getMonstro(name);
        if(m==null){
           System.out.println("There's no monster with this name here.");
            System.out.println(currentRoom.getMonstrosString());
            return;
        }
        if(m.isAlive() && h.isAlive()){
            escrita.println(h.getNome()+" is figthing " + m.getNome()+".");
            h.lutar(m);
        }
        if(h.isPoisoned()){
            m.decremento((float)2.0);
            escrita.println(h.getNome()+" is poisoned. ");
            System.out.println("You are poisoned. Figthing hurts you. ");
        }
        if(!m.isAlive() && h.isAlive()){//o monstro precisa estar morto e o herói vivo, se o herói também morrer, não faz sentido imprimir a descrição
            currentRoom.mataMonstro(m.getNome());
            System.out.println(currentRoom.getLongDescription());
            escrita.println(h.getNome()+" killed " + m.getNome()+".");
        }
    }
     
      private void pickItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Pick what?");
            return;
        }

        String name = command.getSecondWord();
        
        Item i = currentRoom.getItem(name);
        
        if(i==null){
           System.out.println("There's no item with this name here");
            System.out.println(currentRoom.getItensString());
            return;
        }
        h.pickItem(i);//coloca no inventario do herói
        currentRoom.removeItem(i.getNome());//e tira da sala
        escrita.println(h.getNome()+" picked " + i.getNome()+".");
    }
      
      private void dropItem(Command command){
          if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        String name = command.getSecondWord();
        
        Item i = h.removerItem(name);//tira o item do inventário do herói
        
        if(i==null){
           System.out.println("You do not have the item you want to remove.");
            System.out.println(h.getInventarioString());
            return;
        }
        currentRoom.setItem(i.getNome(),i);//e tira da sala
        escrita.println(h.getNome()+" dropped " + i.getNome()+".");
          
      }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
