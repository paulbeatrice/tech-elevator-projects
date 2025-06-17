# Module Three Mid-Module Project

There are two options for the mid-module project. The two options are:
1. Implement the Solar System Geek E-Commerce Application described below.
2. Create and implement your own application. This can be used for your module-2 final project or an entirely new application.

The provided Solar System Geek E-Commerce Application is guided with clear requirements describing exactly what work needs to be done.
However, since the application and the instructions were created by Tech Elevator it is a part of the
Tech Elevator curriculum. As a result the source code can not be hosted publicly nor used directly in your software portfolio.

## Creating your own Application

If you decide to create your own application, **you must confirm your application proposal with your instructor.**

### Custom Application Requirements

The following are the minimum requirements your application must include:
* At least 2 [wireframe](https://en.wikipedia.org/wiki/Website_wireframe) sketches or outlines for a single web page, one for desktop and one for mobile, that outlines the page   for both device views
  * You may create the wireframes yourself or use a wireframe template found online or elsewhere
    * If creating your own, [Figma](https://www.figma.com/wireframe-tool/) is one of the most used tools for UX/UI design and wireframing.
  * A wireframe for tablet devices is **optional**
  * Place your wireframes in the `/design` folder
* At least 1 web page (html file) that contains:
  * A header with a logo
    * You can create your own or insert a placeholder image from [Placeholder.com](Placeholder.com)
    * `<img src="https://via.placeholder.com/700x200.jpg">`
  * A footer with copyright text
    * You can decide on the text content
    * Use © or put `&copy;` in the html
  * At least 3 site navigation links
    * It is not required that these link to other pages
  * Styling that utilizes CSS flexbox and/or CSS grid
    * Styles must be in a separate css file that is included in your html file
    * You may use other CSS libraries (bootstrap, tailwind, etc.) to *supplement* your CSS styling
  * No horizontal (left or right) scrolling of the page in the browser window
  * Support for both desktop and mobile views
    * Desktop view is 1024 pixel width or greater
    * Mobile view is 425 pixel width or smaller
  * A display of data generated dynamically from an array containing at least 5 JavaScript objects
    * This must be implemented using JavaScript
      * **Hard-coding JavaScript objects as HTML elements is not permitted**
* A javascript file containing an array of at least 5 JSON objects to display on the web page
  * This javascript file must be included in your html file
  * The array of objects can be hard-coded, sourced from mock data, or from the database of any project you created during the program (see section below)
* At least 3 event listeners and event handlers that respond to user input
  * An event listener for `DOMContentLoaded` can not be used as one of the 3 event listeners
  * Example: a text input field that captures key presses for a search or filter
  * Example: a trash can icon or button that removes a piece of data when clicked
  * Example: a toggle switch that changes your page theme to dark/light mode
* A clear purpose, function, or utility

### Starting Code

You may create a new `index.html` or use the `index.html` for the provided project as a basis for your project.

### Using Mock Data

You can use Mockaroo to generate mock JSON data for your application: [https://www.mockaroo.com/](https://www.mockaroo.com/)

### Optional - Using Module-2 Final Project Data

You can use the [fetch api](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch) to make http requests from JavaScript and source JSON data from your Module-2 final project. **This is optional and will likely require additional work/time to integrate.**

Below is an example of how to use the fetch api. A working Codepen example can be found [here](https://codepen.io/dencee/pen/XWwwgMV). Note: you will have to run your module-2 project and change the URL in the example to match your endpoint.

```js
// Your javascript file, e.g. script/my-script.js
document.addEventListener('DOMContentLoaded', onDomLoaded);

async function onDomLoaded(){
  try{
    // Default HTTP method is GET for fetch()
    // Refer to Codepen examples (link above) for POST, PUT, DELETE
    const response = await fetch('http://localhost:8080/products/4');
    const product = await response.json();
    console.log(response.status);   // 200
    console.log(product);           // {productId: 42, ...}
  } catch(error) {
    console.error(error);
  }
}
```

```html
<head>
  ...
  <!-- Importing your javascript file -->
  <script src="script/my-script.js"></script>
</head>
```

```java
@RestController
@CrossOrigin    // <--- must add to controller class
@RequestMapping("/products")
public class CartController {
    ...
}
```

## Solar System Geek E-Commerce Application

This application allows a retailer to sell their products to customers in an online setting. Customers can view a list of products or search for a particular item using a built-in search bar. With a click, they can view more information about a product or add the product to a personal cart.

The [Requirements](#requirements) section later in this document describes the application features in greater detail.

Here is a wireframe of the fully functioning website:

![Cards Wireframe](./img/wf-wide.png)


## Starting code

Open the Module Three mid-module project in VSCode and review the starting code.

The starting code displays a product set based on hard-coded data in `index.html`. However, the application needs more style and interactivity.

Some essential files to explore:

### `index.html`

The `<head>` element links all essential stylesheets and scripts. This part of the file requires no modification.

`<section id="product-cards">` contains temporary data describing four cards. Note that these hard-coded cards have different attributes than those you'll eventually generate.

### `script/productService.js`

`allProducts[]` holds the data for seven products that you need to display in your application. You need to read this array and dynamically generate a set of elements from this data. These elements replace the hard-coded values currently in the `index.html` file.

`getProducts()` returns the `allProducts` array.

You'll add additional methods to this file that return subsets of the `allProducts` array.

### `script/app.js`

This file has no content save a brief top comment. Use it to:

* Hook up your event handlers.

* Write all methods that define the required behavior of the application.

### `css/style.css`

Another empty file. Use `style.css` to style the application to match the wireframe images provided.

## Requirements

**Requirement 1: Create header**

Add a `header` element to the top of the page.

The `header` must:

* Display a logo centered on the page
* Always display at the top of the viewport, regardless of scroll position

For the logo, you can insert a placeholder image from [Placeholder.com](https://placeholder.com/). For example, to insert a JPEG image with dimensions 700 pixels by 200 pixels, you can include the following image element:

```html
<img src="https://via.placeholder.com/700x200.jpg">
```

**Requirement 2: Create nav**

Add a `nav` element after the `header` element and before the existing `main` element.

The `nav` must:

* have three links: Home, Cart, and Logout
* left justify the "Home" and "Cart" links
* right justify the "Logout" link
* always display at the top of the viewport, following the `header`

*Tip*: You can assign the `href` attribute for all links as `"#"` so the page doesn't reload when you click a link.

**Requirement 3: Create footer**

Add a `footer` element after the existing `main` element but still within the encompassing `<div id="app">`.

The `footer` must:

* contain the copyright text
* always display at the bottom of the viewport, regardless of the length of the main section

*Tip*: You can copy/paste the copyright symbol from here—`©`—or put `&copy;` in your HTML to have the browser render it.

**Requirement 4: Enable main scrolling**

Style the `main` element to scroll if its content doesn't fit the available space.

**Requirement 5: Style the product card collection**

Style the product card collection. Use `flexbox` to ensure that the cards respond to varying screen widths, as shown in the following images:

![Cards Wireframe](./img/wf-tile.png)

**Requirement 6: Style the product cards**

Style the individual product cards. Use `grid` to arrange the information in the product cards like in the sample wireframes.

**Requirement 7: Build cards From data**

Remove the hard-coded cards currently in your HTML. Build cards dynamically from the data in `productService.js`.

Reference the hard-coded HTML to aid you in creating elements. Pay attention to the nesting of elements and their classes. Also, take note of the `data-id` attribute on the hard-coded elements numbered 1-4. Your dynamically generated cards must also have this attribute, each with a unique value.

*Hint*: See [Currency formatting](#currency-formatting) in the Hints section for tips on formatting numbers in JavaScript.

*Hint*: You might not expect to see the cart icon in an `<i>` tag, but that and classes like `fa-solid` and `fa-cart-plus` are how the open source library of icons called **Font Awesome** loads its icons. For more information, see [Font Awesome icons](#font-awesome-icons) in the Hints section.

*Hint*: Use `setAttribute()` to add element attributes. See [Using `setAttribute()` and `getAttribute()`](#using-setattribute-and-getattribute) in the Hints section for more information.

**Requirement 8a: Add an event handler to the product name**

Set up an event handler such that clicking the product name triggers a `window.alert` displaying the product description.

*Hint*: Use `getAttribute()` to identify which product the user clicked. See [Using `setAttribute()` and `getAttribute()`](#using-setattribute-and-getattribute) in the Hints section for more information.

**Requirement 8b: Add an event handler to the shopping cart icon**

Create an event handler such that when the user clicks the shopping cart icon, they receive a `window.alert` notification that the item has been added to the cart.

**Requirement 9: Add a textbox for search**

Add a textbox that allows the user to enter a search term. Then define a method `searchProducts(searchTerm)` in `productService.js`. Use the array `filter` method so that `searchProducts` returns all products equal to or containing the `searchTerm` parameter.

Add the `keyup` event listener to your search bar. Use `searchProducts(searchTerm)` to filter the products list if there's a search term, and `getProducts()` if not.

**Optional**

Upgrade your event handlers from **Requirements 8a and 8b**. Instead of generating a window alert, deliver the appropriate message to a "message window" centered within your `nav`. The message window remains hidden when not displaying a message. Otherwise, the event handlers stay the same:

* Clicking the product name causes the product description to appear in the message window.
* Clicking the shopping cart causes the message window to state that the item has been added to the cart.

---

## Hints

### Currency formatting

To show the product's price in the proper format, you can use the `Intl.NumberFormat` object. `Intl.NumberFormat` accepts `locale` and `options` as arguments. `locale` specifies the region whose formatting rules you want to use. `options` allows you to specify what type of formatting you want to apply to your number.

For example, to display a value in U.S. Dollars (USD):

```javascript
Intl.NumberFormat(`en-US`, {
        currency: `USD`,
        style: "currency",
    }).format(value);
```

For a more extensive description of the capabilities of `Intl.NumberFormat`, check out [Mozilla's documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Intl/NumberFormat)

### Font Awesome icons

**Font Awesome** is an open source provider of icons, many of which you can use for free.

You must add their kit to your project to use icons from the Font Awesome library. The `index.html` contains a `stylesheet` link to do this:

```html
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" />
```

With the kit installed, you can choose from [thousands of free icons to add to your site](https://fontawesome.com/search?m=free&o=r). Click on an icon in the search page to reveal various options and the HTML needed to display it on your page.

For example, to display an icon of a heart:

<img src="./img/heart-regular.svg" width="50" height="50" />

Add the following tag to your HTML:

```html
<i class="fa-regular fa-heart"></i>
```

Font Awesome offers many other icons, including the magnifying glass and shopping cart used in the wireframe solution.

### Using `setAttribute()` and `getAttribute()`

HTML elements can provide more information in the form of **attributes**. For example, the hard-coded product data gives each `product-name` a `data-id` attribute. Each `data-id` has a unique numeric value:

```html
<div class="product-name action" data-id="1">A super product</div>
```

To set an attribute, call the `setAttribute()` method on the element. It takes two parameters—the name of the attribute to set and the value.

Since each value is unique, you can use the `productId` to set each `data-id`:

```javascript
div.setAttribute("data-id", product.productId);
```

You can retrieve an attribute with `getAttribute()`. This method takes one parameter—the attribute name.

You can get the `data-id` to identify which `product-name` the user clicked using the `getAttribute()` method:

```javascript
// Get the id of the target
const id = Number(ev.currentTarget.getAttribute("data-id"));
```
