1 SELECT store_name FROM store_table

2 SELECT  * FROM store_table ORDER BY store_nameabc ASC

3 SELECT store_name,quantity,goods_name
FROM stock_table
JOIN store_table
ON stock_table.store_code = store_table.store_code
JOIN goods_table
ON stock_table.goods_code = goods_table.goods_code;

４ELECT AVG(price) FROM goods_table

５SELECT store_code
FROM stock_table
WHERE store_code='EA01' 
AND quantity > (SELECT AVG(quantity)FROM stock_table)

６INSERT INTO "goods_table"
(goods_code,goods_name,price,update_day)
VALUES
('M001','マフラー','4500','2020-03-22');

7 UPDATE "stock_table"
SET 
quantity = '10',
update_day = '2020-03-22'
WHERE goods_code='S987' AND store_code='EA01';

8 DELETE FROM stock_table 
WHERE goods_code='S987' AND store_code='EA01';