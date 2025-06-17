<template>
    <div class="manage-orders">
        <table class="orders-table">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Client ID</th>
                    <th>Package ID</th>
                    <th>Status</th>
                    <th>Created At</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="order in orders" :key="order.orderId">
                    <td>{{ order.orderId }}</td>
                    <td>{{ order.clientId }}</td>
                    <td>{{ order.packageId }}</td>
                    <td>
                        <select v-model="order.status" @change="updateStatus(order)">
                            <option value="new">New</option>
                            <option value="pending">Pending</option>
                            <option value="canceled">Canceled</option>
                            <option value="completed">completed</option>
                        </select>
                        </td>
                        <td>{{ formatDate(order.createdAt) }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import OrderService from "../services/OrderService";

export default {
    name: 'ManageOrders',
    data() {
        return {
            orders: []
        };
    },
    methods: {
        async fetchOrders() {
            try {
                const response = await OrderService.getAllOrders();
                this.orders = response.data;
            } catch (error) {
                console.error("Failed to fetch orders:", error);
            }
        },
        async updateStatus(order) {
            try {
                 await OrderService.updateOrderStatus(order.orderId, order.status);
                console.log(`Order ${order.orderId} status updated to ${order.status}`);
            } catch (error) {
                console.error("Failed to update order status:", error);
            }
        },
        formatDate(dateTime) {
            return new Date(dateTime).toLocaleDateString(); // Format For Readability
        }
    },
    created() {
        this.fetchOrders();
    }
};
</script>

<style scoped>
.manage-orders {
    padding: 2rem;
    color: #2d3142;
}

.orders-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 1rem;
}

.orders-table th,
.orders-table td {
    border: 1px solid #ccc;
    padding: 0.75rem;
    text-align: left;
    vertical-align: middle;
}

.orders-table th {
    background-color: #EF8354;
    color: white;
}

.status-cell {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    gap: 0.25rem;
}

.status-cell select {
    padding: 0.25rem 0.5rem;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: white;
    color: #2d3142;
    width: 150px;
}

.status-cell .created-at {
    font-size: 0.85rem;
    color: #555;
    padding-left: 2px;
}


</style>

