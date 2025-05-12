import tkinter as tk
from utils.db_handler import DatabaseHandler
from utils.load_config import load_config
from utils.messagebox_utils import MessageBoxHandler
from controllers.song_controller import SongController
from views.main_view import MainView

def main():
    root = tk.Tk()
    root.title("Easy Chords")
    root.geometry("800x600")
    root.config(bg="#ECEBDE")
    root.resizable=False

    config = load_config()   
    messagebox_handler = MessageBoxHandler()
    db = DatabaseHandler(**config["db"], messagebox_handler=messagebox_handler)
    song_controller = SongController(db)

    MainView(root, db, config, song_controller, messagebox_handler)

    root.mainloop()
    db.close()

if __name__ == "__main__":
    main()
