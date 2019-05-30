module.exports = {
    pages: {
        index: 'src/main.js',
    },
    devServer: {
        port: 8081,
        proxy: {
            '/api': {
                target: 'http://localhost:8080'
            },
            '/books': {
                target: 'http://localhost:8080'
            },
        }
    }
}