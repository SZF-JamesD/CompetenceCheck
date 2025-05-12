import tkinter as tk
from utils.db_handler import DatabaseHandler
from utils.load_config import load_config
from utils.messagebox_utils import MessageBoxHandler
from controllers.song_controller import SongController
from app_example import App

def main():
    root = tk.Tk()

    config = load_config()
    db = DatabaseHandler(**config["db"])
    messagebox_handler = MessageBoxHandler()
    quiz_controller = SongController(db)

    app = App(
        root=root,
        db=db,
        messagebox_handler=messagebox_handler,
        quiz_controller=quiz_controller
    )

    root.mainloop()
    db.close()

if __name__ == "__main__":
    main()