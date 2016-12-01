import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Armin Beck on 01.12.2016.
 */
public class Gummi{
    public static void main(String[] args) {
        boolean GummiBär = false;
        boolean Lakriz = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Anzahl Gummibärchen eingeben:");
        int GummiBärchenNr = sc.nextInt();
        System.out.println("Anzahl Lakriz eingeben");
        int LakrizNr = sc.nextInt();

        ArrayList<Boolean> süßigkeiten = new ArrayList<>();
        for (int i = 0; i < GummiBärchenNr; i++) {
            süßigkeiten.add(GummiBär);
        }
        for (int i = 0; i < LakrizNr; i++) {
            süßigkeiten.add(Lakriz);
        }
        Random r = new Random();
        while (süßigkeiten.size() > 1) {
            int idx1 = r.nextInt(süßigkeiten.size());// nextInt(0, süßigkeiten.size());
            int idx2 = r.nextInt(süßigkeiten.size());
            if (idx1 == idx2) {
                continue;
            }

            if (süßigkeiten.get(idx1) == süßigkeiten.get(idx2)) {
                if (idx2 > idx1) {
                    süßigkeiten.remove(idx2);
                    süßigkeiten.remove(idx1);
                } else {
                    süßigkeiten.remove(idx1);
                    süßigkeiten.remove(idx2);
                }
                süßigkeiten.add(Lakriz);
                continue;
            }
            if (süßigkeiten.get(idx1) && !süßigkeiten.get(idx2)) {
                süßigkeiten.remove(idx1);
                continue;
            }
            if (!süßigkeiten.get(idx1) && süßigkeiten.get(idx2)) {
                //remove Lakriz, Gummi stays
                süßigkeiten.remove(idx2);
                continue;
            }
        }
        System.out.println("Ergebnis:");
        int endGummiCount = 0;
        int endLakrizCount = 0;
        for (int i = 0; i < süßigkeiten.size(); i++) {
            if (süßigkeiten.get(i) == GummiBär) {
                endGummiCount++;
            } else {
                endLakrizCount++;
            }
        }
        System.out.print("Gummi:\t" + endGummiCount + "\nLakriz:\t" + endLakrizCount);
        sc.nextLine();
        sc.close();
    }
}
