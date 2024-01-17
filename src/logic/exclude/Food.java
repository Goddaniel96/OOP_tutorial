package logic.components;

import java.util.Objects;

public class Food {


    private String name;
    private int price ; //price must be positice
    private int energy; // energy must be positive
    public Food(String name, int price ,int energy){
        this.name=name;
        if(price<1){
            price = 1;
        }
        if(energy<1){
            energy =1;
        }
        this.price =price;
        this.energy=energy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.price && energy == food.energy && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, energy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
