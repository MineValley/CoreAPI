# ![Logo](http://minevalley.eu/images/style-12/favicon.ico) - Core API 
This api grants important features and access to the internal server-core of MineValleyEU, that is used in any module.

This README.md is ment to help you with your daily issues or questions referring to our core and its components. It should offer you the most important information and give you answers to your upcoming questions. If this isn't the case sometimes, feel free to contact us on Discord.

We do our best to update this documentary. There's no other source of information, that is more up-to-date, than this one.

> **README.md**:
> latest change: _15.11.2021_

> **Core API**:
> version: _1.0.0_
> latest change: _14.11.2021_

## Changelog (v_1.0.0)
Here you can find the newest updates to this api.
- added database-utils
- added this README.md
- inital commit

# Documentation
This documentation contains a brief explaination of every method, that is included in this api.

## PlayerData
<details><summary>Show more</summary>
There's text following here...
</details>

## Database
This api provides the possibility to **get**, **change**, **add** and **remove** entries in every table of our My-SQL-database. If you'd like to add new tables (or edit existing ones) or in case you need help with this part of the core-api, please get in touch with the server-management, the head of development won't be able to help you there!

> Note:
> Although it's a commonly used and safe method to back up data, database-requests are one of the most performance-sapping ways to do so!
> Please check with every use, if you have considered the following terms:
> - If possible, cache the data you are using, instead of requesting it twice
> - There should never be a database-request directly caused by a repeatable player action (use cache or cooldowns to avoid performance degradation)
> - If possible, use provided objects (e.g. PlayerData) to read data
> - Use purpose-adapted requests (e.g. DatabaseEntryCollection) instead of requesting data from the same table twice

<details><summary>conventions regarding the database structure</summary>

The conventions for our database are not as strict as our code conventions, but we recommend that you adhere to them in order to be able to work together with other developers...

- Column- and tablenames should be written in english and should be understandable without further knowledge about the plugin using it. Please only use lowercase letters and underscores. You can separate multiple words with underscores: 'company_name', 'unique_id'.

- Please don't use other data types than String (or Text), Integer, Double or Boolean (is automatically translated to Integer).
If you want to safe other types, convert them to json-Strings.
Inventories can be converted to Strings via the provided InventoryUtils-class.
Locations are often converted to Strings using custom hashing-methods, which is fine.

- Every table should have at least one column with a primary-key, therefor you should always use some kind of id (e.g. player-id, uniqueIds).
</details>

### PlayerCommand
<details><summary>Show more</summary>
There's text following here...
</details>

### ItemBuilder
<details><summary>Show more</summary>
There's text following here...
</details>

### GuiBuilder
<details><summary>Show more</summary>
There's text following here...
</details>

### BankAccount
<details><summary>Show more</summary>
There's text following here...
</details>

### Phone
<details><summary>Show more</summary>
There's text following here...
</details>

### Company / Organisation
<details><summary>Show more</summary>
There's text following here...
</details>

## Utilities

### UUIDFetcher
<details><summary>Show more</summary>
There's text following here...
</details>

### Scheduler / Async-Tasks
<details><summary>Show more</summary>
There's text following here...
</details>

### MetaData
<details><summary>Show more</summary>
There's text following here...
</details>

### InventoryUtils
<details><summary>Show more</summary>
There's text following here...
</details>

### Text
<details><summary>Show more</summary>
There's text following here...
</details>
