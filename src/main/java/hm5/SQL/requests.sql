--Выдайте всю информацию о спортсменах из таблицы sportsman.
SELECT sportsman_name, year_of_birth, country
FROM records.r_sportsman;

-- Выдайте наименование и мировые результаты по всем соревнованиям
SELECT discipline_description, world_record
FROM records.r_discipline;

--Выберите имена всех спортсменов, которые родились в 1990 году.
SELECT sportsman_name
FROM records.r_sportsman
WHERE (year_of_birth = 1990);

--Выберите наименование и мировые результаты по всем соревнованиям, установленные 21-11-2020 или 27-11-2015.
SELECT discipline_description, world_record
FROM records.r_discipline
WHERE (set_date = '2020-11-21' OR set_date = '2015-11-27');

--Выберите дату проведения всех соревнований, которые проводились в Winsdor`eи полученные на них результаты меньше 30 секунд.
SELECT DISTINCT hold_date
FROM records.r_competition comp
JOIN records.r_result res ON (comp.competition_id = res.competition_id)
WHERE (res.result < 30.00 AND comp.city = 'Winsdor');

--Выберите дату проведения всех соревнований, у которых город проведения начинается с буквы "W".
SELECT hold_date
FROM records.r_competition
WHERE city LIKE 'W%';

-- Выберите имена всех спортсменов, у которых имена начинаются с буквы "S" и год рождения не заканчивается на "6".
SELECT sportsman_name
FROM records.r_sportsman
WHERE sportsman_name LIKE 'S%' AND (year_of_birth % 10) != 6;

--Выберите наименования всех соревнований, у которых в названии есть слово "World".
SELECT competition_name
FROM records.r_competition
WHERE competition_name LIKE '%World%';

--Выберите годы рождения всех спортсменов без повторений.
SELECT DISTINCT year_of_birth
FROM records.r_sportsman;

--Найдите количество результатов, полученных 2016-12-06.
SELECT COUNT(*)
FROM records.r_result res
JOIN records.r_competition comp ON (res.competition_id = comp.competition_id)
WHERE comp.hold_date = '2016-12-06';

--Вычислите минимальный год рождения спортсменов, имя которых начинается с буквы S.
SELECT MIN(year_of_birth)
FROM records.r_sportsman
WHERE sportsman_name LIKE 'S%';

--Вычислите средний результат каждого из спортсменов
SELECT s.sportsman_id, s.sportsman_name, AVG(r.result) AS average_result
FROM records.r_sportsman s
JOIN records.r_result r ON (s.sportsman_id = r.sportsman_id)
GROUP BY s.sportsman_id, s.sportsman_name;

--Выведите список спортсменов в виде 'Спортсмен ' ['имя спортсмена'] 'показал результат' ['результат'] 'в городе' ['город']
SELECT
  'Спортсмен ' || s.sportsman_name || ' показал результат ' || r.result || ' в городе ' || c.city AS results
FROM records.r_sportsman s
JOIN records.r_result r ON s.sportsman_id = r.sportsman_id
JOIN records.r_competition c ON (r.competition_id = c.competition_id);

--Выведите данные о спортсменах, у которых персональный рекорд совпадает с мировым.
SELECT s.sportsman_name, s.year_of_birth, s.country, d.discipline_description
FROM records.r_sportsman s
JOIN records.r_personal_records pr ON (s.sportsman_id = pr.sportsman_id)
JOIN records.r_discipline d ON (pr.discipline_id = d.discipline_id)
WHERE (pr.personal_record = d.world_record);

-- Определите количество участников с фамилией Puts, которые участвовали в соревнованиях с названием, содержащим слово 'World'.
SELECT COUNT(DISTINCT s.sportsman_id)
FROM records.r_sportsman s
JOIN records.r_result r ON s.sportsman_id = r.sportsman_id
JOIN records.r_competition c ON r.competition_id = c.competition_id
WHERE s.sportsman_name LIKE '%Puts%' AND c.competition_name LIKE '%World%';

--Определите, спортсмены какой страны участвовали в соревнованиях больше всего.
SELECT r_sportsman.country, COUNT(*) AS participant_count
FROM records.r_sportsman
GROUP BY r_sportsman.country
ORDER BY participant_count DESC
LIMIT 1;

--Измените название соревнований с 'FINA World Swimming Championships (25 m)' на 'FINA World Swimming Championships 2016 (25 m)'
UPDATE records.r_competition
SET competition_name = 'FINA World Swimming Championships 2016 (25 m)'
WHERE competition_name = 'FINA World Swimming Championships (25 m)';

-- Выберите имена всех спортсменов, у которых персональный рекорд не равен 20.99 с по 50m freestyle. Men (25m pool)
SELECT DISTINCT sportsman_name
FROM records.r_sportsman s
JOIN records.r_personal_records pr ON (s.sportsman_id = pr.sportsman_id)
JOIN records.r_discipline r ON (r.discipline_id = pr.discipline_id)
WHERE (pr.personal_record != 20.99 AND r.discipline_description = '50m freestyle. Men (25m pool)');

--Измените дату проведения всех соревнований, проходящих в Winsdor`e, на 4 дня вперед.
UPDATE records.r_competition
SET hold_date = hold_date + INTERVAL '4 days'
WHERE city = 'Winsdor';

