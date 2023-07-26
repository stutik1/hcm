--CREATE TABLE
CREATE TABLE table_name(
    column1 datatype,
    column2 datatype,
    column3 datatype,
   ....
);

--INSERT COMMAND

-- DROP DATABASE
DROP DATABASE database_name;

--DROP TABLE
DROP TABLE table_name;


--GET Call
SELECT * from employee where id=1;

SELECT * from employee where id=1 and deleted=false;

--PUT Call
UPDATE employee
SET first_name = ?, last_name = ?, position = ?
WHERE id = ?

--delete call/DELETE
DELETE FROM employee WHERE id = 1;

UPDATE employee
SET deleted=true
WHERE id = 1;

--Create Call/POST
INSERT
INTO employee
(first_name, last_name, position)
VALUES (?, ?, ?)

--ALTER TABLE
ALTER TABLE table_name
ADD column_name datatype;

--example...
ALTER TABLE employee
ADD COLUMN deleted boolean DEFAULT true;

--to update all the record(row)
UPDATE employee
SET isdelete = false ;

UPDATE employee
SET isdelete = true
where id=12;