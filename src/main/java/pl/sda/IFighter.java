package pl.sda;

public interface IFighter {
    int getHp();
    AttackType getAttackAction ();
    BlockType getBlockAction();

    void decreaseHp( int hpDecrease);
    int getStrength();
    int getStamina();
    void decreaseStamina(int value);
    boolean isAlive();

    String getName();
}
