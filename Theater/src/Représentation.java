import java.util.Set;
import java.util.HashSet;

/**
 * Zone(nomZone,tarif)
 * Place(numRang,ordrePlace,#nomZone)
 * Spectacle(numS,nom)
 * Representation(#numS,date)
 * Vente(numDossier,numTicket,date,prixTotal)
 * Billet(#numRang,#ordrePlace,#numS,#date,#numDossier)
 */
public class Représentation {
   /**
    * <pre>
    *           1..1     0..*
    * Représentation ------------------------- Billet
    *           représentation        &lt;       billet
    * </pre>
    */
   private Set<Billet> billet;
   
   public Set<Billet> getBillet() {
      if (this.billet == null) {
         this.billet = new HashSet<Billet>();
      }
      return this.billet;
   }
   
   /**
    * <pre>
    *           0..*     1..1
    * Représentation ------------------------- Spectacle
    *           représentation        &lt;       spectacle
    * </pre>
    */
   private Spectacle spectacle;
   
   public void setSpectacle(Spectacle value) {
      this.spectacle = value;
   }
   
   public Spectacle getSpectacle() {
      return this.spectacle;
   }
   
   /**
    * <pre>
    *           0..1     1..1
    * Représentation ------------------------- Horaire
    *           représentation        &lt;       horaire
    * </pre>
    */
   private Horaire horaire;
   
   public void setHoraire(Horaire value) {
      this.horaire = value;
   }
   
   public Horaire getHoraire() {
      return this.horaire;
   }
   
   }
