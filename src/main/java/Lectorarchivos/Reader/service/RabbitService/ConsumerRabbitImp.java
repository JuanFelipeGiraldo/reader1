package Lectorarchivos.Reader.service.RabbitService;

import Lectorarchivos.Reader.model.TestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.QueueInformation;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerRabbitImp implements Consumer {
    private RabbitAdmin rabbitAdmin;
    private ObjectMapper objectMapper;
    private TestResult testResult;
    private int trueAnswer = 0;
    private int falseAnswer = 0;

    @Autowired
    public ConsumerRabbitImp(ObjectMapper objectMapper, TestResult testResult, RabbitAdmin rabbitAdmin) {
        this.objectMapper = objectMapper;
        this.testResult = testResult;
        this.rabbitAdmin = rabbitAdmin;
    }

    @Override
    @RabbitListener(queues = "answers")
    public void recive(String jsoninfo) {

        if(jsoninfo.equals("true")){
            trueAnswer++;
        }
        if (jsoninfo.equals("false")){
            falseAnswer++;
        }
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public int getFalseAnswer() {
        return falseAnswer;
    }

    public void setTrueAnswer(int trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public void setFalseAnswer(int falseAnswer) {
        this.falseAnswer = falseAnswer;
    }

    public boolean isQueueEmpty() {
        QueueInformation queueInfo = rabbitAdmin.getQueueInfo("answers");
        return queueInfo != null && queueInfo.getMessageCount() == 0;
    }
}

