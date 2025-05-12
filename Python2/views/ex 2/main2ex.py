import tkinter as tk
from utils.messagebox_utils import MessageBoxHandler
from utils.db_handler import DatabaseHandler
from utils.load_config import load_config
from views.main_window import MainWindow

def main():
    root = tk.Tk()
    root.title("App Name")
    root.geometry("800x600")

    config = load_config()
    db_config = config.get("db", {})

    messagebox_handler = MessageBoxHandler()
    db = DatabaseHandler(
        host=db_config.get("host"),
        user=db_config.get("user"),
        password=db_config.get("password"),
        database=db_config.get("database"),
        messagebox_handler=messagebox_handler
    )

    MainWindow(root, db, config, messagebox_handler)

    root.mainloop()
    db.close()

if __name__ == "__main__":
    main()