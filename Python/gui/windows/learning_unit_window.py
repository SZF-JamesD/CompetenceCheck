from tkinter import *
from tkinter import ttk
from utils.tkinter_utils import *
from  controllers.lesson_controller import LessonController

class LearningUnitWindow(Toplevel):
    def __init__(self, master=None):
        super().__init__(master)
        self.title("Lesson")
        self.geometry("800x600")

        ttk.Label(self, text="Welcome to a new lesson!").pack(pady=20)

        self.grab_set()
        self.transient(master)
        self.wait_window(self)

        test(self)

        def test(self):
            word_choice = LessonController.word_selector()
            print(word_choice)

    def close_window(self):
        self.close_window()
