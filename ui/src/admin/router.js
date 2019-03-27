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
            path: '/namespaces',
            name: 'namespaces',
            component: () => import('./views/Namespaces.vue')
        },
        {
            path: '/projects',
            name: 'projects',
            component: () => import('./views/Projects.vue')
        },
        {
            path: '/project',
            name: 'project',
            component: () => import('./views/Project.vue')
        },
        {
            path: '/users',
            name: 'users',
            component: () => import('./views/Users.vue')
        },
    ]
})
