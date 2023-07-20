-- (IMPORTANT) Database setup script (using mysql). Note that you still have to import data from .csv file to the question table
-- If you're using mysql workbench, simply right click on the "question" table, choose "table data import wizard",
-- uncheck "truncate table before import", click on the wrench icon then change "field separator" to ","
-- and "null and NULL word as sql keyword" to "NO"

create database if not exists quizz;
use quizz;

SET FOREIGN_KEY_CHECKS=0;
drop table if exists `question`;
create table `question`(
	`id` bigint NOT NULL AUTO_INCREMENT,
	`category` varchar(25) DEFAULT NULL,
    `difficulty_level` varchar(25) DEFAULT NULL,
	`option1` varchar(255) DEFAULT NULL,
	`option2` varchar(255) DEFAULT NULL,
    `option3` varchar(255) DEFAULT NULL,
    `option4` varchar(255) DEFAULT NULL,
    `question_title` varchar(255) DEFAULT NULL,
    `correct_answer` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists `quiz`;
create table `quiz`(
	`id` bigint NOT NULL AUTO_INCREMENT,
    `title` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

drop table if exists `quiz_questions`;
create table `quiz_questions` (
	quiz_id bigint NOT NULL,
    questions_id bigint NOT NULL,
    primary key (quiz_id, questions_id),
    FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`),
    FOREIGN KEY (`questions_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS=1;


-- since table data import wizard in mysql workbench miss the first record, 
-- I create it separately
INSERT INTO `question` VALUES 
	(1,'JAVA','Easy',	'class'	,'interface',	'extends',	'implements',	'Which Java keyword is used to create a subclass?',	'extends');