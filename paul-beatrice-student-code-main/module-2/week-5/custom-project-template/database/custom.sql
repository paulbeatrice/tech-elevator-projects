-- Database: Custom
--
-- Contains tables for viewing products on the Solar System Geek site, 
-- and for placing an order.

-- DROP TABLE IF EXISTS line_item;

--CREATE TABLE line_item (
--	line_item_id serial,
--	sale_id INT NOT NULL,
--	product_id INT NOT NULL,
--	quantity INT NOT NULL,
--	CONSTRAINT PK_line_item PRIMARY KEY (line_item_id),
--	CONSTRAINT FK_line_item_sale FOREIGN KEY(sale_id) REFERENCES sale(sale_id),
--	CONSTRAINT FK_line_item_product FOREIGN KEY(product_id) REFERENCES product(product_id)
--);

-- INSERT INTO line_item (sale_id, product_id, quantity) VALUES
-- 1
--  (1, 1, 10),
-- ...

