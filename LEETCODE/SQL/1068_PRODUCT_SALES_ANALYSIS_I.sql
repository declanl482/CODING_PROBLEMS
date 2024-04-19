-- Solution using an INNER JOIN.

SELECT
    Product.product_name AS product_name,
    Sales.year AS year,
    Sales.price AS price
FROM
    Sales
INNER JOIN
    Product ON Sales.product_id = Product.product_id;

-- Solution using a Common Table Expression (CTE).

WITH SaleInformation AS (
    SELECT
        Product.product_name,
        Sales.year,
        Sales.price
    FROM
        Sales
    INNER JOIN
        Product ON Sales.product_id = Product.product_id
)
SELECT
    product_name,
    year,
    price
FROM
    SaleInformation;