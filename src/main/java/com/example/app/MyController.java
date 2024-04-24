package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @GetMapping("/kochbuch")
    public List<Recipe> greeting() {
        Recipe entry = new Recipe("Lasagne", "leckere italienische Lasagne", 15, 20, "Tomaten, Tomatenmark, Käse", 3);
        Recipe entry1 = new Recipe("Pizza", "napoletanische Pizza", 10, 40, "Tomaten, Mehl, Köse", 1);
        Recipe entry2 = new Recipe("Lachsfilet", "Lachsfilet mit Bratkartoffeln", 15, 50, "Lachs, Kartoffeln, Sonnenblumenöl", 1);

        return List.of(entry, entry1, entry2);//zeigt die liste von essen
    }
}
