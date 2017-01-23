/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import dao.Parc;
import dao.Voiture;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import metier.ImetierImpl;
import org.apache.commons.io.IOUtils;

public class JdbcInsertFileOne {

    private metier.Imetier metier = new ImetierImpl();
    private Integer idParc;

    public void enregistrer(String path, String type,Voiture voiture,String numPac) {
        
      
        String url = "jdbc:mysql://localhost:3306/loc_voiture_db";
        String user = "root";
        String password = "";

        String filePath = path;
        List<Parc> parcs=metier.listerParc();
        
          for (Iterator<Parc> iterator = parcs.iterator(); iterator.hasNext();) {
            Parc next = iterator.next();
            if(next.getNumParc().equals(numPac))
            {
                idParc=next.getIdPac();
                break;
            }
        }
  
        

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO `voiture` (`immatriculation_voiture`,"
                    + " `marque_voiture`, `modele_voiture`, `categorie_voiture`, `couleur_voiture`, "
                    + "`carburant_voiture`, `boite_vitesse_voiture`, `climatisation_voiture`, "
                    + "`nbr_portes_voiture`, `nbr_places_voiture`, `type_voiture`, `etat_voiture`, "
                    + "`id_pac_voiture`, `annee_mise_service`, `type`,`image`, `prix_par_jour_3jour`,"
                    + " `prix_par_jour_1semaine`)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, voiture.getImmatriculationVoiture());
            statement.setString(2, voiture.getMarqueVoiture());
            statement.setString(3,voiture.getModeleVoiture() );
            statement.setString(4, voiture.getCategorieVoiture());
            statement.setString(5, voiture.getCouleurVoiture());
            statement.setString(6, voiture.getCarburantVoiture());
            statement.setString(7, voiture.getBoiteVitesseVoiture());
            
            statement.setString(8, voiture.getClimatisationVoiture());
            statement.setInt(9, voiture.getNbrPortesVoiture());
            statement.setInt(10, voiture.getNbrPortesVoiture());
            statement.setString(11, voiture.getTypeVoiture());
            statement.setString(12, voiture.getEtatVoiture());
            statement.setInt(13,idParc);
            statement.setString(14,voiture.getAnneeMiseService());
            statement.setString(15,type);
           
            InputStream inputStream = new FileInputStream(new File(filePath));

            statement.setBlob(16, inputStream);
            statement.setString(17, voiture.getPrixParJour3jour());
            statement.setString(18, voiture.getPrixParJour1semaine());

            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
