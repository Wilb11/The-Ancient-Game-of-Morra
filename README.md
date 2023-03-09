# The-Ancient-Game-of-Morra

Description:

Morra is a hand game that dates back thousands of years. The rules are simple. If a two 
player game, each player (at the same time) must reveal their hand holding out zero to 
five fingers; at the same time, they must call out their guess about how many fingers 
total will be revealed by both players. If a player guesses correctly, they win a point. If 
both players guess correctly, no points are awarded. If no one guesses correctly, no 
points are awarded. The total number of points to win is determined before the game 
starts.

The implementation will be a two player game where each player is a separate client 
and the game is run by a server. The server and clients will use the same machine; 
with the server choosing a port on the local host and clients knowing the local host and 
port number (just as was demonstrated in class). Games will be played until one of the 
players has two points. At the end of each game, each user will be able to play again or 
quit.

All networking must be done utilizing Java Sockets. The server 
must run on its own thread and handle each client on a separate thread. Each 
client must connect and communicate with the server on a separate thread. 
