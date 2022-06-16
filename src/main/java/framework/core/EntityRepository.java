package framework.core;

import framework.core.Observer.Observable;
import framework.core.Observer.Observer;
import framework.core.Storage.*;

import java.util.*;

public abstract class EntityRepository<O extends Storable<K>,K> implements Observable<O> {
    DAO<O,K> dao;

    private Set<Observer> observersList = new HashSet<>();
    public EntityRepository(){
        this.dao = getDao();
    }

    //* Factory method pattern
    public abstract DAO<O,K> getDao();

    // --start-- Observable interface method implementations
    public Set<Observer> getObserversList(){
        return observersList;
    }
    //* Observer pattern
    public void notify(O obj ){
        observersList.forEach((observer -> observer.update(obj)));
    }
    // --end--
    public final void save(O obj){
        this.dao.create(obj);
        notify(obj);
    }

    public final void update(O obj){
        this.dao.update(obj);
        notify(obj);
    }

    public final O loadOne(K k){
        O obj = this.dao.loadOne(k);
        //? notify(obj);
        return obj;
    }

    public final Collection<O> getAll(){
        return this.dao.getAll();
    }

}

