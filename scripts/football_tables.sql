
CREATE DATABASE IF NOT EXISTS `football`;
USE `football`;

CREATE TABLE IF NOT EXISTS `teams` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `players` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

-- join table
CREATE TABLE IF NOT EXISTS `teams_players` (
  `team_id` int(5) NOT NULL,
  `player_id` int(5) NOT NULL,
  PRIMARY KEY (team_id, player_id),
  FOREIGN KEY (team_id) REFERENCES teams(id),
  FOREIGN KEY (player_id) REFERENCES players(id)
);

INSERT INTO `teams` (`id`, `name`) VALUES
	(1, 'Barcelona'),
	(2, 'Real Madrid'),
	(3, 'Manchester United'),
    (4, 'Chelsea'),
    (5, 'Arsenal'),
    (6, 'Bayern Munich');
    
INSERT INTO `players` (`id`, `name`) VALUES
  (1, 'player_1'),
  (2, 'player_2'),
  (3, 'player_3'),
  (4, 'player_4'),
  (5, 'player_5'),
  (6, 'player_6');
  
INSERT INTO `teams_players` (`team_id`, `player_id`) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 1),
  (2, 2),
  (2, 4),
  (3, 5),
  (3, 6),
  (4, 1),
  (4, 2),
  (5, 1),
  (5, 3),
  (5, 5),
  (6, 2),
  (6, 3),
  (6, 4);
  
