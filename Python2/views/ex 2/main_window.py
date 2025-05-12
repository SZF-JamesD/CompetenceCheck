import tkinter as tk
from tkinter import ttk
from views.tab_one import TabOne
from views.tab_two import TabTwo
from views.popup_window import PopupWindow

class MainWindow(ttk.Frame):
    def __init__(self, root, db, config, msgbox):
        super().__init__(root)
        self.pack(fill='both', expand=True)

        self.db = db
        self.config = config
        self.msgbox = msgbox

        self.notebook = ttk.Notebook(self)
        self.tab1 = TabOne(self.notebook, db, config, msgbox)
        self.tab2 = TabTwo(self.notebook, db, config, msgbox)

        self.notebook.add(self.tab1, text="Tab One")
        self.notebook.add(self.tab2, text="Tab Two")
        self.notebook.pack(expand=True, fill="both", padx=10, pady=10)

        btn_frame = ttk.Frame(self)
        btn_frame.pack(pady=10)

        ttk.Button(btn_frame, text="Open popup", command=self.open_popup).pack()

    def open_popup(self):
        PopupWindow(self.db, self.config, self.msgbox)