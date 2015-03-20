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
    * Spectacle ------------------------- Représentation
    *           spectacle        &gt;       représentation
    * </pre>
    */
   private Set<Représentation> représentation;
   
   public Set<Représentation> getReprésentation() {
      if (this.représentation == null) {
         this.représentation = new HashSet<Représentation>();
      }
      return this.représentation;
   }
   
   }
