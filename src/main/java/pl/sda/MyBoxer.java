package pl.sda;

import java.util.Random;
import java.util.Scanner;

public class MyBoxer implements IFighter {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private int hp;
    private int strength;
    private int stamina = 10;

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public AttackType getAttackAction() {
        System.out.println("Insert command. Correct command is Hook , Jab or Uppercut ");

        while (true) {
            String scan = scanner.nextLine();
            switch (scan) {
                case "Hook":
                    return AttackType.HOOK;
                case "Jab":
                    return AttackType.JAB;
                case "Uppercut":
                    return AttackType.UPPERCUT;
                default:
                    System.out.println("Wrong command. Please chose Hook , Jab or Uppercut ");
            }
        }
    }

    @Override
    public BlockType getBlockAction() {
        Random random = new Random();
        if (random.nextInt(10) == 0){
            return BlockType.DODGE;
        }
        System.out.println("Insert command. Correct command is Low or High ");

        while (true) {
            String scan = scanner.nextLine();
            switch (scan){
                case "Low":
                    return BlockType.LOW;
                case "High":
                    return BlockType.HIGH;
                    default:
                        System.out.println("Wrong command. Please chose Low or High");
            }
        }
    }

    public MyBoxer(String name, int hp, int strength) throws WrongParameterException {
        if (hp < 1){
            verifiedValidate(name , hp ,strength);
        }
        this.name = name;
        this.hp = hp;
        this.strength = strength;
    }
    private void verifiedValidate(String name, int hp, int strength) throws WrongParameterException {
        if (hp <= 0 ){
            throw new WrongParameterException("Wrong Hp");
        }
    }

    @Override
    public void decreaseHp(int hpDecrease) {
        hp -= hpDecrease;
    }

    @Override
    public int getStrength() {
        return strength;
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
    public boolean isAlive() {
        return hp <= 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
