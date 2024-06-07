import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      activePizza:{},
      activeToppingsMeats:[],
      activeToppingsCheese:{},
      activeToppingsVeggies:[],
      currentOrder:{},
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_ACTIVE_PIZZA(state, pizza){
        state.activePizza = pizza;
      },
      SET_ACTIVE_MEATS(state, meats){
        state.activeToppingsMeats = meats;
      },
      SET_ACTIVE_CHEESE(state, cheese){
        state.activeToppingsCheese = cheese;
      },
      SET_ACTIVE_VEGGIES(state, veggies){
        state.activeToppingsVeggies = veggies;
      }
    },
  });
  return store;
}
