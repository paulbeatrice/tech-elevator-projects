# JavaScript Essentials Part 2 exercises

In this exercise, you'll work on a cash register application to support a point-of-sale system for merchandise at a concert venue. The starting code provides a user interface and other supporting code. Your task is to write the code to manage a customer's order, including adding and removing items, processing the transaction, and recording the final sale.

## Getting started

Open the `exercise` folder in Visual Studio Code. Open a new Terminal pane and run `npm install` to install the dependencies.

As you complete each step of the exercise, you can verify that you've completed things correctly by running the unit tests using the `npm run test` command.

There's also code provided for a command-line application, which you can run with the command `npm run start`. However, until you have completed more of the application, only the first and last options, "[1] List Products" and "[6] Sales Report" work. If you try to use a feature not implemented yet, you'll get an error like `TypeError: cashRegister.addProductToOrder is not a function`.

## Explore starting code

You'll focus on the `cashRegister.js` file. It's mostly empty right now, but its purpose is to encapsulate the logic for managing customer orders. The unit tests in `tests.js` verify each feature you must add. To complete the assignment successfully, all tests must pass.

However, the application also includes several other files. Although you don't need to edit these, exploring the provided code can help you understand what it does and how it works with the code you must add.

- `product.js`: manages the products available for purchase by providing a `Product` object and the `getProducts()` function, which allows access to the product list.

- `sale.js`: manages completed sales by providing a `Sale` object and functions to access and update sales data.

- `paymentType.js`: represents the possible payment types a customer can make, like cash or a credit card.

- `util.js`: holds a shared utility function for formatting currency in U.S. Dollars using the `Intl.NumberFormat` object.

- `app.js`: the main entry point of the application, containing the logic for the user interface. This code calls the functions you'll add to the `cashRegister.js` file.


## Step One: Complete the `CashRegister` constructor

The `CashRegister` constructor must:

- Declare two properties:
    - `allProducts`: the list of all products
    - `currentOrder`: tracks the products that the current customer wants to purchase
- Import the `getProducts()` function from `products.js` and use it to set the list of all products.
- Set `currentOrder` to an empty array, allowing you to add products later.

After completing this step correctly, the tests under "CashRegister constructor tests" pass.

## Step Two: Write the `addProductToOrder()` method

Now that the cash register can track an order, it needs a way to add products to the order. Create an `addProductToOrder()` method for the `CashRegister`. It must take two parameters—the product ID and the desired quantity. Although the names of the parameters aren't important, the order is.

The `addProductToOrder()` method must:

- Use the product ID parameter to locate the product in the list of `allProducts`.
- Check if the product already exists in the `currentOrder`. If so, increase the quantity of the existing product.
- Otherwise, add a new object to `currentOrder` that contains the properties from the `Product` object plus an additional `quantity` property.
- Subtract the quantity from the product's inventory.
- If the product ID isn't valid, meaning it doesn't exist in `allProducts`, or there's insufficient inventory for the customer's requested quantity, return it `false`. Otherwise, return `true`.

When you implement this method correctly, all tests under "addProductToOrder() tests" pass.

## Step Three: Write the `removeProductFromOrder()` method

There must also be a way to remove products from the current order. Create a `removeProductFromOrder()` method for the `CashRegister`. It must take one parameter, the product ID.

The `removeProductFromOrder()` method must:

- Use the product ID parameter to locate the product in `currentOrder`.
- Remove the product from the `currentOrder`, leaving all other elements intact.
- Add the quantity back to the product's inventory.
- If the product isn't found in the order, return `false`. Otherwise, return `true`.

When you implement this method correctly, all tests under "removeProductFromOrder() tests" pass.

## Step Four: Write the `calculateTotal()` method

To complete the order and collect payment, you must first calculate the total cost of the current order. Create a `calculateTotal()` method for the `CashRegister`. This method requires no parameters.

The `calculateTotal()` method must:

- Calculate the subtotal for each product using the product price and desired quantity.
- Sum the subtotals for all products in the order to get the total cost of the order.
- Return the total cost as a number. Don't format the value for currency.

> TIP: Although you could implement this in a loop, try to use the `reduce()` method from `Array`. Refer back to the reading if you need to.

When you implement this method correctly, all tests under "calculateTotal() tests" pass.

## Step Five: Write the `getOrderSummary()` method

When the customer is ready to check out, they need a summary of their order, including a list of products, their quantities, and the total cost. Add the `getOrderSummary()` method to the `CashRegister`. This method requires no parameters.

The `getOrderSummary()` method must:

- Return an object with two properties—`products` and `total`.
    - Set the `products` property to the `currentOrder` property.
    - Set the `total` property to the total cost of the current order by using `calculateTotal()` from the previous step.

When you implement this method correctly, all tests under "getOrderSummary() tests" pass.

## Step Six: Write the `ringUpSale()` method

When customers are ready to check out, the register must ring up their sale to complete the transaction. Create a `ringUpSale()` method for the `CashRegister`. It must take one parameter for the customer payment type.

The `ringUpSale()` method must record the sale by calling the `addSale()` function from `sale.js`. This function takes three parameters:

- `items`: an object array of the products sold. Each object contains three properties: `productId`, `quantity`, and `subTotal`.
    - TIP: there's an `Array` function that returns a new array of changed objects. Refer back to the reading if you need to.
    - TIP: look at the objects in the `salesDataset` of `sale.js` for the expected data format.
- `total`: the total sale amount, use the return value of `calculateTotal()`.
- `paymentType`: a string representing the payment type (cash, credit card, etc). Use the method's payment type parameter.
    - If you're interested in the data type definition, reference `paymentType.js`.

After calling the `addSale()` function, empty the current order.

When you implement this method correctly, all tests under "ringUpSale() tests" pass.
