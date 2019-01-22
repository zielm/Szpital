
drop table wypisy;
drop table wizyty;
drop table upowaznienia;
drop table rozpoznania;
drop table procedury;
drop table pacjenci;

-- TABLES

create table pacjenci (
    id_pacjenta number(10) NOT NULL,
    pesel varchar(11),
    plec char(1) CHECK (plec IN ('K','M')),
    imie varchar(20),
    drugie_imie varchar(20),
    nazwisko varchar(30),
    nazwisko_rodowe varchar(30),
    adres varchar(50),
    miejsce_urodzenia varchar(20),
    numer_telefonu number(11),
    PRIMARY KEY(id_pacjenta)
);

create table upowaznienia (
    id_upowaznienia number(10) NOT NULL,
    stopien_pokrewiensta varchar(20) NOT NULL,
    imie varchar(20),
    nazwisko varchar(30),
    numer_telefonu number(11) NOT NULL,
    id_pacjenta number(10) NOT NULL,
    PRIMARY KEY(id_upowaznienia),
    FOREIGN KEY (id_pacjenta) REFERENCES pacjenci(id_pacjenta) ON DELETE CASCADE
);

create table rozpoznania (
    id_rozpoznania varchar(5) NOT NULL,
    nazwa_choroby varchar(100) NOT NULL,
    PRIMARY KEY(id_rozpoznania) 
);

create table procedury (
    id_procedury varchar(5) NOT NULL,
    nazwa_procedury varchar(100) NOT NULL,
    PRIMARY KEY(id_procedury)
);

create table wizyty (
    id_wizyty number(10) NOT NULL,
    id_pacjenta number(10) NOT NULL,
    data_przyjecia date NOT NULL,
    lekarz_prowadzacy varchar(30) NOT NULL,
    opis_dolegliwosci varchar(100),
    id_rozpoznania varchar(5),
    id_procedury varchar(5),
    PRIMARY KEY(id_wizyty),
    FOREIGN KEY (id_pacjenta) REFERENCES pacjenci(id_pacjenta) ON DELETE CASCADE,
    FOREIGN KEY (id_rozpoznania) REFERENCES rozpoznania(id_rozpoznania),
    FOREIGN KEY (id_procedury) REFERENCES procedury(id_procedury)
);

create table wypisy(
    id_wizyty number(10),
    data_wypisu date NOT NULL,
    typ_wypisu varchar(20) CHECK ( typ_wypisu IN ('przyjecie', 'odmowa', 'zakonczenie', 'zgon')) NOT NULL, 
    zalecenia varchar(500),
    PRIMARY KEY(id_wizyty),
    FOREIGN KEY(id_wizyty) REFERENCES wizyty(id_wizyty) ON DELETE CASCADE
);

--------------------------------------
-- VIEWS
create or replace view wizyty_pacjentow as 
    select id_wizyty, data_przyjecia, data_wypisu, id_pacjenta, imie, nazwisko, pesel
    from (wizyty natural left join wypisy) natural join pacjenci;


-------------------------------------
-- FUNCTIONS
/
drop function getWiek;
CREATE OR REPLACE FUNCTION getWiek(p_pesel IN VARCHAR) 
RETURN int IS 
   wiek int;
   rok int;
   data_ur int;
   obecna_data int;
BEGIN 
    rok := SUBSTR(p_pesel,0,2);
    data_ur := substr(p_pesel,3,4);
    obecna_data := (extract(month from current_date)*100) + extract(day from current_date);
    CASE SUBSTR(p_pesel,3,1)
        WHEN 2 then 
            wiek := -2000;
            data_ur := data_ur - 2000;
        ELSE wiek := -1900;
    END CASE;
    
    wiek := wiek + extract(year from current_date) - rok;
    
    -- jezeli urodziny nie minely
    IF obecna_data - data_ur < 0 
        THEN wiek := wiek -1; 
    END IF;  
    
    RETURN wiek; 
END; 
/ 



-------------------------------------------
-- PROCEDURES
DROP PROCEDURE okreslPlec;
CREATE OR REPLACE PROCEDURE okreslPlec (p_pesel VARCHAR) AS
    nowa CHAR;
    BEGIN
        nowa := SUBSTR(p_pesel,-2,1) mod 2;
        CASE nowa
            WHEN 0 then nowa := 'K';
            ELSE nowa := 'M';
        END CASE;
        update pacjenci SET plec = nowa WHERE pesel = p_pesel;
    END;
/
-----------------------------------------------------------
-- INDEXES
create unique index idx_pesel_pacjenci on pacjenci(
    case when pesel is not null then pesel end,
    case when pesel is null then null end
);
create index idx_pacjent_wizyty on wizyty(id_pacjenta);



--------------------------------------------------------------
-- SEQUENCES AND TRIGGERS

DROP SEQUENCE pacjenci_seq;
DROP SEQUENCE upowaznienia_seq;
DROP SEQUENCE wizyty_seq;


CREATE SEQUENCE pacjenci_seq START WITH 1;
/
CREATE OR REPLACE TRIGGER pacjenci_trig 
BEFORE INSERT ON pacjenci 
FOR EACH ROW

BEGIN
  SELECT pacjenci_seq.NEXTVAL
  INTO   :new.id_pacjenta
  FROM   dual;
END;
/

CREATE SEQUENCE upowaznienia_seq START WITH 1;
/
CREATE OR REPLACE TRIGGER upowaznienia_trig
BEFORE INSERT ON upowaznienia 
FOR EACH ROW

BEGIN
  SELECT upowaznienia_seq.NEXTVAL
  INTO   :new.id_upowaznienia
  FROM   dual;
END;
/

CREATE SEQUENCE wizyty_seq START WITH 1;
/
CREATE OR REPLACE TRIGGER wizyty_trig
BEFORE INSERT ON wizyty 
FOR EACH ROW

BEGIN
  SELECT wizyty_seq.NEXTVAL
  INTO   :new.id_wizyty
  FROM   dual;
END;
/