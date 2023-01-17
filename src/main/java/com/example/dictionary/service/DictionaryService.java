package com.example.dictionary.service;


import com.example.dictionary.entity.Dictionary;
import com.example.dictionary.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;


    public void save(Dictionary dictionary){
        dictionaryRepository.save(dictionary);
    }

    public void deleteById(int id){
        dictionaryRepository.deleteById(id);
    }

    public void update(Dictionary dictionary){
        int id = dictionary.getId();

        if(dictionaryRepository.findById(id).isPresent()){
            Dictionary dictionary1 = dictionaryRepository.findById(id).get();
            dictionary1.setName(dictionary.getName());
            dictionary1.setDescription(dictionary.getDescription());
            dictionaryRepository.flush();
        }
        else {
            dictionaryRepository.save(dictionary);
        }
    }

    public List<Dictionary> findAll(){
        return dictionaryRepository.findAll();
    }

    public Dictionary getById(int id) throws Exception {
        if(dictionaryRepository.findById(id).isPresent()){
            Dictionary dictionary =  dictionaryRepository.findById(id).get();
            return dictionary;
        }
        else {
            throw new Exception("such dictionary not exists");
        }
    }


}
