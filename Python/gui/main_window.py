import tkinter as tk
from tkinter import ttk
from utils.tkinter_utils import *
from utils.data_utils import DatabaseHandler
from gui.tabs.home_tab import HomeTab as home
from gui.tabs.statistics_tab import StatisticsTab as stats
from gui.tabs.lesson_tab import LessonTab as lesson


class LanguageLearningApp(NotebookBasedGui):
    def __init__(self, root, title="Lingua Learn", geometry="800x600", resizable=(False, False)):
        super().__init__(root, title, geometry, resizable)

        self.db_handler = DatabaseHandler(host="localhost", user="root", password="", database="language_learning")
        self.home_tab = home
        self.stats_tab = stats
        self.first_launch()
        self.add_frames([
            home,
            lesson,
            stats           
        ])

    def first_launch(self):
        result1 = self.db_handler.fetch_all("""select * from learned limit 1""")
        if not result1:
            result2 = self.db_handler.fetch_all("""select * from not_learned limit 1""")
            if not result2:
                self.db_handler.read_json_to_db("data/vokabeln.json")

    def launch_main_window():
        root = tk.Tk()
        app = LanguageLearningApp(root)
        app.run()