package com.test.webtechproject.controller;

import com.test.webtechproject.data.TakenOfferDAO;
import com.test.webtechproject.model.TakenOffer;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TakenOfferController {

    private final TakenOfferDAO takenOfferDAO;
    @Autowired
    public TakenOfferController(TakenOfferDAO takenOfferDAO) {
        this.takenOfferDAO = takenOfferDAO;
    }

    @GetMapping("/takenOffer")
    public String showTakenOffer(Model model) {
        model.addAttribute("takenOfferList", takenOfferDAO.findAll());
        model.addAttribute("newTakenOffer", new TakenOffer());

        return "TakenOfferPage";
    }


    @PostMapping("/takenOffer")
    public String getTakenOffer(@ModelAttribute TakenOffer newTakenOffer) {
        TakenOffer takenOffer = new TakenOffer(newTakenOffer.getTakerUserID(), newTakenOffer.getTakenItemID());
        takenOfferDAO.save(takenOffer);

        return "redirect:takenOffer";
    }

}
