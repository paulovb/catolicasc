/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.controller;

import br.org.pucsc.locadora.dao.CategoriaDao;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {
    
    private final CategoriaDao categoriaDao = new CategoriaDao();
        
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getView(ModelMap model) {
        return "categoria";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    br.org.pucsc.locadora.model.Categoria getReadById(@PathVariable Integer id, ModelMap model) throws Exception {

        br.org.pucsc.locadora.model.Categoria categoria = categoriaDao.findById(id);
        return categoria;
    }

    @RequestMapping(value = "/read/{name}", method = RequestMethod.GET)
    public @ResponseBody
    List getReadByName(@PathVariable String name, ModelMap model) throws Exception {

        List<br.org.pucsc.locadora.model.Categoria> categorias = categoriaDao.findByNome(name);
        return categorias;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public @ResponseBody
    List<br.org.pucsc.locadora.model.Categoria> getRead() throws Exception {

        List<br.org.pucsc.locadora.model.Categoria> categorias = categoriaDao.findAll();
        return categorias;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Categoria update(@RequestBody br.org.pucsc.locadora.model.Categoria categoria) throws Exception {

        categoriaDao.update(categoria);

        return categoria;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Categoria create(@RequestBody br.org.pucsc.locadora.model.Categoria categoria) throws Exception {

        categoriaDao.insert(categoria);

        return categoria;
    }
 
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Categoria destroy(@RequestBody br.org.pucsc.locadora.model.Categoria categoria) throws Exception {

        categoriaDao.delete(categoria);

        return categoria;
    }

}