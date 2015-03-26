import java.util.Date;
import java.util.Set;
import java.util.HashSet;

public class Vente {
   private Integer numDossier;
   
   public void setNumDossier(Integer value) {
      this.numDossier = value;
   }
   
   public Integer getNumDossier() {
      return this.numDossier;
   }
   
   private Integer numTicket;
   
   public void setNumTicket(Integer value) {
      this.numTicket = value;
   }
   
   public Integer getNumTicket() {
      return this.numTicket;
   }
   
   private Date date;
   
   public void setDate(Date value) {
      this.date = value;
   }
   
   public Date getDate() {
      return this.date;
   }
   
   private float prixTotal;
   
   public void setPrixTotal(float value) {
      this.prixTotal = value;
   }
   
   public float getPrixTotal() {
      return this.prixTotal;
   }
   
   /**
    * <pre>
    *           1..1     0..*
    * Vente ------------------------- Billet
    *           vente        &gt;       billet
    * </pre>
    */
   private Set<Billet> billet;
   
   public Set<Billet> getBillet() {
      if (this.billet == null) {
         this.billet = new HashSet<Billet>();
      }
      return this.billet;
   }
   
   }
