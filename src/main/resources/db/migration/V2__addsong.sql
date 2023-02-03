CREATE TABLE IF NOT EXISTS song(
    id SERIAL,
    name VARCHAR(25) NOT NULL,
    genre VARCHAR (15) NOT NULL,
    member_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (member_id) REFERENCES member(id)
)