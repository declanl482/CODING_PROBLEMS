-- The idea is that we want to find the total amount that a customer spends
-- during a single visit across all their transactions during that said visit. If the
-- amount is 0, then we nullify it, otherwise we record the total amount spent during
-- that visit.

-- Then, we want to join the table containing the total amount spent per visit into
-- the table of visits so that for each customer, we can count the number of visits where
-- no transactions were made (they spent an amount of 0 during that visit), grouping by the
-- ID of the customer.

WITH TransactionTotal AS (
    SELECT
        Transactions.visit_id AS visit_id,
        CASE
            WHEN COALESCE(SUM(Transactions.amount), 0) = 0 THEN NULL
            ELSE COALESCE(SUM(Transactions.amount), 0)
        END AS total_amount
    FROM
        Transactions
    GROUP BY
        Transactions.visit_id
)
SELECT
    Visits.customer_id AS customer_id,
    COUNT(Visits.visit_id) AS count_no_trans
FROM
    Visits
LEFT JOIN
    TransactionTotal ON TransactionTotal.visit_id = Visits.visit_id
WHERE
    TransactionTotal.total_amount is NULL
GROUP BY
    Visits.customer_id;
