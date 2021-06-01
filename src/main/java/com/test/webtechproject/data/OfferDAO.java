package com.test.webtechproject.data;

import com.test.webtechproject.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OfferDAO extends JpaRepository<Offer, Long> {

}
