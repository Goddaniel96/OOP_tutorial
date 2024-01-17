package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    private String name;
    private Status status;
    private int energy;
    private int money;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private ArrayList<Ore> ores;

    public Player(String name, Status status) {
        try {
            this.status = status;
            if (status.getHp() < 1) {
                status.setHp(1);
            }
        } catch (BadStatusException e) {
        }
        energy = 10;
        money = 100;
        this.name = name;
        potions = new ArrayList<Potion>(); //0ก็ได้
        foods = new ArrayList<Food>();
        ores = new ArrayList<Ore>();
    }

    public Player(String name, Status status, int energy, int money) {
        potions = new ArrayList<Potion>(); //0ก็ได้
        foods = new ArrayList<Food>();
        ores = new ArrayList<Ore>();
        try {
            this.status = status;
            if (status.getHp() < 1) {
                status.setHp(1);
            }
        } catch (BadStatusException e) {
        }
        if(energy<0)
            this.energy=0;
        else
            this.energy = energy;

        if(money<0)
            this.money=0;
        else
            this.money = money;
        this.name = name;
    }

    public boolean buyOre(Ore ore) {
        if (money >= ore.getCost()) {
            money -= ore.getCost();
            ores.add(ore); //ใช้this ore?
            return true;
        } else {
            return false;
        }
    }

    public void drinkPotion(int index) {
        try {
            if (index >= 0 && index < potions.size()) {
                Potion selectPot = potions.get(index); //เพราะมีหลายอันเลยเติมs
                this.status.addStatus(selectPot.getIncreasingStatus());
                potions.remove(index);
            }
        }//ไปเอากระเป๋าของยา ไอ่arraylistคือช่องของยา ก่อนหน้านี้ไปเอาsele
        catch (BadStatusException e) {}
    }

    public void eatFood(int index) {
        if(index >=0 && index< foods.size())
         {Food selectFood = foods.get(index); // เลือกอาหาร
           energy += selectFood.getEnergy();
           foods.remove(index);}
    }

    public void sellPotion(int index) {
        if(index <0 || index>=potions.size()){ //แปลว่าไม่ทำต้องไร

        }
        else {
        money += potions.get(index).getPrice();
        potions.remove(index);
        }
    }

    public void sellFood(int index) {
        if(index>=0 && index <foods.size())
        {money += foods.get(index).getPrice();
         foods.remove(index);}
    }

    public void attack(Monster monster) {
        try {
            Status mstat = monster.getStatus();
            int mHp = mstat.getHp();
            int mdura = mstat.getDurability();
            int patta = status.getAttack();
            int mdame = patta - mdura;
            if (mdame < 0) {
                mdame = 0;
            }
            int newmHp = mHp - mdame;
            if (newmHp < 0) {
                newmHp = 0;
            }
            mstat.setHp(newmHp);
        } catch (BadStatusException e) {}
    }

    public void magicAttack(Monster monster) {
        try {
            Status mstat2 = monster.getStatus();
            int mHp2 = mstat2.getHp();
            int patta2 = status.getMagic();
            int newmHp2 = mHp2 - patta2;
            if (newmHp2 < 0) {
                newmHp2 = 0;
            }
            mstat2.setHp(newmHp2);
        }
        catch(BadStatusException e) {}
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
        if(energy<0)
            this.energy=0;
        else
            this.energy = energy;
}

public int getMoney() {
    return money;
}

public void setMoney(int money) {
        if(money <0)
            this.money=0;
        else
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
