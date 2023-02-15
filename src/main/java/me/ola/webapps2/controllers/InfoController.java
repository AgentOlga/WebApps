package me.ola.webapps2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/")
    public String index () {
        return "«Приложение запущено»";
    }
    @GetMapping("/info")
    public String info () {
        return "имя ученика : OLga Philippova </br> " + "название проекта : WebApp2 </br>" + "дата создания проекта : 14.03.2023 </br>"+ "описание проекта : Приложение, хранящее в себе рецепты ";
    }


}
