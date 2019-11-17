package pl.akademia.bmiclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademia.bmiclone.model.BMI;
import pl.akademia.bmiclone.model.BMIAtributes;

@Controller
public class BMIController {

    @GetMapping("/")
    public String getHome(ModelMap modelMap){
        modelMap.put("calc",true);
        return "home";
    }
    @PostMapping("/")
    public String postHome(@ModelAttribute BMIAtributes data, ModelMap modelMap){
        modelMap.put("calc",false);
        modelMap.put("BMI", new BMI(data));
        return "home";
    }
}
