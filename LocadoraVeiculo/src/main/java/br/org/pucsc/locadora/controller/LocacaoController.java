/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.controller;

import br.org.pucsc.locadora.dao.CarroDao;
import br.org.pucsc.locadora.dao.LocacaoDao;
import br.org.pucsc.locadora.dao.CategoriaDao;
import br.org.pucsc.locadora.dao.ClienteDao;
import br.org.pucsc.locadora.dao.PrecoLocacaoDao;
import br.org.pucsc.locadora.model.Carro;
import br.org.pucsc.locadora.model.Categoria;
import br.org.pucsc.locadora.model.Cliente;
import br.org.pucsc.locadora.model.PrecoLocacao;
import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping(value = "/locacao")
public class LocacaoController {

    private final LocacaoDao locacaoDao = new LocacaoDao();
    private final CarroDao carroDao = new CarroDao();
    private final ClienteDao clienteDao = new ClienteDao();
    private final CategoriaDao categoriaDao = new CategoriaDao();
    private final PrecoLocacaoDao precolocacaoDao = new PrecoLocacaoDao();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getView(ModelMap model) {
    
        model.addAttribute("carros", populateCarros());
        model.addAttribute("clientes", populateClientes());
        
        return "locacao";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    br.org.pucsc.locadora.model.Locacao getReadById(@PathVariable Integer id, ModelMap model) throws Exception {

        br.org.pucsc.locadora.model.Locacao locacao = locacaoDao.findById(id);
        return locacao;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public @ResponseBody
    List<br.org.pucsc.locadora.model.Locacao> getRead() throws Exception {

        List<br.org.pucsc.locadora.model.Locacao> locacoes = locacaoDao.findAll();
        return locacoes;
    }
    
    @RequestMapping(value = "/readNotReturned", method = RequestMethod.GET)
    public @ResponseBody
    List<br.org.pucsc.locadora.model.Locacao> getReadNotReturned() throws Exception {

        List<br.org.pucsc.locadora.model.Locacao> locacoess = locacaoDao.findAllNotReturned();
        return locacoess;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Locacao update(@RequestBody br.org.pucsc.locadora.model.Locacao locacao) throws Exception {

        Long idcategoria = carroDao.findById(locacao.getIdcarro()).getIdcategoria();
        PrecoLocacao precolocacao = (PrecoLocacao) precolocacaoDao.findByCategoria(idcategoria).get(0);
        
        if (precolocacao == null) {
            throw new Exception("Tabela de preços não encontrada!");
        }
        
        locacao.setIdprecolocacao(precolocacao.getId());
        
        locacao.setPreco(precolocacao.getPreco()*locacao.getKm());
        
        locacaoDao.update(locacao);

        return locacao;
    }
    
    @RequestMapping(value = "/updateDevolution", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Locacao updateDevolution(@RequestBody br.org.pucsc.locadora.model.Locacao locacao) throws Exception {
        
        locacao.setDtdevolucao(new Date());
        locacaoDao.update(locacao);

        return locacao;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Locacao create(@RequestBody br.org.pucsc.locadora.model.Locacao locacao) throws Exception {

        Long idcategoria = carroDao.findById(locacao.getIdcarro()).getIdcategoria();
        PrecoLocacao precolocacao = (PrecoLocacao) precolocacaoDao.findByCategoria(idcategoria).get(0);
        
        if (precolocacao == null) {
            throw new Exception("Tabela de preços não encontrada!");
        }
        
        locacao.setDtcreate(new Date());
        locacao.setIdprecolocacao(precolocacao.getId());        
        locacao.setPreco(precolocacao.getPreco()*locacao.getKm());
        
        locacaoDao.insert(locacao);

        return locacao;
    }
 
    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public @ResponseBody
    br.org.pucsc.locadora.model.Locacao destroy(@RequestBody br.org.pucsc.locadora.model.Locacao locacao) throws Exception {

        locacaoDao.delete(locacao);

        return locacao;
    }
        
    @SuppressWarnings("serial")
    private List<?> populateCarros() {
        try {
            List<Carro> carros = carroDao.findAll();
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();            
            
            for (final Carro o : carros) {
                result.add(new HashMap<String, Object>() {{
                  put("value", o.getId());
                  put("text", o.getNome());
                }});
            }
            return result;
        } catch (Exception ex) {
            Logger.getLogger(LocacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
    @SuppressWarnings("serial")
    private List<?> populateClientes() {
        try {
            List<Cliente> clientes = clienteDao.findAll();
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();            
            
            for (final Cliente o : clientes) {
                result.add(new HashMap<String, Object>() {{
                  put("value", o.getId());
                  put("text", o.getNome());
                }});
            }
            return result;
        } catch (Exception ex) {
            Logger.getLogger(LocacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
}