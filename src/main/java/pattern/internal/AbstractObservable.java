package pattern.internal;

import java.util.ArrayList;
import java.util.List;
import pattern.external.ObservableI;
import pattern.external.ObserverI;

public class AbstractObservable<T> implements ObservableI<T> {

    private final List<ObserverI<T>> observerList = new ArrayList<>();

    private T item;

    private final int minimalUpdateFrequence;

    public AbstractObservable(int minimalUpdateFrequence) {
        this.minimalUpdateFrequence = minimalUpdateFrequence;
    }

    @Override
    public void addObserver(ObserverI<T> newObserver) {
        System.out.println("observer " + newObserver + " registered");
        observerList.add(newObserver);
    }

    @Override
    public void removeObserver(ObserverI<T> newObserver) {
        System.out.println("Beobachter " + newObserver + " unsubscribed");
        observerList.remove(newObserver);
    }

    @Override
    public void addItem(T item) {
        this.item = item;
        List<ObserverI<T>> tempList;
        synchronized (this) {
            tempList = List.copyOf(observerList);
        }
        for (ObserverI<T> tempObserver: tempList ) {
            tempObserver.update(this);
            try {
                Thread.sleep(minimalUpdateFrequence);
            } catch (InterruptedException ex) {
                // expected behavior
            }
        }
    }

    @Override
    public T getItem() {
        return item;
    }
}
