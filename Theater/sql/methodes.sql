SELECT * FROM  SPECTACLE;

SELECT NOMSPECTACLE FROM  SPECTACLE WHERE NUMEROSPECTACLE = 101;

SELECT NUMEROSPECTACLE FROM  SPECTACLE WHERE NOMSPECTACLE = 'Metallica';

SELECT NOMSPECTACLE FROM  SPECTACLE WHERE NUMEROSPECTACLE = 101;
SELECT DATEREPRESENTATION FROM REPRESENTATION WHERE NUMEROSPECTACLE = 101;

SELECT S.NUMEROSPECTACLE,DATEREPRESENTATION FROM REPRESENTATION R, SPECTACLE S WHERE S.NUMEROSPECTACLE = R.NUMEROSPECTACLE AND S.NOMSPECTACLE = 'Metallica';

SELECT * FROM  SPECTACLE;
SELECT R.* FROM REPRESENTATION R WHERE R.NUMEROSPECTACLE = '101';
SELECT S.nomSpectacle, R.* FROM Spectacle S, Representation R where S.numeroSpectacle = R.numeroSpectacle ORDER BY nomSpectacle, R.numeroSpectacle NULLS FIRST;

SELECT S.* FROM SPECTACLE S, REPRESENTATION R WHERE S.NUMEROSPECTACLE = R.NUMEROSPECTACLE AND R.DATEREPRESENTATION = '14-JAN-09';


/* METHODE_B :  */
SELECT * FROM ZONE WHERE NOMZONE = 'Zone1';

SELECT * FROM ZONE WHERE NOMCATEGORIE = 'Cat�gorie1';

SELECT P.* FROM ZONE Z, PLACE P WHERE Z.NOMCATEGORIE = 'CATEGORIE1' AND P.NOMZONE = Z.NOMZONE;

SELECT Z.NOMCATEGORIE,P.* FROM ZONE Z, PLACE P WHERE P.NOMZONE = 'ZONE1' AND P.NOMZONE = Z.NOMZONE;

SELECT B.* FROM DOSSIER D, BILLET B WHERE D.NUMDOSSIER = B.NUMDOSSIER AND NUMDOSSIER = '15321561'; /* G�RER LE CAS D'UNE SEULE PLACE ? */

SELECT B.* FROM DOSSIER D, BILLET B WHERE D.NUMDOSSIER = B.NUMDOSSIER AND NUMDOSSIER = '15321561';

SELECT P.* FROM PLACE P, BILLET B WHERE P.NUMERORANG = B.NUMERORANG AND P.ORDREPLACE = B.ORDREPLACE AND B.NUMEROSPECTACLE = '102' AND B.DATEREPRESENTATION = '14-JAN-09';

SELECT P.* FROM PLACE P WHERE (P.NUMERORANG,P.ORDREPLACE) NOT IN (SELECT B.NUMERORANG,B.ORDREPLACE FROM BILLET B WHERE B.NUMEROSPECTACLE = '102' AND B.DATEREPRESENTATION = '14-JAN-09');

/*
INSERT INTO BILLET
+ INSERT INTO DOSSIER

IDEM AVEC PLUSIEURS BILLETS


DELETE BILLET + DELETE DOSSIER

DELETE BILLET(S) + DELETE DOSSIER

*/