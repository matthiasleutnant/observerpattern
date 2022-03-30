package beispiel;

import pattern.internal.AbstractObservable;

public class ZufallszahlenObservable extends AbstractObservable<Double> {

    private final double untereGrenze;
    private final double obereGrenze;
    private final String name;

    public ZufallszahlenObservable(int minimalUpdateFrequence, double untereGrenze, double obereGrenze, String name) {
        super(minimalUpdateFrequence);
        this.untereGrenze = untereGrenze;
        this.obereGrenze = obereGrenze;
        this.name = name;
    }

    public void generiereZufallszahl() {
        Double zufallszahl = Math.random() * (obereGrenze - untereGrenze) + untereGrenze;
        System.out.println("Observable hat die Zufallszahl "+ zufallszahl + " generiert");
        this.addItem(zufallszahl);
    }
}
