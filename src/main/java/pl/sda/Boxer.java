package pl.sda;

import lombok.Data;

import java.util.Random;

@Data
public class Boxer implements IFighter {
    private String name;
    private int hp;
    private int stamina = 10;
    private int strength;

    Boxer(String name, int hp, int strength) throws WrongParameterException {
        verifiedValidate(name, hp, strength);
        this.strength = strength;
        this.name = name;
        this.hp = hp;
    }

    private void verifiedValidate(String name, int hp, int strength) throws WrongParameterException {
        if (hp <= 0) {
            throw new WrongParameterException("Wrong Hp amount");
        }
        if (strength <= 0) {
            throw new WrongParameterException("Wrong strength amount");
        }
        if (name == null) {
            throw new WrongParameterException("Wrong name value");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int getStamina() {
        return stamina;
    }

    @Override
    public void decreaseStamina(int value) {
        stamina -= value;
    }


    @Override
    public int getStrength() {
        return strength;
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
