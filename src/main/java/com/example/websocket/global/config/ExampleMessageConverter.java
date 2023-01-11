package com.example.websocket.global.config;

import com.example.websocket.global.model.Example;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

// * Jms에서 MessageConverter를 사용하려면 다음과 같이 직접 어떻게 변환할지 정의해주어야 합니다.
public class ExampleMessageConverter implements MessageConverter {

    @Override
    public Message toMessage(Object object, Session session)
        throws JMSException, MessageConversionException {
            return session.createObjectMessage((Example) object);
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        return message.getBody(Example.class);
    }
}
