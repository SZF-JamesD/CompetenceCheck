import tkinter as tk
from tkinter import ttk

class PopupWindow(tk.Toplevel):
    def __init__(self, db, config, msgbox):
        super().__init__()
        self.db = db
        self.config = config
        self.msgbox = msgbox

        self.title("Popup Window")
        self.geometry("300x200")

        ttk.Label(self, text="This popup is here").pack(pady=10)
        ttk.Button(self, text="Close", command=self.destroy).pack()