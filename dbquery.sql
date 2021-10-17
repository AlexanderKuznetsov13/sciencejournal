CREATE SEQUENCE user_seq;

CREATE TABLE users
(
    id          INTEGER      NOT NULL DEFAULT nextval('user_seq'),
    name        VARCHAR(100) NOT NULL,
    surname     VARCHAR(300) NOT NULL,
    middle_name VARCHAR(300) NULL,
    email       VARCHAR(50)  NOT NULL,
    password    VARCHAR(50)  NOT NULL,

    CONSTRAINT user_id_pk PRIMARY KEY (id)
);

COMMENT ON TABLE users IS 'List of users';
COMMENT ON COLUMN users.id IS 'ID';
COMMENT ON COLUMN users.name IS 'name of user';
COMMENT ON COLUMN users.surname IS 'Surname of user';
COMMENT ON COLUMN users.middle_name IS 'middle_name of user';
COMMENT ON COLUMN users.email IS 'email of user';
COMMENT ON COLUMN users.password IS 'password of user';

SELECT ID, NAME, SURNAME, MIDDLE_NAME, EMAIL, PASSWORD
FROM users
where id = 1;


--list of all languages
select *
from sciencejournal.languages;

-- list of all topics
select *
from sciencejournal.topics;

-- list of all user types
select *
from sciencejournal.usertypes;

select *
from sciencejournal.author;

select *
from sciencejournal.authorsbyaffiliation;


select * from sciencejournal.users;
select * from sciencejournal.usersbyjournal;
select * from sciencejournal.journals;
select * from sciencejournal.application;
select * from sciencejournal.authorsbyaffiliation;
select * from sciencejournal.applicationstatustypes;



select *
from sciencejournal.usersbyjournal
where (user_id=4 and user_type_id=1 and journal_id=2) or (user_id=3 and user_type_id=2 and journal_id=2);




--
select j.id, j.name, t.name, l.name from sciencejournal.journals j
                                             inner join  sciencejournal.topics t on j.topic_id = t.id
                                             inner join  sciencejournal.languages l on j.language_id = l.id;

--
select * from sciencejournal.usersbyjournal t1
                  inner join sciencejournal.users t2 on t1.user_id = t2.id ;

--
select t1.id, t4.name, t4.surname, t3.name, t2.name
from sciencejournal.usersbyjournal t1
         inner join sciencejournal.journals t2 on t1.journal_id = t2.id
         inner join sciencejournal.usertypes t3 on t1.user_type_id = t3.id
         inner join sciencejournal.users t4 on t1.user_id = t4.id;

-- list of all affliations
select *
from sciencejournal.affiliation;


CREATE SEQUENCE topics_seq;

CREATE TABLE topics
(
    id   INTEGER      NOT NULL DEFAULT nextval('topics_seq'),
    name VARCHAR(100) NOT NULL,

    CONSTRAINT topics_id_pk PRIMARY KEY (id)
);

COMMENT ON TABLE topics IS 'List of topics';
COMMENT ON COLUMN topics.id IS 'ID';
COMMENT ON COLUMN topics.name IS 'name of topic';




select *
from pg_catalog.pg_namespace;