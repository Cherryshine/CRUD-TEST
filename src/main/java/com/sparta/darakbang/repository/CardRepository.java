package com.sparta.darakbang.repository;

import com.sparta.darakbang.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> { // Card 라는 db 테이블과 연결하는 역할

}
