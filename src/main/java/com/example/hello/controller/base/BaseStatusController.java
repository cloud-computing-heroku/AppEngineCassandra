package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseStatusController {
    @RequestMapping(value = "/status")
    public String getAll() {
        return "status-info";
    }

    @RequestMapping(value = "/status/details/{i}")
    public String detailStatus() {
        return "status-details";
    }

    @RequestMapping(value = "/status/do-create")
    public String doCreateStatus() {
        return "redirect:/status";
    }

    @RequestMapping(value = "/status/create")
    public String createStatus() {
        return "status-create";
    }

    @RequestMapping(value = "/status/update/{id}")
    public String updateStatus() {
        return "status-update";
    }

    @RequestMapping(value = "/status/do-update/{id}")
    public String doUpdateStatus() {
        return "redirect:/status";
    }

    @RequestMapping(value = "/status/delete/{id}")
    public String deleteStatus() {
        return "redirect:/status";
    }
}
