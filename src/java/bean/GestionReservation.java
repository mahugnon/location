/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Client;
import dao.Contrat;
import dao.Facture;
import dao.Reservation;
import dao.Voiture;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import metier.ImetierImpl;

/**
 *
 * @author TECHNOPC
 */
@ManagedBean
@SessionScoped
public class GestionReservation {
    private List<Reservation> reservations;
    private metier.Imetier metier;
    private Reservation reservation;

    /**
     * Creates a new instance of GestionReservation
     */
    public GestionReservation() {
        metier=new ImetierImpl();
        reservations=metier.listerReservation();
        reservation=new Reservation();
    }

    public String afficherClient(Reservation r){
       
      List<Client> cls=metier.listerClient();
      Integer idCl=r.getClient().getId();
      Client cl=null;
        for (Client next : cls) {
            if(Objects.equals(next.getId(), idCl))
                cl=next;
        }
        if(cl!=null){
                 return cl.getCinCl();
   
        }
        return "";
    }
    
     public String afficherVoiture(Reservation r){
      List<Voiture> vts=metier.listerVoiture();
      Integer idVt=r.getVoiture().getIdVoiture();
      Voiture vt=null;
        for (Voiture next : vts) {
            if(Objects.equals(next.getIdVoiture(), idVt))
                vt=next;
        }
       if(vt!=null)
       {
            return vt.getImmatriculationVoiture();
       }
       return "";
    }
     public void confirmer(Reservation r){
         FacesContext context=FacesContext.getCurrentInstance();
         Client cl = null;Voiture vt = null;
        for (Client next : metier.listerClient()) {
            if(Objects.equals(next.getId(), r.getClient().getId()))
                cl=next;
        }
          for (Voiture next : metier.listerVoiture()) {
            if(Objects.equals(next.getIdVoiture(), r.getVoiture().getIdVoiture()))
                vt=next;
        }
        
         Contrat ctr=new Contrat(cl, vt, 1, new Date(), daysBetween(r.getDateDebutReserv(),r.getDateFinReserv()));
         r.setEtatReserve("Confirmer");
         metier.modifierReservation(r);
         metier.ajouterContrat(ctr);
         FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO, "succes!!", "résevation bien confirmée");
         context.addMessage(null, message);
     }
     //nbrs jours
     public  int daysBetween(Date d1, Date d2){
         long dt1=d1.getTime();
         long dt2=d2.getTime();
         int nbrj=(int) ((dt2-dt1)/86400000);
         return nbrj;
    }
     
    public List<Reservation> getReservations() {
        reservations=metier.listerReservation();
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
}
