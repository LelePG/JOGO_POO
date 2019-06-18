package jogorpg.world_of_zuul;

import java.io.*;
import jogorpg.itens.*;
import jogorpg.monsters.*;
import jogorpg.personagens.*;
import java.awt.Desktop;
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;



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
        h = new Hero(5,5,15,8);
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room cave_entrance,inside_cave,long_stone_corridor, jail, library, wet_stone_corridor, storage_room,alchemy_lab,monster_nest, gate,boss1_room;
        Room castle_entrance, castle_corridor, castle_throne_room, castle_jail, castle_garden,final_room;
        
        Bat bat1,bat2,bat3,bat4;
        Rat rat1,rat2,rat3,rat4,rat5;
        Snake snake1,snake2,snake3,snake4;
        Spider spider1,spider2,spider3,spider4;
        BossScorpion bossscorpion1,bossscorpion2;
        BossSnake bosssnake1,bosssnake2;
        Scorpion scorpion1,scorpion2,scorpion3,scorpion4;
        
        Weapon stick;
        
        // create the rooms
        cave_entrance = new Room("outside that weird cave Ilea likes so much. You hear someone crying for help. It seems to be Ilea.","Outside the Cave");
        inside_cave = new Room ("inside the cave. It's too dark, and you are now sure it's Ilea who's crying for help.\n There's a hole in the ground, and you are sure that's where the cries are comming from.","The Cave");
        long_stone_corridor = new Room("in a long stone corridor. There is something weird in the air, and no sign of Ilea.\n You cannot go back the same way you came in and you have to keep searching","Long Stone Corridor");
        jail = new Room("in some kind of jail. There are some people caged. They seem to be sleeping, but you have to find out where you sister is.","Jail");
        library = new Room("in a dusty old library. There are old books everywhere. ","Library");
        wet_stone_corridor = new Room("in a stone corridor. The walls are wet, there must be water nearby.","Wet Stone Corridor");
        storage_room = new Room("in a weird storage room. There are all kinds of things around.","Storage Room");
        alchemy_lab = new Room("in an alchemy lab. There are some books on the shelves and lots of bottles with colouful liquids inside.","Alchemy Lab");
        monster_nest = new Room("in a monster nest. You better be careful here.","Monster Nest");
        gate = new Room("in a big iron gate. There's a tunnel with weird noises comming from it, and someone near the gate.","Iron Gate");
        boss1_room = new Room("in a tunnel. There's a key to open the gate. But it is guarded by a monster.", "Tunnel");
        castle_corridor = new Room("in a corridor that leads to a Castle. The gate you passed by is now closed again. Ilea must be in the castle.","Way to the Castle");
        castle_entrance = new Room("at the Castle's entrance. You hear someone crying for help again, and you can be sure it's her.","Castle Entrance");
        castle_jail = new Room ("at the Castle's jail. You look for Ilea, but she's not here.", "Castle Jail");
        castle_garden = new Room("an the Castle's garden. You look around and... There she is! You found her. Ilea's playing in the bushes!","Castle Garden");
        castle_throne_room = new Room ("in a weird throne room. There's a weird man sitting on the throne looking very unfriendly...","Throne Room");
        final_room = new Room("running through the passageway. The light is near, and you find yourselves in the forest, near the cave.\n Most important, near home.\n----THE END----","THE END");
        
        //creating monsters
        bat1 = new Bat("Bat1");
        bat2 = new Bat("Bat2");
        bat3 = new Bat("Bat3");
        bat4 = new Bat("Bat4");
        
        rat1 = new Rat("Rat1");
        rat2 = new Rat("Rat2");
        rat3 = new Rat("Rat3");
        rat4 = new Rat("Rat4");
        rat5 = new Rat("Rat5");
        
        snake1 = new Snake("Snake1",false);
        snake2 = new Snake("Snake2",true);
        snake3 = new Snake("Snake3",true);
        snake4 = new Snake("Snake4",false);
        
        spider1 = new Spider("Spider1",false);
        spider2 = new Spider("Spider2",true);
        spider3 = new Spider("Spider3",false);
        spider4 = new Spider("Spider4",false);
        
        bossscorpion1 = new BossScorpion("BossScorpion1");
        bossscorpion2 = new BossScorpion("BossScorpion2");
        
        bosssnake1 = new BossSnake("BossSnake1");
        bosssnake2 = new BossSnake("BossSnake2");
        
        scorpion1 = new Scorpion("Scorpion1",true);
        scorpion2 = new Scorpion("Scorpion2",false);
        scorpion3 = new Scorpion("Scorpion3",true);
        scorpion4 = new Scorpion("Scorpion4",true);
        
        stick = new Weapon("Stick",1,"a fragile wooden stick.",2,2,10);
        
        // initialise room exits, monsters, characters and items
        cave_entrance.setExit("east",inside_cave);
        
        inside_cave.setExit("west",cave_entrance);
        inside_cave.setExit("down",long_stone_corridor);
        
        long_stone_corridor.setExit("east", jail);
        long_stone_corridor.setItem(stick.getNome(),stick);
        
        long_stone_corridor.setMonstro(rat1.getNome(),rat1);
        
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
        storage_room.setMonstro(bossscorpion1.getNome(), bossscorpion1);
        
        alchemy_lab.setExit("north",library);
        alchemy_lab.setMonstro(scorpion1.getNome(), scorpion1);
        alchemy_lab.setMonstro(scorpion2.getNome(), scorpion2);
        alchemy_lab.setMonstro(rat2.getNome(), rat2);
        alchemy_lab.setMonstro(snake2.getNome(), snake2);
        
        wet_stone_corridor.setExit("west",library);
        wet_stone_corridor.setExit("south", gate);
        wet_stone_corridor.setExit("east",monster_nest);
        wet_stone_corridor.setMonstro(bossscorpion2.getNome(),bossscorpion2);
        
        gate.setExit("north", wet_stone_corridor);
        gate.setExit("west",boss1_room);
        gate.setExit("east",castle_corridor);//tem que ser one way
        gate.setMonstro(bat3.getNome(),bat3);
        gate.setMonstro(bat4.getNome(),bat4);
        gate.setMonstro(snake3.getNome(),snake3);
        
        boss1_room.setExit("east", gate);
        
        monster_nest.setExit("west",wet_stone_corridor);
        monster_nest.setMonstro(bosssnake1.getNome(),bosssnake1);
        monster_nest.setMonstro(bosssnake2.getNome(),bosssnake2);
        monster_nest.setMonstro(rat5.getNome(),rat5);
        monster_nest.setMonstro(snake4.getNome(),snake4);
        monster_nest.setMonstro(scorpion4.getNome(),scorpion4);
        
        castle_corridor.setExit("east",castle_entrance);
        
        castle_entrance.setExit("west",castle_corridor);
        castle_entrance.setExit("north",castle_jail);
        castle_entrance.setExit("south",castle_garden);
        
        castle_jail.setExit("south",castle_entrance);
        
        castle_garden.setExit("east", castle_throne_room);
        
        castle_throne_room.setExit("north",final_room);
        
        currentRoom = cave_entrance;
        
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {   
        printWelcome();
        escrita.println("----------------------------------");
        escrita.println(h.getNome() + " started to play.");
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
        System.out.println(h.getNome()+ ",it's been a long time since your sister went to explore that cave, right? ");
        System.out.println("It will be dark soon, and no one wants little Ilea outside in the dark.");
        System.out.println("You have to go after her, specially with the stories that are told about that cave...");
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
            talkTo(command);
            
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
        System.out.println("You find yourself in a strange place, looking for your sister Ilea. ");
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
            if(currentRoom.sairSala()){
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                escrita.println("----------------------------------");
                escrita.println(h.getNome()+ " entered " + currentRoom.getName()+".");
            }
            else{
                System.out.println("You cannot leave monsters behind. You must end them all.");
            }
            
        }
        
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
        try {
            TimeUnit.SECONDS.sleep((long) 0.2);
        } catch (InterruptedException ex) {
           
        }
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
        System.out.println("You picked "+ i.getDescription());
        escrita.println(h.getNome()+" picked " + i.getDescription());
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
        System.out.println("You dropped "+ i.getDescription());
        escrita.println(h.getNome()+" dropped " + i.getNome()+".");
          
      }
      
      private void talkTo(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Talk to whom?");
            return;
        }
        String pessoa_nome = command.getSecondWord();

        Personagem Pessoa = currentRoom.getPessoa(pessoa_nome);

        if (Pessoa == null) {
            System.out.println("There is no one with this name here!");
            return;
        }
        Pessoa.talk();
        escrita.println(h.getNome()+ " entered " + currentRoom.getName()+".");
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
