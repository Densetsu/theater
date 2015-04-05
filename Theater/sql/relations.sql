BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE billet';
EXCEPTION
   WHEN OTHERS
   THEN
      IF SQLCODE != -942
      THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE representation';
EXCEPTION
   WHEN OTHERS
   THEN
      IF SQLCODE != -942
      THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE place';
EXCEPTION
   WHEN OTHERS
   THEN
      IF SQLCODE != -942
      THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE zone';
EXCEPTION
   WHEN OTHERS
   THEN
      IF SQLCODE != -942
      THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE categorie';
EXCEPTION
   WHEN OTHERS
   THEN
      IF SQLCODE != -942
      THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE spectacle';
EXCEPTION
   WHEN OTHERS
   THEN
      IF SQLCODE != -942
      THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE dossier';
EXCEPTION
   WHEN OTHERS
   THEN
      IF SQLCODE != -942
      THEN
         RAISE;
      END IF;
END;

CREATE TABLE categorie
(
   nomCategorie   VARCHAR (20) NOT NULL,
   tarif          NUMBER (5, 2) NOT NULL,
   CONSTRAINT categorie_pk PRIMARY KEY (nomCategorie)
);

CREATE TABLE zone
(
   nomZone        VARCHAR (20) NOT NULL,
   nomCategorie   VARCHAR (20) NOT NULL,
   CONSTRAINT zone_pk PRIMARY KEY (nomZone),
   CONSTRAINT fk_categorie FOREIGN KEY (nomCategorie)
       REFERENCES categorie (nomCategorie)
);

CREATE TABLE place
(
   numeroRang   INTEGER NOT NULL,
   ordrePlace   INTEGER NOT NULL,
   nomZone      VARCHAR (20) NOT NULL,
   CONSTRAINT place_pk PRIMARY KEY (numeroRang, ordrePlace),
   CONSTRAINT fk_zone FOREIGN KEY (nomZone) REFERENCES zone (nomZone)
);

CREATE TABLE spectacle
(
   numeroSpectacle   INTEGER NOT NULL,
   nomSpectacle      VARCHAR (50) NOT NULL,
   CONSTRAINT spectacle_pk PRIMARY KEY (numeroSpectacle),
   CONSTRAINT spectacle_c1 CHECK (numeroSpectacle > 0)
);



CREATE TABLE representation
(
   numeroSpectacle      INTEGER NOT NULL,
   dateRepresentation   DATE NOT NULL,
   CONSTRAINT representation_pk PRIMARY KEY
      (numeroSpectacle, dateRepresentation),
   CONSTRAINT fk_spectacle FOREIGN KEY (numeroSpectacle)
       REFERENCES spectacle (numeroSpectacle)
);

CREATE TABLE dossier
(
   numDossier     INTEGER NOT NULL,
   numTicket      INTEGER UNIQUE NOT NULL,
   dateAchat      DATE NOT NULL,
   montantAchat   NUMBER (6, 2),
   CONSTRAINT dossier_pk PRIMARY KEY (numDossier)
);



CREATE TABLE billet
(
   numeroRang           INTEGER NOT NULL,
   ordrePlace           INTEGER NOT NULL,
   numeroSpectacle      INTEGER NOT NULL,
   dateRepresentation   DATE NOT NULL,
   numDossier           INTEGER NOT NULL,
   CONSTRAINT billet_pk PRIMARY KEY
      (numeroRang,
       ordrePlace,
       numeroSpectacle,
       dateRepresentation),
   CONSTRAINT fk_place FOREIGN KEY (numeroRang, ordrePlace)
       REFERENCES place (numeroRang, ordrePlace),
   CONSTRAINT fk_representation FOREIGN KEY
      (numeroSpectacle, dateRepresentation)
       REFERENCES representation (numeroSpectacle, dateRepresentation),
   CONSTRAINT fk_dossier FOREIGN KEY (numDossier)
       REFERENCES dossier (numDossier)
);