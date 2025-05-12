import tkinter as tk

class BaseView(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        self.db = controller.db
        self.msgbox = controller.messagebox_handler
        self.quiz_controller = controller.quiz_controller

    def navigate(self, page):
        self.controller.show_frame(page)

        
    def go_home(self):
        self.controller.show_frame("HomePage")

    def show_message(self, text):
        tk.Label(self, text=text).pack()