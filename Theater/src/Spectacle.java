import java.util.Set;
import java.util.HashSet;

public class Spectacle {
   private Integer numS;
   
   public void setNumS(Integer value) {
      this.numS = value;
   }
   
   public Integer getNumS() {
      return this.numS;
   }
   
   private String nom;
   
   public void setNom(String value) {
      this.nom = value;
   }
   
   public String getNom() {
      return this.nom;
   }
   
   /**
    * <pre>
    *           1..1     0..*
    * Spectacle ------------------------- Repr�sentation
    *           spectacle        &gt;       repr�sentation
    * </pre>
    */
   private Set<Repr�sentation> repr�sentation;
   
   public Set<Repr�sentation> getRepr�sentation() {
      if (this.repr�sentation == null) {
         this.repr�sentation = new HashSet<Repr�sentation>();
      }
      return this.repr�sentation;
   }
   
   }
