import tkinter as tk

class ListPage(tk.Frame):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller

        tk.Label(self, text="List Page").pack(pady=10)
        tk.Listbox(self).pack(pady=5)

        users = self.user_controller.get_all_users()
        for user in users:
            tk.Label(self, text=user["pet_name"]).pack()

        tk.Button(self, text="Back", command=lambda: controller.show_frame("HomePage")).pack(pady=5)