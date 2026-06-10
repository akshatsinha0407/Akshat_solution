-- Q17: Multi-Session Speakers
-- Identify speakers who are handling more than one session across all events.

SELECT 
    s.speaker_name,
    COUNT(s.session_id) AS total_sessions,
    GROUP_CONCAT(DISTINCT e.title ORDER BY e.title SEPARATOR ', ') AS events
FROM Sessions s
JOIN Events e ON s.event_id = e.event_id
GROUP BY s.speaker_name
HAVING COUNT(s.session_id) > 1
ORDER BY total_sessions DESC;
