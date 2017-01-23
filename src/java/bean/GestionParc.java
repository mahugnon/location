/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Parc;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import metier.ImetierImpl;

/**
 *
 * @author TECHNOPC
 */
@ManagedBean
@SessionScoped
public class GestionParc {
    private Parc parc;
    private metier.Imetier metier;
    private List<Parc> parcs;
    private Parc selectedParc;

    /**
     * Creates a new instance of GestionParc
     */
    public GestionParc() {
        metier=new ImetierImpl();
        parc=new Parc();
        parcs=metier.listerParc();
    }
    
    public String ajouterParc(){
        metier.ajouterParc(parc);
        parc=new Parc();
      return "parcs?faces-redirect=true"; 
    }
    public String vider(){
        parc.setNumParc("");
        parc.setCategorieVoiture("");
        return "parcs?faces-redirect=true";
    }
    
     public String modifierParc(){
        metier.modifierParc(parc);
       
      return "parcs?faces-redirect=true"; 
    }
    
    public String supprimer(Parc p) {
        metier.supprimerParc(p);
        return "parcs?faces-redirect=true";

    }
    
    public String recupererParc(Parc p) {
        this.parc = p;
        return "editerParc?faces-redirect=true";

    }

    public Parc getParc() {
        return parc;
    }

    public void setParc(Parc parc) {
        this.parc = parc;
    }

    public List<Parc> getParcs() {
        parcs = metier.listerParc();
        return parcs;
    }

    public void setParcs(List<Parc> parcs) {
        this.parcs = parcs;
    }

    public Parc getSelectedParc() {
        return selectedParc;
    }

    public void setSelectedParc(Parc selectedParc) {
        this.selectedParc = selectedParc;
    }

}
