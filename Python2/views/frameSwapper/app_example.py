import tkinter as tk
from home_page import HomePage
from quiz_page import QuizPage

class App(tk.Tk):
    def __init__(self, root, db, messagebox_handler, user_controller):
        super().__init__()

        self.db = db
        self.messagebox_handler = messagebox_handler
        self.quiz_controller = user_controller

        self.title("Exam app")
        self.geometry("600x400")

        self.frames = {}
        container = tk.Frame(self)
        container.pack(fill="both", expand=True)

        for PageClass in (HomePage, QuizPage):
            page = PageClass(container, self)
            self.frames[PageClass.__name__] = page
            page.grid(row=0, column=0, sticky="nsew")

        self.show_frame("HomePage")

    def show_frame(self, name):
        frame = self.frames[name]
        frame.tkraise()