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
	numeroSpectacle INTEGER not null,
	nomSpectacle VARCHAR(50) not null,
	CONSTRAINT spectacle_pk PRIMARY KEY (numeroSpectacle)
);



CREATE TABLE representation
(
   numeroSpectacle      INTEGER NOT NULL,
   dateRepresentation   DATE NOT NULL,
   CONSTRAINT representation_pk PRIMARY KEY
      (numeroSpectacle, dateRepresentation),
   CONSTRAINT fk_spectacle FOREIGN KEY (numeroSpectacle)
       REFERENCES zone (numeroSpectacle)
);

CREATE TABLE dossier
(
	numDossier INTEGER not null,
	numTicket INTEGER UNIQUE not null,
	dateAchat DATE not null,
	montantAchat NUMBER(6,2),
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