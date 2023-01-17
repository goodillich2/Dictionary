package com.example.dictionary.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Entity
@Table(name = "dictionaries")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Dictionary extends BaseEntity<Integer>{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;


    @OrderBy("translation asc")
    @OneToMany(mappedBy = "dictionary",fetch = FetchType.EAGER)
    private List<Word> wordList;

    public void addEmployee(Word word){
        if(wordList== null)
            wordList = new ArrayList<>();
        wordList.add(word);
        word.setDictionary(this);
    }

    public Dictionary(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Dictionary(Integer id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
