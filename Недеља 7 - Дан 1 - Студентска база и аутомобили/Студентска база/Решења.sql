-- Resenje 1. zadatka
select *
from predmet

-- Resenje 2. zadatka
select *
from dosije
where dosije.mesto_rodjenja = "Beograd"

-- Resenje 3. zadatka
select DISTINCT dosije.mesto_rodjenja
from dosije
where dosije.mesto_rodjenja is not NULL

-- Resenje 4. zadatka
select predmet.naziv
from predmet
where predmet.bodovi>6

-- Resenje 5. zadatka
select predmet.sifra, predmet.naziv
from predmet
where predmet.bodovi>8 and predmet.bodovi<15

-- Resenje 6. zadatka
select *
from ispit
where bodovi=81 or bodovi=76 or bodovi=59
group by id_predmeta

-- Resenje 7. zadatka
select *
from ispit
where bodovi is not 81 AND bodovi is not 76 AND bodovi is not 59
group by id_predmeta

-- Resenje 8. zadatka
select predmet.naziv, predmet.bodovi*1500 as Din
from predmet

-- Resenje 9. zadatka
select predmet.naziv, "cena u din" Nova_Kolona, predmet.bodovi*1500 as din
from predmet

-- Resenje 10. zadatka
a)
select *
from predmet
order by predmet.bodovi ASC

b)
select *
from predmet
order by predmet.bodovi DESC

c)
select *
from predmet
order by predmet.bodovi asc, predmet.naziv DESC

-- Resenje 11. zadatka
nisam znao kako da dodjem do resenja..da je format bio yyyy/mm/dd znao bih mozda, ovako nije bilo sanse..mozda nije toliko komplikovano koliko mislim da jeste..

-- Resenje 12. zadatka
SELECT ispit.oznaka_roka, count(DISTINCT ispit.id_predmeta) as "polozeni ispiti", count(DISTINCT dosije.indeks) as "br studenata"
FROM ispit, dosije
WHERE dosije.indeks = ispit.indeks and ocena!<6 (znam da ovo ne radi, ali gledao sam po netu, ne razumem sto ne radi !< - https://www.tutorialspoint.com/sqlite/sqlite_operators.htm
GROUP BY ispit.oznaka_roka

-- Resenje 13. zadatka
select DISTINCT dosije.ime, dosije.prezime
from dosije, ispit
where ispit.oznaka_roka="jan" and ispit.id_predmeta=1001 and ocena>5

-- Resenje 14. zadatka
select avg(bodovi)
from ispit
WHERE ispit.id_predmeta=1021 and ispit.oznaka_roka!="apr"

-- Resenje 15. zadatka
select count(distinct ispit.indeks) as "studenti koji su polozili ispit"
from ispit
WHERE ocena>5

-- Resenje 16. zadatka
select avg(bodovi)
from ispit
WHERE indeks=20130023

-- Resenje 17. zadatka
select avg(ocena)
from ispit
WHERE ispit.oznaka_roka="jan"

-- Resenje 18. zadatka
select DISTINCT predmet.naziv
from ispit, predmet
WHERE predmet.id_predmeta=ispit.id_predmeta and ispit.oznaka_roka="jan" and predmet.bodovi=6