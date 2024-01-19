package com.example.talk.controller;

import com.example.talk.model.dto.AccountDto;
import com.example.talk.model.dto.MessageDto;
import com.example.talk.service.AccountService;
import com.example.talk.service.ChatService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AccountService accountService;
    private final ChatService chatService;

    @GetMapping("/main")
    public String home(HttpSession session, Model model) {

        //1 session.get Email
        //2 get all List
        //3 show all list
        List<AccountDto> accountDtoList = this.accountService.getAllList(session.getAttribute("email").toString());
        model.addAttribute("accountDtoList", accountDtoList);

        model.addAttribute("messages", chatService.findAll());

        return "main";
    }

    @PostMapping("/send")
    public String sendMessage(String content) {
        MessageDto message = new MessageDto();
        message.setContent(content);
        chatService.save(message);
        return "redirect:/main";
    }

}
