1. Per què s’atura el programa al cap d’un temps?

Perquè arriba un moment en què tots els fils estan esperant una plaça lliure amb wait(), però com que ningú cancel·la cap plaça així que no hi han notificacions de cancel·lació i el programa s'atura.

2. Què passaria si en lloc d’una probabilitat de 50%-50% fora de 70% (ferReserva) – 30% (cancel·lar)? I si foren al revés les probabilitats?
→ Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos.

Amb 70% ferReserva les places s’omplen molt ràpid, quasi ningú cancel·la, molts assistents intenten cancel·lar sense tenir reserva, surten molts errors, les places es queden a 0 molta estona:

if (accio < 0.5) {
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }

Resultat:

Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-3 ha fet una reserva. Places disponibles: 4
Assistent-2 ha fet una reserva. Places disponibles: 3
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-4 ha fet una reserva. Places disponibles: 2
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-7 ha fet una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 ha cancel·lat una reserva. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-5 ha fet una reserva. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 ha cancel·lat una reserva. Places disponibles: 2
Assistent-2 ha cancel·lat una reserva. Places disponibles: 3
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-3 ha fet una reserva. Places disponibles: 2
Assistent-4 ha fet una reserva. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0

Quan cancel·lar té un 70% de probabilitat fa que hi hagin places disponibles i que els assistents no reservin tant, cancelen més que reserven. 

Si apliquen la inversa amb els % pasará el contrari del que ha passat amb els dos resultats de 70%-30%.

Resultat:

Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-4 ha fet una reserva. Places disponibles: 4
Assistent-6 ha fet una reserva. Places disponibles: 3
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-5 ha fet una reserva. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-9 ha fet una reserva. Places disponibles: 1
Assistent-5 ha cancel·lat una reserva. Places disponibles: 2
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-7 ha fet una reserva. Places disponibles: 1
Assistent-9 ha cancel·lat una reserva. Places disponibles: 2
Assistent-1 ha fet una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1

3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves?
Una llista ens podria ajudar a tenir un millor control de qui fa la reserva, quan, així com altres dades com les cancel·lacions amb un ordre coherent.