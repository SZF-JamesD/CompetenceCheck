from tkinter import ttk
from utils.tkinter_utils import *

class StatisticsTab(ttk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller