/*
Created: 28/5/2021
Modified: 1/6/2021
Model: Oracle 18c
Database: Oracle 18c
*/






-- Drop keys for tables section -------------------------------------------------

ALTER TABLE def_user DROP CONSTRAINT PK_def_user
;




-- Drop tables section ---------------------------------------------------

DROP TABLE def_user
;

-- Drop sequences section --------------------------------------------------- 

DROP SEQUENCE def_user_seq01
;

-- Create sequences section -------------------------------------------------

CREATE SEQUENCE def_user_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

-- Create tables section -------------------------------------------------

-- Table def_user

CREATE TABLE def_user(
  user_id Number NOT NULL,
  user_username Varchar2(50 ) NOT NULL,
  user_pass Varchar2(50 ) NOT NULL,
  user_lvl Integer DEFAULT 1
 NOT NULL,
  user_imguser Integer DEFAULT 0 NOT NULL,
  user_imgballesta Integer DEFAULT 0 NOT NULL,
  user_imgcastillo Integer DEFAULT 0 NOT NULL,
  user_dinero Integer DEFAULT 0 NOT NULL,
  user_esmeraldas Integer DEFAULT 0 NOT NULL,
  user_mvida Integer DEFAULT 0 NOT NULL,
  user_mmana Integer DEFAULT 0 NOT NULL,
  user_lvlfuerza Integer DEFAULT 0 NOT NULL,
  user_lvlagilidad Integer DEFAULT 0 NOT NULL,
  user_lvlretroceso Integer DEFAULT 0 NOT NULL,
  user_lvldddamage Integer DEFAULT 0 NOT NULL,
  user_lvltirodoble Integer DEFAULT 0 NOT NULL,
  user_sfireball Integer DEFAULT 0 NOT NULL,
  user_sfreeze Integer DEFAULT 0 NOT NULL,
  user_srayo Integer DEFAULT 0 NOT NULL
)
;

-- Add keys for table def_user

ALTER TABLE def_user ADD CONSTRAINT PK_def_user PRIMARY KEY (user_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN def_user.user_id IS 'Id del usuario  '
;
COMMENT ON COLUMN def_user.user_username IS 'username'
;
COMMENT ON COLUMN def_user.user_pass IS 'password'
;
COMMENT ON COLUMN def_user.user_lvl IS 'nivel'
;
COMMENT ON COLUMN def_user.user_imguser IS 'img de la ballesta'
;
COMMENT ON COLUMN def_user.user_imgballesta IS 'img del castillo'
;
COMMENT ON COLUMN def_user.user_imgcastillo IS 'img del dinero'
;
COMMENT ON COLUMN def_user.user_dinero IS 'dinero '
;
COMMENT ON COLUMN def_user.user_esmeraldas IS 'esmeraldas'
;
COMMENT ON COLUMN def_user.user_mvida IS 'nivel de vida del castillo
'
;
COMMENT ON COLUMN def_user.user_mmana IS 'nivel de mana del usuario'
;
COMMENT ON COLUMN def_user.user_lvlfuerza IS 'nivel de fuerza'
;
COMMENT ON COLUMN def_user.user_lvlagilidad IS 'nivel de agilidad'
;
COMMENT ON COLUMN def_user.user_lvlretroceso IS 'nivel de retroceso'
;
COMMENT ON COLUMN def_user.user_lvldddamage IS 'nivel de doble damage'
;
COMMENT ON COLUMN def_user.user_lvltirodoble IS 'nivel de tiro doble'
;
COMMENT ON COLUMN def_user.user_sfireball IS 'nivel de fireball'
;
COMMENT ON COLUMN def_user.user_sfreeze IS 'nivel de freeze'
;
COMMENT ON COLUMN def_user.user_srayo IS 'nivel de rayo'
;

-- Trigger for sequence def_user_seq01 for column user_id in table def_user ---------
CREATE OR REPLACE TRIGGER def_user_tgr01 BEFORE INSERT
ON def_user FOR EACH ROW
BEGIN
  IF :new.user_id IS NULL OR :new.user_id <1 THEN
  :new.user_id := def_user_seq01.nextval;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER def_user_tgr02 AFTER UPDATE OF user_id
ON def_user FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column user_id in table def_user as it uses sequence.');
END;
/





