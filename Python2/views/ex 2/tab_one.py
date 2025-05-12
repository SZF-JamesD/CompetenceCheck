from tkinter import ttk

class TabOne(ttk.Frame):
    def __init__(self, parent, db, config, msgbox):
        super().__init__(parent)
        self.db = db
        self.config = config
        self.msgbox = msgbox

        ttk.Label(self, text="Tab One").pack(pady=10)