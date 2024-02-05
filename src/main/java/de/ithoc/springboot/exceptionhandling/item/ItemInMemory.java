package de.ithoc.springboot.exceptionhandling.item;

import java.util.HashMap;
import java.util.Map;

public class ItemInMemory {

    private final Map<String, Item> data = new HashMap<>();

    private static final ItemInMemory instance = new ItemInMemory();

    private ItemInMemory() {
    }

    @SuppressWarnings("unused")
    public static ItemInMemory getInstance() {
        return instance;
    }

    public void create(String id, Item item) {

        data.put(id, item);
    }

    public Item findById(String id) {

        return data.get(id);
    }

    public void delete(String id) {

        data.remove(id);
    }

}

