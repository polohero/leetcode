DECLARE @global_avg INT;

SELECT @global_avg = AVG(duration) FROM Calls;


SELECT name as country
  FROM (
SELECT country.name, c.duration
  FROM Calls c
 INNER JOIN
       (
         SELECT id, name, SUBSTRING(phone_number, 1, 3) as country
          FROM Person
       ) p
    ON p.id =    caller_id
 INNER JOIN Country country
    ON country.country_code = p.country
   
UNION ALL

SELECT country.name, c.duration
  FROM Calls c
 INNER JOIN 
       (
         SELECT id, name, SUBSTRING(phone_number, 1, 3) as country
          FROM Person
       ) p
    ON p.id = c.callee_id 
 INNER JOIN Country country
    ON country.country_code = p.country
       ) a
   GROUP BY name
  HAVING AVG(duration) > @global_avg;
