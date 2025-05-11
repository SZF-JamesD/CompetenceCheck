import json

def load_config(path="data/config.json"):
    try:
        with open(path, "r") as file:
            return json.load(file)
    except FileNotFoundError:
        print(f"Config file not found at: {path}")
        return {}
    except json.JSONDecodeError as e:
        print(f"JSON decode error in config file: {e}")
        return {}
    

