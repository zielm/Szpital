-- DATA

-- PACJENCI
/* pesel, plec, imie, drugie_imie, nazwisko, nazwisko_rodowe, 
    adres, miejsce_urodzenia, numer_telefonu */
insert into pacjenci VALUES (null, '90010515836', 'M', 'Marek', 'Andrzej', 'Nowak', null, 
    'ul. Piekna 12/23 60-243 Poznan',  'Poznan', 654882034);
insert into pacjenci VALUES (null, '92071314764', 'K', 'Anna', null, 'Kaczorowska', null, 
    'ul. Andersena 1/1 60-489 Poznan',  'Poznan', 722566985);
insert into pacjenci VALUES (null, '81100216357', 'M', 'Dominik', null, 'Cieszkowski', null, 
    'ul. Warszawska 123/42 60-322 Poznan',  'Gdansk', 512458863);
insert into pacjenci VALUES (null, '80072909146', 'K', 'Weronika', 'Maria', 'Mazurkiewicz', 'Wierzba', 
    'ul. Forteczna 12 60-124 Poznan',  'Komorniki', 699452365);
insert into pacjenci VALUES (null, '90080517455', 'M', 'Patryk', null, 'Flis', null, 
    'ul. Markwarta 2/15 60-875 Poznan',  'Poznan', 566986585);
insert into pacjenci VALUES (null, '90060804786', 'K', 'Agnieszka', 'Dorota', 'Chmara', null, 
    'ul. Serafitek 3/13 61-144 Poznan',  'Poznan', 644523655);
insert into pacjenci VALUES (null, '65071209862', 'K', 'Helena', null, 'Zasada', 'Biel', 
    'ul. Deszczowa 13/67 61-265 Poznan',  'Konin', 542365255);
insert into pacjenci VALUES (null, '67040500538', 'M', 'Kazimierz', 'Stefan', 'Kula', null, 
    'ul. Kopernika 3 60-262 Poznan',  'Lublin', 511452366);
insert into pacjenci VALUES (null, '69112121548', 'K', 'Barbara', 'Maria', 'Kula', 'Lewandowska', 
    'ul. Kopernika 3 60-262 Poznan',  'Lublin', 518569655);
insert into pacjenci VALUES (null, '04251203234', 'M', 'Karol', 'Adam', 'Flis', null,
    'ul. Markwarta 2/15 60-875 Poznan',  'Poznan', null);

-- UPOWAZNIENIA
/* id_upowaznienia, stopien_pokrewiensta, imie, nazwisko, numer_telefonu, fd_pacjenta */
insert into upowaznienia VALUES (null, 'zona', 'Barbara', 'Kula', 518569655, 
    (select id_pacjenta from pacjenci where pesel = 67040500538) );
insert into upowaznienia VALUES (null, 'maz', 'Kazimierz', 'Kula', 511452366, 
    (select id_pacjenta from pacjenci where pesel = 69112121548) );
insert into upowaznienia VALUES (null, 'matka', 'Agnieszka', 'Kaczorowska', 600589456, 
    (select id_pacjenta from pacjenci where pesel = 92071314764) );
insert into upowaznienia VALUES (null, 'ojciec', 'Patryk', 'Flis', 566986585, 
    (select id_pacjenta from pacjenci where pesel = 04251203234) );

-- ROZPOZNANIA
/*  id_rozpoznania, nazwa_choroby */
insert into rozpoznania VALUES ('I21.0', 'Ostry zawal serca');
insert into rozpoznania VALUES ('S00.3', 'Powierzchowny uraz nosa');
insert into rozpoznania VALUES ('S42.3', 'Zlamanie trzonu kosci ramiennej');
insert into rozpoznania VALUES ('K35.1', 'Zapalenie wyrostka robaczkowego');
insert into rozpoznania VALUES ('F10.0', 'Zatrucie alkoholem');

-- PROCEDURY
/*  id_procedury, nazwa_procedury */
insert into procedury VALUES ('88.7',	'Diagnostyczna ultrasonografia');
insert into procedury VALUES ('88.21',	'Zdjecie RTG kosci barku i ramienia');
insert into procedury VALUES ('99.21',	'Wstrzykniecie antybiotyku');
insert into procedury VALUES ('21.71',	'Nastawienie zlamania nosa');

-- WIZYTY
/* id_wizyty, fd_pacjenta, data_przyjecia, lekarz_prowadzacy, opis_dolegliwosci, fd_choroby, fd_procedury int */
insert into wizyty VALUES (null, 1, 
    TO_DATE ('8-01-19', 'DD-MM-RR'),
    'Dariusz Lewandowski', 'Ostry ból brzucha', 'K35.1', '88.7');
insert into wizyty VALUES (null, 2, 
    TO_DATE ('10-01-19', 'DD-MM-RR'),
    'Marek Dobry', 'Pobicie', 'S00.3', null);
insert into wizyty VALUES(null, 5, 
    TO_DATE ('19-01-19', 'DD-MM-RR'),
    'Dariusz Lewandowski', 'Silny ból ramienia po upadku na beton', 'S42.3', '88.21');

-- WYPISY
/*  fd_wizyty, data_wypisu, typ_wypisu, zalecenia varchar(200) */
insert into wypisy VALUES (1,  
    TO_DATE ('9-01-19', 'DD-MM-RR'),
    'przyjecie', null);
insert into wypisy VALUES (3,
     TO_DATE ('19-01-19', 'DD-MM-RR'),
     'zakonczenie', 'Gips bêdzie mo¿na zdj¹æ po 8 tygodniach');

commit;
