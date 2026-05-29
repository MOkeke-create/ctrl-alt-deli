🥪 Ctrl-Alt-Deli Sandwich Shop

A console-based Java application that simulates a sandwich shop ordering system. Users can create custom sandwich orders by selecting bread, meat, cheese, toppings, drinks, and more through an interactive menu-driven interface.

📌 Features
Start a new sandwich order
Choose sandwich components:
Bread type
Meat selection
Cheese selection
Toppings (veggies & extras)
Add drinks to an order
Add multiple items per order
Cancel or exit at any time
Simple console-based UI
Object-oriented design (OOP principles)
🧠 Project Structure

Typical structure of the project:

com.pluralsight
│
├── ui
│   └── UserInterface.java
│
├── models
│   ├── Sandwich.java
│   ├── Drink.java
│   ├── Order.java
│   └── MenuItem.java
│
└── Main.java
🚀 How to Run
1. Clone the repository
git clone https://github.com/your-username/deli-shop.git
cd deli-shop
2. Compile the project

If you're using terminal:

javac com/pluralsight/**/*.java
3. Run the application
java com.pluralsight.Main

Or run directly from your IDE (IntelliJ, Eclipse, VS Code).

🧾 Example Menu Flow
===== Ctrl-Alt-Deli Sandwich Shop =====
1) New Order
0) Exit

Choose an option:
> 1

===== BUILD YOUR SANDWICH =====
Select bread:
1) White
2) Wheat
3) Rye
0) Cancel
🥤 Drink Options

When adding a drink, users can choose from:

Sprite
Dr Pepper
Coke
Sweet Tea
Lemonade
🛠️ Technologies Used
Java
Object-Oriented Programming (OOP)
Scanner (user input handling)
Console-based UI
📈 Future Improvements
Add GUI interface (JavaFX or Swing)
Save orders to file or database
Add pricing system and receipts
Add order history
Unit tests for models and order logic
👨‍💻 Author

Built as part of a Java learning project focused on OOP design, user input handling, and modular application structure.
