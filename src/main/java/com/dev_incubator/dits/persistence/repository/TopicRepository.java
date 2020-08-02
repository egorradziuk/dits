package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByName(String name);
    //my part
    @Query("Select name From TestY Where topicY.name = ?1")
    List<String> findTestsByTopicY(String name);
}
