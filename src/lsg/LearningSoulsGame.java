package lsg;

import lsg.characters.*;
import java.lang.Character;
import lsg.weapons.Weapon;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;


import java.util.Scanner;

public class LearningSoulsGame {

    //On déclare 1 Hero et 1 Monstre ainsi qu'un Scanner
    private lsg.characters.Character hero1 = new Hero();
    private lsg.characters.Character monster1 = new Monster();
    private Scanner scanner = new Scanner(System.in);


    //Méthode refresh qui permet d'afficher les valeurs de chaque combattant
    private void refresh(){

        hero1.printStats();
        monster1.printStats();
    }

    //Méthode qui permet d'attribuer les armes aux deux combattants
    private void init() {

        hero1.setWeapon(new Sword());
        monster1.setWeapon(new Claw());
    }

    //Méthode dans laquelle les combattants vont être intervertis tant qu'un des deux et vivant
    private void fight1v1() {

        lsg.characters.Character p1 = hero1;
        lsg.characters.Character p2 = monster1;

        int att;
        int dmg;

        lsg.characters.Character tmp;

        while(hero1.isAlive() && monster1.isAlive()) {

            refresh();
            System.out.print("\nPress enter to continue ... ");
            scanner.nextLine();

            att = p1.attack();
            dmg = p2.getHitWith(att);
            System.out.println("\n" + p1.getName() + " attacks " + p2.getName() + " with " + p1.getWeapon().getName() + " (ATTACK:" + att + " | DMG : " + dmg + ")");

            tmp = p2;
            p2 = p1;
            p1 = tmp;

        }
        System.out.println("\n--- " + p2.getName() + " WINS !!! ---");
    }

    private void play_v1() {
        init();
        fight1v1();
    }

    public static void main(String[] args) {

        LearningSoulsGame lsg = new LearningSoulsGame();
        lsg.play_v1();


       /*Monster M1 = new Monster("STUDENTATORT");
       Monster M2 = new Monster();
       Monster M3 = new Monster();

       System.out.println(Hero1.isAlive());

       Hero1.printStats();
       M1.printStats();
       M2.printStats();
       M3.printStats();*/



    }
}
