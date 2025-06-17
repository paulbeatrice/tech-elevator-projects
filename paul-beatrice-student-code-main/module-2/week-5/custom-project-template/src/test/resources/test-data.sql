BEGIN TRANSACTION;

-- DROP TABLE IF EXISTS line_item;

-- CREATE TABLE line_item (
-- 	line_item_id serial,
--	sale_id INT NOT NULL,
--	product_id INT NOT NULL,
--	quantity INT NOT NULL,
--	CONSTRAINT PK_line_item PRIMARY KEY (line_item_id),
--	CONSTRAINT FK_line_item_sale FOREIGN KEY(sale_id) REFERENCES sale(sale_id),
--	CONSTRAINT FK_line_item_product FOREIGN KEY(product_id) REFERENCES product(product_id)
--);

-- Insert test data

--INSERT INTO line_item (	sale_id, product_id, quantity)
--VALUES
-- (1, 1, 1),
-- (1, 2, 1),
-- (1, 4, 1),
-- (2, 4, 10),
-- (2, 1, 10),
-- (3, 1, 100);

COMMIT;
