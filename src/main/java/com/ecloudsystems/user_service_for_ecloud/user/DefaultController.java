package com.ecloudsystems.user_service_for_ecloud.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String redirectToUsers() {
        return "redirect:/users";
    }
}

