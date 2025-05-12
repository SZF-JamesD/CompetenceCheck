import tkinter as tk
from tkinter import ttk
from controllers.chord_creator import ChordCreator

class MainView(tk.Frame):
    def __init__(self, root, db, config, song_controller, msgbox ):
        super().__init__(root)
        self.root = root
        self.db = db
        self.config = config
        self.song_controller = song_controller
        self.msgbox = msgbox
        self.chord_creator = ChordCreator
        
        self.songs = self.song_controller.get_all_songs()

        tk.Label(root, text="Select a song", font=("Arial", 10), bg="#ECEBDE").pack(anchor='nw', padx=5, pady=2)


        self.song_dropdown = ttk.Combobox(root, state="readonly",  width=25)
        self.song_dropdown['values'] = list(self.songs.keys())
        self.song_dropdown.pack(anchor='nw', padx=5, pady=2)
        self.song_dropdown.bind("<<ComboboxSelected>>", self.on_song_selected)
        tk.Label(root, text="Chord Progression", bg="#ECEBDE",font=("Arial", 18)).pack(anchor='n',pady=(30,2), padx=30)

        self.chord_text_box = tk.Text(root, wrap="none", height=1, font=("Arial", 14), state="disabled") 
        self.chord_text_box.pack(anchor="n", side="top", padx=(2,2) ,pady=(2,100))

        tk.Label(root, text="Chord Display", bg="#ECEBDE",font=("Arial", 14)).pack(anchor="n", padx=(10,2), pady=5)
        
        self.chord_display_box = tk.Text(root, wrap="none", height=3, font=("Arial", 14), state="disabled")
        self.chord_text_box.tag_configure("center", justify="center")
        self.chord_display_box.pack( side="top", fill="x", padx=(10,2), pady=2)

        
        self.radio_value = tk.StringVar(value="A")
        i = 0
        for option in ["A",
                        "A#",
                        "B",
                        "C",
                        "C#",
                        "D",
                        "D#",
                        "E",
                        "F",
                        "G",
                        "G#"]:
            tk.Radiobutton(root, text= option, value= option, 
                           variable=self.radio_value, background="#C1BAA1", 
                           width=3).pack(side="left", padx=2, pady=2)
            i+=1


        self.radio_value.trace_add("write", self.on_radio_change)
        self.selected = self.radio_value.get()

        tk.Button(text="Maj", bg="#D7D3BF", command=lambda: self.chord_displayer("maj", self.selected)).pack(side="left", padx=5)
        tk.Button(text="Min", bg="#D7D3BF", command=lambda:self.chord_displayer("min", self.selected)).pack(side="left", padx=5)
        tk.Button(text="Sus2", bg="#D7D3BF", command=lambda:self.chord_displayer("s2", self.selected)).pack(side="left", padx=5)
        tk.Button(text="Sus4", bg="#D7D3BF", command=lambda:self.chord_displayer("s4", self.selected)).pack(side="left", padx=5 )


    def on_song_selected(self, event):
        selected_title = self.song_dropdown.get()
        song_data = self.songs[selected_title]
        chords = song_data["chords"]
       
        self.chord_text_box.config(state="normal")
        self.chord_text_box.delete(1.0, tk.END)

        for chord_data in chords:

            chord_name = chord_data["name"]
            position = chord_data["position"]
            self.chord_text_box.insert(tk.END, f"{position+1}: {chord_name}   ")
        self.chord_text_box.config(state="disabled")


    def chord_displayer(self,label,letter):
        self.chord_display_box.config(state="normal")
        self.chord_display_box.delete(1.0, tk.END)
        a = self.chord_creator(letter, label)
        self.chord_display_box.insert(tk.END, a.notes, "center")
        self.chord_display_box.config(state="disabled")


    def on_radio_change(self, *args):
        self.selected = self.radio_value.get()
        




