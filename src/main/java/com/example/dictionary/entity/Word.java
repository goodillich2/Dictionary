package com.example.dictionary.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "words")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Word extends BaseEntity<Integer> {

    @Column(unique = true, nullable = false)
    private String original;

    @Column(nullable = false)
    private String translation;


    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    Dictionary dictionary;

}
