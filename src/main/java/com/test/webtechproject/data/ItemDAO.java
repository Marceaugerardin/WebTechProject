package com.test.webtechproject.data;

import com.test.webtechproject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ItemDAO extends JpaRepository<Item, Long> {

}