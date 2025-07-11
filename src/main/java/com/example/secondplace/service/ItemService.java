package com.example.secondplace.service;

import com.example.secondplace.model.Item;
import com.example.secondplace.model.User;
import com.example.secondplace.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item) {
        item.setStatus(Item.ItemStatus.AVAILABLE); // Set default status to AVAILABLE
        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> getItemsByUser(User user) {
        return itemRepository.findByPostedBy(user);
    }

    public List<Item> getItemsByUserId(Long userId) {
        return itemRepository.findByPostedById(userId);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> getItemsByCategory(String category) {
        return itemRepository.findByCategory(category);
    }

    public List<Item> getItemsByStatus(Item.ItemStatus status) {
        return itemRepository.findByStatus(status);
    }

    public List<Item> getItemsByCondition(Item.ItemCondition condition) {
        return itemRepository.findByCondition(condition);
    }

    public Item updateItem(Long id, Item itemDetails) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setTitle(itemDetails.getTitle());
                    item.setDescription(itemDetails.getDescription());
                    item.setPrice(itemDetails.getPrice());
                    item.setCategory(itemDetails.getCategory());
                    item.setCondition(itemDetails.getCondition());
                    item.setStatus(itemDetails.getStatus());
                    item.setPostedBy(itemDetails.getPostedBy());
                    return itemRepository.save(item);
                })
                .orElse(null);
    }

    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }
}
