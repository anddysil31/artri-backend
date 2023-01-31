CREATE TABLE IF NOT EXISTS song_statistics(
    id SERIAL,
    song_id INT NOT NULL,
    statistics_song INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(song_id) REFERENCES song(id),
    FOREIGN KEY(statistics_song) REFERENCES statistics(id)
)