import tkinter as tk

class FormPage(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller

        tk.Label(self, text="Form Page").pack(pady=10)
        tk.Entry(self).pack(pady=5)
        tk.Button(self, text="Back", command=lambda: controller.show_frame("HomePage")).pack(pady=5)