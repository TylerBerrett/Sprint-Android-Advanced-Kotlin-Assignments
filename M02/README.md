# Sprint-Android-Advanced-Kotlin-Assignments

## Build an app which implements Extension Functions using lambda for Notification Builder and write an extension function to load image using Glide.

## Instructions:

# Part - 1 Notification Builder (Extension Function using Lambda)
1. Follow the example for AlertDialog builder in the guided project and repeat that for the Notification Builder class.
2. Use NotificationCompat.Builder class to build the notification. 
3. In the lambda for the Notification, pass in an id of 0 and an empty string for the channel Id.
4. The text should be "This is my Notification."
5. Set an icon and use colorPrimary when trying to get the color for the icon.

# Part - 2 Glide Extension Function
1. Following is a code snippet for downloading an image using Glide and listening to success and failure events.

```
private fun loadurl(url:String){
        Glide.with(this)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageLoaded = false
                    return false
                }
​
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageLoaded = true
                    return false
                }
            })
            .into(this)
    }
```
2. Now, re-write this using extension functions to achieve the same functionality with much more readability:
3. The resulting function should look like this: 
```.load()
.onSuccess {
}
.onFailure {
}
```
4. Use this extension function in a sample app to load an image. 
