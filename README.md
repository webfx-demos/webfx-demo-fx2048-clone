# Live demo

The demo is published on [this page][demo-live-link].

This is the game 2048.
You can use the arrow keys to play (or the touch screen on tablets and mobiles).
Tiles with the same number can merge into one that sums these 2 numbers. 
The goal of the play is to sum 2048 on a single tile.

# Highlighted features

## Reusability

This demo demonstrates how you can port existing JavaFX applications.
There was indeed already a [JavaFX version][fx2048-link] of the game, and this demo is just a port of it in WebFX so the game could be transpiled into a Web Application.

## HTML/CSS mapping

This demo also shows that you can write applications such as games using the scene graph and CSS (this game is not canvas based).

[demo-live-link]: https://fx2048.webfx.dev
[fx2048-link]: https://github.com/brunoborges/fx2048