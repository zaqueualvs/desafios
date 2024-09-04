CREATE TABLE customer
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(50),
    gender     TINYINT,
    date_birth TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,

    PRIMARY KEY (id)
);

CREATE TABLE health_problem
(
    id   BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40),
    type TINYINT,

    PRIMARY KEY (id)
);

CREATE TABLE customer_health_problem
(
    customer_id       BIGINT NOT NULL AUTO_INCREMENT,
    health_problem_id BIGINT NOT NULL AUTO_INCREMENT,

    CONSTRAINT fk_customer_health_problem_customer
        FOREIGN KEY (customer_id)
            REFERENCES customer (id),
    CONSTRAINT fk_customer_health_problem_health_problem
        FOREIGN KEY (health_problem_id)
            REFERENCES customer (id)
);