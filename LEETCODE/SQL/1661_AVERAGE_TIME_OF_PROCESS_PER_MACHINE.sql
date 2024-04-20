-- For each machine, we want to sum over the time to complete a process on a machine for all
-- processes running on that machine, and then take the average of the total time over the
-- number of processes running on that machine.

-- Choosing to mix between inline and block structures for my SQL codes. Whatever feels
-- more natural in the moment.

-- The general algorithm is that we generate a table in which the start and end times for
-- the same process running on the same machine are in the same row using a JOIN.
-- Then, we compute the average time each machine takes to complete a process aggregated over
-- all the process times for the given machine.

SELECT a1.machine_id, round(avg(a2.timestamp - a1.timestamp), 3) AS processing_time
FROM Activity a1
JOIN Activity a2
ON a1.machine_id = a2.machine_id
AND a1.process_id = a2.process_id
AND a1.activity_type = 'start'
AND a2.activity_type = 'end'
GROUP BY a1.machine_id;