/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.Client;
import dao.Contrat;
import dao.Facture;

import dao.Parc;
import dao.Reservation;
import dao.TcPays;
import dao.Voiture;
import java.util.List;

/**
 *
 * @author TECHNOPC
 */
public interface Imetier {
    //gestion de client
    public void ajouterClient(Client cl);
    public Client clientParId(Integer Id);
    public void modifierClient(Client cl);
    public void supprimerClient(Client cl);
    public List<Client> listerClient();
    public List<TcPays> listerPays();
    //gestion de vehicul
    public Integer ajouterVoiture(Voiture v);
    public void modifierVoiture(Voiture v);
    public void supprimerVoiture(Voiture v);
    public List<Voiture> listerVoiture();
    public Voiture voitureParId(Integer id);
    public List<Voiture> voitureParMotCle(String modele, String marque, String Categ, String carb);
    //gestion de parc
    public void ajouterParc(Parc parc);
    public List<Parc> listerParc();
    public void supprimerParc(Parc p);
    public void modifierParc(Parc p);
  
    //gestion reservation
    public void ajouterReservation(Reservation r);
    public void modifierReservation(Reservation r);
    public List<Reservation> listerReservation();
    public void supprimerReservation(Reservation r);
    //gestion de contrat
    public void ajouterContrat(Contrat c);
    //gestion de facture 
    public void ajouterFacture(Facture f);
}
