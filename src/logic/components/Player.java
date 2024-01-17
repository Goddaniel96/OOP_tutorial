package logic.exclude;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    private String name;
    private Status status;
    private int energy ;
    private int money;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private  ArrayList<Ore> ores;
    public Player(String name,Status status){
        try {
            this.status = status;
            if (status.getHp() < 1) {
                status.setHp(1);
            }
        }
        catch (BadStatusException e) {}
        energy=10;
        money=100;
        this.name=name;
    }
    public Player(String name,Status status,int energy,int money){
        try{
            this.status = status;
            if (status.getHp() < 1) {
                status.setHp(1);
        }
        catch (BadStatusException e) {}
            this.name=name;
            this.energy=energy;
            this.money=money;
    }
    public boolean buyOre(Ore ore){
        if(money >=ore.getCost()){
          money-=ore.getCost();
          ores.add(this.ore); //ใช้this ore?
          return true;
        }
        else{
            return false;
        }
    }
    public void  drinkPotion(int index){
      try{
          if(index >=0 && index<potion.size()){
              Potion selectPot =potions.get(index); //เพราะมีหลายอันเลยเติมs
        this.status.addStatus(selectPot.getIncreasingStatus());
        potions.remove(index);}
        }//ไปเอากระเป๋าของยา ไอ่arraylistคือช่องของยา ก่อนหน้านี้ไปเอาsele
    }
    catch(BadStatusException e){}
    public void eatFood(int index){
       Food selectFood=foods.get(index); // เลือกอาหาร
       energy+=selectFood.getEnergy();
       foods.remove(index);
    }
    public void sellpotion(int index){
         money+=potions.get(index).getPrice();
         potions.remove(index);
    }
    public void sellFood(int index){
         money+=foods.get(index).getPrice();
         foods.remove(index);
    }
    public void attack(Monster monster){
        try{Monter mstat=monster.getStatus();
            int mHp=mstat.getHp();
            int mdura=mstat.getDurability();
            int patta=mstat.getAttack();
            int mdame=patta-mdura;
            if(mdame<0){
              mdame=0;
            }
            int newmHp=mHp-mdame;
            if(newmHp<0){
                newmHp=0;
             }
            mstat.setHp(newmHp);
        }
        catch (BadStatusException e) {}
    }
    public void magicAttack(Monster monster){
        try{Monter mstat2=monster.getStatus();
            int mHp2=mstat2.getHp();
            int patta2=mstat2.getAttack();
            int newmHp2=mHp2-patta2;
            if(newmHp2<0){
                newmHp2=0;
            }
            mstat.setHp(newmHp2);
         }
        }
        catch (BadStatusException e) {}
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }
}
