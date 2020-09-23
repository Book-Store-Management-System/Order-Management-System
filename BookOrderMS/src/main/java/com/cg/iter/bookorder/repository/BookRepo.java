package com.cg.iter.bookorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.bookorder.dto.BookEntity;


@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer>{

}
