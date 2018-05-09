package pl.sda;

public enum HitOutcome {
    DODGED(0) , PARTIAL(1) , FULL (2);
    int value;

    HitOutcome(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
