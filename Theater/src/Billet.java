
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
    * Billet ------------------------- Repr�sentation
    *           billet        &gt;       repr�sentation
    * </pre>
    */
   private Repr�sentation repr�sentation;
   
   public void setRepr�sentation(Repr�sentation value) {
      this.repr�sentation = value;
   }
   
   public Repr�sentation getRepr�sentation() {
      return this.repr�sentation;
   }
   
   }
