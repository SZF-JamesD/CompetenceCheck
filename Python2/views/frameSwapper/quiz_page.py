import tkinter as tk
from base_view import BaseView

class QuizPage(BaseView):
    def __init__(self, parent, controller):
        super().__init__(parent, controller)

        self.question_index = 0
        self.questions = [
            {"q": "Capital of France?", "a": "Paris"},
            {"q": "2 + 2", "a": "4"},
        ]

        self.label = tk.Label(self, text="", font=("Arial", 16))
        self.label.pack(pady=10)

        self.entry = tk.Entry(self)
        self.entry.pack()

        self.submit_btn = tk.Button(self, text="Submit", command=self.check_answer)
        self.submit_btn.pack(pady=5)

        self.feedback = tk.Label(self, text="", fg="green")
        self.feedback.pack()

        self.load_question()

    def load_question(self):
        if self.question_index >= len(self.questions):
            self.label.config(text="Quiz Finished!")
            self.entry.pack_forget()
            self.submit_btn.pack_forget()
            return
        
        question = self.questions[self.question_index]["q"]
        self.label.config(text=question)
        self.entry.delete(0, tk.END)
        self.feedback.config(text="")

    
    def check_answer(self):
        user_answer = self.entry.get().strip()
        correct_answer = self.questions[self.question_index]["a"]

        if user_answer.lower() == correct_answer.lower():
            self.feedback.config(text="Correct!", fg="green")
        else:
            self.feedback.config(text=f"Wrong! It was {correct_answer}", fg="red")

        self.question_index += 1
        self.after(1000, self.load_question)