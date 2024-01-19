package com.example.talk.service;

import com.example.talk.model.Message;
import com.example.talk.model.dto.MessageDto;
import com.example.talk.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final MessageRepository messageRepository;

    public List<MessageDto> findAll() {
        List<MessageDto> result = new ArrayList<>();
        List<Message> list = messageRepository.findAll();
        for (Message message : list) {
            MessageDto messageDto = new MessageDto();
            messageDto.setContent(message.getContent());
            result.add(messageDto);
        }
        return result;
    }

    public void save(MessageDto messageDto) {
        Message message = new Message();
        message.setContent(messageDto.getContent());
        this.messageRepository.save(message);
    }

}
