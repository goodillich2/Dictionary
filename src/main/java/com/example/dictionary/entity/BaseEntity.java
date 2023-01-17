package com.example.dictionary.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  T id;
}
