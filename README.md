TicwearBuildPlugin
=======================

This is an unofficial plugin of building apps for Ticwear platform with gradle.  

For more information about **Ticwear**, Please see

* [Ticwear](http://ticwear.com/)

* [Ticwear Developer](http://developer.ticwear.com/)

## Status

This plugin has already published to **jCenter**, but not on Maven Central yet.  

* [jCenter](https://bintray.com/tinker-s/maven/TicwearBuildPlugin)

## Usage

This is a plugin for gradle, so I recommend you using Android Studio instead of eclipse as development tool.  

To use this plugin, you need add some code in your **build.gradle**:  

* Add dependencies

```
compile 'com.ticwear.tools.build:gradle:1.0.0'
```

* Apply plugin

```
apply plugin 'com.ticwear.application'
// or
apply plugin 'ticwear'
```

Please see the [example](https://github.com/Tinker-S/TicwearBuildPlugin/blob/master/EmbeddedApp/Application/build.gradle).

## Attention

If you have found any bugs or need some features, please create an issue at [Github Issue Tracker](https://github.com/Tinker-S/TicwearBuildPlugin/issues).

## License

    Copyright (C) 2015 Tinker Sun

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
