package com.sisipapa.junit.domain;

import lombok.*;

import javax.persistence.*;

@Table(name = "item")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String name;
    private String description;
}
