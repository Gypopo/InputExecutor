## What is it?
InputExecutor is a simple and lightweight plugin which has a unique way of asking player input using a AnvilGUI.<br>
The input can then be used to execute a server command.

## Example:
Take for example the <i><b>/shop search [filter]</b></i> command from <a href="https://www.spigotmc.org/resources/economyshopgui-premium.104414/">EconomyShopGUI-Premium</a>.<br>
There would be multiple ways of letting players know about this command: 
- Either by simply telling players <i>"Use command <b>/shop search [filter]</b> to search items"</i>

<b>
<img src="https://user-images.githubusercontent.com/52633285/235501671-42ccd01e-a56b-44b1-8159-0713cd24b602.png" width="40%" height="40%">

<img src="https://user-images.githubusercontent.com/52633285/235507266-1dcdde00-0855-43fc-8ec0-c5d8130defbc.png" width="30%" height="30%">

<img src="https://user-images.githubusercontent.com/52633285/235508047-d9b3a638-ed38-4cea-b43a-371aa83d1a54.png" width="25%" height="25%">
</b>

- OR by creating a simple input-request and linking it to an NPC:

<b>
<img src="https://user-images.githubusercontent.com/52633285/235504116-95899be2-fc36-42e4-b5f6-d0b43e903f07.png" width="30%" height="30%">

<img src="https://user-images.githubusercontent.com/52633285/235505120-b556c473-75e9-44f0-95af-dbfb9346aa7e.png" width="30%" height="30%">

<img src="https://user-images.githubusercontent.com/52633285/235505610-cb18472e-4dbf-4bb4-97f0-bc3822d9cad3.png" width="25%" height="25%">
</b>

<br>Using the latter method it is easier for the player.<br>
They do not have to remember the command nor the arguments, they just click the NPC and the rest will follow thru the input-request.

## How to use?

We will take the example from above into place.<br>
The full command of the NPC above is `input player:<p> request:'§9§lEnter search filter' command:'p:shop search %input%'`, lets take a closer look at the command arguments.<br>
- `player:<p>` - This will open the input-request for the given player. In this case it will be the player clicking the NPC.
- `request:'§9§lEnter search filter'` - The question to ask the player
- `command:'p:shop search %input%'` - The command executed as the console when the player enters the input.
  - You may use the following placeholders:
    - `%input%` - Replaced with the input the player has entered inside the AnvilGUI
    - `%player%` - Replaced with the player name which has entered the input
  - Aditionally you can start the command with `p:` to execute the command as the player instead of console.
    
## 
