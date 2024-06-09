<template>
    <div class="page">
    <NavBar />
    <div class="container">
        <main>
            <h1> Menu Coming Soon!</h1>
            <router-link v-bind:to="{ name: 'home' }">
                <h2> Return to Home </h2>
            </router-link>
        </main>
    </div>
</div>
</template>

<script>
import NavBar from '../components/NavBar.vue';

export default {
    components: {
        NavBar
    },
}
</script>

<style scoped>
.page {
    background-color: rgba(0, 0, 0, 0.918);
}
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-image: url("../../public/images/prototype_logo.jpg");
    background-size: cover;
    background-position: center;
    opacity: 0.8;
}
main {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: #A4200B;
    padding: 20px;
    border: 2px solid #F7C516;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin: 20px;
    width: 50%;
    text-align: center;
}
h1, h2 {
    color: #F2DC9C;
    text-transform: capitalize;
}
</style>