package jogorpg.world_of_zuul;

import java.io.*;
import jogorpg.itens.*;
import jogorpg.monsters.*;
import jogorpg.personagens.*;
import java.awt.Desktop;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


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
    private BufferedWriter escrita;//Object to print in my file
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
            escrita = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(registro)));
        } catch (IOException e){//If something goes wrong in creating the file, an exeption in caught.
            System.out.println("AN ERROR HAS OCURRED. CANNOT CREATE YOUR GAME LOG");
        }
        h = new Hero(5,5,30,15);
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room cave_entrance,inside_cave,long_stone_corridor, jail, library, wet_stone_corridor, storage_room,alchemy_lab,monster_nest, gate,boss1_room;
        Room castle_entrance, castle_corridor, castle_throne_room, castle_jail, castle_garden,final_room;
        
        Bat bat1,bat2,bat3,bat4,bat5;
        Rat rat1,rat2,rat3,rat4,rat5,rat6;
        Snake snake1,snake2,snake3,snake4;
        Spider spider1,spider2,spider3,spider4;
        BossScorpion bossscorpion;
        BossSnake bosssnake;
        BossSpider bossspider;
        Scorpion scorpion1,scorpion2,scorpion3,scorpion4,scorpion5;
        
        Weapon stick, barrel_top,club,hammer,wooden_shield,light_lance,heavy_wooden_shield,battle_axe,spiked_club;
        
        Food f1,f2,f3,f4;
        
        Potion h1,h2,h3,h4,h5,s1,s2,p1,p2,p3,p4,p5;
        Personagem fairy,warrior,musician,seer,robber,statue,witch,ilea,king,trader;
        // create the rooms
        cave_entrance = new Room("outside that weird cave Ilea likes so much. You hear someone crying for help. It seems to be Ilea.","Outside the Cave");
        inside_cave = new Room ("inside the cave. It's too dark, and you are now sure it's Ilea who's crying for help.\nThere's a hole in the ground, and you are sure that's where the cries are comming from.","The Cave");
        long_stone_corridor = new Room("in a long stone corridor. There is something weird in the air, and no sign of Ilea.\nYou cannot go back the same way you came in and you have to keep searching","Long Stone Corridor");
        jail = new Room("in some kind of jail. There are some people caged. They seem to be sleeping, but you have to find out where you sister is.","Jail");
        library = new Room("in a dusty old library. There are old books everywhere. ","Library");
        wet_stone_corridor = new Room("in a stone corridor. The walls are wet, there must be water nearby.","Wet Stone Corridor");
        storage_room = new Room("in a weird storage room. There are all kinds of things around, and... wait. That statue is moving???","Storage Room");
        alchemy_lab = new Room("in an alchemy lab. There are some books on the shelves and lots of bottles with colouful liquids inside.","Alchemy Lab");
        monster_nest = new Room("in a monster nest. You better be careful here.","Monster Nest");
        gate = new Room("in a big iron gate. There's a tunnel with weird noises comming from it. Looks like you need a key to open the gate.","Iron Gate");
        boss1_room = new Room("in a tunnel. There's a key to open the gate. But it is guarded by a giant spider!", "Tunnel");
        castle_corridor = new Room("in a corridor that leads to a Castle. The gate you passed by is now closed again. Ilea must be in the castle.","Way to the Castle");
        castle_entrance = new Room("at the Castle's entrance. You hear someone crying for help again, and you can be sure it's her.","Castle Entrance");
        castle_jail = new Room ("at the Castle's jail. You look for Ilea, but she's not here.", "Castle Jail");
        castle_garden = new Room("an the Castle's garden. You look around and... There she is! You found her. Ilea's playing in the bushes!","Castle Garden");
        castle_throne_room = new Room ("in a weird throne room. There's a weird man sitting on the throne looking very unfriendly...","Throne Room");
        final_room = new Room("running through the passageway. The light is near, and you find yourselves in the forest, near the cave entrance.\n Most important, near home.\n----THE END----","THE END");
        
        //creating monsters
        bat1 = new Bat("Bat1");
        bat2 = new Bat("Bat2");
        bat3 = new Bat("Bat3");
        bat4 = new Bat("Bat4");
        bat5 = new Bat("Bat5");
        
        rat1 = new Rat("Rat1");
        rat2 = new Rat("Rat2");
        rat3 = new Rat("Rat3");
        rat4 = new Rat("Rat4");
        rat5 = new Rat("Rat5");
        rat6 = new Rat("Rat6");
        
        snake1 = new Snake("Snake1",false);
        snake2 = new Snake("Snake2",true);
        snake3 = new Snake("Snake3",true);
        snake4 = new Snake("Snake4",false);
        
        spider1 = new Spider("Spider1",false);
        spider2 = new Spider("Spider2",true);
        spider3 = new Spider("Spider3",false);
        spider4 = new Spider("Spider4",false);
        
        bossscorpion = new BossScorpion("Boss_Scorpion");
        
        bosssnake = new BossSnake("Boss_Snake");
     
        bossspider = new BossSpider("Boss_Spider");
        
        scorpion1 = new Scorpion("Scorpion1",true);
        scorpion2 = new Scorpion("Scorpion2",false);
        scorpion3 = new Scorpion("Scorpion3",true);
        scorpion4 = new Scorpion("Scorpion4",true);
        scorpion5 = new Scorpion("Scorpion5",false);
        
       //CREATE WEAPONS
        stick = new Attack_Weapon("Stick",1,"a fragile wooden stick that could be used as a weapon.",2,2,10);
        barrel_top = new Defense_Weapon("Barrel_top",1,"a barrel top. Could be used for self-defence, if you are completely out of options.",2,2,20);
        club= new Attack_Weapon("Club",2,"a club. It seems to make lots of damage.",4,3,15);
        hammer= new Attack_Weapon("Hammer",2,"a normal hammer. But it could be used for more then just driving nails.",5,2,17);
        wooden_shield= new Defense_Weapon("Wooden_Shield",2,"a shield made of wood.",3,4,30);
        light_lance = new Attack_Weapon("Light_Lance",3,"a long lance.",6,4,20);
        heavy_wooden_shield = new Defense_Weapon("Heavy_Wooden_Shield",5,"a heavy shield make of wood. Seems resistent.",3,4,30);
        battle_axe = new Attack_Weapon("Battle_Axe",7,"a heavy axe. Looks deadly.",10,5,20);
	spiked_club= new Attack_Weapon("Spiked_Club",5,"a club with spikes. It looks scary.",12,3,25);
       
