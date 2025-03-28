import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character c1 = new Character();    //just here to generate the objects and print them out for testing purposes, nothing new here
        System.out.println(c1 + "\n");
        Character c2 = new barbarian("Bingus", 1);
        System.out.println(c2 + "\n");
        Character c3 = new barbarian();
        System.out.println(c3);
    }
}
class Character{
    protected int STR;    //initializes the starting variables and their data types except for the list
    protected int DEX;
    protected int CON;
    protected int INT;
    protected int WIS;
    protected int CHA;
    protected String Name;
    protected int Level;
    protected int HP;
    protected int AC;
    protected ArrayList<String> Feats;

    public Character(){    //base constructor for the character where all the starting stats are ten, the name is just "Player", and the feats gets initializes
        this.STR = 10;
        this.DEX = 10;
        this.CON = 10;
        this.INT = 10;
        this.WIS = 10;
        this.CHA = 10;
        this.Name = "Player";
        this.Level = 1;
        this.HP = 10;
        this.AC = 10;
        this.Feats = new ArrayList<>();
    }

    public Character(String name, int level){    //constructs the character with the arguments of name and level
        this.STR = stat_initializer();    //calls the function stat_initializer() for generating the stats
        this.DEX = stat_initializer();
        this.CON = stat_initializer();
        this.INT = stat_initializer();
        this.WIS = stat_initializer();
        this.CHA = stat_initializer();
        this.Name = name;                //sets the arguments of name and level to Name and Level.
        this.Level = level;
        calculateHitPoints();            //calls the functions calculateHitPoints and calculateArmorClass
        calculateArmorClass();
        this.Feats = new ArrayList<>();  //initializes the Feats ArrayList
    }

    public int stat_initializer(){       //"rolls" a six sided dice and retuns the number to be assigned to a stat
        Random randInt = new Random();
        return randInt.nextInt(14) + 3;
    }

    public void calculateHitPoints(){    //calculates the hit points based on the level
        if(this.Level == 1){             //if the level is one then it sets the level to the constitution + 10
            this.HP = 10 + this.CON;   
        }
        else{                            //if the level isn't one then it sets the hp to it self plus the level miuns 1 times the 6 + constitution
            this.HP = this.HP + ((this.Level - 1) * (6 + this.CON));
        }
    }

    public void calculateArmorClass(){    //sets the armor class to 10 + the dexterity 
        this.AC = 10 + this.DEX;
    }

    public int getAbilityModifier(int score){    //gets the ability modifirer back by runing it through the calculation of subtracting ten and then dividing that by two and rounding down
        return (score - 10)/2;
    }
    public void levelUp(){                //level up sets the level to itself + 1 and recalculates the health and armor class
        this.Level += 1;
        calculateHitPoints();
        calculateArmorClass();
    }

    public void addFeat(String feat){    //addFeat appends the feats ArrayList with the argument passed in
        this.Feats.add(feat);
    }

    public String toString() {           //toString overide to make the information more readable
        return "Character: " + Name+
                " | Level: " + Level +
                "\nHP: " + HP + " | AC: " + AC +
                "\nSTR: " + STR +
                " | DEX: " + DEX +
                " | CON: " + CON +
                "\nINT: " + INT +
                " | WIS: " + WIS +
                " | CHA: " + CHA +
                "\nFeats: " + Feats;
    }
}

class barbarian extends Character{      //sub class of the barbarian which extends character
        barbarian(){                    //defaut constructor that doesn't take in any parameters
        super();                        //calls the default constructor for the character parent class
        this.STR += 2;                  //increases the strenght and constitution of the class but 2 and one respectively
        this.CON += 1;
        this.addFeat("Rage");           //appends the feats of rage and unarmored defense
        this.addFeat("Unarmored Defense");
    }
    
    barbarian(String name, int level){  //constructor with the arguments for the name and level of the character 
        super(name, level);             //calls the constructor for the parent class Character witht the arguments name and level passed in
        this.STR += 2;                  //increases the strenght and constitution of the class but 2 and one respectively
        this.CON += 1;        
        this.addFeat("Rage");           //appends the feats of rage and unarmored defense
        this.addFeat("Unarmored Defense");
    }
}
