CREATE TABLE IF NOT EXISTS statistics_member(
    id SERIAL,
    member_id INT NOT NULL,
    statistics_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(member_id) REFERENCES member(id),
    FOREIGN KEY(statistics_id) REFERENCES statistics(id)
)