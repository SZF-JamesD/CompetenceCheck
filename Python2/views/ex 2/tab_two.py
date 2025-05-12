from tkinter import ttk

class TabTwo(ttk.Frame):
    def __init__(self, parent, db, config, msgbox):
        super().__init__(parent)
        self.db = db
        self.config = config
        self.msgbox = msgbox

        ttk.Label(self, text="Tab Two").pack(pady=10)