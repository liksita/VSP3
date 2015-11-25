==========================================================
Link's:
Aufgabe 2
https://pub.informatik.haw-hamburg.de/home/pub/prof/kossakowski_klaus-peter/wise2015/verteiltesysteme/VSAI-wise2015-Aufgabe-2.pdf

PUB/Kossakowski
https://pub.informatik.haw-hamburg.de/home/pub/prof/kossakowski_klaus-peter/wise2015/verteiltesysteme/

Building a simple RESTful API with Spark
http://www.mscharhag.com/java/building-rest-api-with-spark

===========================================================
Github's

https://github.com/kumpelblase2/vs-2
https://github.com/Slaan/vsp/
https://github.com/motation/VS
https://github.com/iNaD/vsp
https://github.com/Octav14n/VSP
https://github.com/d-is/Monopoly

===========================================================
сделал сегодня мало

1) чо-то я никак не соображу как начать игру, если все зареганные:
- Wenn alle Clients bereit sind, kann das Spiel beginnen – die erste Person muss anfangen zu würfeln!
известить мы никого не можем. мы же сервер, мы ждём запрос, или? но мы можем выкидывать инфу на экран
при запросе /get/gameID. игроки видят в первую очередь, кто активный сейчас (игроки бросают кубик в том порядке
 в котором регались). активный игрок видит кроме того адреса остальных сервисов (например /diсe).
 для этого можно и опциональные пункты задания имплементировать (тем более, что 2.6 уже готов):
{Optional 2.4: Implementieren Sie eine Repräsentation des Spielstandes bzw. Spielbretts für den Client. „It's nice to have a GUI“,
Optional  2.5: Implementieren Sie eine Anzeige, die darstellt, welche Spieler das Spiel bisher betreten haben, während gewartet wird,
Optional 2.5: Implementieren Sie, dass der Client den /games-Service nach aktuellen Spielen abfragen kann mit: get /games
}

а чтобы остальные не могли без очереди кубик кидать и ходить, я сделал в Game.java поле nowPlaying, и после завершения входа сохраняю там следующего игрока.

2) GameController.java + GameSevice.java + Game.java: я изменил немного регистрацию - если игра началась или если чувак уже зареганный, то он получает отказ.

//ToDo
если мы делаем пункт Б, то надо начать писать банковские дела.