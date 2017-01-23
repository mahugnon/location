/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;


import dao.Voiture;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import metier.ImetierImpl;

import org.primefaces.event.FileUploadEvent;

@ManagedBean(name = "fileUploadController")
public class FileUploadController {

    private String destination = "G:\\tmp\\";
    private JdbcInsertFileOne enregistre=new JdbcInsertFileOne();
    private Integer id=null;
    private Voiture voiture;
    private String numPac;

    public FileUploadController(Voiture voiture,String numPac) {
        this.voiture = voiture;
        this.numPac=numPac;
    }
    
    
    
    public void upload(FileUploadEvent event) {
     
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " l'image à été bien eregistrer");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            System.out.println( event.getFile().getContentType());
            copyFile(event.getFile().getContentType(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }

    public void copyFile(String type, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + voiture.getIdVoiture()));

            int read = 0;
            byte[] bytes = new byte[8192];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
         
            in.close();
            out.flush();
            out.close();
            enregistre.enregistrer(destination + voiture.getIdVoiture(),type,voiture,numPac);
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
