package com.example.dictionary.service;

import com.example.dictionary.entity.Word;
import com.example.dictionary.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;


    public void save(Word word){
        wordRepository.save(word);
    }

    public void deleteById(int id){
        wordRepository.deleteById(id);
    }

    public void update(Word word){
        int id = word.getId();

        if(wordRepository.findById(id).isPresent()){
            Word word1 = wordRepository.findById(id).get();
            word1.setOriginal(word.getOriginal());
            word1.setTranslation(word.getTranslation());
        }
        else {
            wordRepository.save(word);
        }
    }

    public List<Word> findAll(){
        return wordRepository.findAll();
    }

    public Word getById(int id) throws Exception {
        if(wordRepository.findById(id).isPresent()){
            Word word =  wordRepository.findById(id).get();
            return word;
        }
        else {
            throw new Exception("such word not exists");
        }
    }

    public Word getByOriginal(String original) throws Exception {
        if(wordRepository.findByOriginal(original) != null){
            return wordRepository.findByOriginal(original);
        }
        else {
            throw new Exception("such word not exists");
        }

    }


}
