class SongController:
    def __init__(self, db):
        self.db = db

    def get_all_songs(self):
        a = self.db.fetch_all("Select * from get_songs")
        songs = {}
        for row in a:
            song_title = row["song_title"]
            chord = {
                "name": row["chord_name"],
                "position": row["chord_position"]
            }

            if song_title not in songs:
                songs[song_title] = {
                    "title": song_title,
                    "chords": []
                }
            songs[song_title]["chords"].append(chord)

        return songs
    
    
if __name__ == "__main__":
    from utils.db_handler import DatabaseHandler
    from utils.load_config import load_config
    from utils.messagebox_utils import MessageBoxHandler
    from models.song import Song
    config = load_config()   
    messagebox_handler = MessageBoxHandler()
    db = DatabaseHandler(**config["db"], messagebox_handler=messagebox_handler)
    sc = SongController(db)
  
    print(sc.get_all_songs())
    