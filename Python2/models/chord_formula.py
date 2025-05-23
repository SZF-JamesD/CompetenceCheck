from enum import Enum
from models.intervals import Intervals as i

class ChordForumla(Enum):
    maj = i.P1.value, i.M3.value, i.P5.value
    min = i.P1.value, i.m3.value, i.P5.value
    s2 = i.P1.value, i.M2.value, i.P5.value
    s4 = i.P1.value, i.P4.value, i.P5.value
    D7 = i.P1.value, i.M3.value, i.P5.value, i.m7.value
    M7 = i.P1.value, i.M3.value, i.P5.value, i.M7.value
    m7 = i.P1.value, i.m3.value, i.P5.value, i.m7.value