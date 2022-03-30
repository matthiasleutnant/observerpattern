package beispiel;

import pattern.external.ObservableI;
import pattern.internal.AbstractObserver;

public class ZufallszahlenObserver extends AbstractObserver<Double> {

    private final String name;

    public ZufallszahlenObserver(String name) {
        super();
        this.name = name;
    }

    @Override
    public void update(ObservableI<Double> observableI) {
        System.out.println(name + " hat die Zufallszahl " + observableI.getItem() + " erhalten");
    }
}
