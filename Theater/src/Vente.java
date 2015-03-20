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
   
   private DateTime date;
   
   public void setDate(DateTime value) {
      this.date = value;
   }
   
   public DateTime getDate() {
      return this.date;
   }
   
   private Real prixTotal;
   
   public void setPrixTotal(Real value) {
      this.prixTotal = value;
   }
   
   public Real getPrixTotal() {
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
