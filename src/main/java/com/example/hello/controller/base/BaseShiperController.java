package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseShiperController {

    @RequestMapping(value = "/shiper")
    public String getAll() {
        return "shiper-info";
    }

    @RequestMapping(value = "/shiper/details/{i}")
    public String detailShiper() {
        return "shiper-details";
    }

    @RequestMapping(value = "/shiper/do-create")
    public String doCreateShiper() {
        return "redirect:/shiper";
    }

    @RequestMapping(value = "/shiper/create")
    public String createShiper() {
        return "shiper-create";
    }

    @RequestMapping(value = "/shiper/update/{id}")
    public String updateShiper() {
        return "shiper-update";
    }

    @RequestMapping(value = "/shiper/do-update/{id}")
    public String doUpdateShiper() {
        return "redirect:/shiper";
    }

    @RequestMapping(value = "/shiper/delete/{id}")
    public String deleteShiper() {
        return "redirect:/shiper";
    }
}
