DROP SCHEMA IF EXISTS "records" CASCADE;
CREATE SCHEMA "records";

CREATE TABLE IF NOT EXISTS
records.r_competition(
	competition_id serial PRIMARY KEY,
	competition_name varchar NOT NULL,
	city varchar NOT NULL,
	hold_date date NOT NULL
);

CREATE TABLE IF NOT EXISTS
records.r_discipline(
	discipline_id serial PRIMARY KEY,
	discipline_description varchar UNIQUE NOT NULL,
	world_record decimal NOT NULL,
	set_date date NOT NULL
);

CREATE TABLE IF NOT EXISTS
records.r_competitions_disciplines (
	competition_id integer NOT NULL,
	discipline_id integer NOT NULL,
	PRIMARY KEY (competition_id, discipline_id),
	FOREIGN KEY (discipline_id)
	REFERENCES records.r_discipline(discipline_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (competition_id)
	REFERENCES records.r_competition(competition_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS
records.r_sportsman(
	sportsman_id serial PRIMARY KEY,
	sportsman_name varchar NOT NULL,
	year_of_birth integer NOT NULL,
	country varchar NOT NULL,
	rank varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS
records.r_result (
	competition_id integer NOT NULL,
	discipline_id integer NOT NULL,
	sportsman_id integer NOT NULL,
	result decimal,
	PRIMARY KEY (competition_id, discipline_id, sportsman_id),
	FOREIGN KEY (competition_id)
	REFERENCES records.r_competition(competition_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (discipline_id)
	REFERENCES records.r_discipline(discipline_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (sportsman_id)
	REFERENCES records.r_sportsman(sportsman_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS
records.r_personal_records(
	sportsman_id integer NOT NULL,
	discipline_id integer NOT NULL,
	personal_record decimal NOT NULL,
	PRIMARY KEY (sportsman_id, discipline_id),
	FOREIGN KEY (sportsman_id)
	REFERENCES records.r_sportsman(sportsman_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (discipline_id)
	REFERENCES records.r_discipline(discipline_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('50m freestyle. Men (25m pool)', 20.16, '2020-11-21');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('100m freestyle. Men (25m pool)', 44.84, '2021-10-29');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('200m freestyle. Men (25m pool)', 99.37, '2009-11-15');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('400m freestyle. Men (25m pool)', 212.25, '2012-11-15');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('800m freestyle. Men (25m pool)', 443.42, '2008-07-20');

INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('50m backstroke. Men (25m pool)', 22.11, '2022-11-23');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('100m backstroke. Men (25m pool)', 48.33, '2022-11-23');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('200m backstroke. Men (25m pool)', 105.63, '2015-11-27');

INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('50m butterfly. Men (25m pool)', 21.75, '2018-10-6');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('100m butterfly. Men (25m pool)', 47.78, '2020-11-21');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('200m butterfly. Men (25m pool)', 106.85, '2022-10-22');

INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('50m breakstroke. Men (25m pool)', 24.95, '2021-12-27');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('100m breakstroke. Men (25m pool)', 55.28, '2021-11-26');
INSERT INTO records.r_discipline (discipline_description, world_record, set_date) VALUES ('200m breakstroke. Men (25m pool)', 120.16, '2018-12-13');

INSERT INTO records.r_competition (competition_name, city, hold_date) VALUES ('FINA World Swimming Championships (25 m)', 'Winsdor', '2016-12-06');

INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 1);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 2);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 3);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 4);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 6);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 7);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 8);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 9);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 10);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 11);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 12);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 13);
INSERT INTO records.r_competitions_disciplines (competition_id, discipline_id) VALUES (1, 14);

INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Jesse Puts', 1994, 'Netherlands', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Vladimir Victorovish Morozov', 1992, 'Russia', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Simonas Bilis', 1993, 'Lithuania', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Shinri Shioura', 1991, 'Japan', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Tommaso D Orsogna', 1990, 'Australia', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Park Tae-hwan', 1989, 'South Korea', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Chad le Clos', 1992, 'Mauritius', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Aleksandr Vladimirovich Krasnykh', 1995, 'Russia', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Péter Bernek', 1992, 'Hungary', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Gregorio Paltrinieri', 1994, 'Italy', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Wojciech Wojdak', 1996, 'Poland', 'AAAA');
INSERT INTO records.r_sportsman (sportsman_name, year_of_birth, country, rank) VALUES ('Junya Koga', 1987, 'Japan', 'AAAA');

INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 1, 1, 21.10);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 1, 2, 21.14);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 1, 3, 21.23);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 2, 3, 46.58);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 2, 4, 46.59);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 2, 5, 46.70);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 3, 6, 101.03);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 3, 7, 101.65);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 3, 8, 101.95);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 4, 6, 214.59);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 4, 8, 215.39);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 4, 9, 217.65);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 6, 12, 22.85);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 7, 2, 57.00);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 11, 7, 48.08);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 10, 7, 21.98);
INSERT INTO records.r_result (competition_id, discipline_id, sportsman_id, result) VALUES (1, 12, 7, 108.76);

INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (1, 1, 20.99);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (1, 2, 46.52);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (1, 6, 24.01);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (1, 9, 22.60);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (2, 1, 20.31);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (2, 2, 44.95);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (2, 12, 25.51);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (2, 13, 56.33);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (2, 9, 22.17);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (3, 1, 20.98);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (3, 2, 46.11);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (5, 2, 46.13);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (5, 3, 102.26);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (6, 2, 48.42);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (6, 3, 104.80);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (6, 4, 221.53);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (7, 1, 21.05);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (7, 2, 45.78);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (7, 3, 101.45);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (7, 9, 21.95);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (7, 10, 48.08);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (10, 3, 110.96);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (10, 4, 226.29);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (10, 5, 459.37);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (12, 6, 24.24);
INSERT INTO records.r_personal_records (sportsman_id, discipline_id, personal_record) VALUES (12, 7, 52.26);