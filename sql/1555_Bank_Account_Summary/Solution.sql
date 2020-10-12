SELECT user_id
      ,user_name
      ,credit
      ,CASE WHEN credit <= 0 THEN 'Yes' ELSE 'No' END AS credit_limit_breached
  FROM (
        SELECT u.user_id
              ,u.user_name
              ,u.credit + IFNULL(paidTo.amount, 0) - IFNULL(paidBy.amount, 0)  AS credit
          FROM Users u
          LEFT OUTER JOIN  
            (
                SELECT paid_to, SUM(IFNULL(t.amount, 0)) as amount
                  FROM Transactions t
                 GROUP BY t.paid_to
            ) paidTo
            ON paidTo.paid_to = u.user_id
          LEFT OUTER JOIN 
           (
                SELECT paid_by, SUM(IFNULL(t.amount, 0))  as amount
                  FROM Transactions t
                 GROUP BY t.paid_by
           ) paidBy
            ON paidBy.paid_by = u.user_id
      ) result
