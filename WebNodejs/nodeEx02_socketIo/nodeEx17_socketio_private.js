 
var http = require('http');
var fs = require('fs'); 
var socketio = require('socket.io');
var server = http.createServer((request, response)=>{
	 
	if(request.url=="/chat"){
		fs.readFile(__dirname+'\\chattingForm1.html','utf-8', (error, data)=>{
			if(error){//읽기 실패 
				response.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
				response.end(data);
			}else{
				response.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
				response.end(data);
			} 	 
		});
	}else{
		response.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
		response.end("404 Page Error");
	} 
	}); 
server.listen(15001, ()=>{
	console.log("server start ->http://localhost/chat"); 

}); 
 
//==============================================
var io = socketio.listen(server);

//접속을 기다리는 이벤트 
io.sockets.on('connection',(socket)=>{
	console.log('socketId->', socket.id, "클라이언트가 접속함");
	var  id = socket.id;//통신할 접속자의 id를 전역변수에 보관한다
	
	socket.on('hello', (clientMsg)=>{//클라이언트가 hello 이벤트를 발생시킬 경우 clientMsg에 저장		
		console.log('clientMsg->',clientMsg);
		//클라이언트가 문자보내는 이벤트 발생
		io.sockets.in(id).emit('echo', 'Server Msg->'+clientMsg);
	});
});	