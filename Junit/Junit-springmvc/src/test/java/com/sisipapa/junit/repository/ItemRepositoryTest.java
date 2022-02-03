package com.sisipapa.junit.repository;

import com.sisipapa.junit.domain.Item;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@TestPropertySource(locations = "classpath:application-test.yml")
//@ActiveProfiles("test")
@DataJpaTest
class ItemRepositoryTest {

//    @Autowired
//    private ItemRepository itemRepository;

    @MockBean
    private ItemRepository itemRepository;


    @Test
    void save(){
        // given
        final Item item = Item.builder().name("item1").description("아이템1입니다.").build();

        when(itemRepository.save(item)).thenReturn(item);

        // when
        final Item saveItem = itemRepository.save(item);

        // then
        assertEquals(saveItem.getName(), "item1");
        assertEquals(saveItem.getDescription(), "아이템1입니다.");
    }
}