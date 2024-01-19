package com.example.talk.controller;

import com.example.talk.model.dto.AccountDto;
import com.example.talk.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String register(AccountDto accountDto, Model model) {
        if (!this.signUpService.regist(accountDto)) {
            model.addAttribute("message", "생성오류가 발생하였습니다. 관리자에게 문의 바랍니다.");
            model.addAttribute("replaceUrl", "/");

            return "alert";
        }

        return "redirect:/";
    }
}
