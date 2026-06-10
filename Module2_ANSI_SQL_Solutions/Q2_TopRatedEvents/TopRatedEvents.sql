-- Q2: Top Rated Events
-- Identify events with the highest average rating (at least 10 feedback submissions).

SELECT 
    e.event_id,
    e.title,
    COUNT(f.feedback_id) AS feedback_count,
    ROUND(AVG(f.rating), 2) AS avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;
