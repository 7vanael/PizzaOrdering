<template>
    <section class="container-fluid">
        <div class="row">
            <div class="col-2">
                <div class="menu">
                    <div class="menu-items">
                        <div class="menu-item">
                            <a href="#pizzas"><h3>Pizzas</h3></a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas"><h3>Salads</h3></a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas"><h3>Sides</h3></a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas"><h3>Kid's Meal</h3></a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas"><h3>Beverages</h3></a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas"><h3>Desserts</h3></a>
                        </div>
                        <div class="menu-item">
                            <a href="#pizzas"><h3>Deals</h3></a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-10">
                <div id="carouselExampleCaptions" class="carousel slide">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3"
                            aria-label="Slide 4"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4"
                            aria-label="Slide 5"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="5"
                            aria-label="Slide 6"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="6"
                            aria-label="Slide 7"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="../images/BBQ chicken pizza.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>The Back-End</h5>
                                <p>BBQ sauce, BBQ chicken, onions, and tons of cheese</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="../images/tomato basil pizza.jpeg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>The Front-End</h5>
                                <p>Sliced tomatoes, mozzarella cheese, garlic, fresh basil, and extra-virgin olive oil</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="../images/veggie pizza.webp" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>The Debugger</h5>
                                <p>Pesto sauce with shredded mozzarella cheese and topped with fresh green peppers, black
                                    olives,
                                    onions, mushrooms, and fresh basil leaves.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="../images/Meat Lovers.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>The Framework</h5>
                                <p>Served with crumbled Italian sausage, bacon, and pepperoni.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="../images/supreme pizza.webp" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>The Full-Stack</h5>
                                <p>Delicious pepperoni, sausage, onions, green peppers, mushrooms, and olives.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="../images/classic cheese pizza.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>The Constructor</h5>
                                <p>A classic cheese pizza. Add some jalapenos to spicy up your night!</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="../images/custom pizza.jpeg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>The Polymorph</h5>
                                <p>Design your pizza YOUR way!</p>
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
            <CustomPizzaMenu />
            
        </div>
        
    </section>
</template>


<script>
import CustomPizzaMenu from './CustomPizzaMenu.vue';



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