--Удалите все результаты спортсменов, которые родились в 2001 году.
DELETE FROM records.r_result
WHERE sportsman_id IN (
    SELECT sportsman_id
    FROM records.r_sportsman
    WHERE year_of_birth = 2001
);

 -- Выберите города проведения соревнований, где результаты принадлежат множеству {13, 25, 17, 21.10}.
SELECT DISTINCT c.city
FROM records.r_competition c
JOIN records.r_result r ON c.competition_id = r.competition_id
WHERE r.result IN (13, 25, 17, 21.10);

--Выберите имена всех спортсменов, у которых год рождения 1991 и разряд не принадлежит множеству {'AA', 'AAA', 'A'}.
SELECT sportsman_name
FROM records.r_sportsman
WHERE year_of_birth = 1991 AND rank NOT IN ('AA', 'AAA', 'A');

-- Вычислите максимальный результат, полученный в Winsdor.
SELECT MAX(result) AS max_result
FROM records.r_result r
JOIN records.r_competition c ON r.competition_id = c.competition_id
WHERE c.city = 'Winsdor';

--Измените страну у спортсменов, у которых разряд равен AAA или AAAA, с Италии на Россию.
UPDATE records.r_sportsman
SET country = 'Russia'
WHERE rank IN ('AAAA', 'AAA') AND country = 'Italy';

--Измените разряд на 1 тех спортсменов, у которых личный рекорд совпадает с мировым.
UPDATE records.r_sportsman
SET rank = '1'
WHERE sportsman_id IN (
    SELECT s.sportsman_id
    FROM records.r_sportsman s
    JOIN records.r_personal_records pr ON s.sportsman_id = pr.sportsman_id
    JOIN records.r_discipline d ON pr.discipline_id = d.discipline_id
    WHERE pr.personal_record = d.world_record
);

--Увеличьте мировой результат на 2 с для соревнований ранее 20-03-2005.
UPDATE records.r_discipline
SET world_record = world_record + 2
WHERE set_date < '2005-03-20';

--Уменьшите результаты на 2 с соревнований, которые проводились 20-05-2012 и показанный результат не менее 45 с.
UPDATE records.r_result
SET result = result - 2
WHERE competition_id IN (
    SELECT competition_id
    FROM records.r_competition
    WHERE hold_date = '2012-05-20'
) AND result >= 45;

--Выберите названия всех соревнований, у которых мировой рекорд равен 20.99 с и дата установки рекорда не равна 12-02-2015.
SELECT c.competition_name
FROM records.r_competition c
JOIN records.r_competitions_disciplines cd ON c.competition_id = cd.competition_id
JOIN records.r_discipline d ON cd.discipline_id = d.discipline_id
WHERE d.world_record = 20.99 AND d.set_date <> '2015-02-12';

--Удалите все соревнования, у которых результат равен 20 с.
DELETE FROM records.r_competition
WHERE competition_id IN (
    SELECT r.competition_id
    FROM records.r_result r
    WHERE r.result = 20
);

--Вычислите возраст спортсменов, которые участвовали в соревнованиях в Москве.
SELECT AVG(s.year_of_birth) AS average_age
FROM records.r_sportsman s
WHERE s.sportsman_id IN (
    SELECT DISTINCT r.sportsman_id
    FROM records.r_competition c
    JOIN records.r_result r ON c.competition_id = r.competition_id
    WHERE c.city = 'Winsdor'
);