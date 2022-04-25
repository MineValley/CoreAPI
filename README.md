# ![Logo](https://cdn.minevalley.eu/branding/logo_64px_cropped.png) - Core API 
This api grants important features and access to the internal server-core of MineValleyEU, that is used in any module.

This README.md is intended to help you with your daily issues or questions referring to our core and its components. It should offer you the most important information and give you answers to your upcoming questions. If this isn't the case sometimes, feel free to contact us on Discord.

We do our best to update this documentary. There's no other source of information, that is more up-to-date, than this one. If there is any missing information or mistake in this README or if you should have any suggestions, please create a new issue, thank you!

> **README.md**:
>
> latest change: _05.04.2022_

> **Core API**:
>
> version: _1.133
>
> latest change: _25.04.2022_

## Changelog (v1.36)
Here you can find the newest updates to this api.
- added many methods around the user object

# Documentation
This documentation contains a brief explanation of every method, that is included in this api.

## User
The user object is usually used as a substitute for the conventional player object. It contains some methods which on the one hand to obtain information, but also to carry out   actions around the player.

> The conventional player object can always be returned from the user object with .getPlayer()

#### Core.getUser(Player player);
Returns the user object of the specific player. It is already cached in the backend, so you don't have to.

### Utilization

<details>
  <summary>
    refresh();
  </summary>
  Refreshes the user object from the database. This method should be used rarely due its perfomance-costs.
  If you just want to update the users cash, use updateCash().
</details>
  
<details>
  <summary>
    joinTeamServive();
  </summary>
  Lets the user join the team-service if authorized to.
</details>
  
<details>
  <summary>
    leaveTeamService();
  </summary>
  Lets the user leave the team-service.
</details>
  
<details>
  <summary>
    joinSupportService();
  </summary>
  Lets the user join the support-service if authorized to.
</details>
  
<details>
  <summary>
    leaveSupportService();
  </summary>
  Lets the user leave the support-service.
</details>

<details>
  <summary>
    sendMessage(String message);
   </summary>
  Sends a message to the user just like the default player.sendMessage()-method does. There's no prefix or color added!
</details>

<details>
  <summary>
    sendMessage(BaseComponent baseComponent);
  </summary>
  Sends a message to the user that contains a BaseComponent. This is used to add ClickableMessages to your message.
</details>

<details>
  <summary>
    sendMessage(MessageType messageType, String message);
  </summary>
    Sends a message to the user using the specific message type.
</details>

<details>
  <summary>
    sendError();
  </summary>
    Sends the usual "Unbekannter Befehl!"-message. This is mostly used when a player tries to execute an command he isn't authorized to execute.
</details>

<details>
  <summary>
    input(String message, Consumer<String> callback);
  </summary>
    Asks the user for any type of input via a chat-interface. Keep in mind that the player is always able to leave this interface!
		If the user writes something into this interface, the callback is called with his answer.
</details>
	
<details>
  <summary>
    leaveInterface();
  </summary>
    Lets the user leave his current chat-interface.
</details>
	
<details>
  <summary>
    updateCash();
  </summary>
    Updates the users cash. Changing the users cash with the payCash(double amount)-method automaticly updates it, so you don't have to.
</details>

<details>
  <summary>
    hasPlayerRank(PlayerRank... ranks);
  </summary>
    Gets whether the user has one of the given playerranks.
</details>
	
<details>
  <summary>
    hasTeamRank(TeamRank... ranks);
  </summary>
    Gets whether the user has one of the given teamranks.
</details>
	
<details>
  <summary>
    isTeamler();
  </summary>
    Gets whether the user is team-member.
</details>
	
<details>
  <summary>
    payCash(double amount);
  </summary>
    Withdraws the given amount from the users cash. If the user doesn't have enough money, nothing gets withdrawn. This method returns whether the action was successful.
</details>
	
<details>
  <summary>
    getCash();
  </summary>
    Gets the current amount of cash in the users wallet.
</details>

<details>
  <summary>
    getWantedLevel();
  </summary>
    Gets the current wanted-level of the user.
</details>
	
<details>
  <summary>
    setCash();
  </summary>
    Sets the wanted-level of the user.
</details>

<details>
  <summary>
    isAllowedToUseGeneralKey();
  </summary>
    Gets whether the user is allowed to use a general-key.
</details>

<details>
  <summary>
    isUsingGeneralKey();
  </summary>
    Gets whether the user is currently using a general-key.
</details>
	
<details>
  <summary>
    canEnterSupportService();
  </summary>
    Gets whether the user is allowed to enter the support-service.
</details>

<details>
  <summary>
    isKnockedOut();
  </summary>
    Gets whether the user is knocked out.
</details>
	
<details>
  <summary>
    getPlayerHead();
  </summary>
    Gets the players head as ItemStack. It's already cached in the Core, so you don't have to!
</details>
	
<details>
  <summary>
    getUniqueId();
  </summary>
    Gets the players unique id as String.
</details>

<details>
  <summary>
    setId();
  </summary>
    Gets the users id as String.
</details>
	
<details>
  <summary>
    getPlayer();
  </summary>
    Gets the users player object.
</details>
	
