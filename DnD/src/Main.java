import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character c1 = new Character();
        System.out.println(c1);
        Character c2 = new Character("Bingus", 1);
        System.out.println(c2);
    }
}
class Character{
    protected int STR;
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

    public Character(){
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

    public Character(String name, int level){
        this.STR = stat_initializer();
        this.DEX = stat_initializer();
        this.CON = stat_initializer();
        this.INT = stat_initializer();
        this.WIS = stat_initializer();
        this.CHA = stat_initializer();
        this.Name = name;
        this.Level = level;
        calculateHitPoints();
        calculateArmorClass();
        this.Feats = new ArrayList<>();
    }

    public int stat_initializer(){
        Random randInt = new Random();
        return randInt.nextInt(14) + 3;
    }

    public void calculateHitPoints(){
        if(this.Level == 1){
            this.HP = 10 + this.CON;
        }
        else{
            this.HP = this.HP + ((this.Level - 1) * (6 + this.CON));
        }
    }

    public void calculateArmorClass(){
        this.AC = 10 + this.DEX;
    }

    public int getAbilityModifier(int score){
        return (score - 10)/2;
    }
    public void levelUp(){
        this.Level += 1;
        calculateHitPoints();
        calculateArmorClass();
    }

    public void addFeat(String feat){
        this.Feats.add(feat);
    }

    public String toString() {
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