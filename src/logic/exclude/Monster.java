package logic.component;

import exception.BadStatusException;

public class Monster {
    private String name ;
    private Status status;
    private Food food; //food which drop when the monster is dead
    private Potion potion; //potion which drops when the monster is dead
    public Monster(String name,Status status){
        try {
            this.status = status;
            if (status.getHp() < 1) {
                status.setHp(1);
            }
        }
            catch(BadStatusException e ){}

        food=null; //the monster hp() must be at least equal to 1
        potion=null; //deal with exception inside constructor only (no exception is actually possible)
        this.name=name;
    }
    public void attack(Player player){
        try{ playstat=player.getStatus(); //ไปดึงstatus playerมาก่อน
            int playHp=playstat.getHp();
            int playdura=playstat.getDurability();
            int monattack=status.getAttack();
            int damaged=monattack-playdura;
            if(damaged<0){
                damaged=0;}
           int newplayhp=damaged-playHp;
            if(newplayhp<0){
                newplayhp=0;
            }
            playstat.setHP(newplayhp);
        }
        catch(BadStatusException e){}
    }
    public void magic Attack(Player player){
        try{playstattwo=player.getstatus();
          int newhptwo=playstattwo.getHp();
        }
        catch (BadStatusException e){}
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}
