
public class Horaire {
   private DateTime date;
   
   public void setDate(DateTime value) {
      this.date = value;
   }
   
   public DateTime getDate() {
      return this.date;
   }
   
   /**
    * <pre>
    *           1..1     0..1
    * Horaire ------------------------- Repr�sentation
    *           horaire        &gt;       repr�sentation
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