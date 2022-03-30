import beispiel.ZufallszahlenObservable;
import beispiel.ZufallszahlenObserver;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ZufallszahlenObserverTest {

    List<ZufallszahlenObservable> observableList = new ArrayList<>();

    List<ZufallszahlenObserver> observerList = new ArrayList<>();

    @Test
    public void zufallszahlenTest() {
        initialisiereObservables();
        initialisiereObserver();
        for(int i =0; i<10;i++){
            for(ZufallszahlenObservable observable:observableList) {
                observable.generiereZufallszahl();
            }
        }
    }

    private void initialisiereObservables() {
        observableList = new ArrayList<>();
        observableList.add(new ZufallszahlenObservable(500, -1, 1, "Observable 1"));
        observableList.add(new ZufallszahlenObservable(1000, 0, 10, "Observable 2"));
        observableList.add(new ZufallszahlenObservable(2000, 20, 100, "Observable 3"));
    }

    private void initialisiereObserver() {
        for (int i = 0; i < Math.pow(2, observableList.size()); i++) {
            ZufallszahlenObserver zufallszahlenObserver = new ZufallszahlenObserver("Observer " + i);
            for(ZufallszahlenObservable observable: bestimmeObservablesFuer(i)) {
                observable.addObserver(zufallszahlenObserver);
            }
            observerList.add(zufallszahlenObserver);
        }
    }

    private List<ZufallszahlenObservable> bestimmeObservablesFuer(int zahl) {
        List<ZufallszahlenObservable> ergebnis = new ArrayList<>();
        for (int i=0; zahl > 0; i++) {
            if (zahl % 2 == 1) {
                ergebnis.add(observableList.get(i));
            }
            zahl /= 2;
        }
        return ergebnis;
    }
}
