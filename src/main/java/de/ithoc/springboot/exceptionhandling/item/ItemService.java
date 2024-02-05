package de.ithoc.springboot.exceptionhandling.item;

import jakarta.annotation.PostConstruct;
import org.jeasy.random.EasyRandom;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ItemService {

    // This singleton simulates a database for simplicity reasons.
    private final ItemInMemory itemInMemory = ItemInMemory.getInstance();


    @PostConstruct
    private void init() {

        EasyRandom generator = new EasyRandom();
        for (int i = 0; i < 1000; i++) {
            String id = generator.nextObject(UUID.class).toString();
            Item item = generator.nextObject(Item.class);
            itemInMemory.create(id, item);
        }
    }


    public Optional<Item> getItem(String id) {

        return Optional.ofNullable(itemInMemory.findById(id));
    }

}