//CREATE ITEMS
        f1 = new Food("Biscuits",1,5,"a pack with biscuits found in the cave floor.");
        f2 = new Food("Biscuits",1,5,"a pack with biscuits found in the prision floor.");
        f3 = new Food("Grape_Pie",2,10,"a pretty grape pie.");
        f4 = new Food("Pumpkin_Pie",2,10,"a pumpkin pie.");
        
        h1 = new Heal_Potion("Healing_Juice",2,"a bottle with 'healing juice' written on it",3);
        h2 = new Heal_Potion("Healing_Soda",2,"a bottle with 'healing soda' written on it",4);
        h3 = new Heal_Potion("Healing_Tea",2,"a bottle with 'healing tea' written on it",5);
        h4 = new Heal_Potion("Healing_Bottle",2,"a bottle with 'healing bottle' written on it",3);
	h5 = new Heal_Potion("Healing_Liquid",2,"a bottle with 'healing bottle' written on it",5);
        
        s1 = new Strength_Potion("Rat's_Juice",2,"a bottle with a dark liquid. It's impossible to know what will happen if you drink it",2);
        s2 = new Strength_Potion("Bat's_Juice",2,"a bottle with a dark liquid. It's impossible to know what will happen if you drink it",4);
        
        p1 = new Poison_Potion("Antidote1",1,"a bottle with 'drink if you are poisoned, idiot' witten with big letters",5);
        p2 = new Poison_Potion("Antidote2",1,"a bottle with 'drink if you are poisoned, idiot' witten with big letters",5);
        p3 = new Poison_Potion("Antidote3",1,"a bottle with 'drink if you are poisoned, idiot' witten with big letters",4);
        p4 = new Poison_Potion("Antidote4",1,"a bottle with 'drink if you are poisoned, idiot' witten with big letters",3);
	p5 = new Poison_Potion("Antidote5",1,"a bottle with 'drink if you are poisoned, idiot' witten with big letters",2);
        
        //CREATE CHARACTERS
        fairy = new Fairy("Fairy");
        warrior = new Warrior("Warrior");
        musician = new Musician("Musician");
        seer = new Seer("Seer");
        robber = new Robber("Robber");
        statue = new TalkingStatue("Statue");
        witch = new Witch("Witch");
        ilea = new Ilea("Ilea");
        king =  new KingOdrian("King_Odrian");
        trader = new Trader(100,h);
        // initialise room exits, monsters, characters and items
        cave_entrance.setExit("east",inside_cave);
        
        inside_cave.setExit("west",cave_entrance);
        inside_cave.setExit("down",long_stone_corridor);
        
        long_stone_corridor.setExit("east", jail);
        long_stone_corridor.setItem(f1.getNome(),f1);
        long_stone_corridor.setItem(stick.getNome(),stick);
        long_stone_corridor.setMonstro(rat1.getNome(),rat1);
        long_stone_corridor.setMonstro(rat2.getNome(),rat2);
        
        jail.setExit("west", long_stone_corridor);
        jail.setExit("east", library);
        jail.setPessoa(fairy.getNome(), fairy);
        jail.setPessoa(warrior.getNome(), warrior);
        jail.setPessoa(musician.getNome(), musician);
        jail.setPessoa(seer.getNome(), seer);
        jail.setPessoa(robber.getNome(), robber);
        jail.setItem(f2.getNome(), f2);
        jail.setItem(barrel_top.getNome(),barrel_top);
        
        library.setExit("west",jail);
        library.setExit("north",storage_room);
        library.setExit("south", alchemy_lab);
        library.setExit("east",wet_stone_corridor);
        library.setMonstro(rat3.getNome(),rat3);
        library.setMonstro(rat4.getNome(),rat4);
        
        storage_room.setExit("south",library);
        storage_room.setItem(f3.getNome(),f3);
        storage_room.setItem(club.getNome(),club);
        storage_room.setItem(hammer.getNome(),hammer);
        storage_room.setItem(light_lance.getNome(),light_lance);
        storage_room.setItem(wooden_shield.getNome(),wooden_shield);
        storage_room.setItem(s2.getNome(),s2);//poção de força2
        storage_room.setMonstro(rat5.getNome(), rat5);
        storage_room.setMonstro(rat6.getNome(), rat6);
        storage_room.setMonstro(bat1.getNome(), bat1);
        storage_room.setPessoa(statue.getNome(),statue);
        
        alchemy_lab.setExit("north",library);
        alchemy_lab.setMonstro(snake1.getNome(), snake1);
        alchemy_lab.setMonstro(snake2.getNome(), snake2);
        alchemy_lab.setItem(p1.getNome(),p1);
        alchemy_lab.setItem(p2.getNome(),p2);
        alchemy_lab.setItem(h1.getNome(),h1);
        alchemy_lab.setItem(h2.getNome(),h2);
        alchemy_lab.setItem(s1.getNome(),s1);
        
        
        wet_stone_corridor.setExit("west",library);
        wet_stone_corridor.setExit("south", gate);
        wet_stone_corridor.setExit("east",monster_nest);
        wet_stone_corridor.setMonstro(bat2.getNome(),bat2);
        wet_stone_corridor.setMonstro(bat3.getNome(),bat3);
        wet_stone_corridor.setMonstro(snake3.getNome(),snake3);
        wet_stone_corridor.setMonstro(scorpion1.getNome(),scorpion1);
        
        
        monster_nest.setExit("west",wet_stone_corridor);
        monster_nest.setMonstro(bat4.getNome(),bat4);
        monster_nest.setMonstro(bat5.getNome(),bat5);
        monster_nest.setMonstro(scorpion2.getNome(),scorpion2);
        monster_nest.setMonstro(scorpion3.getNome(),scorpion3);
        monster_nest.setMonstro(scorpion4.getNome(),scorpion4);
        monster_nest.setMonstro(snake4.getNome(),snake4);
        monster_nest.setMonstro(spider2.getNome(),spider2);
        monster_nest.setItem(heavy_wooden_shield.getNome(), heavy_wooden_shield);
        monster_nest.setItem(battle_axe.getNome(), battle_axe);
        monster_nest.setItem(f4.getNome(), f4);
        monster_nest.setItem(h3.getNome(),h3);
        monster_nest.setItem(p3.getNome(), p3);
        monster_nest.setItem(p4.getNome(), p4);
        
        gate.setExit("north", wet_stone_corridor);
        gate.setExit("west",boss1_room);
        gate.setExit("east",castle_corridor);//tem que ser one way
        gate.setMonstro(spider3.getNome(),spider3);
        gate.setMonstro(snake4.getNome(),snake4);
        
        //Os itens em Boss1_room são inseridos quando o boss morre. :D
        boss1_room.setExit("east", gate);
        boss1_room.setMonstro(bossspider.getNome(),bossspider);
        
        castle_corridor.setExit("east",castle_entrance);
        castle_corridor.setPessoa(trader.getNome(), trader);
        
        castle_entrance.setExit("west",castle_corridor);
        castle_entrance.setExit("north",castle_jail);
        castle_entrance.setExit("south",castle_garden);
        castle_entrance.setMonstro(spider4.getNome(),spider4);
        castle_entrance.setMonstro(scorpion5.getNome(),scorpion5);
        
        castle_jail.setExit("south",castle_entrance);
        castle_jail.setPessoa(witch.getNome(),witch);
	castle_jail.setItem(spiked_club.getNome(),spiked_club);
	castle_jail.setItem(p5.getNome(),p5);
	castle_jail.setItem(h4.getNome(),h4);
        
        castle_garden.setExit("east", castle_throne_room);
        castle_garden.setPessoa(ilea.getNome(), ilea);
        castle_garden.setMonstro(bosssnake.getNome(),bosssnake);
        
        castle_throne_room.setExit("north",final_room);
        castle_throne_room.setPessoa(ilea.getNome(), ilea);
	castle_throne_room.setMonstro(bossscorpion.getNome(),bossscorpion);
	castle_throne_room.setItem(h5.getNome(),h5);
        castle_throne_room.setPessoa(king.getNome(), king);
        
        //currentRoom = cave_entrance;
        currentRoom = castle_corridor;
    }

    public void escreve(String escreve){
        try{
            escrita.write(escreve+'\n');
        } catch (IOException ex) {
            System.out.println("Error recording action.");
        }
    }
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {   
        printWelcome();
        escreve("----------------------------------");
        escreve(h.getNome() + " started to play.");
        escreve("----------------------------------");

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        //So, here the game if over, all I have to do is ask if the person wants to display the game log
        this.showGameLog();
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void showGameLog(){
        Scanner c = new Scanner(System.in);//creates a scanner so I can read the input
        String cont;//and a String to save it
        
        try {//antes mesmo de verificar o game log, e preciso fechar o buffer
            escrita.close();//closing BufferedWriter
        } catch (IOException ex) {
            System.out.println("Error saving Game Log");
        }
        
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
            if(this.currentRoom.getName().equals("THE END")){
                return true;
            }
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
            escreve("----------------------------------");
            escreve(h.getNome()+" quitted the game.");
            escreve("----------------------------------");
        }
        else if(commandWord ==CommandWord.ATTACK){
            attackMonster(command);
            if(!h.isAlive()){
                System.out.println("\n######################");
                System.out.println("######GAME OVER#######");
                System.out.println("######################");
                
                escreve("----------------------------------");
                escreve(h.getNome() + " Died. Game over");
                escreve("----------------------------------");
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
            useItem(command);
        }
        else if(commandWord==CommandWord.TALK){
           wantToQuit= talkTo(command); 
        }
        else if(commandWord==CommandWord.EQUIP){
            equip(command);
        }
        else if(commandWord==CommandWord.UNEQUIP){
            unequip(command);
        }
        else if(commandWord==CommandWord.INVENTORY){
            h.displayInventory();
        }
        else if(commandWord==CommandWord.CHEAT){
            cheat(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    private void delay(){//as vezes o print que a função faz sai antes no terminal do que o comando de entrada. Essa função deixa um tempo pro comando aparecer na saida e depois libera os prints da função.
         try {
            TimeUnit.SECONDS.sleep((long) 0.4);//só pra garantir que vai printar o comando primeiro e depois a ação correspondente.
        } catch (InterruptedException ex) {
           //não altera nada se não conseguir
        }
    }

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
        System.out.println( currentRoom.getLongDescription());
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
        delay();
        
        String direction = command.getSecondWord();
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            if(currentRoom.sairSala()){
                currentRoom = nextRoom;
                if(this.currentRoom.getName().equals("THE END")){//quando eu chegar no final do jogo
                escreve("----------------------------------");
                escreve(h.getNome()+ " finished the game");
                    System.out.println(currentRoom.getShortDescription());
                    return;
                }
                System.out.println(currentRoom.getLongDescription());
                escreve("----------------------------------");
                escreve(h.getNome()+ " entered " + currentRoom.getName()+".");
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

        delay();
        
        String name = command.getSecondWord();
        
        Monster m = currentRoom.getMonstro(name);
        if(m==null){
           System.out.println("There's no monster with this name here.");
           System.out.println(currentRoom.getMonstrosString());
            return;
        }
        if(m.isAlive() && h.isAlive()){//caso os dois estejam lutando
            escreve(h.getNome()+" is figthing " + m.getNome()+".");
            h.lutar(m);
            if(h.getAttackWeapon()!=null){//se eu tiver uma arma de ou defesa ela tem o decremento de durabilidade aqui.
                h.getAttackWeapon().use(h);//usa a arma
                if(h.getAttackWeapon().getDestroy()){//se tiver esgotado a durabilidade da arma
                    System.out.println("Attack Weapon "+h.getAttackWeapon().getNome()+" is broken.");
                    escreve(h.getNome()+" broke " + h.getAttackWeapon().getNome()+"(Attack Weapon).");
                    h.unequipAttackWeapon();//só tira o elemento do equipamento
                }
            }
            if(h.getDefenseWeapon()!=null){//se eu tiver uma arma de ou defesa ela tem o decremento de durabilidade aqui.
                h.getDefenseWeapon().use(h);//usa a arma
                if(h.getDefenseWeapon().getDestroy()){//se tiver esgotado a durabilidade da arma
                    System.out.println("Shield "+h.getDefenseWeapon().getNome()+" is broken.");
                    escreve(h.getNome()+" broke " + h.getDefenseWeapon().getNome()+"(Defense Weapon).");
                    h.unequipShield();//só tira o elemento do equipamento
                }
            }
        }
        if(h.isPoisoned()){
            m.decremento((float)2.0);
            escreve(h.getNome()+" is poisoned. ");
            System.out.println("You are poisoned. Figthing hurts you. ");
        }
        if(!m.isAlive() && h.isAlive()){//o monstro precisa estar morto e o herói vivo, se o herói também morrer, não faz sentido imprimir a descrição
            
            m.dropAll(currentRoom);//método pra colocar tudo que o monstro carrega na sala.
           
            currentRoom.mataMonstro(m.getNome());
            System.out.println(m.getNome() + " dropped something.");
            System.out.println(currentRoom.getLongDescription());
            escreve(h.getNome()+" killed " + m.getNome()+".");
            escreve(m.getNome()+ " dropped something.");
        }
    }
     
      private void pickItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Pick what?");
            return;
        }
        delay();

        String name = command.getSecondWord();
       
        Item i = currentRoom.getItem(name);
        
        if(i==null){
           System.out.println("There's no item with this name here");
            System.out.println(currentRoom.getItensString());
            return;
        }
        
       if(h.pickItem(i)){//coloca no inventario do herói
        currentRoom.removeItem(i.getNome());//e tira da sala
        System.out.println("You picked "+ i.getDescription());
        escreve(h.getNome()+" picked " + i.getDescription());
       }
       else{
           System.out.println("You can't carry this. It's too heavy for you.");
       }
    }
      
      private void dropItem(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }
        delay();
        String name = command.getSecondWord();
        Item i = h.removerItem(name);//tira o item do inventário do herói
        
        if(i==null){
           System.out.println("You do not have the item you want to drop.");
            System.out.println(h.getInventarioString());
            return;
        }
        currentRoom.setItem(i.getNome(),i);//e tira da sala
        System.out.println("You dropped "+ i.getDescription());
        escreve(h.getNome()+" dropped " +i.getDescription());
          
      }
      
      private boolean talkTo(Command command) 
    {
        if(!command.hasSecondWord()) {
            h.talk();
            System.out.println("Talk with someone? ");
            return false;
        }
        delay();
        String pessoa_nome = command.getSecondWord();
        
        Personagem Pessoa = currentRoom.getPessoa(pessoa_nome);
        
        if(Pessoa instanceof KingOdrian){
            Pessoa.talk();
            finalScene((KingOdrian) Pessoa,h,(Ilea)currentRoom.getPessoa("Ilea"));
            currentRoom.emptyMonsters(currentRoom);
            return true;
        }

        if (Pessoa == null) {
            System.out.println("There is no one with this name here!");
            return false;
        }
        Pessoa.talk();
        System.out.println("");
        escreve(h.getNome()+ " talked to " + Pessoa.getNome()+".");
        return false;
    }
      
    private void equip(Command command){
        if(!command.hasSecondWord()) {
         System.out.println("Equip what?");
          return;
        }
        delay();
        String name = command.getSecondWord();//equip Stick
        
        Item i = h.removerItem(name);//tira o item do inventário do herói
        String print = new String("You equipped ");
        String print_file = new String(h.getNome() + " equipped ");
        if(i==null){
            System.out.println("You do not have the item you want to equip.");//A mensagem de erro está na função getAttackWeapon
            System.out.println(h.getInventarioString());
            return;
        }
        else if(i instanceof Attack_Weapon){
            if(h.getAttackWeapon()!=null){
            System.out.println("You are already equipped with "+h.getAttackWeapon().getNome() + " you have to unequip it first");
            h.pickItem(i);//se eu não conseguir equipar, coloco de volta no inventário
            return;
            }
           h.equipAttackWeapon((Attack_Weapon)i);
           print+= i.getNome()+ ", a Attack Weapon. ";
           print_file+=i.getNome()+ ", a Attack Weapon. ";           
           
        }
        else if(i instanceof Defense_Weapon){
            if(h.getDefenseWeapon()!=null){
            System.out.println("You are already equipped with "+h.getDefenseWeapon().getNome() + " you have to unequip it first");
            h.pickItem(i);
            return;
            }
           h.equipShield((Defense_Weapon)i);
           print+= i.getNome()+ ", a Defense Weapon. ";
           print_file+=i.getNome()+ ", a Defense Weapon. ";
        }
        System.out.println(print);
        System.out.println(i.getNome()+" increased "+h.getNome()+"'s attributes");
       // System.out.println(h.getInventarioString());//verificar o iventário

        escreve(print_file);
        escreve(i.getNome()+" increased "+h.getNome()+"'s attributes");
          
    }
    
     private void unequip(Command command){
      if(!command.hasSecondWord()) {
         System.out.println("Unquip what?");
          return;
        }
      delay();
        String name = command.getSecondWord();//unequip Stick
       
        Item i;
        String print = new String("You unequipped ");
        String print_file = new String(h.getNome() + " unequipped ");
        //if pra attack weapon
        if(h.getAttackWeapon()!=null && h.getAttackWeapon().getNome().equals(name)){
           i = h.unequipAttackWeapon();
           print+= i.getNome()+ ", a Attack Weapon. ";
           print_file+=i.getNome()+ ", a Attack Weapon. "; 
           if(!h.pickItem(i)){//caso o inventário do herói esteja cheio, o item volta pro inventário da sala
                currentRoom.setItem(i.getNome(),i);
            }
        }
       
        //ifs pra Defense weapon
        else if(h.getDefenseWeapon()!=null && h.getDefenseWeapon().getNome().equals(name)){
           i = h.unequipShield();
           print+= i.getNome()+ ", a Defense Weapon. ";
           print_file+=i.getNome()+ ", a Defense Weapon. "; 
           if(!h.pickItem(i)){//caso o inventário do herói esteja cheio, o item volta pro inventário da sala
               currentRoom.setItem(i.getNome(),i);
           }
        }
        else {
            System.out.println("You have nothing to unnequip with this name");
            return;
        }
        //System.out.println(h.getInventarioString());//verificar o inventario
        System.out.println(print);
        System.out.println(h.getNome()+"'s attributes were decreased.");
        
        escreve(print_file);
          
    }
      
     public void finalScene(KingOdrian O,Hero h, Ilea i){
         Scanner s = new Scanner(System.in);
         String str;
         System.out.println("\nDo you want to play the dice game? Y/N");
         str = s.next();
         if(str.equals("y")||str.equals("Y")){
             if(O.diceGame(h,i)){//true eles ganham o jogo, false eles perdem
                 System.out.println("'I'll let you leave then. You just have to pass trough the door'");
                 escreve(h.getNome()+ " and Ilea played dices with King Odrian and won.");
                 System.out.println("\nYou pass trough the door...");
                 try {
                TimeUnit.SECONDS.sleep((long) 6);//só pra garantir que vai printar o comando primeiro e depois a ação correspondente.
                } catch (InterruptedException ex) {
                  //não altera nada se não conseguir
                }
                 currentRoom = currentRoom.getExit("north");
                 System.out.println("\nYou and Ilea are "+currentRoom.getShortDescription());
                 escreve("----------------------------------");
                escreve(h.getNome()+ " finished the game");
             }
             else{
                System.out.println("'Both of you are mine now.'");
                escreve(h.getNome()+ " and Ilea played dices with \nKing Odrian and lost.");
                escreve("Both shall remain his prisioners til the \nend of their days.");
                escreve("----------------------------------");
                escreve("            Game over        ");
                escreve("----------------------------------");
                System.out.println("\n######################");
                System.out.println("######GAME OVER#######");
                System.out.println("######################");
             }
         }
         else{
             System.out.println("\n'You don't wanna play? Well it's a pity. I tried to give you a chance."
                     + "\nI'm sorry for what I'm about to do... It's nothing personal.'");
             h.died();
             System.out.println("\nYou and Ilea were killed by King Odrian. "
                     + "You just had to roll a dice.");
              System.out.println("\n######################");
              System.out.println("######GAME OVER#######");
              System.out.println("######################");
                
             escreve("----------------------------------");
             escreve(h.getNome() + " and Ilea are dead.");
             escreve("They refused to play dices with\nKing Odrian and were killed. \nGame over.");
             escreve("----------------------------------");
         }
         
     }

  private void useItem(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Use what?");
            return;
        }
        delay();
        String name = command.getSecondWord();
        
        Item i = h.removerItem(name);//tira o item do inventário do herói
        
        if(i==null){
           System.out.println("You do not have the item you want to use.");
            System.out.println(h.getInventarioString());
            return;
        }
      
        i.use(h);//o item i é usado por h
        if(!i.getDestroy()){
            h.pickItem(i);//se o item não tiver que ser destruido, inserir ele novamente no iventario do herói
        }
        System.out.println("You used "+ i.getDescription());
        escreve(h.getNome()+" used " +i.getNome()+".");
        escreve(i.getPrintLine());
          
      }
  
  private void cheat(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Invalid command.");
            return;
        }

        String action = command.getSecondWord();

        if(action.equals("fillhero")){
            h.setEnergia(30);
            h.setAtaque(30);
            h.setDefesa(30);
            escreve("****A CHEAT WAS USED****");
            return;
        }
        else if (action.equals("killall")) {
            currentRoom.emptyMonsters(currentRoom);
            System.out.println(currentRoom.getLongDescription());
            escreve("****A CHEAT WAS USED****");
            return;
        }
        
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
