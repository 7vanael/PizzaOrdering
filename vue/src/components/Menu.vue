<template>
    <section class="container-fluid">
        <div class="row">
            <!-- <div class="col-2"> -->
                <div class="menu">
                    <div class="menu-items">
                        <div v-for="(menuItem, index) in menuItems" :key="index" class="menu-item">
                            <a href="#" @click="showCarousel(menuItem.type)">
                                <h3>{{ menuItem.label }}</h3>
                            </a>
                        </div>
                        <!-- <div class="menu-item">
                            <a href="#salads">
                                <h3>Salads</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#sides">
                                <h3>Sides</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#kids">
                                <h3>Kid's Meal</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#beverages">
                                <h3>Beverages</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#desserts">
                                <h3>Desserts</h3>
                            </a>
                        </div>
                        <div class="menu-item">
                            <a href="#deals">
                                <h3>Deals</h3>
                            </a>
                        </div> -->
                    </div>
                </div>
            <!-- </div> -->


            <!-- <div class="col-10"> -->

<!-- Pizza Carousel-->
                <div v-if="menuItems === 'Pizzas'">
                    <div id="pizzas-carousel" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button v-for="(pizza, index) in pizzas" :key="index" type="button"
                                :data-bs-target="'#pizzas-carousel'" :data-bs-slide-to="index"
                                :class="{ active: index === 0 }" :aria-current="index === 0 ? 'true' : undefined"
                                :aria-label="'Slide ' + (index + 1)">
                            </button>
                        </div>
                        <div class="carousel-inner">
                            <div v-for="(pizza, index) in pizzas" :key="pizza.name"
                                :class="['carousel-item', { active: index === 0 }]">
                                <img :src="pizza.image" class="d-block w-100" :alt="pizza.name">
                                <div class="carousel-caption d-none d-md-block">
                                    <h5>{{ pizza.name }}</h5>
                                    <p>{{ pizza.description }}</p>
                                </div>
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

<!-- Salad Carousel-->
                <div v-else="selectedCarousel === 'Salads'">
                    <div id="salads-carousel" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button v-for="(salad, index) in salads" :key="index" type="button"
                                :data-bs-target="'#salads-carousel'" :data-bs-slide-to="index"
                                :class="{ active: index === 0 }" :aria-current="index === 0 ? 'true' : undefined"
                                :aria-label="'Slide ' + (index + 1)">
                            </button>
                        </div>
                        <div class="carousel-inner">
                            <div v-for="(salad, index) in salads" :key="salad.name"
                                :class="['carousel-item', { active: index === 0 }]">
                                <img :src="salad.image" class="d-block w-100" :alt="salad.name">
                                <div class="carousel-caption d-none d-md-block">
                                    <h5>{{ salad.name }}</h5>
                                    <p>{{ salad.description }}</p>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" :data-bs-target="'#salads-carousel'"
                            data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" :data-bs-target="'#salads-carousel'"
                            data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
<!-- Sides Carousel-->

<!-- Kids Carousel-->

<!-- Beverages Carousel-->

<!-- Desserts Carousel-->

<!-- Deals Carousel-->



            <!-- </div> -->
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
            images:
            {
                'The Front-End': '../images/AI_margherita_pizza.webp',
                'The Default': '../images/pepperoni_pizza.jpg',
                'The Back-End': '../images/BBQ_chicken_pizza.jpg',
                'The Constructor': '../images/classic_cheese_pizza.jpg',
                'The Polymorph': '../images/custom_pizza.jpeg',
                'The Framework': '../images/Meat_Lovers.jpg',
                'The Compiler': '../images/supreme_pizza.webp',
                'The API': '../images/tomato_basil_pizza.jpeg',
                'The Debugger': '../images/veggie_pizza.webp',
                'The Full-Stack': '../images/full_stack_pizza.jpg'
            },
            pizzas: [],
            salads: [
                {
                    name: 'Salad',
                    description: 'Eat your greens, boys and girls!',
                    image: '../images/prototype_logo.jpg'
                }
            ],
            menuItems: [
                { label: 'Pizzas', type: 'pizzas' },
                { label: 'Salads', type: 'salads' },
                // { label: 'Sides', type: 'sides' },
                // { label: 'Kid\'s Meal', type: 'kids' },
                // { label: 'Beverages', type: 'beverages' },
                // { label: 'Desserts', type: 'desserts' },
                // { label: 'Deals', type: 'deals' }
            ],
        };
    },
    created() {
        ToppingsService.getPizzas().then(response => {
            this.pizzas = response.data;
        });
        // ToppingsService.getSalads().then(response => {
        // this.salads = response.data;
        // });
    },
    methods: {
        showCarousel(type) {
            this.selectedCarousel = type;
        }
    }
    
};



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