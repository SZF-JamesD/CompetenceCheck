import tkinter as tk
from tkinter import ttk
from utils.tkinter_utils import *
from controllers.lesson_controller import LessonController

class LessonTab(ttk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller

        ttk.Label(self, text="Welcome to a new lesson!").pack(pady=20)

        #create_test(self)

        def create_test(self):
            word_choice = LessonController.word_selector()
            print(word_choice)

        

    def close_window(self):
        self.close_window()