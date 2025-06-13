CREATE TABLE IF NOT EXISTS students (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    group_name VARCHAR(50) NOT NULL,
    enrollment_date TIMESTAMP WITH TIME ZONE NOT NULL
);