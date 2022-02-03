package com.sisipapa.junit.repository;

import com.sisipapa.junit.domain.Item;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@TestPropertySource(locations = "classpath:application-test.yml")
//@ActiveProfiles("test")
@DataJpaTest
class ItemRepositoryTest {

//    @Autowired
//    private ItemRepository itemRepository;

    @Mock
    private ItemRepository itemRepository;


    @Test
    void save(){
        // given
        final Item item = Item.builder().name("item1").description("아이템1입니다.").build();

        given(itemRepository.save(any())).willReturn(item);

        // when
        final Item saveItem = itemRepository.save(new Item());

        // then
        verify(itemRepository).save(any());
        assertEquals(saveItem.getName(), "item1");
        assertEquals(saveItem.getDescription(), "아이템1입니다.");
    }
}