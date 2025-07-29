hotels = []
rooms = []
customers = []
bookings = []
reviews = []
loyalty_points = {}

PRICES = {
    "single": 150.00,
    "couple": 250.00,
    "premium": 350.00
}

def add_hotel():
    print("Hotel Name:")
    name = input()
    print("Address:")
    address = input()
    print("Description:")
    description = input()

    for h in hotels:
        if h["name"] == name:
            print("This hotel already exists.")
            return

    hotel = {"name": name, "address": address, "description": description}
    hotels.append(hotel)
    print("Hotel added successfully.")

def list_hotels():
    if not hotels:
        print("No hotels registered.")
    for i, hotel in enumerate(hotels, start=1):
        print(f"\nHotel {i}: {hotel['name']}\nAddress: {hotel['address']}\nDescription: {hotel['description']}")

def get_hotel_by_name(name):
    for h in hotels:
        if h["name"] == name:
            return h
    return None

def add_room():
    print("Hotel name to add room:")
    hotel_name = input()
    hotel = get_hotel_by_name(hotel_name)
    if not hotel:
        print("Hotel not found.")
        return

    print("Room Number:")
    number = input()
    print("Type (single/couple/premium):")
    room_type = input()

    if room_type not in PRICES:
        print("Invalid room type.")
        return

    for r in rooms:
        if r["number"] == number and r["hotel"] == hotel_name:
            print("Room already exists in this hotel.")
            return

    room = {
        "hotel": hotel_name,
        "number": number,
        "type": room_type,
        "price": PRICES[room_type],
        "available": True
    }
    rooms.append(room)
    print("Room added successfully.")

def list_rooms():
    print("Hotel name to list rooms:")
    hotel_name = input()
    found = False
    for r in rooms:
        if r["hotel"] == hotel_name:
            found = True
            status = "Available" if r["available"] else "Booked"
            print(f"Room {r['number']} - {r['type']} - ${r['price']} - {status}")
    if not found:
        print("No rooms found for this hotel.")

def create_customer():
    print("Customer name:")
    name = input()
    print("Email:")
    email = input()

    for c in customers:
        if c["email"] == email:
            print("Customer already exists.")
            return

    customer = {"name": name, "email": email}
    customers.append(customer)
    loyalty_points[email] = 0
    print("Customer profile created.")

def book_room():
    print("Customer email:")
    email = input()
    print("Hotel name:")
    hotel_name = input()
    print("Room number:")
    room_number = input()

    customer = None
    for c in customers:
        if c["email"] == email:
            customer = c
            break
    if not customer:
        print("Customer not found.")
        return

    room = None
    for r in rooms:
        if r["number"] == room_number and r["hotel"] == hotel_name and r["available"]:
            room = r
            break
    if not room:
        print("Room not available.")
        return

    room["available"] = False
    bookings.append({"email": email, "room": room_number, "hotel": hotel_name})
    loyalty_points[email] += 10
    print(f"Room {room_number} in {hotel_name} booked successfully. Loyalty points: {loyalty_points[email]}")

def cancel_booking():
    print("Hotel name:")
    hotel_name = input()
    print("Room number to cancel:")
    room_number = input()

    for i in range(len(bookings)):
        b = bookings[i]
        if b["room"] == room_number and b["hotel"] == hotel_name:
            for r in rooms:
                if r["number"] == room_number and r["hotel"] == hotel_name:
                    r["available"] = True
            bookings.pop(i)
            print("Booking cancelled.")
            return
    print("Booking not found.")

def add_review():
    print("Customer email:")
    email = input()
    print("Hotel name:")
    hotel_name = input()
    print("Rating (1-5):")
    rating = int(input())
    print("Comment:")
    comment = input()

    reviews.append({
        "email": email,
        "hotel": hotel_name,
        "rating": rating,
        "comment": comment
    })
    print("Review added.")

def show_reviews():
    print("Hotel name to view reviews:")
    hotel_name = input()
    found = False
    for r in reviews:
        if r["hotel"] == hotel_name:
            found = True
            print(f"{r['email']} rated {r['rating']}/5: {r['comment']}")
    if not found:
        print("No reviews for this hotel.")

def show_analytics():
    print("Hotel name to analyze:")
    hotel_name = input()

    total_rooms = 0
    occupied = 0
    revenue = 0.0
    for r in rooms:
        if r["hotel"] == hotel_name:
            total_rooms += 1
            if not r["available"]:
                occupied += 1
                revenue += r["price"]

    if total_rooms == 0:
        print("No rooms registered for this hotel.")
        return

    occupancy = (occupied / total_rooms) * 100
    print(f"Total rooms: {total_rooms}")
    print(f"Occupied rooms: {occupied}")
    print(f"Occupancy rate: {occupancy:.2f}%")
    print(f"Estimated revenue: ${revenue:.2f}")

def show_loyalty_points():
    print("Digite o e-mail do cliente:")
    email = input()
    if email in loyalty_points:
        print(f"{email} possui {loyalty_points[email]} pontos de lealdade.")
    else:
        print("Cliente não encontrado ou ainda não possui pontos.")


while True:
    print("\n-------- HOTEL BOOKING SYSTEM --------")
    print("1. Add Hotel\n2. List Hotels\n3. Add Room\n4. List Rooms\n5. Create Customer Profile")
    print("6. Book Room\n7. Cancel Booking\n8. Add Review\n9. Show Reviews")
    print("10. Analytics Report\n11. Show Loyalty Points\n12. Exit")
    print("--------------------------------------")
    choice = input("Choose an option: ")

    if choice == "1":
        add_hotel()
    elif choice == "2":
        list_hotels()
    elif choice == "3":
        add_room()
    elif choice == "4":
        list_rooms()
    elif choice == "5":
        create_customer()
    elif choice == "6":
        book_room()
    elif choice == "7":
        cancel_booking()
    elif choice == "8":
        add_review()
    elif choice == "9":
        show_reviews()
    elif choice == "11":
        show_loyalty_points()
    elif choice == "12":
        print("Exiting...")
        break
    else:
        print("Invalid option.")
