CREATE TABLE IF NOT EXISTS song_member(
    id SERIAL,
    song_id INT NOT NULL,
    member_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(song_id) REFERENCES song(id),
    FOREIGN KEY(member_id) REFERENCES member(id)

    )