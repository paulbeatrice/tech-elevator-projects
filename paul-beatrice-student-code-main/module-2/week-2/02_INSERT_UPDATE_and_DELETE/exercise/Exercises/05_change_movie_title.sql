-- 5. The movie "Star Wars" was originally released by that name because it wasn't known if there would be a sequel. After the subsequent
--    movies came out, it was retroactively re-titled "Star Wars: A New Hope".
--    Write an UPDATE query to change the title in the movie table to "Star Wars: A New Hope" (1 row)

UPDATE movie
SET title = 'Star Wars: A New Hope'
WHERE title = 'Star Wars';