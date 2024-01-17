package logic.components;

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
        catch (BadStatusException e ){}
        food=null; //the monster hp() must be at least equal to 1
        potion=null; //deal with exception inside constructor only (no exception is actually possible)
        this.name=name;
    }
    public void attack(Player player){
        try{Status pstat1=player.getStatus(); //ไปดึงstatus playerมาก่อน
            int pHp=pstat1.getHp();
            int pdura=pstat1.getDurability();
            int monatta=status.getAttack();
            int damaged=monatta-pdura;
            if(damaged<0){
                damaged=0;}
           int newpHp=pHp-damaged;
            if(newpHp<0){
                newpHp=0;
            }
            pstat1.setHp(newpHp);
        }
        catch (BadStatusException e){}
    }
    public void magicAttack(Player player){
        try{Status pstat2=player.getStatus();//ไว้ดึงเอาข้อมูลจากStatusของplayer
            int monAtta2=status.getMagic();
            int pHp2=pstat2.getHp();
            int newpHp2=pHp2-monAtta2;
            if(newpHp2<0){
                newpHp2=0;
            }
           pstat2.setHp(newpHp2);
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
