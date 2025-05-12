import mysql.connector
from mysql.connector import Error

class DatabaseHandler:
    def __init__(self, host, user, password, database, messagebox_handler):
        self.messagebox = messagebox_handler
        try:
            self.connection = mysql.connector.connect(
                host=host,
                user=user,
                password=password,
                database=database
            )
            self.connection.autocommit = False
            self.cursor = self.connection.cursor(dictionary=True)
            print("Connected to the database")
        except Error as e:
            self.messagebox.show_error(f"Database Connection Error:  {str(e)}")
            raise
        

    def execute_query(self, query, params=None):
        self.cursor.execute(query, params or ())


    def fetch_all(self, query, params=None):
        self.cursor.execute(query, params or ())
        return self.cursor.fetchall()


    def fetch_one(self, query, params=None):
        self.cursor.execute(query, params or ())
        return self.cursor.fetchone()
    

    def commit(self):
        self.connection.commit()


    def rollback(self):
        self.connection.commit()
    

    def close(self):
        if self.connection.is_connected():
            self.connection.close()
            print("Database connection closed.")


if __name__ == "__main__": 
    from load_config import load_config
    from messagebox_utils import MessageBoxHandler

    config = load_config()
    msgbox = MessageBoxHandler()

    try:
        db = DatabaseHandler(
            host=config["host"],
            user=config["user"],
            password=config["password"],
            database=config["database"],
            messagebox_handler=msgbox
        )

        print("Connection test successful!")
        print(db.fetch_all( "select * from songs"))
    except Exception as e:
        print(f"Connection test failed: {e}")