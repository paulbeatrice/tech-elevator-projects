<!-- Admin Dashboard -->
 <template>
    <div class="admin-dashboard-wrapper">
        <!-- Toggle Dashboard Sidebar -->
         <aside :class="['sidebar', {collapsed: isSidebarCollapsed }]">
         <button class="toggle-btn" @click="toggleSidebar">
            <img src="/assets/ellipsis-solid.svg" alt="Toggle Sidebar" />
        </button>

                <ul class="menu">
                    <li @click="goTo('users')">
                        <img src="/assets/user-regular.svg" alt="Users" />
                        <span v-if="!isSidebarCollapsed">Manage Users</span>
                    </li>
                    <li @click="goTo('orders')">
                        <img src="/assets/folder-regular.svg" alt="Orders" />
                        <span v-if="!isSidebarCollapsed">Manage Orders</span>
                    </li>
                    <li @click="goTo('report')">
                        <img src="/assets/file-lines-regular.svg" alt="Report" />
                        <span v-if="!isSidebarCollapsed">Generate Report</span>
                    </li>
                    <li @click="goTo('contact-submissions')">
                        <img src="/assets/address-book-regular.svg" alt="Leads" />
                        <span v-if="!isSidebarCollapsed">Contact Submission Leads</span>
                    </li>
                    <li @click="goTo('packages')">
                        <img src="/assets/pen-to-square-regular.svg" alt="Packages" />
                        <span v-if="!isSidebarCollapsed">Manage SEO Packages</span>
                    </li>
                </ul>
         </aside>

         <!-- Main Content -->
         <main class="admin-dashboard">
            <h1>Welcome, {{ user.name }}!</h1>
    

            <!-- Render sub-routes inside this layout -->
            <router-view :key="$route.fullPath"></router-view>
         </main>
    </div>
 </template>

 <script>
 export default {
    name: "AdminDashboard",
    computed: {
        user() {
            return this.$store.state.user;
        },
    },
    data() {
        return {
            isSidebarOpen: false,
            isSidebarCollapsed: false
        };
    },
    methods: {
        toggleSidebar() {
            this.isSidebarCollapsed = !this.isSidebarCollapsed;
        },
       goTo(path) {
        this.$router.push(`/admindashboard/${path}`);
       },
    },
 };
</script>

<style scoped>
.admin-dashboard-wrapper {
    display: flex;
    
}

.sidebar {
    background-color: #2d3142;
    color: white;
    min-height: 100vh;
    width: 220px;
    padding-top: 1rem;
    transition: width 0.3s ease;
    overflow-x: hidden;
}

.sidebar.collapsed {
    width: 60px;
}

.toggle-btn {
    background-color: #EF8354;
    border: none;
    color: white;
    margin: 0 auto 1rem auto;
    padding: 0.5rem;
    border-radius: 8px;
    width: 40px;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
}

.toggle-btn img {
    width: 20px;
    height: 20px;
}

.menu {
    list-style-type: none;
    padding: 0;
}

.menu li {
    display: flex;
    align-items: center;
    padding: 1rem;
    cursor: pointer;
    transition: background 0.2s ease;
}

.menu li:hover {
    background-color: #4F5D75;
}

.menu img {
    width: 20px;
    height: 20px;
    margin-right: 10px;
    filter: brightness(0) invert(1);
}

.sidebar.collapsed .menu li {
    justify-content: center;
}

.sidebar.sidebar.collapsed .menu span {
    display: none;
}

.admin-dashboard {
    flex-grow: 1;
    padding: 2rem;
    background-color: #f5f5f5;
    color: #2d3142;
}



</style>