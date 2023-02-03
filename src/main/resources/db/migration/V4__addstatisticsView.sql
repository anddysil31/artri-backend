CREATE VIEW statistics_view as
SELECT m.nickname,s.name,st.date,score from member m JOIN song s ON m.id = s.id JOIN statistics st ON st.song_id=s.id;