/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.controller;

import br.org.pucsc.locadora.dao.PrecoLocacaoDao;
import br.org.pucsc.locadora.dao.CategoriaDao;
import br.org.pucsc.locadora.model.Categoria;
import br.org.pucsc.locadora.model.PrecoLocacao;
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
@RequestMapping(value = "/precolocacao")
public class PrecoLocacaoController {

    private final PrecoLocacaoDao precolocacaoDao = new PrecoLocacaoDao();
    private final CategoriaDao categoriaDao = new CategoriaDao();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getView(ModelMap model) {
    
        model.addAttribute("categorias", populateCategorias());
        model.addAttribute("tpKilometros", populateKilometros());

        return "precolocacao";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    br.org.pucsc.locadora.model.PrecoLocacao getReadById(@PathVariable Integer id, ModelMap model) throws Exception {

        br.org.pucsc.locadora.model.PrecoLocacao precolocacao = precolocacaoDao.findById(id);
        return precolocacao;
    }

    @RequestMapping(value = "/read/{name}", method = RequestMethod.GET)
    public @ResponseBody
    List getReadByName(@PathVariable String name, ModelMap model) throws Exception {

        List<br.org.pucsc.locadora.model.PrecoLocacao> precolocacaos = precolocacaoDao.findByDescription(name);
        return precolocacaos;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public @ResponseBody
    List<br.org.pucsc.locadora.model.PrecoLocacao> getRead() throws Exception {

        List<br.org.pucsc.locadora.model.PrecoLocacao> precolocacaos = precolocacaoDao.findAll();
        return precolocacaos;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.PrecoLocacao update(@RequestBody br.org.pucsc.locadora.model.PrecoLocacao precolocacao) throws Exception {

        precolocacaoDao.update(precolocacao);

        return precolocacao;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.PrecoLocacao create(@RequestBody br.org.pucsc.locadora.model.PrecoLocacao precolocacao) throws Exception {

        precolocacaoDao.insert(precolocacao);

        return precolocacao;
    }
 
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.PrecoLocacao destroy(@RequestBody br.org.pucsc.locadora.model.PrecoLocacao precolocacao) throws Exception {

        precolocacaoDao.delete(precolocacao);

        return precolocacao;
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
            Logger.getLogger(PrecoLocacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    } 
    
    @SuppressWarnings("serial")
    private List<?> populateKilometros() {
        try {
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();            
            
            result.add(new HashMap<String, Object>() {{
                  put("value", PrecoLocacao.TP_KM_LIVRE);
                  put("text", "Livre");
                }});
            result.add(new HashMap<String, Object>() {{
                  put("value", PrecoLocacao.TP_KM_PERCORRIDO);
                  put("text", "Percorrido");
                }});
            return result;
        } catch (Exception ex) {
            Logger.getLogger(PrecoLocacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    } 

}