CREATE TABLE IF NOT EXISTS statistics(
    id SERIAL,
    date DATE NOT NULL,
    score INT NOT NULL,
    PRIMARY KEY(id)
)