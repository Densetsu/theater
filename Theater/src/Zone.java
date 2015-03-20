import java.util.Set;
import java.util.HashSet;

public class Zone {
   private String nomZone;
   
   public void setNomZone(String value) {
      this.nomZone = value;
   }
   
   public String getNomZone() {
      return this.nomZone;
   }
   
   private Real tarif;
   
   public void setTarif(Real value) {
      this.tarif = value;
   }
   
   public Real getTarif() {
      return this.tarif;
   }
   
   /**
    * <pre>
    *           1..1     0..*
    * Zone ------------------------- Place
    *           zone        &gt;       place
    * </pre>
    */
   private Set<Place> place;
   
   public Set<Place> getPlace() {
      if (this.place == null) {
         this.place = new HashSet<Place>();
      }
      return this.place;
   }
   
   }
