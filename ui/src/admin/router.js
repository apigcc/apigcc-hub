import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/login',
            name: 'login',
            component: () => import('./views/Login.vue')
        },
        {
            path: '/',
            name: 'home',
            component: () => import('./views/Dashboard.vue')
        },
        {
            path: '/doc',
            name: 'doc',
            component: () => import('./views/Doc.vue')
        },
    ]
})
