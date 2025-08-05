CREATE TABLE donor (
                       id SERIAL PRIMARY KEY,
                       full_name VARCHAR(100) NOT NULL
);

CREATE TABLE payment (
                         id SERIAL PRIMARY KEY,
                         amount_in_miaraka INTEGER NOT NULL,
                         payment_date TIMESTAMP NOT NULL
);

CREATE TABLE donation (
                          id SERIAL PRIMARY KEY,
                          donor_id INTEGER NOT NULL,
                          payment_id INTEGER NOT NULL,
                          FOREIGN KEY (donor_id) REFERENCES donor(id),
                          FOREIGN KEY (payment_id) REFERENCES payment(id)
);
