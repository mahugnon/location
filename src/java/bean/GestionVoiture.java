/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Image;
import dao.Parc;
import dao.Voiture;
import image.FileUploadController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import metier.ImetierImpl;

/**
 *
 * @author TECHNOPC
 */
@ManagedBean
@SessionScoped
public class GestionVoiture {

    private Voiture voiture;
    private final metier.Imetier metier;
    private List<Voiture> voitures;
    private Voiture selectedVoiture;
    private Image photo;
    private String numPac="";
    private final String[] marque;
    private Integer idvoiture=null;
    private FileUploadController uploader;
   
    private List<String> marques = new ArrayList<>();
    private List<Parc> parcs;
    private Parc parc=new Parc();
    /**
     * Creates a new instance of GestionVoiture
     */
    @ManagedProperty("#{parcService}")
    private ParcService service;
    
    
    public GestionVoiture() {
        this.marque = new String[]{"Chevrolet", "Citroën", "Datsun", "Dodge", "Fiat", "Ford", "Holden",
            "Honda", "Hyundai", "Kia", "Lancia", "Mazda", "Mitsubishi",
            "Nissan", "Opel", "Peugeot", "Renault", "Seat", "Škoda", "Subaru", "Toyota", "Vauxhall", "Volkswagen"
        };
        metier = new ImetierImpl();
        parcs=metier.listerParc();
        voitures = metier.listerVoiture();
        voiture = new Voiture();
        marque();
    }

    private void marque() {
        marques.addAll(Arrays.asList(marque));
    }

    public String ajouterVoiture() {
        for (Iterator<Parc> iterator = parcs.iterator(); iterator.hasNext();) {
            Parc next = iterator.next();
            if(next.getNumParc().equals(numPac)){
                 voiture.setParc(next);
            }
               
        }
      idvoiture=metier.ajouterVoiture(voiture);
        voiture=new Voiture();
        return "imagevoiture?faces-redirect=true";
    }
    public String ajoutImage(){
        uploader=new FileUploadController(voiture,numPac);
        return "imagevoiture?faces-redirect=true";
    }

    public String recupererVoiture(Voiture v) {
        this.voiture = v;
        return "editerVoiture?faces-redirect=true";
    }
      public void recupererVtl(Voiture v) {
        this.voiture = v;
        
    }

    public String vider() {
        voiture = new Voiture();
        return "voitures?faces-redirect=true";
    }

    public String modifierVoiture() {
        metier.modifierVoiture(voiture);
        return "voitures?faces-redirect=true";
    }

    public String supprimer(Voiture v) {
        metier.supprimerVoiture(v);
        return "voitures?faces-redirect=true";
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public List<Voiture> getVoitures() {
        voitures=metier.listerVoiture();
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public Voiture getSelectedVoiture() {
        return selectedVoiture;
    }

    public void setSelectedVoiture(Voiture selectedVoiture) {
        this.selectedVoiture = selectedVoiture;
    }

    public List<String> getMarques() {
        return marques;
    }

    public void setMarques(List<String> marques) {
        this.marques = marques;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public List<Parc> getParcs() {
        return parcs;
    }

    public void setParcs(List<Parc> parcs) {
        this.parcs = parcs;
    }

    public Parc getParc() {
        return parc;
    }

    public void setParc(Parc parc) {
        this.parc = parc;
    }

    public ParcService getService() {
        return service;
    }

    public void setService(ParcService service) {
        this.service = service;
    }

    public String getNumPac() {
        return numPac;
    }

    public void setNumPac(String numPac) {
        this.numPac = numPac;
    }

    public FileUploadController getUploader() {
        return uploader;
    }

    public void setUploader(FileUploadController uploader) {
        this.uploader = uploader;
    }
    
    
}
