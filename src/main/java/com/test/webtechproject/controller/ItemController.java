package com.test.webtechproject.controller;

import com.test.webtechproject.data.ItemDAO;
import com.test.webtechproject.model.Item;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ItemController {

    private final ItemDAO itemDAO;
    @Autowired
    public ItemController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @GetMapping("/item")
    public String showItem(Model model) {
        model.addAttribute("itemList", itemDAO.findAll());
        model.addAttribute("newItem", new Item());

        return "ItemPage";
    }


    @PostMapping("/item")
    public String getItem(@ModelAttribute Item newItem) {
        Item item = new Item(newItem.getId(), newItem.getItemName(), newItem.getItemValue(), newItem.getDescription(), newItem.getState(),
                newItem.getNumberOfViews(), newItem.getUserID(), newItem.getGivenOffer(), newItem.getTakenOffer());
        itemDAO.save(item);

        return "redirect:item";
    }




}
