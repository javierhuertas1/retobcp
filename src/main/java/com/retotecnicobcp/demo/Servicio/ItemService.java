package com.retotecnicobcp.demo.Servicio;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retotecnicobcp.demo.Entidad.Item;
import com.retotecnicobcp.demo.Repo.ItemRepository;
import java.util.List;

@Service
public class ItemService {
     @Autowired
    private ItemRepository itemRepository;

    public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {
        return itemRepository.findItemsWithAverageRatingLowerThan(rating)
                             .stream()
                             .map(Item::getTitle)
                             .collect(Collectors.toList());
    }
}
