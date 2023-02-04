CREATE VIEW statistics_view as
SELECT st.*, m.nickname member,s.name song from member m JOIN song s ON m.id = s.id JOIN statistics st ON st.song_id=s.id;