package pl.sda;

public enum BlockType {
    HIGH(3) , LOW(2) , DODGE(0);
    int value;

    BlockType(int value) {
        this.value = value;
    }
}
