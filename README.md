# Money Map
An open-source expense tracker mobile application built using Kotlin and Jetpack Compose. The app follows the MVVM architecture and uses Room DB for data persistence.

## Features
- **MVVM Architecture:** Ensures separation of concerns and makes the app easier to maintain.
- **Room Database:** Provides an abstraction layer over SQLite for offline data storage.
- **Financial Overview:** Real-time display of current balance, total income, and expenses.
- **Two Screens:**
  - *Home Screen:*
    - Greets the user based on the local time (morning, afternoon, evening).
    - Displays current balance, income, and expenses.
    - Shows a list of recent transactions sorted by date.
  - *Add Transaction Screen:* 
    - Form-like UI with input fields for transaction details.

## Screens
### Home Screen
  
![Add_Expense_optimized](https://github.com/SahibSingh1311/Money-Map/assets/51374188/c380878a-840e-4643-a04c-4ed43245e9d0)

  - *Greeting:* Personalized greeting based on the time of day.
  - *Balance Card:* Displays current balance, total income, and total expenses.
  - *Transaction List:* Shows the list of recent transactions sorted by transaction date (not the order they were added).

### Add Transaction

 ![Add_Expense_optimized](https://github.com/SahibSingh1311/Money-Map/assets/51374188/018cac25-f0ff-4c67-acb2-71a84e90ec3d)

  - *Transaction Type:* Dropdown with options:
    - Expense(default)
    - Income
  - *Title:* Text input field for the transaction title (required).
  - *Amount:* Numeric input field for the transaction amount (required).
  - *Transaction Category:* Dropdown with 14 predefined categories:
    - MISCELLANEOUS(default)
    - FOOD
    - TRANSPORTATION
    - HOUSING
    - ENTERTAINMENT
    - SHOPPING
    - TRAVEL
    - EDUCATION
    - FINANCE
    - GIFTS
    - GAMES
    - MEDICAL
    - INSURANCE
    - INCOME
  - *Date Picker:* For selecting the transaction date.
  - *Submit Button:* Adds the transaction and redirects to the home screen, displaying a toast message if title or amount fields are empty.
    
### Sorting and UI Enhancements
- *Transaction Sorting:* Transactions are displayed based on the transaction date.
  For example: If transactions are added in the order Salary on 1st July 2024, Dinner on 5th July 2024, and Gift on 3rd July 2024, the list will display as Dinner (5th July), Gift (3rd July), and Salary (1st July).
- *Text Color:*
  - Income transactions are displayed in Green.
  - Expense transactions are displayed in Red.

### App UI

Adding an Income transaction:

https://github.com/SahibSingh1311/Money-Map/assets/51374188/a4d1ee29-5abc-4e6b-a9f9-e5bb495c9e30

Adding an Expense transaction:

https://github.com/SahibSingh1311/Money-Map/assets/51374188/a883483b-b28f-42d9-833e-d88ebff20a3b

A toast message to inform user to add title and amount

[Error.webm](https://github.com/SahibSingh1311/Money-Map/assets/51374188/6fd1f111-dbf3-4d5d-b0ac-0c721b97b41d)

## Getting Started
### Prerequisites
  - Android Studio
  - Kotlin
    
### Installation
1. Clone the repository
```
https://github.com/SahibSingh1311/Money-Map
```
2. Open the project in Android Studio.
3. Build and run the project on an emulator or a physical device.
   
## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your improvements.

## Acknowledgments
- Thanks to the Jetpack Compose and Android community for their tutorials and guidance.
- Thanks to the the designers on [Flat Icon](https://www.flaticon.com/) for providing various resources applied on the app. 
