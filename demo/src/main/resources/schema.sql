CREATE TABLE car_dealership (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    branch VARCHAR(255) NOT NULL,
    applicant VARCHAR(255) NOT NULL,
    UNIQUE (brand, branch, applicant)
);
