import java.util.Date;


public class Horaire {
   private Date date;
   
   public void setDate(Date value) {
      this.date = value;
   }
   
   public Date getDate() {
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
