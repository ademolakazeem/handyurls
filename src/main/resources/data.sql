INSERT INTO users
(id, name, nnumber)
  SELECT 1 , 'Ademola Kazeem', 'n0304267'
  WHERE
    NOT EXISTS (
        SELECT id FROM users WHERE id = 1 and nnumber = 'n0304267'
    );