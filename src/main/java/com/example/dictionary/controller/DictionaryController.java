package com.example.dictionary.controller;


import com.example.dictionary.entity.Dictionary;
import com.example.dictionary.entity.Word;
import com.example.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/list")
    public String getAllDictionary(Model model){
        List<Dictionary> dictionaries = dictionaryService.findAll();
        model.addAttribute("dictionaries", dictionaries);
        return "showAllDictionaries";
    }

    @PostMapping("/add")
    public String addDictionary(@RequestParam("name") String name,
                                @RequestParam("description") String description){
        dictionaryService.save(new Dictionary(name, description));
        return "redirect:/dictionary/list";
    }

    @GetMapping("/add")
    public String addDictionary(){
        return "addDictionaryForm";
    }



    @PostMapping("/update")
    public String updateDictionary(@RequestParam("id") Integer id,
                                   @RequestParam("name") String name,
                                   @RequestParam("description") String description){
        dictionaryService.update(new Dictionary(id, name, description));
        return "redirect:/dictionary/list";
    }

    @GetMapping("/update/{id}")
    public String updateDictionary(@PathVariable("id") int id, Model model) throws Exception {
        Dictionary dictionary =  dictionaryService.getById(id);
        model.addAttribute("dictionary", dictionary);
        return "updateDictionaryForm";
    }


    @PostMapping("/delete/{id}")
    public String deleteDictionary(@PathVariable("id") int id){
        dictionaryService.deleteById(id);
        return "redirect:/dictionary/list";
    }


    @GetMapping("/{id}")
    public String showAllWordListByDictionaryId(@PathVariable("id") int id, Model model) throws Exception {

        Dictionary dictionary = dictionaryService.getById(id);
        List<Word> wordList = dictionary.getWordList();
        model.addAttribute("wordList", wordList);
        return "showWordsInDictionary";


    }



}
