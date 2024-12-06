package hu.unideb.gasstation.api.controllers;

import hu.unideb.gasstation.models.BoxedItems;
import hu.unideb.gasstation.repositories.BoxedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoxedItemController {

    @Autowired
    BoxedItemRepository boxedItemRepository;

    @GetMapping("/boxed")
    public List<BoxedItems> getBoxedItems() {
        return boxedItemRepository.findAll();
    }

    @PostMapping("/boxed/{id}")
    public boolean updateBoxedItem(@PathVariable Long id, @RequestBody BoxedItems boxedItem) {
        if (boxedItemRepository.existsById(id)) {
            boxedItemRepository.save(boxedItem);
            return true;
        }
        return false;
    }

    @PostMapping("/boxed")
    public BoxedItems addBoxedItem(@RequestBody BoxedItems boxedItem) {
        return boxedItemRepository.save(boxedItem);
    }

    @DeleteMapping("/boxed/{id}")
    public void deleteBoxedItemById(@PathVariable Long id) {
        boxedItemRepository.deleteById(id);
    }
}
