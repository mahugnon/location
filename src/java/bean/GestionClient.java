/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Client;
import dao.TcPays;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import metier.ImetierImpl;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author TECHNOPC
 */
@ManagedBean
@SessionScoped
public class GestionClient {

    /**
     * Creates a new instance of GestionClient
     */
    private final ImetierImpl metier;
    private List<TcPays> nationalites;
    private Client client;
    private List<Client> clients;
        private List<Client> filtreclients;
    private Client selectedClient;
    public GestionClient() {
        client=new Client();
        metier=new ImetierImpl();
        nationalites=metier.listerPays();
        clients=metier.listerClient();
        
    }
    
    public Client getClient() {
        return client;
    }
    
    public String ajouterClient(){
        metier.ajouterClient(client);
        client=new Client();
        return "index?faces-redirect=true";
    }
    public String vider(){
        this.client.setAdresseCl("");
        this.client.setAdresseMailCl("");
        this.client.setCinCl("");
        this.client.setDateNaissanceCl(null);
        this.client.setFideliteCl("");
        this.client.setNationnaliteCl("");
        this.client.setNomCl("");
        this.client.setNumPermi("");
        this.client.setNumTelCl(0);
        this.client.setPrenomCl("");
        return "index?faces-redirect=true";
    }
    
    public void onRowSelect(SelectEvent event){
        FacesMessage msg=new FacesMessage("Clent sélectionné",
                ((Client)(event.getObject())).getNomCl()+"\t"+((Client)(event.getObject())).getPrenomCl());
        FacesContext.getCurrentInstance().addMessage("a", msg);
    }
    
     public void onRowUnselect(SelectEvent event){
        FacesMessage msg=new FacesMessage("Clent désélectionné",
                ((Client)(event.getObject())).getNomCl()+"\t"+((Client)(event.getObject())).getPrenomCl());
        FacesContext.getCurrentInstance().addMessage("a", msg);
    }
     
   public String recupererClient(Client cl){
       this.client=cl;
       return "editerClient?faces-redirect=true";
   }
   public String editer(){
       metier.modifierClient(client);
       return"index?faces-redirect=true";
   }  
   
     public void supprimer(Client client){
         metier.supprimerClient(client);
     }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<TcPays> getNationalites() {
        return nationalites;
    }

    public void setNationalites(List<TcPays> nationalites) {
        this.nationalites = nationalites;
    }

    public List<Client> getClients() {
       clients= metier.listerClient();
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }
    
    public List<Client> getFiltreclients() {
        return filtreclients;
    }

    public void setFiltreclients(List<Client> filtreclients) {
        this.filtreclients = filtreclients;
    }
    
    
}
