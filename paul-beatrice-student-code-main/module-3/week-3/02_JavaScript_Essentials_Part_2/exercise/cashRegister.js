import { getProducts } from './product.js';
import  { addSale } from './sale.js';


function CashRegister() {
    this.allProducts = getProducts();
    this.currentOrder = [];

    this.addProductToOrder = function(productId, quantity) {
        const product = this.allProducts.find(p => p.id === productId);

        if (!product || product.inventory < quantity) {
            return false;
        }

        const existingProduct = this.currentOrder.find(p => p.id === productId);

        if (existingProduct) {
            existingProduct.quantity += quantity;

        } else {

            const orderItem = {
                id: product.id,
                name: product.name,
                price: product.price,
                quantity: quantity
            }
            this.currentOrder.push(orderItem);
        }

        product.inventory -= quantity;

        return true;
    }

    this.removeProductFromOrder = function(productId) {
        const index = this.currentOrder.findIndex(p => p.id === productId);

        if (index === -1) {
            return false;
        }

        const removeProduct = this.currentOrder.splice(index, 1)[0];

        const originalProduct = this.allProducts.find(p => p.id === productId);
        if (originalProduct) {
            originalProduct.inventory += removeProduct.quantity;
        }

        return true;
    }

    this.calculateTotal = function() {
        return this.currentOrder.reduce((sum, item) => {
            return sum + item.price * item.quantity;
        }, 0);
    };

    this.getOrderSummary = function() {
        return {
            products: this.currentOrder,
            total: this.calculateTotal()
        };
    };

    this.ringUpSale = function(paymentType) {
        const items = this.currentOrder.map( item => ({
            productId: item.id,
            quantity: item.quantity,
            subTotal: item.price * item.quantity
        }));

        const total = this.calculateTotal();
        addSale(items, total, paymentType);

        this.currentOrder = [];
    };
}


export { CashRegister };