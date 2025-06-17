BEGIN TRANSACTION;
-- Insert products without explicit id values
INSERT INTO Product (name, description) VALUES 
  ('Head First Design Patterns', 'A brain friendly guide to building extensible and maintainable object-oriented software.');

INSERT INTO Product (name, description) VALUES 
  ('Head First Java', 'A brain friendly guide to object-oriented programming in Java.');

INSERT INTO Product (name, description) VALUES 
  ('Head First C#', 'A brain friendly guide to object-oriented programming in C#.');

INSERT INTO Product (name, description) VALUES 
  ('Head First Python', 'A brain friendly guide to the fundamentals of Python programming.');

INSERT INTO Product (name, description) VALUES 
  ('Head First PMP', 'A brain friendly companion to passing the Project Management Professional exam.');

-- Insert reviews for product id=1
INSERT INTO Review (product_id, reviewer, title, review, rating, favorited) VALUES
  (1, 'R Pérez', 'Approachable pattern guide', 'I love the uncomplicated, informal narrative style. I highly recommend this text for anyone trying to understand Design Patterns in a super simple way.', 4, false);

INSERT INTO Review (product_id, reviewer, title, review, rating, favorited) VALUES
  (1, 'Carmen', 'Pattern complexity gone!', 'I struggled for years to understand patterns and how to implement the design and how them. This is by far the best book to learn design patterns. I would give this 10 stars if I could.', 5, false);

INSERT INTO Review (product_id, reviewer, title, review, rating, favorited) VALUES
  (1, 'J. King', 'Not for me', 'The content is thorough and well described. However, the format just doesn''t work for me. I need something more traditional.', 1, false);

INSERT INTO Review (product_id, reviewer, title, review, rating, favorited) VALUES
  (1, 'Safa H.', 'Good for beginners', 'Good introduction to design patterns especially if you have never used them before or are relatively new to OO principles.', 3, false);

INSERT INTO Review (product_id, reviewer, title, review, rating, favorited) VALUES
  (1, 'L Wang', 'Entertaining', 'If you are new to design patterns I HIGHLY recommend this book. You might think it''s not "serious enough" at first. But as you go through it things just stick. It makes learning enjoyable.', 4, false);


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;
