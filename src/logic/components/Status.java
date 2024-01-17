package logic.exclude;

import exception.BadStatusException;

import java.util.Objects;

public class Status {
private int hp; //พลังชีวิต
private int durability;//ป้องกัน
private int attack; //พลังโจมตี
private int magic; //ปล่อยพลังเวท

public Status(int hp, int durability, int attack, int magic) throws BadStatusException{
 if(hp<0 || durability <0 || attack <0 || magic <0 ){
     throw new BadStatusException;
 }
 setHp(hp);
 setAttack(attack);
 setDurability(durability);
 setMagic(magic);
}
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return hp == status.hp && durability == status.durability && attack == status.attack && magic == status.magic;
    }
    @Override
    public int hashCode() {
        return Objects.hash(hp, durability, attack, magic);
    }
    public void addStatus(Status another) throws //รับค่าจากออบเจ็ค another ที่อยุ่ในclass Status
            BadStatusException{
    if(hp<0 || durability <0 || attack <0 || magic <0 ) {
        throw new BadStatusException;
    }
    hp+=another.hp;
    durability+=another.durability;
    attack+=another.attack;
    magic+=another.magic;
}

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) throws BadStatusException {
    if(hp<0){
        throw new BadStatusException;
    }
        this.hp = hp;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) throws BadStatusException {
    if(durability<0){
        throw new BadStatusException;
    }
        this.durability = durability;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) throws BadStatusException {
       if(attack<0){
           throw new  BadStatusException;
       }
       this.attack = attack;
 }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) throws BadStatusException {
        if(magic <0){
            throw new BadStatusException;
        }
        this.magic = magic;
    }
}
