<template>
    <NavBar />
    <div class="location">
        <h1>Location</h1>
        <div class="location-info">
            <h2>Our Location</h2>
            <p>1234 Pizza Place</p>
            <p>San Francisco, CA 94102</p>
            <p>415-555-1234</p>
        </div>
    </div>
</template>

<script>

import NavBar from '../components/NavBar.vue';

export default {
    components: {
        NavBar
    }
}

</script>