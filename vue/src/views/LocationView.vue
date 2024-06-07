<template>
    <NavBar />
    <div id="location">
        <div class="location-info">
            <h1>Our Location</h1>
            <p>1234 Pizza Place</p>
            <p>Pizza City, PZ 91224</p>
            <p>867-5309</p>
        </div>
        <section class="map">
            <iframe
                src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3056.5094430507183!2d-83.04509488722842!3d39.99706677139131!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sus!4v1717687073938!5m2!1sen!2sus"
                allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        </section>
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


<style scoped>
#location {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    color: #A4200B;
    background-color: #F7c516;
}

h1 {
    text-align: center;
    color: #2892C4;
    font-weight: bold;
    font-size: 50pt;
    margin-bottom: 20px;
}

.location-info {
    display: flex;
    flex-direction: column;
    margin-top: 2rem;
    text-align: center;
    font-size: 26pt;
    font-weight: bold;
}

iframe {
    margin: 3em;
    height: 600px;
    width: 800px;
    border: 5px solid #2892C4;
}
</style>