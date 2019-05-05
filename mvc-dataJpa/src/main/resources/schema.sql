DROP TABLE IF EXISTS player CASCADE ;
DROP TABLE IF EXISTS team CASCADE ;

CREATE TABLE player(id serial, first_name VARCHAR(255) not null, last_name VARCHAR(255) not null, position VARCHAR(255) not null, birthday date not null, team_id BIGINT, constraint player_PK  PRIMARY KEY (id) );


CREATE TABLE team(id serial, name VARCHAR(255) not null, captain_id BIGINT not null, constraint team_PK PRIMARY KEY (id), CONSTRAINT team_captain_player_id_FK FOREIGN KEY (captain_id) REFERENCES player(id), CONSTRAINT team_captain_player_UK UNIQUE (name));

ALTER TABLE player ADD CONSTRAINT player_team_id_FK FOREIGN KEY (team_id) REFERENCES team(id);

SELECT setval('player_id_seq', 31,false);
SELECT setval('team_id_seq', 7,false);