<details>
  <summary>
    getPhone();
  </summary>
    Gets the users phone.
</details>
	
<details>
  <summary>
    getBankAccount();
  </summary>
    Gets the users bank-account.
	This method isn't usable at the moment!
</details>
	
<details>
  <summary>
    getFraction();
  </summary>
    Gets the fraction that the user is currently in service for.
</details>

<details>
  <summary>
    getTeamRank();
  </summary>
    Gets the users teamrank if he is in team-service.
</details>
	
<details>
  <summary>
    getPlayerRank();
  </summary>
    Gets the users playerrank.
</details>

## Database
This api provides the possibility to **get**, **change**, **add** and **remove** entries in every table of our My-SQL-database. If you'd like to add new tables (or edit existing ones) or in case you need help with this part of the core-api, please get in touch with the server-management, the head of development won't be able to help you there!

> **Note:**
>
> Although it's a commonly used and safe method to back up data, database-requests are one of the most performance-sapping ways to do so!
> Please check with every use, if you have considered the following terms:
> - If possible, cache the data you are using, instead of requesting it twice
> - There should never be a database-request directly caused by a repeatable player action (use cache or cooldowns to avoid performance degradation)
> - If possible, use provided objects (e.g. PlayerData) to read data
> - Use purpose-adapted requests (e.g. DatabaseEntryCollection) instead of requesting data from the same table twice

<details>
<summary>conventions regarding the database structure</summary>
The conventions for our database are not as strict as our code conventions, but we recommend that you adhere to them in order to be able to work together with other developers...

- Column- and tablenames should be written in english and should be understandable without further knowledge about the module. Please only use lowercase letters and underscores. You can separate multiple words with underscores: 'company_name', 'unique_id'.

- Please don't use other data types than String (or Text), Integer, Double or Boolean (is automatically translated to Integer).
If you want to safe other types, convert them to json-Strings.
Inventories can be converted to Strings via the provided InventoryUtils-class.
Locations are often converted to Strings using custom hashing-methods, which is fine.

- Every table should have at least one column with a primary-key, therefor you should always use some kind of id (e.g. player-id, uniqueIds).
</details>

## PlayerCommand
The PlayerCommand is a replacement for the classic CommandExecutor interface and is used in a similar way.

- ### onCommand(User user, String[] args);
This method is just used as the onCommand()-method in the CommandExecutor-interface. You should always return a CommandRespone! They provide feedback whether the command was executed correctly.
	
- ### onTabComplete(User user, String[] args);
This method isn't included in the CommandExecutor-interface but is really useful! You can use it to give some tabcompletion-suggestions to the user while he's typing in the command. Especially for users, that are using higher versions of minecraft than 1.12, this is extremely useful!

- ### Command Registry
You don't have to register commands in your main-class anymore! Just add the @CommandOptions-annotation above your class. Since there is no plugin.yml in Core-Modules, you don't have to add them there either.
	
- ### @CommandOptions
This annotation is used to register your command, configure it and do some work for you.

Utilization:
	
<details>
  <summary>
    commands
  </summary>
    Put in a list of all command-variations, that should invoke your command. According to the conventions, you should add the written out form of your command, and than add the aliases after. If you don't want to use any aliases, just add a list with one string.
</details>

<details>
  <summary>
    successMessage [optional]
  </summary>
    This defines the message, that is sent to the user, if the onCommand()-method returns SUCCESS. If you don't want to send a success-message, don't use this configuration-option, or specify an empty string: "".
</details>

<details>
  <summary>
    playerRank | fractions | teamranks [optional]
  </summary>
    These three options define, who is allowed to perform this command. A user just has to have one of the ranks! If you want to create a command, which can be issued by everyone, just add every possible option to one of those (e.g. playerRank = {PlayerRank.ORDINARY, PlayerRank.PREMIUM}.
</details>
	
<details>
  <summary>
    syntax
  </summary>
    This defines the correct syntax for this command. It is necessary due its printout if the onCommand()-method returns WRONG_SYNTAX. You should use the mostly used variant of your command (in case of doubt use the written out variant). Arguments are also included in the syntax! Unnecessary arguments are written in square brackets. You don't have to add the slash at the beginning of your syntax.
	Example: example <necessary argument> [<unnecessary argument>]
</details>
	
## BankAccount
<details><summary>Show more</summary>
There's text following here...
</details>

## Phone
<details><summary>Show more</summary>
There's text following here...
</details>

## Company / Organisation
<details><summary>Show more</summary>
There's text following here...
</details>

# Utilities

## UUIDFetcher
<details><summary>Show more</summary>
There's text following here...
</details>

## Scheduler / Async-Tasks
<details><summary>Show more</summary>
There's text following here...
</details>

## MetaData
<details><summary>Show more</summary>
There's text following here...
</details>

## NPC
<details><summary>Show more</summary>
There's text following here...
</details>

## ItemBuilder
<details><summary>Show more</summary>
There's text following here...
</details>

## GuiBuilder
<details><summary>Show more</summary>
There's text following here...
</details>

## InventoryUtils
<details><summary>Show more</summary>
There's text following here...
</details>

## Text
<details><summary>Show more</summary>
There's text following here...
</details>
