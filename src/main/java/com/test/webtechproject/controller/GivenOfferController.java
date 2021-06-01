package com.test.webtechproject.controller;

import com.test.webtechproject.data.GivenOfferDAO;
import com.test.webtechproject.model.GivenOffer;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GivenOfferController {

    private final GivenOfferDAO givenOfferDAO;
    @Autowired
    public GivenOfferController(GivenOfferDAO givenOfferDAO) {
        this.givenOfferDAO = givenOfferDAO;
    }

    @GetMapping("/givenOffer")
    public String showGivenOffer(Model model) {
        model.addAttribute("givenOfferList", givenOfferDAO.findAll());
        model.addAttribute("newGivenOffer", new GivenOffer());

        return "GivenOfferPage";
    }


    @PostMapping("/givenOffer")
    public String getGivenOffer(@ModelAttribute GivenOffer newGivenOffer) {
        GivenOffer givenOffer = new GivenOffer(newGivenOffer.getGiverUserID(), newGivenOffer.getGivenItemID());
        givenOfferDAO.save(givenOffer);

        return "redirect:givenOffer";
    }

}
