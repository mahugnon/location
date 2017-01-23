/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.detail;

import dao.Client;
import dao.Reservation;
import dao.Voiture;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import metier.ImetierImpl;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author TECHNOPC
 */
@ManagedBean
@SessionScoped
public class DetailVoiture {

    private static metier.Imetier metier;
    private Voiture voiture;
    private List<Reservation> rsvs;

    /**
     * Creates a new instance of DetailVoiture
     */
    public DetailVoiture() {
       
        metier = new ImetierImpl();
    }

    public String recupererVoiture(Voiture voiture) {
        this.voiture = voiture;
        return "detailvoiture?faces-redirect=true";
    }
    public boolean testEtat() {
        List<Reservation> rs = metier.listerReservation();
        rsvs = new ArrayList<>();
        if (rs != null) {
            for (Iterator<Reservation> iterator = rs.iterator(); iterator.hasNext();) {
                Reservation next = iterator.next();
                if (Objects.equals(next.getVoiture().getIdVoiture(), voiture.getIdVoiture())) {
                    rsvs.add(next);
                }
            }
        }
        if (rsvs.isEmpty()) {
            System.out.println("vide");
            return true;
        }
        return false;
    }

    public StreamedContent getStreamedImage() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Get ID value from actual request param.
            Integer id = voiture.getIdVoiture();
            System.out.println(id);
            byte[] image = metier.voitureParId(id).getImage();
            return new DefaultStreamedContent(new ByteArrayInputStream(image));
        }
    }
    public String clientParId(Integer id){
       return metier.clientParId(id).getNomCl()+" "+metier.clientParId(id).getPrenomCl();
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public List<Reservation> getRsvs() {
        return rsvs;
    }

    public void setRsvs(List<Reservation> rsvs) {
        this.rsvs = rsvs;
    }
    
    
}
