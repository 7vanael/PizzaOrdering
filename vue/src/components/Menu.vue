<template>
    <section class="container-fluid">
        <div class="row">
            <div class="col-2">
                <div class="menu">
                    <div class="menu-items">
                        <div class="menu-item">
                            <a href="#pizzas">
                                <h3>Pizzas</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas">
                                <h3>Salads</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas">
                                <h3>Sides</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas">
                                <h3>Kid's Meal</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas">
                                <h3>Beverages</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas">
                                <h3>Desserts</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas">
                                <h3>Deals</h3>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-10">
                <div id="carouselExampleCaptions" class="carousel slide">
                    <div class="carousel-indicators">
                        <button v-for="(pizza, index) in pizzas" :key="index" type="button"
                            :data-bs-target="'#carouselExampleCaptions'" :data-bs-slide-to="index"
                            :class="{ active: index === 0 }" :aria-current="index === 0 ? 'true' : undefined"
                            :aria-label="'Slide ' + (index + 1)"></button>
                    </div>

                    <div class="carousel-inner">
                        <div v-for="(pizza, index) in pizzas" :key="pizza.name"
                            :class="['carousel-item', { active: index === 0 }]">
                    <img :src="images.image" class="d-block w-100" alt="pizza image">
                            <!-- <img src="../images/BBQ chicken pizza.jpg" class="d-block w-100" alt="..."> -->
                            <div class="carousel-caption d-none d-md-block">
                                <h5>{{ pizza.name }}</h5>
                                <p>{{ pizza.description }}</p>
                            </div>

                        </div>

                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>

                </div>
            </div>

        </div>
        <CustomPizzaMenu />


    </section>
</template>


<script>
import ToppingsService from '../services/ToppingsService';
import CustomPizzaMenu from './CustomPizzaMenu.vue';

export default {
    data() {
        return {
            images: [
                { 
                    name: 'AI margherita pizza',
                    image: '../images/AI margherita pizza.webp'
                },
                { 
                    name: 'BBQ chicken pizza',
                    image: '../images/BBQ chicken pizza.jpg'
                },
                { 
                    name: 'Classic Cheese',
                    image: '../images/classic cheese pizza.jpg'
                },
                { 
                    name: 'Custom Pizza',
                    image: '../images/custom pizza.jpg'
                },
                { 
                    name: 'Meat Lovers',
                    image: '../images/Meat Lovers.jpg'
                },
                { 
                    name: 'Supreme pizza',
                    image: '../images/supreme pizza.webp'
                },
                { 
                    name: 'Tomato Basil pizza',
                    image: '../images/tomato basil pizza.jpeg'
                },
                { 
                    name: 'Veggie Pizza',
                    image: '../images/veggie pizza.webp'
                }
                
        ],
        pizzas: [],
        };
    },
    created() {
        ToppingsService.getPizzas().then(response => {
            this.pizzas = response.data;
        });
    }
}



</script>


<style scoped>
.container-fluid {
    margin-top: 20px;
    background-color: #2892C4;
    border: 2px solid #2892C4;
    border-radius: 5px;
    padding: 20px;
    min-height: 40dvh;
}

.row {
    display: flex;
    min-height: 100%;
    background-color: #2892C4;
}

.menu-items {
    display: flex;
    flex-direction: column;
    height: 100%;
}

.menu-item {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 70px;
    width: 100%;
    background-color: #F7C516;
    border: 2px solid #2892C4;
    border-radius: 5px;
    color: #A4200B;
    text-transform: capitalize;
}

img {
    height: 500px;
    /* width: 100%; */
    object-fit: cover;
}

.carousel-control-prev {
    width: 5%;
    height: 100%;
    background-color: #A4200B;
    border: 2px solid #A4200B;
    border-radius: 5px;
}

.carousel-control-next {
    width: 5%;
    height: 100%;
    background-color: #A4200B;
    border: 2px solid #A4200B;
    border-radius: 5px;
}

h5,
p {
    color: #F7C516;
}

.carousel-caption {
    background-color: #A4200B;
    border: 2px solid #A4200B;
    border-radius: 5px;
    opacity: .9;
}
</style>