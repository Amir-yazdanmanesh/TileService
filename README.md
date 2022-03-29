# TileService
 [![android Status](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com/)


A TileService provides the user a tile that can be added to Quick Settings. Quick Settings is a space provided that allows the user to change settings and take quick actions without leaving the context of their current app.

The lifecycle of a TileService is different from some other services in that it may be unbound during parts of its lifecycle. Any of the following lifecycle events can happen independently in a separate binding/creation of the service.

When a tile is added by the user its TileService will be bound to and ```onTileAdded()``` will be called.
When a tile should be up to date and listing will be indicated by  ```onStartListening()``` and onStopListening().
When the user removes a tile from Quick Settings  ```onTileRemoved()``` will be called.
 ```onTileAdded() ``` and  ```onTileRemoved() ``` may be called outside of the ```Service.onCreate() - onDestroy()``` window
## Requirements
-  The label you choose is short (less than 18 characters or it’ll get truncated)
-  Icon is a vector drawable that is solid white on a transparent background 
- My library work on Android 7.0 (API 24)



## Preview
![](https://s22.picofile.com/file/8448701184/ezgif_com_gif_maker_2_.gif) 


