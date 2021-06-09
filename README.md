# AppCompose Library
[#Maintainer](https://wideclassrooms.com)
This library is designed for easily diving into Andriod App Development through through the library components.

This library is under development so the students in android classroom can understand easily how the application developed in android.
 
It is suitabe for beginners who want to learn and contribute in this collaboration solution. To learn and ask your doubts you can register [here](https://wideclassrooms.com)

## Developed Utilities

#### 1 - Image Slider
## How to 
 - In your activity xml 
 ```Xml
    <com.android.appcompose.composable.utility.slider.viewpager2.ImageSliderView
            android:id="@+id/pager"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            libProj:images = "@array/tutorial_images"/>
```
 - In your arrays.xml
 ```Xml
    
    <integer-array name="tutorial_images">
        <item>@drawable/splash_1</item>
        <item>@drawable/splash_2</item>
        <item>@drawable/splash_3</item>
        <item>@drawable/splash_3</item>
        <item>@drawable/splash_3</item>

    </integer-array> 
```
## Under Development

#### 1 - Image Slider With Dot Indicator