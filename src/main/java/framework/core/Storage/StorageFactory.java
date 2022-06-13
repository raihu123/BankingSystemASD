package framework.core.Storage;

import framework.core.Storage.Storable;

public class StorageFactory<O,K> {
    public static <O extends Storable<K>,K> Storage<O,K> getMemoryStorage(){
        return new MemoryStorage<O,K>();
    }

    public static <O extends Storable<K>,K> Storage<O,K> getDatabaseStorage(){
        return new DBStorage<O,K>();
    }

    public static <O extends Storable<K>,K> Storage<O,K> getFileStorage(){
        return new FileStorage<O,K>();
    }
}
