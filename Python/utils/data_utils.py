import json, mysql.connector
from mysql.connector import Error
from utils.tkinter_utils import MessageBoxHandler

class DatabaseHandler:
    def __init__(self, host, user, password, database):
        self.messagebox = MessageBoxHandler()
        try:
            self.connection = mysql.connector.connect(
                host=host,
                user=user,
                password=password,
                database=database
            )
            self.connection.autocommit = False
            self.cursor = self.connection.cursor(dictionary=True)
            print("Connected to the database.")
        except Error as e:
            self.messagebox.show_error("Database Connection Error", f"Error connecting to the database: {e}")
            raise
        except Exception as e:
            self.messagebox.show_error("Unexpected Error", f"An unexpected error occurred during initialization: {e}")
            raise

    def execute_query(self, query, params=None):
        #Execute a query with optional parameters.
        try:
            self.cursor.execute(query, params)
            
        except Error as e:
            self.messagebox.show_error("This Query Execution Error", f"Error executing query: {e}")
            self.connection.rollback()
            raise
        except Exception as e:
            self.messagebox.show_error("Unexpected Error", f"An unexpected error occurred during query execution: {e}")
            self.connection.rollback()
            raise

    def fetch_all(self, query, params=None):
        #Fetch all rows for a query.
        try:      
            self.cursor.execute(query, params)
            return self.cursor.fetchall()
        except Error as e:
            self.messagebox.show_error("Data Fetch Error", f"Error fetching data: {e}")
            return []
        except Exception as e:
            self.messagebox.show_error("Unexpected Error", f"An unexpected error occurred during data fetch: {e}")
            return []


    def save_data(self, data, table):
        try:
            if self.connection.in_transaction:
                print("A transaction is already in progress, rolling back previous transaction.")
                self.connection.rollback()
            
            self.connection.start_transaction()
          

            var = ",".join(str(x) for x in data["wrong_answers"])
            main_params = f"{data["id"]}, '{data["english"]}', '{data["german"]}', '{var}', {data["tries"]}"                                  
            main_query = f"insert into {table} (id, english, german, wrong_answers, tries) values ({main_params})"                                
            self.execute_query(main_query)

            self.connection.commit()

        except Error as e:
            self.messagebox.show_error("Save Data Error", f"Error saving data: {e}")
            self.connection.rollback()
        except Exception as e:
            self.messagebox.show_error("Save Data Error", f"Error saving data: {e}")
            self.connection.rollback()
        
                               
    def delete_data(self, table, value):
        try:
            if self.connection.in_transaction:
                print("Rolling back previous transaction before starting a new one.")
                self.connection.rollback()
            self.connection.start_transaction()

            self.execute_query(f"DELETE FROM {table} WHERE word = %s", (value,))

            self.connection.commit()
            self.messagebox.show_info("Success", f"Records related to {value} have been successfully deleted.")
        
        except Error as e:
            self.connection.rollback()
            self.messagebox.show_error("Deletion Error", f"An error occured during deletaion: {e}")
        except Exception as e:
            self.connection.rollback()
            self.messagebox.show_error("Deletion Error", f"An error occurred during deletion: {e}")


    def close(self):
        #Close the connection.
        try:
            if self.connection:
                self.connection.close()
                print("Database connection closed.")
        except Error as e:
            self.messagebox.show_error("Connection Close Error", f"Error closing the database connection: {e}")
        except Exception as e:
            self.messagebox.show_error("Unexpected Error", f"An unexpected error occurred during connection close: {e}")





    def read_json_to_db(self,file_path):
        try:
            with open(file_path, "r") as file:
                content = json.load(file)
                if not isinstance(content, list):
                    print(f"Error: Expected a list in the JSON file, but got {type(content)}")
                    return
                for item in content:
                    item["tries"] = 0
                    self.save_data(item, "not_learned")
        except FileNotFoundError:
            print(f"File not found: {file_path}. Returning an empty list.")
            return []
        except json.JSONDecodeError as e:
            print(f"Error decoding JSON: {e}. Returning an empty list.")
            return[]
        except Exception as e:
            print(f"Error reading JSON: {e}")
            return []
    

