package com.test.webtechproject.controller;

import com.test.webtechproject.data.OfferDAO;
import com.test.webtechproject.model.Offer;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OfferController {

    private final OfferDAO offerDAO;

    @Autowired
    public OfferController(OfferDAO offerDAO) {
        this.offerDAO = offerDAO;
    }

    @GetMapping("/offer")
    public String showOffer(Model model) {
        model.addAttribute("offerList", offerDAO.findAll());
        model.addAttribute("newOffer", new Offer());

        return "OfferPage";
    }


    @PostMapping("/offer")
    public String getOffer(@ModelAttribute Offer newOffer) {
        Offer offer = new Offer(newOffer.getGivenOfferID(), newOffer.getTakenOfferID(), newOffer.getTimeStamp(), newOffer.getComment(), newOffer.getStatus());
        offerDAO.save(offer);

        return "redirect:offer";
    }




}
