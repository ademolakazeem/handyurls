INSERT INTO users
(id, name, number)
  SELECT 1 , 'Ademola Kazeem', 'ga67766776'
  WHERE
    NOT EXISTS (
        SELECT id FROM users WHERE id = 1 and number = 'ga67766776'
    );
