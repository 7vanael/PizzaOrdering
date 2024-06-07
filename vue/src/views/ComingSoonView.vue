<template>
    <NavBar />
    <h1> Feature Coming Soon!</h1>
    <nav>
        <router-link v-bind:to="{ name: 'home' }">
            <h1> Return to Home </h1>
        </router-link>
    </nav>
</template>

<script>
import NavBar from '../components/NavBar.vue';
export default {
    components: {
    NavBar
  },
}
</script>

<style>

</style>