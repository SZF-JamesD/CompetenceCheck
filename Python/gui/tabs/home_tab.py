import tkinter as tk
from tkinter import ttk
from utils.tkinter_utils import *
from gui.windows.learning_unit_window import LearningUnitWindow
#from controllers.data_manager import load_learned, load_unleared

class HomeTab(ttk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        #learned = load_learned()
        #unlearned = load_unleared()
        def new_lesson():
            LearningUnitWindow(master=parent)
        
        #prog_percent = (len(learned)/(len(learned) + len(unlearned)))*100
        #overview = ttk.Label(parent, text=f"Overall progress: {prog_percent}") 
        #overview.pack()


        Buttons(
            2, 
            (self, self), 
            ("New Lesson", "Reset All Progress"), 
            (new_lesson, lambda: print("Reset Progress")), 
            ("left", "left"), 
            ("n", "n"), 
            (5, 5), 
            (5, 5)
        )
        
        
