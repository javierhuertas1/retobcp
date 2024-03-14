package com.retotecnicobcp.demo.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.retotecnicobcp.demo.Servicio.ItemService;

@RestController
@RequestMapping("/titles")
public class ItemController {
 @Autowired
    private ItemService itemService;

    @GetMapping
    public List<String> getTitles(Double rating) {
        return itemService.getTitlesWithAverageRatingLowerThan(rating);
    }
}
