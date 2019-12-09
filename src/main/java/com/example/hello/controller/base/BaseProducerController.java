package com.example.hello.controller.base;

import com.example.hello.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class BaseProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "/producer-info")
    public String getAll(Model model) {
        model.addAttribute("producerList", this.producerService.getAllProducer());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Producer");
        return "producer-info";
    }

    @RequestMapping(value = "/producer-details/{i}")
    public String detailProducer() {
        return "producer-details";
    }

    @RequestMapping(value = "/producer-create")
    public String createProducer() {
        return "producer-create";
    }

    @RequestMapping(value = "/producer-do-create")
    public String doCreateProducer() {
        return "redirect:/admin/producer-info";
    }

    @RequestMapping(value = "/producer-update/{id}")
    public String updateProducer() {
        return "producer-update";
    }

    @RequestMapping(value = "/producer-do-update/{id}")
    public String doUpdateProducer() {
        return "redirect:/admin/producer-info";
    }

    @RequestMapping(value = "/producer-delete/{id}")
    public String deleteProducer() {
        return "redirect:/admin/producer-info";
    }
}
