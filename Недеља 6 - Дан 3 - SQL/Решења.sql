--Resenje 1. zadatka
SELECT *
from Fakultet
WHERE "Drzavni/Privatni" = 'D'

--Resenje 2. zadatka
select Naziv
from Fakultet
where "Drzavni/Privatni" = 'P'

--Resenje 3. zadatka
SELECT count(*)
from Fakultet
where "Drzavni/Privatni" = 'D'

--Resenje 4. zadatka
SELECT avg(BrojStudenata)
from Fakultet

--Resenje 5. zadatka
SELECT avg(BrojStudenata)
from Fakultet
WHERE "Drzavni/Privatni" = 'D'

--Resenje 6. zadatka
SELECT DISTINCT Grad
from Fakultet

--Resenje 7. zadatka
SELECT sum(BrojStudenata)
from Fakultet

--Resenje 8. zadatka
SELECT Ime, Prezime
from Student

--Resenje 9. zadatka
SELECT *
from Student
WHERE GodinaStudija = 3

--Resenje 10. zadatka
SELECT *, Max(Prosek)
from Student

--Resenje 11. zadatka
SELECT *, Max(Prosek)
from Student
WHERE GodinaStudija = 3

--Resenje 12. zadatka
SELECT avg(Prosek)
from Student
WHERE GodinaStudija = 4

--Resenje 13. zadatka
SELECT avg(Prosek)
from Student
WHERE pol = 'M'

--Resenje 14. zadatka
SELECT *
from Student
where prosek is NULL

--Resenje 15. zadatka
SELECT *
from Student
where prosek is NOT NULL

--Resenje 16. zadatka
SELECT *
From Student
WHERE Prosek > (SELECT avg(Prosek) from Student)