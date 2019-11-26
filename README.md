<h2>TicTacToe Game - To determine the result of the game</h2>
This application will determine the result of TicTacToe game, based on the following rules.</br>

<h3>Game Rules:</br></h3>
<ul>
  <li>X always goes first.</li>
  <li>Players cannot play on a played position.</li>
  <li>Players alternate placing X’s and O’s on the board until either:
    <ul><li>One player has three in a row, horizontally, vertically or diagonally</li>
      <li>All nine squares are filled.</li>
    </ul>
  <li>If a player is able to draw three X’s or three O’s in a row, that player wins.</li>
  <li>If all nine squares are filled and neither player has three in a row, the game is a draw.</li>
</ul>

<b>More information available at:</b>
https://github.com/stephane-genicot/katas/blob/master/TicTacToe.md

<b>Prerequisites:</b>
Java 1.7+
Maven 3.5+

<b>How to run:</b>
<ol>
  <li>Import the project in an IDE (For Eg. Eclipse).</li>
  <li>Perform maven install by, Right clicking on project and select 'Run as' -> Maven install</li>
  <li>Now the dependencies (Junit jar) are downloaded</li>
  <li>Run the class PlayTicTacToe.java by right clicking inside the file PlayTicTacToe.java. In the console, enter the 'position' the players X and O needs to choose.</li>
</ol>

<b>Note:</b>
Player selection is done in the code itself. Player X goes first and then O and then X and so on...

The 'position' needs to be from 0 to 8, if not, an IllegalPositionException is thrown at runtime.

Whenever there is a result (X win or O win or Draw), it will be shown in the console.
