package pl.sda;

public class BoxingMatch implements IFight {
    private IFighter boxer1;
    private IFighter boxer2;

    public BoxingMatch(IFighter boxer1, IFighter boxer2) {
        this.boxer1 = boxer1;
        this.boxer2 = boxer2;
    }

    @Override
    public void fight() {

    }
}
