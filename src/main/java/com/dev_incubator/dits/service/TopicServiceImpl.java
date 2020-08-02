package com.dev_incubator.dits.service;

import com.dev_incubator.dits.exception.TopicNotFoundException;
import com.dev_incubator.dits.persistence.entity.Topic;
import com.dev_incubator.dits.persistence.repository.TopicRepository;
import com.dev_incubator.dits.service.dto.TopicDto;
import com.dev_incubator.dits.service.dto.mapper.TopicMapper;
import com.dev_incubator.dits.service.interfaces.TopicService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@Transactional
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    private final TopicMapper topicMapper;

    @Override
    public List<TopicDto> getAllTopics() {
        return topicRepository.findAll().stream().map(topicMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TopicDto getTopicById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("topic.not.found"));
        return topicMapper.toDto(topic);
    }

    @Override
    public void deleteTopicById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("topic.not.found"));
        topicRepository.delete(topic);
    }

    @Override
    public boolean saveTopic(TopicDto topicDto) {
        Topic topicFromDb = topicRepository.findByName(topicDto.getName());
        //edit topic
        if (nonNull(topicDto.getId())) {
            if (nonNull(topicFromDb) && !topicFromDb.getId().equals(topicDto.getId())) {
                return false;
            }
            topicRepository.save(topicMapper.fromDto(topicDto));
            return true;
        }
        //create topic
        if (nonNull(topicFromDb)) {
            return false;
        }
        topicRepository.save(topicMapper.fromDto(topicDto));
        return true;
    }

    //my part
    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public List<String> findTestsByTopic(String name) {
        return topicRepository.findTestsByTopicY(name);
    }


}
