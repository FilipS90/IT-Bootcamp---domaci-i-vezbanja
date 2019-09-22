-- Resenje 1. zadatka
SELECT Odsek.Naziv, count(Kurs.Naziv)
from Kurs, Odsek
where Odsek.SifO=kurs.SifO
group by Odsek.Naziv

-- Resenje 2. zadatka
SELECT Kurs.Naziv, count(student.sifs) as "Broj studenata"
FROM Kurs, Student, Pohadja, Raspored
WHERE student.SifS=pohadja.SifS and pohadja.SifR=raspored.SifR and raspored.sifk = kurs.SifK
group by Kurs.Naziv
HAVING count(Student.SifS)>3

-- Resenje 3. zadatka
SELECT sum(Raspored.BrPrijaveljenih)/count(distinct SifK) as "Srednji broj studenata"
FROM Raspored

-- Resenje 4. zadatka
SELECT kurs.Naziv
FROM Kurs, Student, Pohadja, Raspored
WHERE student.SifS=pohadja.SifS and pohadja.SifR=raspored.SifR and raspored.sifk = kurs.SifK and student.SifS=1

-- Resenje 5. zadatka
SELECT Student.Ime
FROM Student, Pohadja, Raspored
WHERE pohadja.SifR=raspored.SifR and student.SifS=pohadja.SifS
group by student.Ime
having count(pohadja.sifs)>2

-- Resenje 6. zadatka
SELECT DISTINCT Student.Ime
FROM Student, Pohadja, Raspored, Ucionica
WHERE student.SifS=pohadja.SifS and pohadja.SifR=raspored.SifR and raspored.SifU = ucionica.SifU and ucionica.sifu = 111 and raspored.Dan = "Pon"

-- Resenje 7. zadatka
SELECT kurs.Naziv, max(raspored.BrPrijaveljenih)
FROM Kurs, Profesor, Raspored
WHERE raspored.SifP = profesor.SifP and profesor.SifO = kurs.SifO and Profesor.sifp = 7

-- Resenje 8. zadatka
SELECT kurs.Naziv
FROM Kurs, Preduslov
WHERE preduslov.SifKP = kurs.SifK and preduslov.SifK = 4

-- Resenje 9. zadatka
select Kurs.Naziv, count(Preduslov.SifKP) as "Broj preduslova"
from kurs, Preduslov
WHERE kurs.SifK=Preduslov.SifK
group by Kurs.Naziv

-- Resenje 10. zadatka
select profesor.Ime, Raspored.BrPrijaveljenih as "Broj studenata"
from Student, Profesor, Raspored, Pohadja
where raspored.SifP=Profesor.SifP and Raspored.dan = "Pon"
group by profesor.Ime