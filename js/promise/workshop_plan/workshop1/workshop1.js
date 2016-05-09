(function () {
    var https = require('https');
    var Promise = require("bluebird");

    module.exports.getMyGithubRepos = function () {
        var responseBody = "";
        https.get({
                host: 'api.github.com',
                path: '/users/cuipengfei/repos',
                headers: {
                    'User-Agent': 'Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.13) Gecko/20080311 Firefox/2.0.0.13'
                }
            }, function (res) {
                console.log('Got response: ' + res.statusCode);
                res.on('data', function (chunk) {
                    responseBody += chunk;
                });
                res.on('end', function () {
                    console.log(
                        JSON.parse(responseBody).map(function (repo) {
                            return repo.name;
                        }));
                })
            })
            .on('error', function (e) {
                console.log('Got error: ' + e.message);
            });
    };

    module.exports.one = 1;
})();