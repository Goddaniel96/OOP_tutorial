package logic.component;

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
        try{

        }
        energy=10;
        money=100;
    }
    public Player(String name,Status status,int energy,int money){

    }
    public boolean buyOre(Ore one){
        if(money >= ores.getCost()){
          money-=ores.getCost();
          ores.add(ore);
          return true;
        }
        else{
            return false;
        }
    }
    public void  drinkPotion(int index){
        Potion  selectPot =potions.get(index); //เพราะมีหลายอันเลยเติมs
        this.status.addStatus(selectPot.getIncreasingStatus());
        potions.remove(index); //ไปเอากระเป๋าของยา ไอ่arraylistคือช่องของยา ก่อนหน้านี้ไปเอาsele
    }
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

    }
    public void magicAttack(Monster monster){

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
