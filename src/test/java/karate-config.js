function fn() {
    var env = karate.env; // get java system property 'karate.env'
    karate.log('karate.env system property was:', env);

    var config = {
        baseUrl: 'https://api.example.com',
        jsonplaceholderUrl: 'https://jsonplaceholder.typicode.com'
    };

    if (env == 'dev') {
        config.baseUrl = 'https://dev-api.example.com';
    } else if (env == 'qa') {
        config.baseUrl = 'https://qa-api.example.com';
    }

    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);

    return config;
} 