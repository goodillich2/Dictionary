package com.example.dictionary.repository;

import com.example.dictionary.entity.Word;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
   public Word findByOriginal(String original);
}
