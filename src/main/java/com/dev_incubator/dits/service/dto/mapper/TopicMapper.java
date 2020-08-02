package com.dev_incubator.dits.service.dto.mapper;

import com.dev_incubator.dits.persistence.entity.Topic;
import com.dev_incubator.dits.service.dto.TopicDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static java.util.Objects.nonNull;

@Component
public class TopicMapper {

    public TopicDto toDto(final Topic topic) {
        TopicDto dto = new TopicDto();
        dto.setId(topic.getId());
        dto.setName(topic.getName());
        dto.setDescription(topic.getDescription());
        return dto;
    }

    public Topic fromDto(final TopicDto dto) {
        Topic topic = new Topic();
        if (nonNull(dto.getId())) {
            topic.setId(dto.getId());
        }
        topic.setName(dto.getName());
        topic.setDescription(dto.getDescription());
//        topic.setTests(new HashMap<Test>());
        return topic;
    }
}
