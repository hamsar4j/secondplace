package com.example.secondplace.repository;

import com.example.secondplace.model.Item;
import com.example.secondplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByPostedBy(User user);

    List<Item> findByPostedById(Long userId);

    List<Item> findByCategory(String category);

    List<Item> findByStatus(Item.ItemStatus status);

    List<Item> findByCondition(Item.ItemCondition condition);

}
