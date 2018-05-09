package pl.sda;

import lombok.Data;

import java.util.Random;

@Data
public class Boxer implements IFighter {
    private String name;
    private int hp;

    Boxer(String name, int hp) {

        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }


    public int getHp() {
        return hp;
    }


    @Override
    public AttackType getAttackAction() {
        AttackType attackType;
        Random random = new Random();
        int tmp = random.nextInt(4);
        if ((tmp == 0)) {
            attackType = AttackType.HOOK;
        } else if (tmp == 1) {
            attackType = AttackType.UPPERCUT;
        } else {
            attackType = AttackType.JAB;
        }

        return attackType;
    }

    @Override
    public BlockType getBlockAction() {
        BlockType blockType;
        Random random = new Random();
        int tmp = random.nextInt(4);
        if (tmp == 3) {
            blockType = BlockType.DODGE;
        } else if (tmp < 2) {
            blockType = BlockType.HIGH;
        } else {
            blockType = BlockType.LOW;
        }

        return blockType;
    }

    @Override
    public void decreaseHp(int hpDecrease) {
        hp -= hpDecrease;
    }


    public boolean isAlive() {
        return hp <= 0;
    }
}
