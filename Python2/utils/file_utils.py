import csv, json

def read_csv(file_path):
    try:
        with open(file_path, more="r", newline="") as file:
            reader = csv.DictReader(file)
            return [row for row in reader]
    except FileNotFoundError:
        print(f"CSV file not found: {file_path}")
        return []
    except Exception as e:
        print(f"Error reading CSV: {e}")
        return []
    

def write_csv(file_path, data):
    try:
        if not data:
            with open(file_path, mode="w", newline="") as file:
                writer = csv.DictWriter(file, fieldnames=[])
                writer.writeheader()
            print("Empty CSV file created.")
            return
        
        fieldnames = data[0].keys()
        with open(file_path, mode="w", newline="") as file:
            writer = csv.DictWriter(file, fieldnames=fieldnames)
            writer.writeheader()
            writer.writerows(data)
        print(f"CSV written to {file_path}.")
    except Exception as e:
        print(f"Error writing CSV: {e}")


def read_json(file_path):
    try:
        with open(file_path, "r") as file:
            content = json.load(file)
            if not isinstance(content, list):
                print(f"Expected list in JSON, get {type(content)}")
                return []
            return content
    except FileNotFoundError:
        print(f"JSON file not found: {file_path}")
        return []
    except json.JSONDecodeError as e:
        print(f"JSON decode error: {e}")
        return []
    except Exception as e:
        print(f"Error reading JSON: {e}")
        return []
    
    def write_json(file_path, new_data):
        try:
            if not isinstance(new_data, list):
                raise ValueError("Data must be a list of dictionaries.")
            
            existing_data = read_json(file_path)
            updated_data = existing_data + new_data

            with open(file_path, "w") as file:
                json.dump(updated_data, file, indent=4)
            print(f"JSON written to {file_path}")
        except Exception as e:
            print(f"Error writing JSON: {e}")
