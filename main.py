hotels = []
rooms = []

def add_hotels():
    
    print("Hotel Name:")
    name = input()
    print("Adress:")
    adress = input()
    print("Add a description:")
    description = input()
    
    hotel = {
        "name" : name,
        "adress" : adress,
        "description" : description
    }
    
    hotels.append(hotel)
    
def all_hotels():
    if not hotels:
        print("There's no hotel signed yet")
        return
    for i, hotel in enumerate(hotels, start=1):
        print(f"\nHotel {i}: {hotel['name']}")
        print(f"Adress: {hotel['adress']}")
        print(f"Description {hotel['description']}")

PRICES = {
    "single": 150.00,
    "couple": 250.00
}        

def book_room():
    print("Room Number:")
    number = input()
    print("Type of Room(ex: single, couple, etc):")
    type = input()
    
    room = {
        "number" : number,
        "type" : type,
        "price" : PRICES[type],
        "available" : True
    }
    
    print(f"\nRoom {number} ({type}) booked with price $ {PRICES[type]}")
    
    rooms.append(room)
    
def room_availibity_price():
    print("Room Number:")
    number = input()
    
    for n in rooms:
        if n["number"] == number:
            if n["available"] == True:
                print(f"\nRoom {number} availabe, price $ {PRICES[type]}")
            else:
                print("Choose another room")
        else:
            print("Room doesn't exists")
    




while True:
    print("--------------------MENU--------------------")
    print("Choose a option:\n1 - Hotel Listing Management\n2 - Room Booking and Cancellation\n3 - Price and Availability Management\n4 - Customer Profile Management\n5 - Payment Processing\n6 - Reviews and Ratings\n7 - Loyalty Program Integration\n8 - Multi-Language Support\n9 - Customer Support Interface\n10 - Analytics and Reporting\n11 - Leave")
    print("--------------------------------------------")
    
    
    option = int(input())
    
    if option == 1:
        print("1 - Add a new hotel\n2 - Listing all hotels")
        function1 = int(input())
        
        if function1 == 1:
            add_hotels()
        elif function1 == 2:
            all_hotels()
    elif option == 2:
        book_room()
    elif option == 3:
        print("...")
    elif option == 4:
        print("...")
    elif option == 5:
        print("...")
    elif option == 6:
        print("...")
    elif option == 7:
        print("...")
    elif option == 8:
        print("...")
    elif option == 9:
        print("...")
    elif option == 10:
        print("...")
    elif option == 11:
        print("Leaving...")
        break
    else:
        print("Error!Choose a valid number!")
    