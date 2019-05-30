import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('./views/Dashboard.vue')
        },
        {
            path: '/projects',
            name: 'projects',
            component: () => import('./views/Projects.vue')
        },
        {
            path: '/project/:id',
            name: 'projectEdit',
            props: true,
            component: () => import('./views/Project.vue')
        },
        {
            path: '/project',
            name: 'projectCreate',
            component: () => import('./views/Project.vue')
        },
        {
            path: '/system',
            name: 'system',
            props: true,
            component: () => import('./views/System.vue')
        },
    ]
})
