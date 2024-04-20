
-- Generate a table containing all possible combinations of students and subjects using a
-- CROSS JOIN. Also, generate a CTE for an examination log, which contains columns for the
-- student ID, the examination subject, and a count for the number of each type of examination
-- subject attended by the student.

-- Peform a LEFT JOIN of the examination log table onto the cartesian joined table to generate
-- a column for the exam attendance counts (per student, per subject). Then finally, order the
-- rows by student ID and subject name, both in ascending order.


WITH ExaminationLog AS (
    SELECT
        student_id,
        subject_name,
        COUNT(*) AS attended_exams
    FROM
        Examinations
    GROUP BY
        student_id, subject_name
)
SELECT
    stu.student_id,
    stu.student_name,
    sub.subject_name,
    COALESCE(exlog.attended_exams, 0) AS attended_exams
FROM
    Students stu
CROSS JOIN
    Subjects sub
LEFT JOIN
    ExaminationLog exlog ON stu.student_id = exlog.student_id
    AND sub.subject_name = exlog.subject_name
ORDER BY
    stu.student_id ASC,
    sub.subject_name ASC;