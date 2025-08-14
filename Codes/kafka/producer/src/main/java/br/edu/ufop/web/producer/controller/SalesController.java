package br.edu.ufop.web.producer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.producer.service.MessageProducer;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    
    @Autowired
    private MessageProducer messageProducer;
    
    @PostMapping("/notify")
    public String notifyUser(@RequestBody
    String message) {
        messageProducer.sendMessage("sales", message);
        return "Message from producer: " + message;
    }
    
    @GetMapping("/notify/group")
    public List<String> notifiyGroup(@RequestParam(
            name = "id", required = false, defaultValue = "1") String id) {

        int n = Integer.parseInt(id);
        List<String> messageList = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            String message = "Message from group - ID: " + i;
            messageList.add(message);
            messageProducer.sendMessage("sales", message);
        }

        return messageList;

    }

}
