-- Q6: Event Resource Summary
-- Generate a report showing the number of resources (PDFs, images, links) uploaded for each event.

SELECT 
    e.event_id,
    e.title AS event_title,
    COUNT(CASE WHEN r.resource_type = 'pdf' THEN 1 END) AS pdf_count,
    COUNT(CASE WHEN r.resource_type = 'image' THEN 1 END) AS image_count,
    COUNT(CASE WHEN r.resource_type = 'link' THEN 1 END) AS link_count,
    COUNT(r.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_resources DESC;
