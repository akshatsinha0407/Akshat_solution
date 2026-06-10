-- Q21: Top Feedback Providers
-- List top 5 users who have submitted the most feedback entries.

SELECT 
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    COUNT(f.feedback_id) AS total_feedbacks,
    ROUND(AVG(f.rating), 2) AS avg_rating_given
FROM Users u
JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name, u.email, u.city
ORDER BY total_feedbacks DESC
LIMIT 5;
