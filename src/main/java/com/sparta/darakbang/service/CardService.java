package com.sparta.darakbang.service;

import com.sparta.darakbang.dto.CardRequestDto;
import com.sparta.darakbang.dto.CardResponseDto;
import com.sparta.darakbang.entity.Card;
import com.sparta.darakbang.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card createCard(CardRequestDto request) {
        Card saveCard = new Card(request);
        cardRepository.save(saveCard);
        return saveCard;
    }

    public CardResponseDto getCard(Long cardId) {
        // DB 조회
        Card card = cardRepository.findById(cardId).orElseThrow();
        CardResponseDto cardResponseDto = new CardResponseDto(card);
        // null 이면 예외를 던진다
        return cardResponseDto;
    }

    public List<CardResponseDto> getCards() {
        // DB 조회
        List<Card> cardList = cardRepository.findAll();
        List<CardResponseDto> cardResponseDtoList = new ArrayList<>();
        for (Card card : cardList) {
            cardResponseDtoList.add(new CardResponseDto(card));
        }
        // null 이면 예외를 던진다
        return cardResponseDtoList;
    }

    //delete
    public void deleteCard(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow();
        cardRepository.delete(card);
    }

    //update
    @Transactional
    public Card updateCard(Long cardId, CardRequestDto request) {
        Card card = cardRepository.findById(cardId).orElseThrow();
        card.update(request);
//        cardRepository.save(card); -> Transactional 사용시 불필요 (엔티티의 변경 감지)
        return card;
    }

}
