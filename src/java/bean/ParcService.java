/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Parc;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import metier.ImetierImpl;

/**
 *
 * @author TECHNOPC
 */
@ManagedBean(name="parcService", eager = true)
@ApplicationScoped
public class ParcService {
    metier.Imetier metier=new ImetierImpl();
    private List<Parc> parcs;
    
     @PostConstruct
    public void init() {
        parcs=metier.listerParc();
    }

    public List<Parc> getParcs() {
        return parcs;
    }
    
}
