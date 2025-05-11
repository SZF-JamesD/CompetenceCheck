from tkinter import messagebox

class MessageBoxHandler:

    def show_error(title, message):
        messagebox.showerror(title, message)

    def show_warning(title, message):
        messagebox.showwarning(title, message)

    def show_info(title, message):
        messagebox.showinfo(title, message)