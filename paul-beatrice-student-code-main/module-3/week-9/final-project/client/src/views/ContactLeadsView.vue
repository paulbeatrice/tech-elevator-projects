<template>
    <div class="contact-leads">
        <h2>Contact Submission Leads</h2>

        <table v-if="submissions.length">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Business</th>
                    <th>Website</th>
                    <th>Platform</th>
                    <th>Social Link</th>
                    <th>Message</th>
                    <th>Submitted At</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="submission in submissions" :key="submission.id">
                    <td>{{ submission.name }}</td>
                    <td>{{ submission.email }}</td>
                    <td>{{ submission.phone }}</td>
                    <td>{{ submission.businessName }}</td>
                    <td>{{ submission.businessWebsite }}</td>
                    <td>{{ submission.socialPlatform }}</td>
                    <td>{{ submission.socialLink }}</td>
                    <td>{{ submission.message }}</td>
                    <td>{{ formatDate(submission.submittedAt) }}</td>
                </tr>
            </tbody>
        </table>

        <p v-else>No contact submissions found.</p>
    </div>
</template>

<script>
export default {
    name: 'ContactLeadsView',
    data() {
        return {
            submissions: []
        };
    },
    methods: {
        async fetchSubmissions() {
            const res = await fetch('/api/contact-submissions');
            this.submissions = await res.json();
        },
        formatDate(dateStr) {
            return new Date(dateStr).toLocaleString();
        }
    },
    mounted() {
        this.fetchSubmissions();
    }
};
</script>

<style scoped>
.contact-leads {
    padding: 2rem;
    color: #2d3142;
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
}
</style>