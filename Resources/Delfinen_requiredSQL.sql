-- Required SQL for DelfinenDB
USE delfinendb;

-- ----------------------------------------------------------------------------------------------
-- Insert static records to tables in `rolle`, `disciplines`, `subscription` and `activityform`
-- ----------------------------------------------------------------------------------------------
LOCK TABLES rolle WRITE;
INSERT INTO rolle (rolleName) VALUES ('President'),
									 ('Coach'),
                                     ('accountant'),
                                     ('Member');
UNLOCK TABLES;

LOCK TABLES disciplines WRITE;
INSERT INTO disciplines (discipline) VALUES ('butterfly'),
											('crawl'),
                                            ('rygcrawl'),
                                            ('brystsvoemning');
UNLOCK TABLES;

LOCK TABLES subscription WRITE;
INSERT INTO subscription (subscriptionName,subscriptionPrice) VALUES ('Junior svoemmer','1000'),
																	 ('Senior svoemmer','1600'),
                                                                     ('Passiv medlem','500');
UNLOCK TABLES;

UNLOCK TABLES;
INSERT INTO activityform (activityForm) VALUES ('motionist'),
											   ('konkurrencesvoemmer');
UNLOCK TABLES;
