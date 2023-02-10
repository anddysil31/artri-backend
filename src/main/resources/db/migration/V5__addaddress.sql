CREATE TABLE IF NOT EXISTS address(
    id SERIAL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR (100) NOT NULL,
    member_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (member_id) REFERENCES member(id)
)