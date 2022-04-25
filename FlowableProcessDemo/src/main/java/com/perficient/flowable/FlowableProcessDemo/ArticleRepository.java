package com.perficient.flowable.FlowableProcessDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	//Article findByAuthor(String username);
}
