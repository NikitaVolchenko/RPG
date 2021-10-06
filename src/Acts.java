import java.util.Random;

import static java.lang.Math.abs;

public class Acts {

    public void startAct1(MainCharacter mainCharacter) {
        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 10, false);
        clothes[1] = new Four("shoes", 0, 10, false);
        clothes[2] = new Four("pants", 0, 10, false);
        clothes[3] = new Four("chain mail", 0, 20, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 5, 0, true);
        skills[1] = new Four("hard blow", 10, 0, true);
        skills[2] = new Four("protection", 0, 10, true);
        skills[3] = new Four("healing", 0, 0, true);

        Monster monster = new Monster("Monster1", clothes, skills, 50, 0);

        int min = 0;
        int max = 1;
        int diff = max - min;
        Random random = new Random();
        int number = random.nextInt(diff + 1);
        number += min;

        System.out.println("number = " + number);

        while (mainCharacter.getHealth() > 0 || monster.getHealth() > 0) {
            System.out.println(mainCharacter);
            System.out.println(monster);
            switch (number) {
                case 0:                                //ход игрока
                    Motion motion = new Motion();
                    int number1 = motion.makeMotion();

                    if (mainCharacter.getSkills()[number1].isAvailability()) {
                        int damage = mainCharacter.getSkills()[number1].getDamage();
                        int protection = mainCharacter.getSkills()[number1].getProtection();
                        mainCharacter.addProtection(protection);

                        protection = 0;
                        for (int i = 0; i < 4; i++) {
                            if (clothes[i].isAvailability()) {
                                protection += clothes[i].getProtection();
                            }
                        }

                        monster.characterAttack(abs(monster.getProtection() + protection - damage));
                    }

                    if(mainCharacter.getSkills()[number1].getThing().equals("healing")) {
                        mainCharacter.setHealth(100);
                    }
                    System.out.println("Герой сделал ход");
                case 1:                                //ход монстра
                    int min1 = 0;
                    int max1 = 3;
                    int diff1 = max1 - min1;
                    Random random1 = new Random();
                    int number2 = random1.nextInt(diff1 + 1);
                    number2 += min1;

                    if (monster.getSkills()[number2].isAvailability()) {
                        int damage = monster.getSkills()[number2].getDamage();
                        int protection = monster.getSkills()[number2].getProtection();
                        monster.addProtection(protection);

                        protection = 0;
                        for (int i = 0; i < 4; i++) {
                            if (mainCharacter.getClothes()[i].isAvailability()) {
                                protection += clothes[i].getProtection();
                            }
                        }

                        mainCharacter.monsterAttack(abs(mainCharacter.getProtection() + protection - damage));
                    }

                    if(monster.getSkills()[number2].getThing().equals("healing")) {
                        monster.setHealth(50);
                    }
                    System.out.println("Монстр сделал ход");
            }
            if (number == 0) {
                number = 1;
            } else {
                number = 0;
            }
        }
    }
}
