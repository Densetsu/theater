
public class Billet {
   /**
    * <pre>
    *           0..*     1..1
    * Billet ------------------------- Vente
    *           billet        &lt;       vente
    * </pre>
    */
   private Vente vente;
   
   public void setVente(Vente value) {
      this.vente = value;
   }
   
   public Vente getVente() {
      return this.vente;
   }
   
   /**
    * <pre>
    *           0..*     1..1
    * Billet ------------------------- Place
    *           billet        &lt;       place
    * </pre>
    */
   private Place place;
   
   public void setPlace(Place value) {
      this.place = value;
   }
   
   public Place getPlace() {
      return this.place;
   }
   
   /**
    * <pre>
    *           0..*     1..1
    * Billet ------------------------- Représentation
    *           billet        &gt;       représentation
    * </pre>
    */
   private Représentation représentation;
   
   public void setReprésentation(Représentation value) {
      this.représentation = value;
   }
   
   public Représentation getReprésentation() {
      return this.représentation;
   }
   
   }
