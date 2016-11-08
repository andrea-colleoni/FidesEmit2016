/* Query 1 */

SELECT titolo
FROM libro
WHERE anno_pubblicazione < 1950;

/* Query 2 */

SELECT *
FROM autore
WHERE NAZIONALITA = 'Italia';

/* Query 3 */

SELECT *
FROM libro
WHERE CASA_EDITRICE = 'Salani' 
		AND N_PAGINE > 400;
		
/* Query 4 */

SELECT *
FROM autore
WHERE ANNO_NASCITA < 1950;
		
/* Query 5 */

SELECT *
FROM cliente;

/* Query 6 */

SELECT *
FROM libro
WHERE CODICE_GENERE = 1;

/* Query 7 */

SELECT l.*
FROM libro l
WHERE l.CODICE_GENERE = 2
		AND l.CASA_EDITRICE = 'Salani'
		AND l.ANNO_PUBBLICAZIONE >= 1990
		AND l.ANNO_PUBBLICAZIONE <= 2010;
		
/* Query 8 */

SELECT l.*
FROM libro l
WHERE l.ANNO_PUBBLICAZIONE LIKE '19_0' 
or l.ANNO_PUBBLICAZIONE = 2000;

/* Query 9 */

SELECT a.*
FROM autore a
WHERE	
	a.COGNOME >= 'a' and a.COGNOME <= 'm'
order by
	a.ANNO_NASCITA desc;
	
/* Query 10 */

SELECT p.*
FROM prestito p
WHERE p.DATA_RESTITUZIONE IS NULL;

/* Query 11 */

SELECT l.*
FROM libro l
WHERE l.TITOLO LIKE '%Potter%';

/* Query 12 */

SELECT l.*
FROM libro l
WHERE l.N_PAGINE between 300 and 600;

/* Query 13 */

SELECT a.*
FROM autore a
ORDER BY a.ANNO_NASCITA, a.COGNOME, a.NOME;

/* Query 14 */

SELECT a.*
FROM autore a
WHERE
	a.CODICE_GENERE IN(1, 5)
	and a.NAZIONALITA IN ('Italia', 'UK')
	and a.ANNO_NASCITA like '19__'
order by
	a.ANNO_NASCITA desc;
	
/* Query 15 */
	
SELECT l.*
FROM libro l
WHERE l.TITOLO LIKE CONCAT('%', l.CASA_EDITRICE, '%');
	