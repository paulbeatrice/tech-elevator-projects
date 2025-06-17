<template>
    <div class="generate-report">
        <h2>PageSpeed Report Generator</h2>

        <form @submit.prevent="generateReport">
            <input v-model="url" type="url" placeholder="Enter website URL" required />
            <button type="submit">Generate Report</button>
        </form>

        <div v-if="report" class="results">
            <h3>Results for: {{ url }}</h3>
            <p><strong>Performance Score:</strong>{{ report.performance_score * 100 }}</p>
            <p><strong>First Contentful Paint:</strong>{{ report.first_contentful_paint }}</p>
            <p><strong>Largest Contentful Paint:</strong>{{ report.largest_contentful_paint }}</p>
            <p><strong>Cumulative Layout Shift:</strong>{{ report.cumulative_layout_shift }}</p>
        </div>

        <p v-if="error" style="color: red">{{ error }}</p>
    </div>
</template>

<script>
export default {
    name: 'GenerateReportView',
    data() {
        return {
            url: '',
            report: null,
            error: ''
        };
    },
    methods: {
        async generateReport() {
            this.report = null;
            this.error = '';

            const token = this.$store.state.token;

            try {
                const res = await fetch(`/api/pagespeed?url=${encodeURIComponent(this.url)}`, {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });

                const data = await res.json();
                if(!res.ok) {
                    this.error = data.error || 'Something went wrong';
                } else {
                    this.report = data;
                }
            } catch (error) {
                this.error = 'Network error. Please try again.';
            }
        }
    }
};
</script>

<style scoped>
.generate-report {
    padding: 2rem;
    color: #2d3142;
}

input {
    padding: 0.5rem;
    width: 100%;
    max-width: 400px;
    margin-bottom: 1rem;
}

button {
    background-color: #ef8354;
    color: white;
    padding: 0.5rem 1rem;
    border: none;
    cursor: pointer;
    font-weight: bold;
    border-radius: 4px;
}

.results {
    margin-top: 2rem;
    padding: 1rem;
    background: #f5f5f5;
    border-radius: 8px;
}
</style>