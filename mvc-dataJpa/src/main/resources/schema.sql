DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS team;
DROP SEQUENCE IF EXISTS team_seq;
DROP SEQUENCE IF EXISTS player_seq;

CREATE TABLE player(id BIGINT, first_name VARCHAR(255) not null, last_name VARCHAR(255) not null, position VARCHAR(255) not null, birthday date not null, team_id BIGINT, constraint player_PK  PRIMARY KEY (id) );


CREATE TABLE team(id BIGINT, name VARCHAR(255) not null, captain_id BIGINT not null, constraint team_PK PRIMARY KEY (id), CONSTRAINT team_captain_player_id_FK FOREIGN KEY (captain_id) REFERENCES team(id), CONSTRAINT team_captain_player_UK UNIQUE (name));

ALTER TABLE player ADD CONSTRAINT player_team_id_FK FOREIGN KEY (team_id) REFERENCES team(id);

CREATE SEQUENCE team_seq START 10;
CREATE SEQUENCE player_seq START 70;
