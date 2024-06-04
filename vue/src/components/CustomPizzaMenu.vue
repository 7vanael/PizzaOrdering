<template>
  <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist" style="height: 20px">
    <li class="nav-item" role="presentation">
      <a class="nav-link" id="pills-crust-tab" data-bs-toggle="pill" data-bs-target="#pills-crust" type="button"
        role="tab" aria-controls="pills-crust" aria-selected="true">Crust and Size
      </a>
    </li>
    <li class="nav-item" role="presentation">
      <a class="nav-link" id="pills-sauce-cheese-tab" data-bs-toggle="pill" data-bs-target="#pills-sauce-cheese"
        type="button" role="tab" aria-controls="pills-sauce-cheese" aria-selected="false">Sauce and Cheese
      </a>
    </li>
    <li class="nav-item" role="presentation">
      <a class="nav-link" id="pills-meat-tab" data-bs-toggle="pill" data-bs-target="#pills-meat" type="button" role="tab"
        aria-controls="pills-meat" aria-selected="false">Meats
      </a>
    </li>
    <li class="nav-item" role="presentation">
      <a class="nav-link" id="pills-veggies-tab" data-bs-toggle="pill" data-bs-target="#pills-veggies" type="button" role="tab"
        aria-controls="pills-veggies" aria-selected="false">Veggies
      </a>
    </li>
  </ul>
  <!-- Crust and Size -->
  <div class="tab-content" id="pills-tabContent">
    <div class="tab-pane show active" id="pills-crust" role="tabpanel" aria-labelledby="pills-crust-tab">
      <div class="card" style="width: 100%;">
        <ul class="list-group list-group">
          <li class="list-group-item size-crust">Choose Size and Crust</li>
          <li class="list-group-item">
            <div class="card card-radio my-20" style="width: 100%;">
              <ul class="list-group">
                <li class="list-group-item pg-1-card-header">Regular</li>
                <li class="list-group-item">Garlic seasoned crust with a rich, buttery taste.
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
                <li class="list-group-item">
                  <label>
                    <input type="radio" name="pizza-crust" value="medium-hand">
                  </label>
                  Large (14")
                </li>
              </ul>
            </div>
            <br>
            <div class="card card-radio" style="width: 100%;">
              <ul class="list-group">
                <li class="list-group-item pg-1-card-header">Deep Dish</li>
                <li class="list-group-item">Chicago-style deep dish crust with a buttery, flaky exterior.
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="radio" name="pizza-crust" value="small-crispy">
                  </label>
                  Small (10")
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
            <br>
            <div class="card card-radio" style="width: 100%;">
              <ul class="list-group">
                <li class="list-group-item pg-1-card-header">Thin</li>
                <li class="list-group-item">Thin enough for optimum crispy to crunchy ratio.
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="radio" name="pizza-crust" value="small-crispy">
                  </label>
                  Small (12")
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="radio" name="pizza-crust" value="medium-crispy">
                  </label>
                  Medium (14")
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="radio" name="pizza-crust" value="large-crispy">
                  </label>
                  Large (16")
                </li>
              </ul>
            </div>
            <br>
            <div class="card card-radio" style="width: 100%;">
              <ul class="list-group">
                <li class="list-group-item pg-1-card-header">Cauliflower</li>
                <li class="list-group-item">Gluten-free cauliflower crust with a buttery, flaky exterior.
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="radio" name="pizza-crust" value="small-crispy">
                  </label>
                  Small (12")
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="radio" name="pizza-crust" value="medium-crispy">
                  </label>
                  Medium (14")
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="radio" name="pizza-crust" value="large-crispy">
                  </label>
                  Large (16")
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
    <!-- Cheese and Sauce -->
    <div class="tab-pane" id="pills-sauce-cheese" role="tabpanel" aria-labelledby="pills-sauce-cheese-tab">
      <div class="card" style="width: 100%;">
        <ul class="list-group list-group">
          <li class="list-group-item cheese-sauce">Choose Sauce and Cheese</li>
          <li class="list-group-item">
            <!--Sauce-->
            <div class="card card-radio" style="width: 100%;">
              <ul class="list-group list-group">
                <li class="list-group-item pg-2-card-header">Pick Your Sauce</li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="pizza-sauce" value="tomato">
                  </label> Tomato
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="pizza-sauce" value="pesto">
                  </label> Pesto
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="pizza-sauce" value="alfredo">
                  </label> Alfredo
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="pizza-sauce" value="BBQ">
                  </label> BBQ
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
            <br />
            <!--Cheese-->
            <div class="card card-radio my-20" style="width: 100%;">
              <ul class="list-group list-group">
                <li class="list-group-item pg-2-card-header">Pick Your Cheese</li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="pizza-cheese" value="house-blend">
                  </label> House Blend
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="pizza-cheese" value="mozzarella">
                  </label> Fresh Mozzarella
                </li>
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
          </li>
          <div class="card-footer d-flex justify-content-end my-1">
            <button class="next-step"> Previous</button>
            <button class="next-step">Next ></button>
          </div>
        </ul>
      </div>
    </div>
    <!-- Meats-->
    <div class="tab-pane" id="pills-meat" role="tabpanel" aria-labelledby="pills-meat-tab">
      <div class="card" style="width: 100%;">
        <ul class="list-group list-group">
          <li class="list-group-item toppings">Choose Your Meat</li>
          <li class="list-group-item">
            <!--Meats-->
            <div class="card card-radio my-20" style="width: 100%;">
              <ul class="list-group list-group">

                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="meat-toppings" value="pepperoni">
                  </label>
                  Pepperoni
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="meat-toppings" value="italian-sausage">
                  </label>
                  Italian Sausage
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="meat-toppings" value="bacon">
                  </label>
                  Bacon
                </li>
                <li class="list-group-item">
                  <label>
                    <input type="checkbox" name="meat-toppings" value="chicken">
                  </label>
                  BBQ Chicken
                </li>
              </ul>
            </div>
            <div class="card-footer d-flex justify-content-end my-1">
            <button class="next-step"> Previous</button>
            <button class="next-step">Next ></button>
          </div>
          </li>
        </ul>
      </div>
    </div>
    <div class="tab-pane" id="pills-veggies" role="tabpanel" aria-labelledby="pills-veggies-tab">
        <div class="card" style="width: 100%;">
          <ul class="list-group list-group">
            <li class="list-group-item toppings">Choose Veggies</li>
            <li class="list-group-item">
              <!--Non-Meats-->
              <div class="card card-radio" style="width: 100%;">
                <ul class="list-group list-group">
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
                  <li class="list-group-item">
                    <label>
                      <input type="checkbox" name="non-meat-toppings" value="basil">
                    </label>
                    Basil
                  </li>
                  <li class="list-group-item">
                    <label>
                      <input type="checkbox" name="non-meat-toppings" value="black-olives">
                    </label>
                    Black Olives
                  </li>
                  <li class="list-group-item">
                    <label>
                      <input type="checkbox" name="non-meat-toppings" value="green-olives">
                    </label>
                    Green Olives
                  </li>
                  <li class="list-group-item">
                    <label>
                      <input type="checkbox" name="non-meat-toppings" value="tomato-slices">
                    </label>
                    Tomato Slices
                  </li>
                  <li class="list-group-item">
                    <label>
                      <input type="checkbox" name="non-meat-toppings" value="pineapple">
                    </label>
                    Pineapple
                  </li>
                </ul>
              </div>
            </li>
            <li class="list-group-item">
            </li>
          </ul>
          <div class="card-footer d-flex justify-content-end">
            <button class="next-step">Checkout
              <svg xmlns="http://www.w3.org/2000/svg" height="1em"
                viewBox="0 0 576 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                <path
                  d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z" />
              </svg>
            </button>
          </div>
        </div>
      </div>
  </div>
</template>


<script>

</script>


<style>
svg {
  fill: #ffffff
}
</style>