package com.sisipapa.junit.repository;

import com.sisipapa.junit.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}
