<template>
    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist" style="height: 20px">
        <li class="nav-item" role="presentation">
            <a class="nav-link" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
                role="tab" aria-controls="pills-home" aria-selected="true"><span
                    class="badge rounded-pill bg-secondary">1</span>Size and Crust
            </a>
        </li>
        <li class="nav-item" role="presentation">
            <a class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button"
                role="tab" aria-controls="pills-profile" aria-selected="false"><span
                    class="badge rounded-pill bg-primary">2</span>Cheese and
                Sauce
            </a>
        </li>
        <li class="nav-item" role="presentation">
            <a class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" type="button"
                role="tab" aria-controls="pills-contact" aria-selected="false"><span
                    class="badge rounded-pill bg-danger">3</span>Toppings
            </a>
        </li>
    </ul>
    <div class="tab-content" id="pills-tabContent">
        <div class="tab-pane show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
            <div class="card" style="width: 100%;">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item size-crust">Choose Size and Crust</li>
                    <li class="list-group-item">
                        <div class="card card-radio my-20" style="width: 100%;">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item pg-1-card-header">Hand Tossed</li>
                                <li class="list-group-item">Garlic seasoned crust with a rich, buttery
                                    taste.
                                </li>
                                <li class="list-group-item">
                                    <label>
                                        <input type="radio" name="pizza-crust" value="small-hand">
                                    </label>
                                    Small (10")
                                </li>
                                <li class="list-group-item">
                                    <label>
                                        <input type="radio" name="pizza-crust" value="medium-hand">
                                    </label>
                                    Medium (12")
                                </li>
                            </ul>
                        </div>
                        <br>
                        <div class="card card-radio" style="width: 100%;">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item pg-1-card-header">Crispy Thin</li>
                                <li class="list-group-item">Thin enough for optimum crispy to crunchy ratio
                                    .
                                </li>
                                <li class="list-group-item">
                                    <label>
                                        <input type="radio" name="pizza-crust" value="medium-crispy">
                                    </label>
                                    Medium (12")
                                </li>
                                <li class="list-group-item">
                                    <label>
                                        <input type="radio" name="pizza-crust" value="large-crispy">
                                    </label>
                                    Large (14")
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="list-group-item">
                    </li>
                </ul>
                <div class="card-footer d-flex justify-content-end">
                    <button class="next-step" id="nextButton">Next Step ></button>
                    <a href="#pills-profile" data-toggle="tab"></a>
                </div>
            </div>
        </div>
        <div class="tab-pane" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
            <div class="card" style="width: 100%;">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item cheese-sauce">Choose Cheese and Sauce</li>
                    <li class="list-group-item">
                        <div class="card card-radio my-20" style="width: 100%;">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item pg-2-card-header">Cheese</li>
                                <li class="list-group-item">How Much?</li>
                                <li class="list-group-item">
                                    <label>
                                        <select id="cheese-amount" name="cheese">
                                            <option value="light">Light</option>
                                            <option value="normal">Normal</option>
                                            <option value="extra">Extra</option>
                                            <option value="double">Double</option>
                                        </select>
                                    </label>
                                </li>
                            </ul>
                        </div>
                        <br>
                        <div class="card card-radio" style="width: 100%;">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item pg-2-card-header">Sauce</li>
                                <li class="list-group-item">What Type?</li>
                                <li class="list-group-item">
                                    <label>
                                        <select id="sauce-type" name="sauce-type">
                                            <option value="tomato">Tomato</option>
                                            <option value="marinara">Marinara</option>
                                            <option value="bbq">BBQ</option>
                                            <option value="alfredo">Alfredo</option>
                                        </select>
                                    </label>
                                </li>
                                <li class="list-group-item">How Much?</li>
                                <li class="list-group-item">
                                    <label>
                                        <select id="sauce-amount" name="cheese">
                                            <option value="light">Light</option>
                                            <option value="normal">Normal</option>
                                            <option value="extra">Extra</option>
                                        </select>
                                    </label>
                                </li>
                            </ul>
                        </div>

                    </li>
                </ul>
            </div>
        </div>
    
    <div class="tab-pane" id="pills-contact" role="tabpanel" aria-labelledby="pills-profile-tab">
                        <div class="card" style="width: 100%;">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item toppings">Choose Toppings</li>
                                <li class="list-group-item">
                                    <div class="card card-radio my-20" style="width: 100%;">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item pg-3-card-header">Choose Meats</li>
                                            <li class="list-group-item">
                                                <label>
                                                    <input type="checkbox" name="meat-toppings" value="beef">
                                                </label>
                                                Beef
                                            </li>
                                            <li class="list-group-item">
                                                <label>
                                                    <input type="checkbox" name="meat-toppings" value="ham">
                                                </label>
                                                Ham
                                            </li>
                                            <li class="list-group-item">
                                                <label>
                                                    <input type="checkbox" name="meat-toppings" value="philly">
                                                </label>
                                                Philly Steak
                                            </li>
                                            <li class="list-group-item">
                                                <label>
                                                    <input type="checkbox" name="meat-toppings" value="bacon">
                                                </label>
                                                Bacon
                                            </li>
                                        </ul>
                                    </div>
                                    <br>
                                    <div class="card card-radio" style="width: 100%;">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item pg-3-card-header">Choose Non-meats</li>
                                            <li class="list-group-item">
                                                <label>
                                                    <input type="checkbox" name="non-meat-toppings" value="green-peppers">
                                                </label>
                                                Green Peppers
                                            </li>
                                            <li class="list-group-item">
                                                <label>
                                                    <input type="checkbox" name="non-meat-toppings" value="mushrooms">
                                                </label>
                                                Mushrooms
                                            </li>
                                            <li class="list-group-item">
                                                <label>
                                                    <input type="checkbox" name="non-meat-toppings" value="onions">
                                                </label>
                                                Onions
                                            </li>
                                            <li class="list-group-item">
                                                <label>
                                                    <input type="checkbox" name="non-meat-toppings" value="jalapeno">
                                                </label>
                                                Jalape&#241;o Peppers
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                </li>
                            </ul>
                        </div>
                    </div></div>
    
                
</template>

<script>
export default {

}
</script>

<style></style>