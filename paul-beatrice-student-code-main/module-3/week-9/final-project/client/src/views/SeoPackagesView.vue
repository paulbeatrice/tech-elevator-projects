<template>
    <div class="admin-dashboard-content">
        <div class="seo-packages"></div>

        <!-- Heading & Add Package Button -->
         <div class="header-bar">
            <h2>Manage SEO Packages</h2>
            <button @click="openCreateForm">+ Add New Package</button>

         </div>

    <table v-if="packages.length">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price ($)</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="pkg in packages" :key="pkg.packageId">
                <td>{{ pkg.packageId }}</td>
                <td>{{ pkg.name }}</td>
                <td>{{ pkg.description }}</td>
                <td>${{ formatPrice(pkg.price) }}</td>
                <td>
                    <button @click="openEditForm(pkg)">Edit</button>
                    <button @click="deletePackage(pkg.packageId)">Delete</button>
                </td>
            </tr>
        </tbody>
    </table>

    <p v-else>No packages found.</p>

    <div v-if="showForm" class="modal">
        <h3>{{ isEditMode ? 'Edit' : 'Create' }} SEO Package</h3>
        <form @submit.prevent="submitForm">
            <input type="text" v-model="selectedPackage.name" placeholder="Package Name" required />
            <textarea v-model="selectedPackage.description" placeholder="Description" required></textarea>
            <input type="number" v-model="selectedPackage.price" step="0.01" placeholder="Price" required />
            <button type="submit">{{ isEditMode ? 'Update' : 'Create' }}</button>
            <button type="button" @click='closeForm'>Cancel</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: 'SeoPackagesView',
    data() {
        return {
            packages: [],
            showForm: false,
            isEditMode: false,
            selectedPackage: {
                packageId: null,
                name: '',
                description: '',
                price: 0.0
            }
        };
    },
    methods: {
        async fetchPackages() {
            try {
                const response = await fetch('/api/packages');
                this.packages = await response.json();
            } catch (error) {
                console.error('Error fetching packages:', error);
            }
        },
        formatPrice(price) {
            return Number(price).toFixed(2);
        },
        openCreateForm() {
            this.isEditMode = false;
            this.selectedPackage = {
                packageId: null,
                name: '',
                description: '',
                price: 0.0
            };
            this.showForm = true;
        },
        openEditForm(pkg) {
            this.isEditMode = true;
            this.selectedPackage.packageId = pkg.packageId;
            this.selectedPackage.name = pkg.name;
            this.selectedPackage.description = pkg.description;
            this.selectedPackage.price = pkg.price;
            this.showForm = true;
        },
        closeForm() {
            this.showForm = false;
        },
        async submitForm() {
            const method = this.isEditMode ? 'PUT' : 'POST';
            const url = this.isEditMode
            ? `/api/packages/${this.selectedPackage.packageId}`
            : '/api/packages';

            const token = this.$store.state.token;

            const response = await fetch(url, {
                method,
                headers: { 
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify(this.selectedPackage)
            });

            if(response.ok) {
                this.fetchPackages();
                this.closeForm();
            } else {
                console.error('Failed to save package');
            }
        },
        async deletePackage(id) {
            const confirmed = confirm('Are you sure you want to delete this package?');
            if (!confirmed) return;

            const token = this.$store.state.token;

            const response = await fetch(`/api/packages/${id}`, {
                method: 'DELETE',
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });

            if (response.ok) {
                this.fetchPackages();
            } else {
                console.error('Failed to delete package');
            }
        }
    },
    mounted() {
        this.fetchPackages();
    }
};
</script>

<style scoped>
.seo-packages {
    padding: 2rem;
    color: #2d3142;
}

.header-bar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 1rem;
}

.header-bar h2 {
    font-size: 1.75rem;
}

.header-bar button {
    background-color: #ef8354;
    color: white;
    border: none;
    padding: 0.5rem 1rem;
    font-weight: bold;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.2s ease;
}

.header-button:hover {
    background-color: #d56b3a;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 1rem;
}

th, td {
    border: 1px solid #ccc;
    padding: 0.5rem;
    text-align: left;
    vertical-align: top;
}

th {
    background-color: #f0f0f0;
    font-weight: 600;
}

td button {
    margin-right: 0.5rem;
    padding: 0.4rem 0.75rem;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

td button {
    margin-right: 0.5rem;
    padding: 0.4rem 0.75rem;
    border: none;
    border-radius: 4px;
    cursor: pointer;
 }

 td button:first-of-type {
    background-color: #4f5d75;
    color: white;
 }

 td button:hover {
    opacity: 0.85;
 }

 .modal {
    margin-top: 2rem;
    padding: 1.5rem;
    background: #f5f5f5;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
 }

 .modal input,
 .modal textarea {
    width: 100%;
    margin-bottom: 1rem;
    padding: 0.5rem;
    border: 1px solid #ccc;
 }

 .modal button {
    margin-right: 0.5rem;
    padding: 0.5rem;
    font-weight: bold;
    border: none;
    border-radius: 4px;
    cursor: pointer;
 }

 .modal button[type='submit'] {
    background-color: #4f5d75;
    color: white;
 }

 .modal button[type='submit']:hover {
    background-color: #3e4b60;
 }

 .modal button[type='button'] {
    background-color: #ccc;
    color: #333;
 }

 .modal button[type='button']:hover {
    background-color: #bbb;
 }

 .admin-dashboard-content {
    flex-grow: 1;
    min-width: 0;
    padding: 2rem;
 }
</style>