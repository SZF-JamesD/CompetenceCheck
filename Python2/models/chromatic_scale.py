class ChromaticScale:
    notes = ('A', 'A#', 'B', 'C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#')

    def __init__(self, root_note):
        self.root_note = root_note

    @property
    def scale(self) -> dict[str, int]:
        starting_index = list(self.notes).index(self.root_note)
        notes: list[str] = []

        for idx in range(len(self.notes)):
            new_index = (starting_index + idx) % len(self.notes)
            notes.append(self.notes[new_index])

        return dict(zip(notes, list(range(len(notes)))))