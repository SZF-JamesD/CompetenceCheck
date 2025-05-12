from models.chromatic_scale import ChromaticScale
from models.chord_formula import ChordForumla

class ChordCreator:
    def __init__(self, key, quality) -> None:
        self.key = key
        self.quality = quality
        s = ChromaticScale(key)
        self.scale : dict[str, int] = s.scale

    @property
    def notes(self):
        ranges = ChordForumla.__getitem__(self.quality).value
        return [k for k, v in self.scale.items() if v in ranges]
        

