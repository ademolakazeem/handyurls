INSERT INTO users
(id, name, nnumber)
  SELECT 1 , 'Ademola Kazeem', 'ga67766776'
  WHERE
    NOT EXISTS (
        SELECT id FROM users WHERE id = 1 and nnumber = 'ga67766776'
    );
