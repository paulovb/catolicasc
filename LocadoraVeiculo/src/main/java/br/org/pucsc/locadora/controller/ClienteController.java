/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.controller;

import br.org.pucsc.locadora.dao.ClienteDao;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

    private final ClienteDao clienteDao = new ClienteDao();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getView(ModelMap model) {
        return "cliente";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    br.org.pucsc.locadora.model.Cliente getReadById(@PathVariable Integer id, ModelMap model) throws Exception {

        br.org.pucsc.locadora.model.Cliente cliente = clienteDao.findById(id);
        return cliente;
    }

    @RequestMapping(value = "/read/{name}", method = RequestMethod.GET)
    public @ResponseBody
    List getReadByName(@PathVariable String name, ModelMap model) throws Exception {

        List<br.org.pucsc.locadora.model.Cliente> clientes = clienteDao.findByDescription(name);
        return clientes;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public @ResponseBody
    List<br.org.pucsc.locadora.model.Cliente> getRead() throws Exception {

        List<br.org.pucsc.locadora.model.Cliente> clientes = clienteDao.findAll();
        return clientes;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Cliente update(@RequestBody br.org.pucsc.locadora.model.Cliente cliente) throws Exception {

        clienteDao.update(cliente);

        return cliente;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Cliente create(@RequestBody br.org.pucsc.locadora.model.Cliente cliente) throws Exception {

        clienteDao.insert(cliente);

        return cliente;
    }
 
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Cliente destroy(@RequestBody br.org.pucsc.locadora.model.Cliente cliente) throws Exception {

        clienteDao.delete(cliente);

        return cliente;
    }
    
}