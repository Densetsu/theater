
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
    * Horaire ------------------------- Représentation
    *           horaire        &gt;       représentation
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
