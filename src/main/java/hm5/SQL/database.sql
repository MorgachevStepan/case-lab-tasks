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
	rank varchar NOT NULL,
	year_of_birth integer NOT NULL,
	country varchar NOT NULL
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