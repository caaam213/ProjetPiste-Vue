<template>
    <footer class="footer">
        <div class="container">
            <p class="footer-text">{{ message }}</p>
        </div>
    </footer>
</template>

<script setup>
const message = 'Camélia - Clémence - Mélinda - Sacha - Polytech Lyon 2023';
</script>

<style scoped>
.footer {
    background-color: #f5f5f5;
    padding: 20px 0;
    text-align: center;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
}

.footer-text {
    font-size: 1.2rem;
    color: #888;
}
</style>