# esi4k

Kotlin client implementation of the Eve Online ESI API. This is still in early stages of development.

---

[![Build Status](https://travis-ci.com/EveEngine/esi4k.svg?branch=master)](https://travis-ci.com/EveEngine/esi4k)

---

## What it is...
ESI4K is An interface client for the ESI API calls with predefined entities catered to Jackson. The `Resource`s have a 
standardized method architecture to give the developer multiple options as to how they want to handle responses. 

## What is isn't...
ESI4K is **not** an SSO client, meaning this client does not manage your access or refresh tokens. This was
to keep this client lightweight and single-purposed: to codify the interaction to the ESI API. This could easily be
wrapped around a token manager to keep the client's token up to date. Another option is to extend the `ESIClient` to
do just that.   

## Implementation Notes
The data models implemented are from the latest version of each API resource. If a resource is updated by ESI and has not
been updated here to reflect that change, then the typed methods will likely return `FailedReify` unless you use your own
model to deserialize the JSON to the updated implementation.

Data models defined for ESI4K only reflect the latest versions of the API resource unless an API is out of sync with
ESI4k, in which the model will need to be updated. It is important to review version changes before updating.
 
## Status of resource APIS

- [x] Completed
- [x] **Still needs testing**
- [ ] Not yet started

----------------------------------
- [x] Alliance
- [x] Assets
- [x] **Bookmarks**
- [x] **Calendar**
- [x] **Character**
- [x] **Clones**
- [x] **Contacts**
- [x] **Contracts**
- [x] **Corporation**
- [x] **Dogma**
- [x] **Faction Warfare**
- [x] **Fittings**
- [x] **Fleets**
- [x] **Incursions**
- [x] **Industry**
- [x] **Insurance**
- [x] **Killmails**
- [x] **Location**
- [x] **Loyalty**
- [x] **Mail**
- [x] **Market**
- [x] **Opportunities**
- [x] **Planetary Interaction**
- [x] **Routes**
- [x] **Search**
- [x] **Skills**
- [x] **Sovereignty**
- [x] **Status**
- [x] **Universe**
- [x] **User Interface**
- [x] **Wallet**
- [x] **Wars**

