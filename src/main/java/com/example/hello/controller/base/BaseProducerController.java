package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseProducerController {

    @RequestMapping(value = "/producer")
    public String getAll() {
        return "producer-info";
    }

    @RequestMapping(value = "/producer/details/{i}")
    public String detailProducer() {
        return "producer-details";
    }

    @RequestMapping(value = "/producer/create")
    public String createProducer() {
        return "producer-create";
    }

    @RequestMapping(value = "/producer/do-create")
    public String doCreateProducer() {
        return "redirect:/producer";
    }

    @RequestMapping(value = "/producer/update/{id}")
    public String updateProducer() {
        return "producer-update";
    }

    @RequestMapping(value = "/producer/do-update/{id}")
    public String doUpdateProducer() {
        return "redirect:/producer";
    }

    @RequestMapping(value = "/producer/delete/{id}")
    public String deleteProducer() {
        return "redirect:/producer";
    }
}
