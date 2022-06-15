package framework.core.Observer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface Observable<O> {

    //? Factory method pattern
    Set<Observer> getObserversList();

    default void addObserver(Observer observer){
        getObserversList().add(observer);
    }

    default void removeObserver(Observer observer){
        if(getObserversList().contains(observer)){
            getObserversList().remove(observer);
        }
    }
    void notify(O obj);
}
