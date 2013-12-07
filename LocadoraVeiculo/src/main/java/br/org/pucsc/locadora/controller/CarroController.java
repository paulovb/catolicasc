/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.controller;

import br.org.pucsc.locadora.dao.CarroDao;
import br.org.pucsc.locadora.dao.CategoriaDao;
import br.org.pucsc.locadora.model.Categoria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/carro")
public class CarroController {

    private final CarroDao carroDao = new CarroDao();
    private final CategoriaDao categoriaDao = new CategoriaDao();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getView(ModelMap model) {
    
        model.addAttribute("categorias", populateCategorias());

        return "carro";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    br.org.pucsc.locadora.model.Carro getReadById(@PathVariable Integer id, ModelMap model) throws Exception {

        br.org.pucsc.locadora.model.Carro carro = carroDao.findById(Long.valueOf(id.toString()));
        return carro;
    }

    @RequestMapping(value = "/read/{name}", method = RequestMethod.GET)
    public @ResponseBody
    List getReadByName(@PathVariable String name, ModelMap model) throws Exception {

        List<br.org.pucsc.locadora.model.Carro> carros = carroDao.findByDescription(name);
        return carros;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public @ResponseBody
    List<br.org.pucsc.locadora.model.Carro> getRead() throws Exception {

        List<br.org.pucsc.locadora.model.Carro> carros = carroDao.findAll();
        return carros;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Carro update(@RequestBody br.org.pucsc.locadora.model.Carro carro) throws Exception {

        carroDao.update(carro);

        return carro;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Carro create(@RequestBody br.org.pucsc.locadora.model.Carro carro) throws Exception {

        carroDao.insert(carro);

        return carro;
    }
 
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Carro destroy(@RequestBody br.org.pucsc.locadora.model.Carro carro) throws Exception {

        carroDao.delete(carro);

        return carro;
    }
    
    
    
    @SuppressWarnings("serial")
    private List<?> populateCategorias() {
        try {
            List<Categoria> categorias = categoriaDao.findAll();
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();            
            
            for (final Categoria o : categorias) {
                result.add(new HashMap<String, Object>() {{
                  put("value", o.getId());
                  put("text", o.getNome());
                }});
            }
            return result;
        } catch (Exception ex) {
            Logger.getLogger(CarroController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    } 

}