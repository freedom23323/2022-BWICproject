const http = require("http");
const WebSocketServer = require('websocket').server

// Setup Websocket server
const server = http.createServer(function (request, response) {
    console.log(response);
    response.end()
});

server.listen(3000, function () {
    console.log((new Date()) + ' Server is listening on port 3000.');
});

webServer = new WebSocketServer({
    httpServer: server
});

// setup connection with client
webServer.on("request", function (request) {
    var connection = request.accept(null, request.origin);

    connection.on('message', function (message) {
        console.log(message)
    });

    setInterval(function () {
        connection.sendUTF("Message: " + new Date());
    }, 10000)
});