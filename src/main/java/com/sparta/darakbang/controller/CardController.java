package com.sparta.darakbang.controller;


import com.sparta.darakbang.dto.CardRequestDto;
import com.sparta.darakbang.dto.CardResponseDto;
import com.sparta.darakbang.entity.Card;
import com.sparta.darakbang.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // create
    @PostMapping("/card") // http://localhost:8080/api/card POST
    public Card createCard(@RequestBody CardRequestDto request) {
        // { cardNumber:" 16자리 "}
        return cardService.createCard(request);
    }

    // read
    @GetMapping("/cards")
    public List<CardResponseDto> getCards() {
        return cardService.getCards();
    }

    @GetMapping("/cards/{cardId}")
    public CardResponseDto getCard(@PathVariable Long cardId) {
        return cardService.getCard(cardId);
    }

    // update
    @PutMapping("/cards/{cardId}")
    public CardResponseDto updateCard(@PathVariable Long cardId, @RequestBody CardRequestDto request) {
        cardService.updateCard(cardId, request);
        return cardService.getCard(cardId);
    }

    // delete
    @DeleteMapping("/cards/{cardId}")
    public void delete(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
    }




}
