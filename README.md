# MartLib
A bunch of random functionality and tweaks I've added to my Minecraft server.

# Modules
<h3>All modules are toggleable in the config. Do <code>/martlib:reload</code> to reload the <a href="https://github.com/Guedosha/MartLib/blob/main/src/main/resources/config.yml">config</a> after making changes</h3>
<h5>Book Signature:<br>Adds a /sign command to allow multiple players to sign the same book</h5>
<h5>Bushmans Bow:<br>Functionality for a custom item on my server</h5>
<h5>Cultist Banner:<br>Adds a command to give the player a banner coresponding to their team. Currently hardcoded but will be configurable in the future</h5>
<h5>Death Coordinates:<br>Sends a message to a player after they die containing their death coordinates. For Java Edition players, it will send a hoverable message to show the coords that can be clicked to copy to clipboard. For Bedrock Edition players, it will just send the coordinates to the player</h5>
<h5>Easy Raid Evokers:<br>Functionality for a compromise my players made to allow raids to spawn evokers while keeping our server in easy difficulty</h5>
<h5>Global Freeze:<br>"Freezes" all players who don't have the martlib.globalfreeze.move permission</h5>
<h5>Invincibility Frames:<br>Adds a configurable window of invulnerability when players join the server</h5>
<h5>Player Logger:<br>Logs certain player actions such as dying, sleeping, changing dimensions, using creative, etc</h5>
<h5>Schizophrenia:<br>A W.I.P module that i've remade and deleted several times. In its completed form, it will be a way for admins to troll players by making them question their sanity</h5>
<h5>Seasonal Items:<br>A module that prevents players from using items with &5Verified in their lore. It was made to allow players to keep a box of sentimental items from the previous season while preventing them from gaining an advantage</h5>
<h5>Simple Spleef:<br>A simple spleef mechanic that puts snow ball items directlyin the player's inventory when the break snow blocks and makes snow balls instantly break snow blocks</h5>
<h5>Stop Sounds On Death:<br>A minor tweak I made because I was annoyed it isn't vanilla behavior. The explanation is in the name</h5>
<h5>Warden Boss:<br>A W.I.P. module to add a custom warden boss. Currently cincomplete and is disabled by default in the config.</h5>
<h5>Warden Heart Fix:<br>A patch for a custom item on my server that allowed players to dupe experience</h5>

## Dependencies
[Geyser](https://geysermc.org/download/)<br>
[Floodgate](https://geysermc.org/download/?project=floodgate)<br>
[MythicMobs](https://www.spigotmc.org/resources/%E2%9A%94-mythicmobs-free-version-%E2%96%BAthe-1-custom-mob-creator%E2%97%84.5702/)<br>
[Luckperms](https://luckperms.net/download)<br>
<sub>Certain dependencies aren't required depending on which modules are enabled.</sub>

## Permissions
* /martlib:reload command: <code>martlib.reload</code>
* /martlib command: <code>martlib.admin</code>
* /sign command: <code>martlib.sign</code>
* Allow players to move when GlobalFreeze is enabled: <code>martlib.globalfreeze.move</code>

<h2>Copyright © 2024 Guedosha. All Rights Reserved</h2>
<sub>Since I'm indecisive, this repository is all rights reserved until I make up my mind on an appropriate license.<br>
If you want to use any of this code, just message me on discord.</sub>
