-- Dummy records for DelfineDB
USE delfinendb;

-- ----------------------------------------------------------------------
-- Insert dummy records in tables `user`, `userdisciplines` and `result`
-- ----------------------------------------------------------------------
LOCK TABLES user WRITE;
INSERT INTO user (name,surname,adresse,zip,town,email,phone,age,startDate,payDate,subscription,active,activityFormID,rolleID) VALUES ('Niels','Holm','Industrivænget 2, 2 tv','9000','Aalborg','niels@holm.dk','98254523','35','2008-7-04','2019-2-27','1600','1','2','1'),
																												   ('Adam','Jakobsen','Hagagata 24','0653','Olso','adam@jakobsen.no','98474235','27','2010-4-12','2019-4-12','1600','1','2','2'),
                                                                                                                   ('Tove','Andreasen','Soegade 33, 2 tv','9000','Aalborg','tove@andreasen.dk','64534563','25','2011-8-23','2019-3-12','1600','1','2','3'),
                                                                                                                   ('Bettina','Christiansen','Svinget 17','9000','Aalborg','bettina@christensen.dk','98765123','18','2014-10-03','2019-1-23','1600','1','2','4'),
                                                                                                                   ('Karin','Henriksen','Industrivænget 2, st th','9000','Aalborg','karin@henriksen.dk','23984745','19','2013-3-12','2018-11-03','1600','1','2','4'),
                                                                                                                   ('Arne','Henriksen','Skovvej 77A','6800','Varde','arne@henriksen.dk','64782947','34','2016-9-03','2019-6-08','1600','1','1','4'),
                                                                                                                   ('Tage','Olsen','Boulevarden 14','6800','Varde','tage@olsen.dk','93745098','17','2017-2-24','2018-11-23','1000','1','1','4'),
                                                                                                                   ('Christian','Svanholm','Industrivænget 2, 2 th','9000','Aalborg','christian@svanholm.dk','28456876','23','2009-11-02','2019-5-21','500','2','1','4');
UNLOCK TABLES;

LOCK TABLES userdisciplines WRITE;
INSERT INTO userdisciplines (userID,disciplinesID) VALUES ('1','1'),
														  ('1','2'),
                                                          ('2','1'),
                                                          ('2','2'),
                                                          ('2','3'),
                                                          ('2','4'),
                                                          ('3','4'),
                                                          ('4','2'),
                                                          ('4','3'),
                                                          ('4','4'),
                                                          ('5','1'),
                                                          ('5','2'),
                                                          ('5','4'),
                                                          ('6','1'),
                                                          ('6','2'),
                                                          ('7','2'),
                                                          ('7','4'),
                                                          ('8','4');
UNLOCK TABLES;

LOCK TABLES results WRITE;
INSERT INTO results (disciplinesID,userID,time,date,event) VALUES ('2','4','1:00.78','2018-4-02','100m fri'),
																  ('3','4','1:08.22','2018-6-21','100m ryg'),
                                                                  ('2','5','1:55.19','2019-2-02','200m fri'),
                                                                  ('4','5','1:02.09','2019-2-02','100m bryst'),
                                                                  ('1','6','1:12.34','2018-9-18','100m traening');
UNLOCK TABLES;