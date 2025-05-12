import tkinter as tk

class HomePage(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller

        tk.Label(self, text="Home Page", font=("Arial", 18)).pack(pady=20)

        tk.Button(self, text="Go to Form", command=lambda: controller.show_frame("FormPage")).pack(pady=5)
        tk.Button(self, text="Go to List", command=lambda: controller.show_frame("ListPage")).pack(pady=5)