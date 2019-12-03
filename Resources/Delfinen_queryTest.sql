-- MySQL test queryes for DelfinenDB

-- ----------------------------------
-- queryes for single tables 
-- ----------------------------------
SELECT * FROM rolle;
SELECT * FROM disciplines;
SELECT * FROM subscription;
SELECT * FROM activityform;
SELECT * FROM user;
SELECT * FROM userdisciplines;
SELECT * FROM results;

-- -----------------------------------------------
-- all users with disciplines order by rolleID 
-- -----------------------------------------------
SELECT user.name,user.surname,rolle.rolleID,rolle.rolleName,activityform.activityForm,GROUP_CONCAT(disciplines.discipline) as disciplin FROM user
INNER JOIN rolle on user.rolleID = rolle.rolleID
INNER JOIN activityform on user.activityFormID = activityform.activityFormID
INNER JOIN userdisciplines on user.userID = userdisciplines.userID
INNER JOIN disciplines on userdisciplines.disciplinesID = disciplines.disciplinesID
GROUP BY user.name
ORDER BY rolle.rolleID;

-- ----------------------------
-- one user with disciplines
-- ----------------------------
SELECT user.name,user.surname,rolle.rolleName,activityform.activityForm,GROUP_CONCAT(disciplines.discipline) as disciplin FROM user
INNER JOIN rolle on user.rolleID = rolle.rolleID
INNER JOIN activityform on user.activityFormID = activityform.activityFormID
INNER JOIN userdisciplines on user.userID = userdisciplines.userID
INNER JOIN disciplines on userdisciplines.disciplinesID = disciplines.disciplinesID
WHERE user.userID = 5
GROUP BY user.name;

-- -----------------------------
-- users who is in restance
-- -----------------------------
SELECT user.name,user.surname,user.adresse,user.zip,user.town,user.phone,user.email,user.payDate,user.subscription FROM user
WHERE date_add(current_date(), INTERVAL -1 YEAR) > user.payDate;
