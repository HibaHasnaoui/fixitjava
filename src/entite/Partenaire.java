/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author bazinfo
 */
public class Partenaire {
    private int id;
    private String nom;
    private String adresse;
    private String description;
    private String image;

    public Partenaire() {
    }

    public Partenaire(int id, String nom, String adresse, String description, String image) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.image = image;
    }
     public Partenaire(int id){
            this.id = id;
         
         
     }
    
    

    public Partenaire(String nom, String adresse, String description, String image ,int id) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.image = image;
        this.id=id;
    }
       public Partenaire(String nom, String adresse, String description, String image ) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.image = image;
       
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Partenaire{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", description=" + description + ", image=" + image + '}';
    }

    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
