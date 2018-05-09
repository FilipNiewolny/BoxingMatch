package pl.sda;

public interface IFighter {
    int getHp();
    AttackType getAttackAction ();
    BlockType getBlockAction();

    void decreaseHp( int hpDecrease);

    boolean isAlive();

    String getName();
}
