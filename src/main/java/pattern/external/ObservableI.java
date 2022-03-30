package pattern.external;

public interface ObservableI<T> {
    public void addObserver(ObserverI<T> newObserver);
    public void removeObserver(ObserverI<T> newObserver);
    public void addItem(T item);
    public T getItem();
}
