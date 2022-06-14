package framework.core;

import framework.core.Storage.*;
import framework.core.Storage.Storage;

import java.util.Collection;

public abstract class DAO<T extends Storable<K>,K> {
    private final Storage<T,K> storage;

    public DAO(){
        this.storage = createStorageFactory();
    }

    public abstract Storage<T,K> createStorageFactory();

    public void create(T obj) {
        storage.create(obj);
    }

    public void update(T obj) {
        storage.update(obj);
    }

    public T loadOne(K key) {
        return storage.loadByKey(key);
    }

    public Collection<T> getAll() {
        return storage.getAll();
    }
}
