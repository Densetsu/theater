import java.util.Set;
import java.util.HashSet;

public class Place {
   private Integer numRang;
   
   public void setNumRang(Integer value) {
      this.numRang = value;
   }
   
   public Integer getNumRang() {
      return this.numRang;
   }
   
   private Integer ordrePlace;
   
   public void setOrdrePlace(Integer value) {
      this.ordrePlace = value;
   }
   
   public Integer getOrdrePlace() {
      return this.ordrePlace;
   }
   
   /**
    * <pre>
    *           0..*     1..1
    * Place ------------------------- Zone
    *           place        &lt;       zone
    * </pre>
    */
   private Zone zone;
   
   public void setZone(Zone value) {
      this.zone = value;
   }
   
   public Zone getZone() {
      return this.zone;
   }
   
   /**
    * <pre>
    *           1..1     0..*
    * Place ------------------------- Billet
    *           place        &gt;       billet
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
