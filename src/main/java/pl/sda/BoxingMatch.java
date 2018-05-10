package pl.sda;

import java.util.Random;

public class BoxingMatch implements IFight {
    private IFighter boxer1;
    private IFighter boxer2;

    BoxingMatch(IFighter boxer1, IFighter boxer2) {
        this.boxer1 = boxer1;
        this.boxer2 = boxer2;
    }

    @Override
    public void fight() throws InterruptedException {
        IFighter first;
        IFighter second;

        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            first = boxer1;
            second = boxer2;
        } else {
            first = boxer2;
            second = boxer1;
        }
        IFighter winner;
        while (true) {
            AttackType attackActionFighter1 = first.getAttackAction();
            BlockType blockActionFighter2 = second.getBlockAction();
            HitOutcome hitOutcome = isHitSuccessful(first, attackActionFighter1, blockActionFighter2);
            int damage = checkDamage(first, second, hitOutcome);
            System.out.println(first.getName() + " zadaje cios " + attackActionFighter1);
            System.out.println(second.getName() + " broni się za pomocą " + blockActionFighter2
                    + " otrzymuje obrażenia równe " + damage + " ma wciąż " + second.getHp() + " HP");
            if (second.isAlive()) {
                winner = first;
                break;
            }

            Thread.sleep(100);

            AttackType attackTypeFighter2 = second.getAttackAction();
            BlockType blockActionFighter1 = first.getBlockAction();
            hitOutcome = isHitSuccessful(second, attackTypeFighter2, blockActionFighter1);
            damage = checkDamage(second, first, hitOutcome);
            System.out.println(second.getName() + " zadaje cios " + attackTypeFighter2);
            System.out.println(first.getName() + " broni się za pomocą " + blockActionFighter1
                    + " otrzymuje obrażenia równe " + damage + " ma wciąż " + first.getHp() + " HP");
            if (first.isAlive()) {
                winner = second;
                break;
            }
            Thread.sleep(100);
        }
        System.out.println("The winner is " + winner.getName());
    }

    private int checkDamage(IFighter first, IFighter second, HitOutcome hitOutcome) {
        int result = 0;
        if (hitOutcome.value != 0) {
            if (first.getStamina() > 5) {
                second.decreaseHp(hitOutcome.value + first.getStrength());
                result = hitOutcome.value + first.getStrength();
            } else {
                second.decreaseHp((hitOutcome.value + first.getStrength() - 1));
                result = (hitOutcome.value + first.getStrength() - 1);
            }
        }
        return result;
    }

    private HitOutcome isHitSuccessful(IFighter fighter, AttackType attackActionFighter1, BlockType blockActionFighter2) {
        HitOutcome hitOutcome;
        if (attackActionFighter1.value == blockActionFighter2.value) {
            hitOutcome = HitOutcome.PARTIAL;
            fighter.decreaseStamina(2);
        } else if (blockActionFighter2.value == 0) {
            hitOutcome = HitOutcome.DODGED;
            fighter.decreaseStamina(3);
        } else {
            hitOutcome = HitOutcome.FULL;
            fighter.decreaseStamina(1);
        }


        return hitOutcome;
    }
}
