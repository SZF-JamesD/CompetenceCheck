import random

class LessonController:
    def __init__(self):

        def word_selector(not_learned_list):
            words = []
            for i in range(10):
                choice = random.randint(0, len(not_learned_list)-1)
                words.append(not_learned_list[choice])
            return words
        
        