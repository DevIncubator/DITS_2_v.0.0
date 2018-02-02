CREATE TABLE `dits`.`answer` (
  `answerId` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `correct` TINYINT(1) NULL DEFAULT 0,
  `questionId` INT NOT NULL,
  PRIMARY KEY (`answerId`),
  UNIQUE INDEX `answerId_UNIQUE` (`answerId` ASC),
  FOREIGN KEY (`questionId`) REFERENCES question (`questionId`)
);


CREATE TABLE `dits`.`link` (
  `linkId` INT NOT NULL,
  `link` VARCHAR(45) NULL,
  `literatureId` INT NOT NULL,
  PRIMARY KEY (`linkId`),
  UNIQUE INDEX `linkId_UNIQUE` (`linkId` ASC),
  FOREIGN KEY (`literatureId`) REFERENCES literature (`literatureId`)
);

CREATE TABLE `dits`.`literature` (
  `literatureId` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `questionId` INT NOT NULL,
  PRIMARY KEY (`literatureId`),
  UNIQUE INDEX `literatureId_UNIQUE` (`literatureId` ASC),
  FOREIGN KEY (`questionId`) REFERENCES question (`questionId`)

)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('1', 'description of literature', '1');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('2', 'description of literature', '2');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('3', 'description of literature', '3');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('4', 'description of literature', '4');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('5', 'description of literature', '5');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('6', 'description of literature', '6');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('7', 'description of literature', '7');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('8', 'description of literature', '8');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('9', 'description of literature', '9');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('10', 'description of literature', '10');

INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('1', 'asdfasdf', '1');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('2', 'asdfasdf', '2');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('3', 'asdfasdf', '3');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('4', 'asdfasdf', '4');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('5', 'asdfasdf', '5');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('6', 'asdfasdf', '6');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('7', 'asdfasdf', '7');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('8', 'asdfasdf', '8');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('9', 'asdfasdf', '9');
INSERT INTO 'dits'.'link' ('linkId', 'link', 'literatureId') VALUES ('10', 'asdfasdf', '10');
