package pattern.external;

public interface ObserverI<T> {
    void update(ObservableI<T> observableI);
}
