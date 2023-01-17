package com.example.dictionary.controller;


import com.example.dictionary.entity.Dictionary;
import com.example.dictionary.entity.Word;
import com.example.dictionary.service.DictionaryService;
import com.example.dictionary.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @Autowired
    private DictionaryService dictionaryService;


    @GetMapping("/")
    public String getWord(@RequestParam("original") String original, Model model) throws Exception {
        Word word = wordService.getByOriginal(original);
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        model.addAttribute("word", word);
        model.addAttribute("wordList", wordList);
        return "showWord";
    }


    @GetMapping("/add")
    public String addWord(){
        return "addWordForm";
    }


    @PostMapping("/add")
    public String addWord(@RequestParam("original") String original,
                                @RequestParam("translation") String translation, @RequestParam("id") int dictionaryId) throws Exception {
        Dictionary dictionary = dictionaryService.getById(dictionaryId);


        wordService.save(new Word(original, translation, dictionary));
        return "redirect:/dictionary/" + dictionaryId;
    }




    @PostMapping("/delete/{id}")
    public String deleteWord(@PathVariable("id") int id){
        wordService.deleteById(id);
        return "redirect:/dictionary/list";
    }
}
