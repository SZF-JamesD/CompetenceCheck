from utils.tkinter_utils import MessageBoxHandler

class DataManager:
    def __init__(self, db_handler):
        self.db_handler = db_handler

        def load_unlearned(self):
            main_query = "select * from unlearned"
            
            unlearned_words = self.db_handler.fetch_all(main_query)
            
            return unlearned_words
            #later combine size of both lists to get %

        def load_learned(self):
            main_query = "select * from learned"

            learned_words = self.db_handler.fetch_all(main_query)

            return learned_words
        
        def save_progress(self, new_learned_words):
            for item in new_learned_words:
                if item == None:
                    MessageBoxHandler.show_error("There are no new words to add.")
                    return
                
                insert_query = f"insert into learned (words, tries) values({item["word"]}, {item["tries"]})"

                self.db_handler.save_data(insert_query, )

        