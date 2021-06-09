# AppCompose Library
[#Maintainer](https://wideclassrooms.com)
This library is designed for easily diving into Andriod App Development through the library components.

This library is under development so the students in android classroom can understand easily how the application developed in android.
 
It is suitabe for beginners who want to learn and contribute in this collaboration solution. To learn and ask your doubts you can register [here](https://wideclassrooms.com)

## Developed Utilities

#### 1 - Image Slider
#### How to integrate image slider

 - In your activity xml 
 --Add following namespace in your activity xml root
 
 ```Xml
    xmlns:libProj="http://schemas.android.com/apk/res-auto" 
```
  --Add child where you would like to have image pager. You can change the width and height according to your requirement
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