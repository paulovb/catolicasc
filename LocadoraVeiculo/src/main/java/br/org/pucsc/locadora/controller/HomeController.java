package br.org.pucsc.locadora.controller;

import br.org.pucsc.locadora.dao.CarroDao;
import br.org.pucsc.locadora.dao.CategoriaDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HomeController {
    
    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
}
