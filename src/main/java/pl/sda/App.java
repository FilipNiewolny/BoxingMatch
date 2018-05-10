package pl.sda;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, WrongParameterException {
        IFighter fighter1 = new Boxer("Andrzej Gołota" ,55 , 2);
        IFighter fighter2 = new Boxer("Mike Tyson" ,20 , 2);
        IFighter myFighter = new MyBoxer("Niewo" , 500 , 1);

IFight fight = new BoxingMatch(fighter1 , myFighter);
    fight.fight();
    }
}
