CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    CURSOR savings_cursor IS
        SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings';
BEGIN
    FOR acc_rec IN savings_cursor LOOP
        UPDATE Accounts
        SET Balance = acc_rec.Balance + (acc_rec.Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;
    END LOOP;

    COMMIT;
END;
/
