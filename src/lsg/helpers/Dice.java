package lsg.helpers;
import java.util.Random;

public class Dice {

    private int faces;
    private Random random;


    private void setFaces(int faces) {
        this.faces = faces;
    }

    private int getFaces() {
        return faces;
    }

    public Dice(int nbF){
        random = new Random(5342);
        this.setFaces(nbF);
    }

    public int roll(){
        int v;
        v = random.nextInt(faces);
        return v;
    }



}
