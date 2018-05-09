package pl.sda;

public enum AttackType {


    HOOK (2),
    JAB (1),
    UPPERCUT(3) ;

    int value;

    AttackType(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
