package com.sisipapa.junit.repository;

import com.sisipapa.junit.domain.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@TestPropertySource(locations = "classpath:application-test.yml")
//@ActiveProfiles("test")
//@DataJpaTest
@ExtendWith(MockitoExtension.class)
class ItemRepositoryTest {

//    @Autowired
//    private ItemRepository itemRepository;

//    @MockBean
    @Mock
    private ItemRepository itemRepository;


    @Test
    void save(){
        // given
        final Item item = Item.builder().name("item1").description("아이템1입니다.").build();

        when(itemRepository.save(any())).thenReturn(item);

        // when
        final Item saveItem = itemRepository.save(new Item());

        // then
        verify(itemRepository).save(any());
        assertEquals(saveItem.getName(), "item1");
        assertEquals(saveItem.getDescription(), "아이템1입니다.");
    }
}