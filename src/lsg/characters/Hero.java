package lsg.characters;

import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.RingedKnightArmor;

public class Hero extends Character {

    private int MAX_ARMOR_PIECES = 3;
    private ArmorItem armor[] = new ArmorItem[MAX_ARMOR_PIECES];

    public Hero() {
        this("Gregooninator");
    }

    public Hero(String name) {
        super(name);
        this.setLife(100);
        this.setStamina(50);
        this.setMaxLife(100);
        this.setMaxStamina(50);
    }

    public void setArmorItem(ArmorItem Ai, int indice){

        if(indice > 0 && indice <= MAX_ARMOR_PIECES){
            armor[indice -1] = Ai;
        }
    }

    public float getTotalArmor(){

        float somme = 0;

        for (int i = 0; i < MAX_ARMOR_PIECES; i++){
            if(armor[i] != null)
            somme = somme + armor[i].getArmorValue();
        }

        return somme;
    }

    public String armorToString(){

        String c = String.format("ARMOR ", 1);

        for (int i = 0; i < MAX_ARMOR_PIECES; i++) {

            c = c.concat(String.format(" %2d:%-30s", i + 1, ((armor[i] != null) ? armor[i].toString() : "empty")));

        }
            c = c.concat("TOTAL:" + getTotalArmor());

        return c;
    }

    public ArmorItem[] getArmorItems() {

        int c = 0;
        for (int a = 0; a < MAX_ARMOR_PIECES; a++){
            if(armor[a] != null){
                c++;
            }
        }

        ArmorItem tab[] = new ArmorItem[c];

        for (int i = 0, j = 0; i < MAX_ARMOR_PIECES; i++){
            if(armor[i] != null){
                    tab[j] = armor[i];
                    j++;
                }
            }

        return tab;
    }

    public static void main(String[] args) {

        Hero h1 = new Hero();

        BlackWitchVeil b = new BlackWitchVeil();
        RingedKnightArmor r = new RingedKnightArmor();

        h1.setArmorItem(b, 1);
        h1.setArmorItem(r, 3);

        System.out.println(h1.armorToString());
    }

    // 6)La visibilité optimale est protected car elle permet d'accéder à la méthode depuis le même package

    // 7)La visibilité optimale est public car il n'y a qu'elle qu'y permet d'accéder à la méthode
}
