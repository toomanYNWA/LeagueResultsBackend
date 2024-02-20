INSERT INTO city (name, country) VALUES ('Liverpool', 'UK');
INSERT INTO city (name, country) VALUES ('London', 'UK');
INSERT INTO city (name, country) VALUES ('Nottingham', 'UK');
INSERT INTO city (name, country) VALUES ('Birmingham', 'UK');
INSERT INTO city (name, country) VALUES ('Leeds', 'UK');
INSERT INTO city (name, country) VALUES ('Manchester', 'UK');
INSERT INTO city (name, country) VALUES ('Leicester', 'UK');
INSERT INTO city (name, country) VALUES ('Newcastle', 'UK');
INSERT INTO city (name, country) VALUES ('Southampton', 'UK');
INSERT INTO city (name, country) VALUES ('Sheffield', 'UK');
INSERT INTO city (name, country) VALUES ('Bournemouth', 'UK');
INSERT INTO city (name, country) VALUES ('Brighton', 'UK');
INSERT INTO city (name, country) VALUES ('Wolverhampton', 'UK');
INSERT INTO city (name, country) VALUES ('West Bromwich', 'UK');
INSERT INTO city (name, country) VALUES ('Luton', 'UK');
INSERT INTO city (name, country) VALUES ('Brentford', 'UK');
INSERT INTO city (name, country) VALUES ('Burnley', 'UK');
INSERT INTO city (name, country) VALUES ('Norwich', 'UK');
INSERT INTO city (name, country) VALUES ('Watford', 'UK');

INSERT INTO stadium (capacity,fk_city_id,name) VALUES (30750, 12, 'Amex Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (61074, 1, 'Anfield');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (33000, 10, 'Bramall Lane');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (17250, 16, 'Gtech Community Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (30602, 3, 'City Ground');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (25700, 2, 'Craven Cottage');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (60704, 2, 'Emirates Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (55097, 6, 'Etihad Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (40157, 1, 'Goodison Park');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (10356, 15, 'Kenilworth Road');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (62500, 2, 'London Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (31700, 13, 'Molineux Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (74140, 6, 'Old Trafford');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (26255, 2, 'Selhurst Park');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (52409, 8, 'St James'' Park');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (41837, 2, 'Stamford Bridge');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (62062, 2, 'Tottenham Hotspur Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (21944, 17, 'Turf Moor');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (42788, 4, 'Villa Park');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (11464, 11, 'Vitality Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (26688, 14, 'The Hawthorns');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (32261, 7, 'King Power Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (37890, 5, 'Elland Road');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (32384, 9, 'St Mary''s Stadium');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (27244, 18, 'Carrow Road');
INSERT INTO stadium (capacity,fk_city_id,name) VALUES (21577, 19, 'Vicarage Road');

INSERT INTO league(name, season) VALUES ('Premiere League','23/24');
INSERT INTO league(name, season) VALUES ('Premiere League','22/23');
INSERT INTO league(name, season) VALUES ('Premiere League','21/22');
INSERT INTO league(name, season) VALUES ('Premiere League','20/21');
INSERT INTO league(name, season) VALUES ('Premiere League','19/20');

INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Liverpool', 1892, 2, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Brighton & Hove Albion', 1901, 1, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Sheffield United', 1889, 3, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Brentford', 1889, 4, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Nottingham Forest', 1865, 5, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Fulham', 1879, 6, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Arsenal', 1886, 7, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Manchester City', 1894, 8, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Everton', 1878, 9, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Luton Town', 1885, 10, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('West Ham United', 1895, 11, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Wolverhampton Wanderers', 1877, 12, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Manchester United', 1878, 13, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Crystal Palace', 1861, 14, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Newcastle United', 1895, 15, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Chelsea', 1905, 16, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Tottenham Hotspur', 1882, 17, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Burnley', 1882, 18, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Aston Villa', 1874, 19, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Bournemouth', 1899, 20, true);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('West Bromwich Albion', 1878, 21, false);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Leicester City', 1884, 22, false);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Leeds United', 1919, 23, false);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Southampton', 1885, 24, false);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Norwich', 1902, 25, false);
INSERT INTO club(name, year_of_establishment,fk_st_id,in_first_league) VALUES('Watford', 1881, 26, false);









