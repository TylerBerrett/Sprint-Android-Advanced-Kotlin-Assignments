# Sprint-Android-Advanced-Kotlin-Assignments

## Build an app that switches between music genres and displays a set of songs from the genre in a RecyclerView

## Instructions:

1. Set a project that contains a RecyclerView in the main activity.
2. Store the RecyclerView in a property on your Activity. Do not use a nullable class; instead think about what option to avoid using nullables makes the most sense for this property.
3. Come up with your own sealed class of songs with subclasses that represent different music genres. Decide upon properties for the classes, and set up a layout for the items in your RecyclerView to display these properties.
4. Set up lists of objects that contain songs from the different genres. You can do a search to find songs for each genre (e.g., [billboard charts](https://en.wikipedia.org/wiki/Billboard_charts#Singles_and_tracks))
4. In your activity, set up a list that will contain the items in the RecyclerView.
5. Set up a menu (either options menu or `NavigationDrawer`) to switch between genres.
6. When the menu item is selected, display the appropriate genre in the list. Use an `observable` or `vetoable` from `Delegates` to propagate the change to your list of songs. Also think about how you can change the list and make sure the RecyclerView's adapter is updated whenever the list changes.

## Stretch goals
1. Polish the UI. Consider changing the title bar, updating the color, icons, etc. to make your project more interesting.
2. Find an API that you can use for the songs instead of setting up your own objects.