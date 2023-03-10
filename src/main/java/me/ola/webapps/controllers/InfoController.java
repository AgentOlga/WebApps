package me.ola.webapps.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
@GetMapping("/")
    public String index() {
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String info() {
    return "имя ученика: Olga Philippova </br>" +
            "название проекта: WebAppOLa </br>" +
            "дата создания проекта: 12.02.2023 </br>" +
            "описание проекта: приложение для сайта рецептов..";
    }

}
