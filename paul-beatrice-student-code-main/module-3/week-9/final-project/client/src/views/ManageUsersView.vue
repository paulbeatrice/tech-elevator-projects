<template>
    <div class="manage-users">
        

        <table class="user-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Name</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in users" :key="user.id">
                    <td>{{  user.id }}</td>
                    <td>{{ user.username }}</td>
                    <td>{{ user.name }}</td>
                    <td>{{ user.role }}</td>
                    <td>
                        <button @click="openEditModal(user)">Edit</button>
                        <button @click="deleteUser(user.id)">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <!-- Edit User Modal -->
         <div v-if="showModal" class="modal">
            <div class="modal-content">
                <h3>Edit User</h3>
                <label>Name:</label>
                <input v-model="editUser.name" />
                <label>Role:</label>
                <select v-model="editUser.role">
                    <option value="ROLE_USER">ROLE_USER</option>
                    <option value="ROLE_ADMIN">ROLE_ADMIN</option>
                </select>
                <div class="modal-actions">
                    <button @click="submitEdit">Save</button>
                    <button @click="closeModal">Cancel</button>
                </div>
            </div>
         </div>
    </div>
</template>

<script>

import UserService from '../services/UserService';


export default {
    name: 'ManageUsersView',
    data() {
        return {
            users: [],
            showModal: false,
            editUser: {
                id: null,
                username: '',
                name: '',
                role: ''
            }
    };
},
mounted() {
    this.fetchUsers();
},
methods: {
    async fetchUsers() {
        try {
            const response = await UserService.getAllUsers();
            console.log('API Response:', response.data);
            this.users = response.data.map(user => ({
                id: user.id,
                username: user.username,
                name: user.name,
                role: user.role
            }));
        } catch (error) {
            console.error('Failed to fetch users:', error);
         }
        },
        async deleteUser(userId) {
            if (confirm("Are you sure you want to delete this user?")) {
                try {
                    await UserService.deleteUser(userId);
                    this.fetchUsers(); //Refresh the list after deletion
                } catch (error) {
                    alert("Failed to delete the user.");
                    console.error(error);
                }
            }
        },
        openEditModal(user) {
            this.editUser.id = user.id;
            this.editUser.username = user.username;
            this.editUser.name = user.name;
            this.editUser.role = user.role;
            this.showModal = true;
        },
        closeModal() {
            this.showModal = false;
        },
        async submitEdit() {
            try {
                    await UserService.updateUser(this.editUser.id, this.editUser);
                    this.fetchUsers();
                    this.closeModal();
            } catch (error) {
                    alert("Failed to update user.");
                    console.error(error);
            }
         }
    }
};
</script>

<style scoped>
.manage-users {
    padding: 2rem;
    color: #2d3142;
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    border-bottom: 1px solid #ccc;
    padding: 0.5rem;
    text-align: left;
}

thead {
    background-color: #ef8354;
    color: white;
}

button {
    margin: 0 4px;
    padding: 4px 10px;
    background-color: #ef8354;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #d46c3f;
}

.modal {
    position: fixed;
    top: 0; left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.4);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
}

.modal-content {
    background-color: white;
    padding: 20px;
    width: 300px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

.modal-content label {
    display: block;
    margin-top: 10px;
    margin-bottom: 4px;
    font-weight: bold;
}

.modal-content input,
.modal-content select {
    width: 100%;
    padding: 6px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.modal-actions {
    display: flex;
    justify-content: space-between;
}




</style>